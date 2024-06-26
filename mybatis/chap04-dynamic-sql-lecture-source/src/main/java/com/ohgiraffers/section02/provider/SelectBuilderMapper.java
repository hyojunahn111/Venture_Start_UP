package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SelectBuilderMapper {

    @Results(id = "menuResultMap", value = {
            @Result(id = true, property = "code", column= "menu_code"),
            @Result(property = "name", column= "menu_name"),
            @Result(property = "price", column= "menu_price"),
            @Result(property = "categoryCode", column= "category_code"),
            @Result(property = "orderableStatus", column= "orderable_Status"),

    })
    @SelectProvider(type = SelectBuilderProvider.class, method = "selectAllMenu")
    List<MenuDTO> selectAllMenu();

    @ResultMap("menuResultMap")
    @SelectProvider(type = SelectBuilderProvider.class, method = "searchMenuByCondition")
    List<MenuDTO> searchMenuByCondition(SearchCriteria searchCriteria);
}
