package com.guige.springbootdemo.mapper;

import com.guige.springbootdemo.entity.ConfParser;
import java.util.List;

public interface ConfParserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ConfParser record);

    ConfParser selectByPrimaryKey(Long id);

    List<ConfParser> selectAll();

    int updateByPrimaryKey(ConfParser record);
}