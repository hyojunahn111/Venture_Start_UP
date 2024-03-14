package com.ohgiraffers.section02.looping;

public class A_for {

    public void testSimpleForStatement(){

        /*for문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다*/
        /*[for문 표현식]
        * for초기식; 조건식; 증감식;){
        *       조건을 만족하는 경우 수행할 구문(반복할 구문);
        * }
        * */

        /*1부터 10까지 1씩 증가시키면서 (10번) i값을 출력하는 기본 반복문
        * */
        for(int i =1; i<= 10; i++){
            System.out.println(i);
        }

    }

    /*기본 반복문 이용해서 조금씩 바꿔가며 우선 문법을 익숙해지도록 하자*/
    /*1. 증감식이 없는 경우
    * 2. 조건식이 없는 경우
    * 3. 초기식, 조건식, 증감식이 없는 경우
    * 4. 초기식, 조건식, 증감식 등을 변경하고 실행 값 예측해보기
    * 5. 역순으로 반복된 실행
    * 등등 필요에 따라 더 기본 반복문을 변형해가며 테스트 해보자*/

}
