package com.szxs.mapper;

import com.szxs.dto.VoItem;
import com.szxs.dto.VoItemDetail;
import com.szxs.dto.VoItemType;
import com.szxs.dto.VoItems;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DmItemMapper {
    /**B3
     * 查询轮播图
     */
     List<VoItem> queryBanner();

    /**B4
     * 今日推荐
     */
    List<VoItem> queryTodayRecommend();
    /**B5
     * 即将开售
     */
    List<VoItem> queryToSaleItem();

    /**B7
     * 热门演出推荐排行
     * @param itemTypeId 剧场类型id
     *
     */
    List<VoItem> queryHotItems(@Param("itemTypeId") Integer itemTypeId);

    /**C1
     *音乐会专区
     * @param ageGroup    根据dm_item表的ageGroup列查询
     * @param limit    个数
     */
    List<VoItems> queryItemByAge(@Param("ageGroup") Integer ageGroup,@Param("limit") Integer limit);


    /**C2
     * 2.精彩聚集(2)
     * @param itemTypeId 根据dm_item表的itemType1Id列查询
     * @param limit  个数
     *
     */
    List<VoItems> queryAdvertising(@Param("itemTypeId") Integer itemTypeId,@Param("limit") Integer limit);

    /**C3
     * 轮播图
     * @param itemTypeId 根据dm_item表的itemType1Id列查询
     *
     */
    List<VoItem> querySlideShowPic(@Param("itemTypeId") Integer itemTypeId);

    /**C4
     * 猜你喜欢
     * @param ageGroup  根据dm_item表的ageGroup列查询
     * @param limit 个数
     *
     */
    List<VoItems> queryItemLike(@Param("ageGroup") Integer ageGroup,@Param("limit") Integer limit);


    /**C5
     * 5.精彩聚集(1)
     * @param itemTypeId    根据dm_item表的itemType1Id列查询
     * @param limit 个数
     *
     */
    List<VoItems> queryItemNice(@Param("itemTypeId") Integer itemTypeId,@Param("limit") Integer limit);


    /**C6
     *热门排行
     * @param itemTypeId    根据dm_item表的itemType1Id列查询
     * @param limit 个数
     * @param areaId    dm_cinema表的区域id
     *
     */
    List<VoItems> queryItemHot(@Param("itemTypeId") Integer itemTypeId,@Param("limit") Integer limit,@Param("areaId")Integer areaId);


    /**C7
     * 7.根据月份查询剧场
     * @param itemTypeId    根据dm_item表的itemType1Id列查询
     * @param month 月份
     * @param year  年份
     *
     */
    List<VoItems> queryItemByMonth(@Param("itemTypeId") Integer itemTypeId,@Param("month") Integer month,@Param("year")Integer year);


    /**E1
     *1.根据id查询剧场详情
     * @param id 剧场ID
     *
     */
    List<VoItemDetail>queryItemDetail(@Param("id") Integer id);


    /**
     * D2
     * 2.查询类型
     */
    List<VoItemType> queryItemType(@Param("parent") Integer parent);

}
