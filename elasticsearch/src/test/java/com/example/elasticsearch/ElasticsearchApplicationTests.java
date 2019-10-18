package com.example.elasticsearch;

import com.example.elasticsearch.bean.Poems;
import com.example.elasticsearch.service.PoemsRepository;
import com.google.gson.Gson;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    private PoemsRepository poemsRepository;

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
    public void addPoems() {

        File file = new File("C:\\Users\\WangYang\\Desktop\\3390.txt");
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
            String line = "";
            while ((line = in.readLine()) != null) {
                if (!line.equals("")) {
                    sb.append("\r\n").append(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = sb.toString();
        String[] split = str.split("\\d+");
        int count = 1;
        for (String s : split) {
            Poems poems = new Poems();
            String[] split1 = s.split("\r\n");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < split1.length; i++) {
                if (i == 0) {
                    String[] split2 = split1[0].split("：");
                    if (split2.length == 2) {
                        poems.setId(count++ + "");
                        poems.setAuthor(split2[0]);
                        poems.setTitle(split2[1]);
                    }
                } else {
                    stringBuilder.append(split1[i]);
                }
            }

            poems.setContent(stringBuilder.toString());
            if (!StringUtils.isEmpty(poems.getAuthor())) {
                poemsRepository.save(poems);
            }
        }


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

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void queryPoems() {
        Optional<Poems> byId = poemsRepository.findById("1");
        byId.ifPresent(System.out::println);
//        elasticsearchTemplate.createIndex(Poems.class);

//        Iterable<Poems> all = poemsRepository.findAll(new Sort(Sort.Direction.ASC, "id"));

//        QPageRequest queryBuilder = new QPageRequest(1,1000);
//        Iterable<Poems> all = poemsRepository.findAll(queryBuilder);

        System.out.println(poemsRepository.count());
//        all.forEach(System.out::println);

        //构建查询
//        SearchQuery query = new NativeSearchQueryBuilder()
//                .withQuery(bqb)
//                .withSort(fsb)
//                .addAggregation(builder)
//                .withPageable(pageable)
//                .build();

//        Pageable pageable = PageRequest.of(1, 100, Sort.Direction.ASC, "id");
//        Pageable pageable = PageRequest.of(0, 100);
//        Page<Poems> all = poemsRepository.findAll(pageable);
//        all.forEach(System.out::println);


//        QueryBuilder qb1 = QueryBuilders.rangeQuery("id").lt(1);
//        Iterable<Poems> search = poemsRepository.search(qb1);
        Iterable<Poems> search = poemsRepository.findAll();
        search.forEach(System.out::println);

    }
}
