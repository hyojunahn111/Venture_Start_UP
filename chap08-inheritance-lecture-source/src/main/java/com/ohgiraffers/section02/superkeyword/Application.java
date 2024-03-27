package com.ohgiraffers.section02.superkeyword;

public class Application {

    public static void main(String[] args) {

        /*Product 기본 생성자로 인스턴스 생성 후 정보 출력*/
        Product product1 = new Product();
        System.out.println(product1.getInformation());

        /*Product의 모든 필드를 초기화하는 생성자로 인스턴스 생성 후 정보 출력*/
        Product product2 = new Product("S-12", "samsung", "Z", 10000000, new java.util.Date());
        System.out.println(product2.getInformation());

        /*Computer 기본생성자로 인스턴스 생성 후 정보 출력*/
        Computer computer1 = new Computer();
        System.out.println(computer1.getInformation());

        /*Computer 모든 필드를 초기화하는 생성자로 인스턴스 생성 후 정보 출력*/
        Computer computer2 = new Computer("뭔가", 500, 12, "안드로");
        System.out.println(computer2.getInformation());

        /*Computer 부모필드도 함계 초기화하는 생성자로 인스턴스 생성 후 정보 출력*/
        Computer computer3 = new Computer("S-14", "sam", "fold", 100000, new.java.util.Date(), "+ 드래곤", 512, 12, "안드로이드");
    }


}
