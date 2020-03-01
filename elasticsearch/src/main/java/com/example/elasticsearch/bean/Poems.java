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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Poems)) return false;

        Poems poems = (Poems) o;

        if (!id.equals(poems.id)) return false;
        if (!title.equals(poems.title)) return false;
        if (!author.equals(poems.author)) return false;
        return content.equals(poems.content);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }
}
