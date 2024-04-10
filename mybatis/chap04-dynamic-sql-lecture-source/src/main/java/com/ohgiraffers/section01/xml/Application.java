package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.SearchCriteria;

import java.awt.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("=========== MyBatis Dynamic SQL ===========");
            System.out.println(" 1. if test");
            System.out.println("2. choose(when, otherwise) test");
            System.out.println("3. foreach test");
            System.out.println("4. trim(where, set) test");
            System.out.println("9. 프로그램 종료");
            System.out.println("실행할 메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no){
                case 1:
                    infSubMenu();
                    break;
                case 9 :
                    System.out.println("프로그램을 종료합니다.");
                    return;




            }


        }
     while(true);
    }

    private static void infSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();


        do{
            System.out.println("=========== if Sub Menu ===========");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 조회");
            System.out.println("2. 메뉴명 또는 카테고리명으로 검색한 메뉴 목록 조회");
            System.out.println("9. 이전 메뉴로 이동");
            System.out.println("실행할 메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no){
                case 1 :
                    menuService.selectMenuByPrice(inputPrice());
                    break;
                case 2:
                    menuService.selectMenu(inputSearchCriteria());
                    break;
                case 9:
                    return;
            }
        }while (true);
    }

    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("찾을 메뉴의 최대 금액을 입력하세요 : ");
        int price = sc.nextInt();

        return price;
    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기준을 입력하세요 (category or menu) : ");
        String condition = sc.nextLine();
        System.out.println("검색어를 입력하세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }
}
