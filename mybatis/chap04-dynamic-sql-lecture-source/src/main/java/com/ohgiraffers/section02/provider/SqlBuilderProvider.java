package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.jdbc.SQL;

public class SqlBuilderProvider {

    public String registMenu(MenuDTO newMenu) {
        return new SQL()
                .INSERT_INTO("tbl_menu")
                .VALUES("menu_name", "#{ name }")
                .VALUES("menu_price", "#{ price }")
                .VALUES("category_code", "#{ categoryCode }")
                .VALUES("orderable_status", "#{ orderableStatus }")
                .toString();

    }

    //UPDATE절에서는 무조건 WHERE절을 넣어줘야한다
    public String modifyMenu(MenuDTO modifyMenu) {
        /*모든 컬럼을 업데이트하지 않는 경우 아래처럼 작성하면 문제가 발생할 수 있다*/
        /*return new SQL()
                .UPDATE("tbl_menu")
                .SET("menu_name = #{ name }"
                    ,"menu_price = #{ price }"
                    ,"category_code = #{ categoryCode }"
                    ,"orderable_status = #{ orderableStatus }")
                .WHERE("menu_code = #{ code }")
                .toString();*/

        SQL sql = new SQL()
                .UPDATE("tbl_menu");

        if(modifyMenu.getName() != null && !"".equals(modifyMenu.getName())) {
            sql.SET("menu_name = #{name}");
        }

        if(modifyMenu.getPrice() > 0){
            sql.SET("menu_price = #{price}");
        }

        if(modifyMenu.getCategoryCode() > 0){
            sql.SET("category_code = #{categoryCode}");
        }

        if(modifyMenu.getOrderableStatus() != null && "".equals(modifyMenu.getOrderableStatus())){
            sql.SET("orderable_status = #{orderableStatus}");
        }

        sql.WHERE("menu_code = #{code}");

        return sql.toString();
    }

    public String removeMenu(){
        return new SQL()
                .DELETE_FROM("tbl_menu")
                .WHERE("menu_code = #{code}")
                .toString();
    }
}
