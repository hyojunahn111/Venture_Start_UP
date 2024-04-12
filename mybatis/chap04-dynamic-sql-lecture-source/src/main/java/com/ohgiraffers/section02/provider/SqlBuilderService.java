package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.Template.getSqlSession;

public class SqlBuilderService {

    private SqlBuilderMapper mapper;

    public void registMenu(MenuDTO newMenu) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SqlBuilderMapper.class);

        int result = mapper.registMenu(newMenu);

        if(result > 0){
            System.out.println("신규 메뉴 등록에 성공하였습니다.");
            sqlSession.commit();
        }else{
            System.out.println("신규 메뉴 등록에 실패하였습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();

    }

    public void modifyMenu(MenuDTO modifyMenu) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SqlBuilderMapper.class);

        int result = mapper.modifyMenu(modifyMenu);

        if(result > 0){
            System.out.println("메뉴 수정에 성공하였습니다.");
            sqlSession.commit();
        }else{
            System.out.println("메뉴 수정에 실패하였습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    public void removeMenu(int menuCode){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SqlBuilderMapper.class);

        int result = mapper.removeMenu(menuCode);

        if(result > 0){
            System.out.println("메뉴 삭제에 성공하였습니다.");
            sqlSession.commit();
        }else{
            System.out.println("메뉴 삭제에 실패하였습니다.");
            sqlSession.rollback();
        }
        sqlSession.close();
    }

}
