package com.szxs.fallback;

import com.szxs.dto.*;
import com.szxs.entity.DmElasticSearchRequestParm;
import com.szxs.feign.DmItemTypeFeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DmItemTypeFeignClientFallback implements DmItemTypeFeignClient {
    public List<VoItemType> queryAllType() {
        return null;
    }

    public List<VoTransverse> queryVoTransverse() {
        return null;
    }

    public List<VoItem> queryBanner() {
        return null;
    }

    public List<VoItem> queryTodayRecommend() {
        return null;
    }

    public List<VoItem> queryToSaleItem() {
        return null;
    }


    public List<VoFloorItems> queryFloorItems() {
        return null;
    }

    public List<VoItem> queryHotItems(Integer itemTypeId) {
        return null;
    }

    public List<VoItems> queryItemByAge(Integer ageGroup, Integer limit) {
        return null;
    }

    public List<VoItems> queryAdvertising(Integer itemTypeId, Integer limit) {
        return null;
    }

    public List<VoItem> querySlideShowPic(Integer itemTypeId) {
        return null;
    }

    public List<VoItems> queryItemLike(Integer ageGroup, Integer limit) {
        return null;
    }

    public List<VoItems> queryItemNice(Integer itemTypeId, Integer limit) {
        return null;
    }

    public List<VoItems> queryItemHot(Integer itemTypeId, Integer limit, Integer areaId) {
        return null;
    }

    public List<VoItems> queryItemByMonth(Integer itemTypeId, Integer month, Integer year) {
        return null;
    }

    public List<VoCity> queryCityList() throws Exception {
        return null;
    }

    public List<VoItemType> queryItemType(Integer parentId) {
        return null;
    }

    public VoEsEntity queryItemRows(DmElasticSearchRequestParm desr) throws Exception {
        return null;
    }


    public List<VoItem> queryVoItem(Integer itemTypeId, Integer limit) throws Exception {
        return null;
    }

    public List<VoItemDetail> queryItemDetail(Integer id) {
        return null;
    }

    public List<VoItemComment> queryItemComment(Integer id) {
        return null;
    }
}
