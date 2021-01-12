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
            "firstCode":{
                "analyzer": "ik_smart",
                "query": "xx"
            }
        }
    }
}