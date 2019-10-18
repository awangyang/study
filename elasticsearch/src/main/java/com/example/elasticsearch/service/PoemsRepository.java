package com.example.elasticsearch.service;

import com.example.elasticsearch.bean.Poems;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author wangyang
 * @date 2019/10/16
 */
public interface PoemsRepository extends ElasticsearchRepository<Poems, String> {
}
