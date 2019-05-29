package com.szxs.mapper;

import com.szxs.dto.VoFloorItems;
import com.szxs.dto.VoItemType;
import com.szxs.dto.VoTransverse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DmItemTypeMapper {

    /**B1
     * 查询所有节目类型
     *
     */
    List<VoItemType> queryAllType(@Param("id") int id);


    /**B2
     * 查询所有一级导航
     */
    List<VoTransverse> queryTransverse();


    /**B6
     *剧场类型推荐电影（1F/2F。。。）
     */
    List<VoFloorItems> queryFloorItems();

    /**
     * D2
     *2.查询类型
     */
    List<VoItemType> queryItemType(Integer parentId);

}
