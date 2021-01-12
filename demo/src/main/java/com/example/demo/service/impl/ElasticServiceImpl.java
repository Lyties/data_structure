package com.example.demo.service.impl;

import com.example.demo.mapper.ElasticRepository;
import com.example.demo.model.DocBean;
import com.example.demo.service.IElasticService;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

@Service("elasticService")
public class ElasticServiceImpl implements IElasticService {

  @Autowired
  private ElasticsearchRestTemplate elasticsearchTemplate;

  @Autowired
  private ElasticRepository elasticRepository;

  private Pageable pageable = PageRequest.of(0, 10);

  @Override
  public void createIndex() {
    elasticsearchTemplate.indexOps(DocBean.class);
  }

  @Override
  public void deleteIndex(String index) {
    elasticsearchTemplate.deleteIndex(index);
  }

  @Override
  public void save(DocBean docBean) {
    elasticRepository.save(docBean);
  }

  @Override
  public Iterable<DocBean> saveAll(List<DocBean> list) {
    return elasticRepository.saveAll(list);
  }

  @Override
  public Iterable<DocBean> findAll() {
    return elasticRepository.findAll();
  }

  @Override
  public Page<DocBean> findByContent(String content) {
    return elasticRepository.findByContent(content, pageable);
  }

  @Override
  public Page<DocBean> findByFirstCode(String firstCode) {
    return elasticRepository.findByFirstCode(firstCode, pageable);
  }

  @Override
  public Page<DocBean> findBySecordCode(String secordCode) {
    return elasticRepository.findBySecordCode(secordCode, pageable);
  }

  @Override
  public Page<DocBean> query(String key) {
    return elasticRepository.findByContent(key, pageable);
  }


}
