package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class C_ifElseIf {

    public void testSimpleIfElseIfStatement(){

        /*if-else-if문 단속 사용에 대한 흐름을 이해하고 적용할 수 있ㄷ*/

        /*[if-else-if문 표현식]*/
        /*if(조건식1){
        *       조건식1이 true일 때 실행할 명령문;
        * }else if(조건식2){
        *       조건식1이 false이고 조건식2가 true일 때 실행할 명령문;
        * }else{
        *       위의 조건 2개가 모두 거짓인 경우 실행할 명령문;
        * }*/

        /*if-else-if문은 조건식1의 결과 값이 참(true)이면 if {} 안에 있는 코드를 실행하고,
        * 조건식1이 false이면 조건2를 확인하여 참(true)이면 else if {} 안에 있는 코드를 실행한다.
        * 조건식1, 2의 결과 값이 모두 거짓(false)이면 else{} 안에 있는 코드를 실행한다*/

        /*여러 개의 조건을 제시하여 그 중 한 가지를 반드시 실행시키고 싶은 경우 사용한다*/

        /*금도끼 은도끼 동화에서 산실령이 어떤 동끼가 나무꾼의 도끼인지 물어보는 시나리오대로 코드를 작성하고
        * 실행하보자!*/

        System.out.println("신 속에서 나무를 하던 나무꾼이 연못에 도끼를 빠뜨리고 말았다.");
        System.out.println("연못에서 산실령이 나타나 금도끼가, 은도끼, 쇠도끼를 들고 나타났다.");
        System.out.println("나무꾼에게 셋 중 어느 도끼가 네 도끼냐 물어보았다");

        /*문자열 비교하는 equals()를 사용해 문자열로 입력을 받아도 된다*/
        System.out.println("어느 도끼가 너의 도끼이냐?(1. 금도끼, 2. 은도끼, 3.쇠도끼 :");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();

        /*대답한 내용이 금도끼인지 확인하는 조건식*/
        if(answer == 1){
            /*금도끼라고 대답한 경우 출력할 내용*/
            System.out.println(("이런 거짓말 쟁이!! 너에게는 아무런 도끼도 줄 수 없구나! 이 욕심쟁이야!"));
        }else if(answer == 2){

            /*은도끼라고 대답한 경우 출력할 내용*/
            System.out.println("욕심이 과하지는 않지만 그래도 넌 거짓말을 하고 있구나!! 꺼지거라.");
        }else{
            /*쇠도끼라고 대답한 경우 출력할 내용*/
            System.out.println("정직하구나. 도끼 다 가지거라");
        }
        /*대답 여부와 상관 없이 마지막에 실행하는 내용*/
        System.out.println("산실령 사라짐");
    }
}
