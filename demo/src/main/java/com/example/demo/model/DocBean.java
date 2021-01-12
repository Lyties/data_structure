package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "doc-bean",createIndex = true,replicas = 1,shards = 3)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocBean {

  @Id
  private Long id;

  @Field(type = FieldType.Keyword)
  private String firstCode;

  @Field(type = FieldType.Keyword)
  private String secordCode;

  @Field(type = FieldType.Text, analyzer = "ik_max_word")
  private String content;

  @Field(type = FieldType.Integer)
  private Integer type;

}
