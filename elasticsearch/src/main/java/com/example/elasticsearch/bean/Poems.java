package com.example.elasticsearch.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author wangyang
 * @date 2019/10/16
 */
@Document(indexName = "poems", type = "poem")
@Data
public class Poems implements Serializable {

    @Id
    private String id;
    @Field(type = FieldType.Keyword)
    private String title;
    @Field(type = FieldType.Keyword)
    private String author;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;
}