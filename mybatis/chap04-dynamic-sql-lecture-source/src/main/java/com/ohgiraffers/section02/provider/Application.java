package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("=========== 구문 빌더 API를 이용한 Dynamic SQL ===========");
            System.out.println("1. SelectBuilder test");
            System.out.println("2. SqlBuilder test");
            System.out.println("9. 프로그램 종료");
            System.out.println("실행할 메뉴 번호를 입력해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: selectBuilderSubMenu(); break;
                case 2: sqlBuilderSubMenu(); break;
                case 9: System.out.println("프로그램을 종료합니다."); return;
            }
        } while (true);
    }

    private static void selectBuilderSubMenu() {
        Scanner sc = new Scanner(System.in);
        SelectBuilderService selectBuilderService = new SelectBuilderService();

        do {
            System.out.println("=========== SelectBuilder Sub Menu ===========");
            System.out.println("1. SelectBuilder 기본 구문 사용");
            System.out.println("2. SelectBuilder를 이용한 동적 쿼리 사용");
            System.out.println("9. 이전 메뉴로 이동");
            System.out.println("실행할 메뉴 번호를 입력해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: selectBuilderService.testSimpleStatement(); break;
                case 2: selectBuilderService.testDynamicStatement(inputSearchCriteria()); break;
                case 9: return;
            }

        } while (true);
    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기준을 입력하세요 (category 또는 menu) : ");
        String condition = sc.nextLine();
        System.out.println("검색어를 입력하세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

    private static void sqlBuilderSubMenu(){
        Scanner sc = new Scanner(System.in);
        SqlBuilderService sqlBuilderService = new SqlBuilderService();

        do {
            System.out.println("=========== SqlBuilder Sub Menu ===========");
            System.out.println("1. 새로운 메뉴 추가");
            System.out.println("2. 기존 메뉴 수정");
            System.out.println("3. 기존 메뉴 삭제");
            System.out.println("9. 이전 메뉴로 이동");
            System.out.println("실행할 메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();


            switch (no){
                case 1 : sqlBuilderService.registMenu(inputNewMenu());break;
                case 2 : sqlBuilderService.modifyMenu(inputModifyMenu());break;
                case 3 : sqlBuilderService.removeMenu(inputMenuCode());break;
                case 9: return;
            }
        } while(true);
    }

    private static MenuDTO inputNewMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("신메뉴의 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.println("신메뉴의 가격을 입력하세요 :");
        int price = sc.nextInt();
        System.out.println("신메뉴의 등록 카테고리를 입력하세요 : ");
        int categoryCode = sc.nextInt();
        System.out.println("판매 등록 여부를 입력하세요 (Y or N) : ");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        MenuDTO newMenu = new MenuDTO();
        newMenu.setName(name);
        newMenu.setPrice(price);
        newMenu.setCategoryCode(categoryCode);
        newMenu.setOrderableStatus(orderableStatus);

        return newMenu;
    }

    private static MenuDTO inputModifyMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("수정 대상 메뉴 코드를 입력하세요 : ");
        int code = sc.nextInt();
        System.out.println("수정할 메뉴명을 입력하세요 : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("수정할 메뉴 가격을 입력하세요 : ");
        int price = sc.nextInt();
        System.out.println("수정할 메뉴 카테고리를 입력하세요 : ");
        int categoryCode = sc.nextInt();
        System.out.println("수정할 판매 등록 여부를 입력하세요 (Y or N) : ");
        String orderableStatus = sc.nextLine();

        return new MenuDTO(code, name, price, categoryCode, orderableStatus);
    }

    private static int inputMenuCode(){
        Scanner sc = new Scanner(System.in);

        System.out.println("삭제할 메뉴 코드를 입력하세요 : ");
        int code = sc.nextInt();

        return code;
    }
}
