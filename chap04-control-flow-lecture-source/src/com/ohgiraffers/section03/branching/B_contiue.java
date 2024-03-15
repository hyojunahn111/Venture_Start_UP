package com.ohgiraffers.section03.branching;

public class B_contiue {

    public void testSimpleContinueStatement(){

        /*continue문 사용에 대한 흐름을 이해하고 적용할 수 있다*/
        /*continue문은 반복문 내에서 사용한다
        * 해당 반복문의 반복 회차를 중간에 멈추고 다시 증감식으로 넘어가게 해준다
        * 일반적으로 if(조건식) {continue;} 처럼 사용된다
        * 보통 반복문 내에서 특정 조건에 대한 예외르 처리하고자 할 때 자주 사용된다*/

        /*1ㅂ터 100 사이의 4의 배수이면서 5의 배수인 값 출력*/
        for(int i =1; i <= 100; i++){
            if(i % 4 == 0 && i % 5 == 0){
                /*i값이 4와 5의 공배수인 경우 i값 출력*/
                System.out.println(i);
            }else{
                /*공배수가 아닌 증감식으로 넘어감*/
                continue;
            }
        }

    }
    public void TestSimpleContinueStatement2(){

        /*중첩 반복문 내 continue문 사용에 대한 흐름을 이해하고 적용할 수 있다*/
        /*continue는 모든 반복문을 건너뛰는 것이 아닌, 자신에게 가장 인접한 반복문 실행만 건너뛴다*/

        /*구구단 2~9단까지 출력
        * 단, 각 단의 수가짝수인 경우 출력을 생략한다*/

        for(int dan = 2; dan < 10; dan++){

            /*여기까지 빠져나옴*/
            for(int su = 1; su < 19; su++){
                if(su % 2 == 0){

                    /*su가 짝수인 경우 해당회차 반복 내용을 건너뛰고 증감식으로 이동*/

                    continue;
                }

                System.out.println(dan + " * " + su + " = " + (dan * su));

            }
            System.out.println();
        }
    }

    public void testJumContinue(){

        /*중첩 반복문 내 continue문 사용시 jump(goto)에 대한 흐름을 이해하고 적용할 수 있다*/
        label:
        for(int dan = 2; dan < 10; dan++){
            /*여기까지 빠져나옴*/
            for(int su = 2; su < 10; su++){
                if(su % 2 == 0){

                    /*su가 짝수인 경우 해당 회차 반복 내용을 건너 뛰고 이름이 부여된 증감식으로 이동*/
                    continue label;

                }
                System.out.println(dan + " * " + su + " = " + dan * su);
            }
            System.out.println();
        }
    }
}
