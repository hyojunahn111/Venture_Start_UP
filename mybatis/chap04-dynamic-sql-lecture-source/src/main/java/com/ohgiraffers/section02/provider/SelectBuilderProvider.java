package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.jdbc.SQL;

public class SelectBuilderProvider {

    public String selectAllMenu() {
        return new SQL()
                .SELECT("menu_code")
                .SELECT("menu_name")
                .SELECT("menu_price")
                .SELECT("category_code")
                .SELECT("orderable_Status")
                .FROM("tbl_menu")
                .WHERE("orderable_status = 'Y'")
                .toString();

    }

    public String searchMenuByCondition(SearchCriteria searchCriteria) {
        SQL sql = new SQL()
                .SELECT("m.menu_code", "m.menu_name", "m.menu_price", "m.category_code", "m.orderable_Status")
                .FROM("tbl_menu m");

        if("category".equals(searchCriteria.getCondition())){
            sql.JOIN("tbl_category c ON (m.category_code = c.category_code)")
                    .WHERE("m.orderable_Status = 'Y'")
                    .AND()
                    .WHERE("c.category_name = #{ value }");
        }

        if("menu".equals(searchCriteria.getCondition())){
            /*가변인자를 이용하면 자동 .AND()로 처리하므로 OR을 사용해야 하는 경우에는 .OR()을 써야한다.*/
            sql.WHERE("m.orderable_Status = 'Y'",
                    "m.menu_name LIKE CONCAT('%', #{ value }, '%'");
        }
        return sql.toString();
    }


}
