package com.example.demo.mapper;

import com.example.demo.model.DocBean;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticRepository extends ElasticsearchRepository<DocBean, Long> {
  //默认的注释
  //@Query("{\"bool\" : {\"must\" : {\"field\" : {\"content\" : \"?\"}}}}")
  Page<DocBean> findByContent(
    String content,
    org.springframework.data.domain.Pageable pageable
  );

  @Query(
    "{\"bool\" : {\"must\" : {\"field\" : {\"firstCode.keyword\" : \"?\"}}}}"
  )
  Page<DocBean> findByFirstCode(
    String firstCode,
    org.springframework.data.domain.Pageable pageable
  );

  @Query(
    "{\"bool\" : {\"must\" : {\"field\" : {\"secordCode.keyword\" : \"?\"}}}}"
  )
  Page<DocBean> findBySecordCode(
    String secordCode,
    org.springframework.data.domain.Pageable pageable
  );
}
