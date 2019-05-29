package com.szxs;


import com.alibaba.fastjson.JSON;
import com.szxs.dto.VoEsEntity;
import com.szxs.dto.VoItem;
import com.szxs.dto.VoItemRows;
import com.szxs.entity.DmElasticSearchRequestParm;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@Component
public class ElasticsearchUtil {
    private TransportClient transportClient;
    @Resource
    private EsConnetion esItemConnection;


    /**
     * 获取Elasticsearch连接
     * @throws Exception
     */
    public void getConnetion() throws Exception {
        Settings es = Settings.builder().put("cluster.name", esItemConnection.getClusterName()).build();
        transportClient = new PreBuiltTransportClient(es).addTransportAddress(
                new TransportAddress( InetAddress.getByName( esItemConnection.getIp() )
                        , esItemConnection.getPort() ) );
    }


    /**D1.查询城市  访问地址：api/p/area/queryCityList
     * 获取城市信息
     * @return
     * @throws Exception
     */
    public Object getVoCity() throws Exception {
        getConnetion();
        return null;
    }

    /**D2.查询类型  访问地址：api/p/type/queryItemType
     * 获取城市信息
     * @return
     * @throws Exception
     */
    public Object getVoItemType(Integer parent) throws Exception {
        getConnetion();
        return null;
    }

    /**D3.全文检索后的内容 访问地址：api/p/type/queryItemList
     * 获取全文检索内容
     * @param desr
     * @return
     * @throws Exception
     */
    public VoEsEntity getVoItemList(DmElasticSearchRequestParm desr) throws Exception {
        //设置返回对象
        VoEsEntity voEsEntity = new VoEsEntity();
        voEsEntity.setCurPage(desr.getCurrentPage());
        voEsEntity.setBeginPos((desr.getCurrentPage()-1)*desr.getPageSize());
        voEsEntity.setPageSize(desr.getPageSize());
        getConnetion();
        //创建索引
//        transportClient.admin().indices().prepareCreate(esItemConnection.getIndex()).get();
        //查询索引内的内容
        SearchRequestBuilder srb = transportClient.prepareSearch(esItemConnection.getIndex());
        //编写复合查询规则
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        setBoolQuery(boolQueryBuilder,desr);
        //设置查询
        srb.setFrom(voEsEntity.getBeginPos());
        srb.setSize(desr.getPageSize());
        getSortRule(srb,desr);
        srb.setQuery(boolQueryBuilder);
        //执行条件检索,获取结果集
        SearchResponse searchResponse = srb.execute().actionGet();
        Long totalHits = searchResponse.getHits().getTotalHits();
        voEsEntity.setRows(getResultSet(searchResponse,VoItemRows.class));
        voEsEntity.setPageCount(  (totalHits.intValue()+voEsEntity.getPageSize()-1)/voEsEntity.getPageSize()   );
        voEsEntity.setTotal(totalHits.intValue());
        return voEsEntity;
    }

    /**D4.查询可能喜欢 访问地址：api/p/queryItemLike
     * 获取可能喜欢信息
     * @return
     * @throws Exception
     */
    public List<VoItem> getVoItemLike(Integer itemTypeId, Integer limit) throws Exception {
        getConnetion();
        //查询索引内的内容
        SearchRequestBuilder srb = transportClient.prepareSearch(esItemConnection.getIndex());
        srb.setSize(limit);
        srb.setQuery(QueryBuilders.termQuery("itemTypeId1",itemTypeId));
        //执行获取结果集
        SearchResponse searchResponse = srb.execute().actionGet();
        return getResultSet(searchResponse, VoItem.class);
    }




    /**
     * 获取排序规则
     * @param srb
     * @param desr
     */
    public void getSortRule(SearchRequestBuilder srb,DmElasticSearchRequestParm desr){
        String sort = null;
        //排序规则
        if(!"".equals(desr.getSort())&&desr.getSort()!=null){
            if("recommend".equals(desr.getSort())){  //热门推荐
                sort = "commentCount";
            }else if("recentShow".equals(desr.getSort())){   //最近开场
                sort = "startTimeLong";
            }else if("recentSell".equals(desr.getSort())){   //最新上架
                sort = "createdTimeLong";
            }
            //降序
            srb.addSort(sort, SortOrder.DESC);
        }
    }

    /**
     * 设置itemName复合查询
     */
    public void setBoolQuery(BoolQueryBuilder boolQueryBuilder,DmElasticSearchRequestParm desr){
        //区域
        if(desr.getAreaId()>0){
            boolQueryBuilder.must(QueryBuilders.matchQuery("areaId",desr.getAreaId()));
        }
        //类型1
        if(desr.getItemTypeId1()!=null && desr.getItemTypeId1()>0){
            boolQueryBuilder.filter(QueryBuilders.termQuery("itemTypeId1",desr.getItemTypeId1()));
        }
        //类型2
        if(desr.getItemTypeId2()!=null && desr.getItemTypeId2()>0){
            boolQueryBuilder.filter(QueryBuilders.termQuery("itemTypeId2",desr.getItemTypeId2()));
        }
        //开始时间
        if(desr.getStartTime()!=null){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("startTimeLong").gte(desr.getStartTime().getTime()));
        }
        //结束时间
        if(desr.getEndTime()!=null){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("endTimeLong").lte(desr.getEndTime().getTime()));
        }
        //关键字查询
        if(!"".equals(desr.getSort())&&desr.getSort()!=null){
            boolQueryBuilder.must(QueryBuilders.matchQuery("itemName",desr.getKeyword()));
        }
    }


    /**
     * 获取结果集
     * @param searchResponse
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> List<T> getResultSet(SearchResponse searchResponse,Class<T> tClass){
        SearchHits hits = searchResponse.getHits();
        SearchHit[] hits1 = hits.getHits();
        List<T> result = null;
        if(hits1 !=null){
            result= new ArrayList<T>();
            for (SearchHit hit:hits1){
                T resultT = JSON.parseObject(hit.getSourceAsString(),tClass);
                result.add(resultT);
            }
        }
        return result;
    }

}
