package com.ohgiraffers.section01.remix;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do {
            System.out.println("========== 메뉴 관리 ==========");
            System.out.println("1. 전체 메뉴 조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 기존 메뉴 변경");
            System.out.println("5. 기존 메뉴 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.println("==============================");
            System.out.print("메뉴 관리 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: menuController.selectAllMenu(); break;
                case 2: menuController.selectMenuByCode(inputMenuCode()); break;
                case 3: menuController.registMenu(inputMenu()); break;
                case 4: menuController.modifyMenu(inputModifyMenu()); break;
                case 5: menuController.deleteMenu(inputMenuCode()); break;
                case 9: System.out.println("메뉴 관리 프로그램을 종료합니다."); return;
                default: System.out.println("잘못된 관리 번호입니다."); break;
            }

        } while(true);

    }

    private static Map<String, String> inputMenuCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 코드를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }

    private static Map<String, String> inputMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("메뉴 가격을 입력하세요 : ");
        String price = sc.nextLine();
        System.out.print("카테고리 코드를 입력하세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    private static Map<String, String> inputModifyMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정 대상 메뉴 코드를 입력하세요 : ");
        String code = sc.nextLine();
        System.out.print("수정할 메뉴 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("수정할 메뉴 가격을 입력하세요 : ");
        String price = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        parameter.put("name", name);
        parameter.put("price", price);

        return parameter;
    }

}
