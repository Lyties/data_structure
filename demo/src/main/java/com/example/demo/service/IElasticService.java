package com.example.demo.service;

import com.example.demo.model.DocBean;
import java.util.Iterator;
import java.util.List;
import org.springframework.data.domain.Page;

public interface IElasticService {
  void createIndex();

  void deleteIndex(String index);

  void save(DocBean docBean);

  Iterable<DocBean> saveAll(List<DocBean> list);

  Iterable<DocBean> findAll();

  Page<DocBean> findByContent(String content);

  Page<DocBean> findByFirstCode(String firstCode);

  Page<DocBean> findBySecordCode(String secordCode);

  Page<DocBean> query(String key);
}
