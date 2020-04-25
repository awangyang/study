package com.example.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.example.elasticsearch.bean.Poems;
import com.example.elasticsearch.bean.User;
import com.example.elasticsearch.service.PoemsRepository;
import com.google.gson.Gson;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.*;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private PoemsRepository poemsRepository;

    @Autowired
    @Qualifier("elasticsearchRestHighLevelClient")
    private RestHighLevelClient restHighLevelClient;


    @Test
    public void addIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("poems");
        CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response));

    }

    @Test
    public void deleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("poems");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(delete.toString());
    }


    @Test
    public void test() {
        Poems poems = new Poems();
        poems.setAuthor("李白");
        poems.setTitle("静夜思");
        poems.setContent("床前明月光，疑是地上霜。举头望明月，低头思故乡。");
        Gson gson = new Gson();
        System.out.println(gson.toJson(poems));

    }


    @Test
    public void addPoems() throws IOException {

        File file = new File("C:\\Users\\WangYang\\Desktop\\3390.txt");
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            String line = "";
            while ((line = in.readLine()) != null) {
                if (!line.equals("")) {
                    sb.append("\r\n").append(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();

        String str = sb.toString();
        String[] split = str.split("\\d+");
        int count = 1;
        BulkRequest bulkRequest = new BulkRequest();
        Map<String, Object> map = new HashMap<>();
        for (String s : split) {
            Poems poems = new Poems();
            String[] split1 = s.split("\r\n");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < split1.length; i++) {
                if (i == 0) {
                    String[] split2 = split1[0].split("：");
                    if (split2.length == 2) {
//                        poems.setId(count++);
                        map.put("id", count++);
                        poems.setAuthor(split2[0]);
                        map.put("author", split2[0]);
                        map.put("title", split2[1]);
                        poems.setTitle(split2[1]);
                    }
                } else {
                    stringBuilder.append(split1[i]);
                }
            }

            poems.setContent(stringBuilder.toString());
            map.put("content", stringBuilder.toString());
            if (!StringUtils.isEmpty(poems.getAuthor())) {
//                poemsRepository.save(poems);
                bulkRequest.add(new IndexRequest("poems").id(String.valueOf(map.get("id"))).source(map));
            }

        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(bulk));

//        poems.setAuthor("李白");
//        poems.setTitle("静夜思");
//        poems.setContent("床前明月光，疑是地上霜。举头望明月，低头思故乡。");
//        System.out.println("--------1------");
//        for (int i = 0; i <= 1000000; i++) {
//            poems.setId(i + "");
//            poemsRepository.save(poems);
//        }
//        System.out.println("--------2------");
    }

    @Test
    public void queryPoems() throws IOException {
//        Iterable<Poems> search = poemsRepository.findAll();
//        search.forEach(System.out::println);
        GetRequest request = new GetRequest("poems").id("b-Ipr3EB7FmcT5v0tJnC");
        GetResponse documentFields = restHighLevelClient.get(request, RequestOptions.DEFAULT);

        System.out.println(documentFields.getSourceAsString());
        System.out.println(documentFields);
    }

    @Test
    public void tt() throws IOException {
        MultiGetRequest multiGetRequest = new MultiGetRequest();

        multiGetRequest.add(new MultiGetRequest.Item("poems", "1"));
//        multiGetRequest.add(new MultiGetRequest.Item("poems","2").fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE));
        multiGetRequest.add(new MultiGetRequest.Item("poems", "2"));
        MultiGetResponse mget = restHighLevelClient.mget(multiGetRequest, RequestOptions.DEFAULT);
        System.out.println(mget.getResponses()[0].isFailed());
        System.out.println(JSON.toJSONString(mget.getResponses()));
        for (MultiGetItemResponse respons : mget.getResponses()) {
//            System.out.println(JSON.toJSONString(respons));
            System.out.println(JSON.toJSONString(respons.getResponse().getSource()));
        }
    }

    @Test
    public void search() throws IOException {
        SearchRequest searchRequest = new SearchRequest("poems");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        HighlightBuilder highlighter = new HighlightBuilder();
//        HighlightBuilder.Field highlightContent = new HighlightBuilder.Field("content");

//        highlightTitle.highlighterType("unified");

        highlighter.preTags("<em>");
        highlighter.postTags("</em>");
        highlighter.requireFieldMatch(false);
        highlighter.field("content");

        searchSourceBuilder.highlighter(highlighter).query(QueryBuilders.termQuery("content", "登"));

        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(search));
        SearchHits hits = search.getHits();
        System.out.println(JSON.toJSONString(hits));
        SearchHit[] hits1 = hits.getHits();
        for (SearchHit documentFields : hits1) {
            Map<String, HighlightField> highlightFields = documentFields.getHighlightFields();
            HighlightField titleField = highlightFields.get("content");
            Text[] fragments = titleField.fragments();
            StringBuilder content = new StringBuilder();
            for (Text fragment : fragments) {
                content.append(fragment);
            }
            documentFields.getSourceAsMap().put("content", content.toString());
            System.out.println(documentFields.getSourceAsMap());
            System.out.println("---------------------");
        }
    }


    @Test
    public void jd() throws Exception {
        Document parse = Jsoup.parse(new URL("https://search.jd.com/Search?keyword=衣服&enc=utf-8"), 3000);
        System.out.println(parse.getElementById("J_goodsList").toString());
    }


    @Test
    public void addUser() throws IOException {

        User user;
        user = new User();
        user.setId(8);
        user.setName("小蓝");
        user.setAge(18);
        user.setFave("学习听音乐");
        user.setGrade("二年级");
        user.setScore(89);
        user.setSex("女");
        IndexRequest request = new IndexRequest("user");
        request.source(JSON.toJSONString(user), XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);

        System.out.println(JSON.toJSONString(response));
    }

}
