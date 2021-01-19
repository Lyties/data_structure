GET _cat/health

/* GET _cat/health?v=true */


GET doc-bean/_mapping

GET _cat/indices

GET _cluster/health


get _cat/indices/doc-bean


get _alias


get _cat/indices


get doc-bean/_mapping/field/firstCode


get doc-bean/_count

get doc-bean/_search

get doc-bean/_search
{
    "query": {
        "match": {
            "content": "小米"
        }
    }
}

PUT /doc-bean/_doc/100
{
    "content":"小米11不错嘛，我很喜欢",
    "firstCode":"goods",
    "secordCode":"name",
    "type":1200,
    "id":111
}


GET _search
{
    "query": {
        "match": {
            "content":"小米"
        }
    }
}


PUT /shop
{
  "settings": {
    "number_of_shards": 3,
    "number_of_replicas": 2
  }
}

PUT /shop/_mapping
{
  "properties": {
    "title": {
      "type": "text",
      "analyzer": "ik_max_word"
    },
    "price": {
      "type": "float"
    },
    "stock": {
      "type": "integer"
    }
  }
}

GET /shop/_mapping

GET /doc-bean/_mapping

GET /shop/_search

put /shop/_doc/1/_create
{
    "title": "小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待",
    "price": 2299.00,
    "stock": 1
}

GET /shop/_search
{
    "query": {
        "match": {
            "title":"小米8"
        }
    }
}



GET _analyze
{
    "analyzer": "ik_smart",
    "text": "天地无极，玄心正法"
}

GET _analyze
{
  "analyzer": "ik_max_word",
  "text": "我是社会主义接班人"
}