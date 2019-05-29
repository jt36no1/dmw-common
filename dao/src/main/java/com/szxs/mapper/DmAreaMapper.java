package com.szxs.mapper;

import com.szxs.dto.VoCity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface DmAreaMapper {
    @Select("select id,name from dm_area")
    List<VoCity> queryAllArea()throws Exception;
}
