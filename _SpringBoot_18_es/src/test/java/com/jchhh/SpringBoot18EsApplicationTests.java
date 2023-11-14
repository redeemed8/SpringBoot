package com.jchhh;

import com.alibaba.fastjson.JSON;
import com.jchhh.dao.BookDao;
import com.jchhh.domain.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;


@SpringBootTest
class SpringBoot18EsApplicationTests {

    @Autowired
    private BookDao bookDao;

    private RestHighLevelClient client;

    //  在所有测试前自动执行
    @BeforeEach
    void setUp() {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
    }

    //  在所有测试后自动执行
    @AfterEach
    void tearDown() throws IOException {
        client.close();
    }

    @Test
    void testCreateClient() throws IOException {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
        client.close();
    }

    @Test
    void testCreateIndex() throws IOException {
        //  客户端操作
        CreateIndexRequest request = new CreateIndexRequest("books");
        //  获取操作索引的客户端对象，调用创建索引操作
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    void testCreateIndexByIk() throws IOException {
        //  客户端操作
        CreateIndexRequest request = new org.elasticsearch.client.indices.CreateIndexRequest("books");
        //  设置请求中的参数
        String Json = "{\n" +
                "    \"mappings\":{\n" +
                "        \"properties\":{\n" +
                "            \"id\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"type\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"name\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"description\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"all\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        request.source(Json, XContentType.JSON);
        //  获取操作索引的客户端对象，调用创建索引操作
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    //  创建文档
    @Test
    void testCreateDoc() throws IOException {
        Book book = bookDao.selectById("1");
        IndexRequest request = new IndexRequest("books").id(book.getId().toString());
        //  对象 转换为 json串
        String json = JSON.toJSONString(book);
        request.source(json, XContentType.JSON);
        client.index(request, RequestOptions.DEFAULT);
    }

    //  创建文档
    @Test
    void testCreateDocAll() throws IOException {
        List<Book> books = bookDao.selectList(null);
        BulkRequest bulkRequest = new BulkRequest();
        for (Book book : books) {
            IndexRequest request = new IndexRequest("books").id(book.getId().toString());
            String json = JSON.toJSONString(book);
            request.source(json, XContentType.JSON);

            bulkRequest.add(request);
        }

        client.bulk(bulkRequest, RequestOptions.DEFAULT);
    }

    @Test
        //  按 id查询
    void testGet() throws IOException {
        GetRequest request = new GetRequest("books", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        String json = response.getSourceAsString();
        System.out.println(json);
    }

    @Test
        //  按条件查询
    void testSearch() throws IOException {
        SearchRequest request = new SearchRequest("books");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("all", "学习"));
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            String source = hit.getSourceAsString();
            //  转换回 对象
            Book book = JSON.parseObject(source, Book.class);
            System.out.println(book);
        }
    }

}
