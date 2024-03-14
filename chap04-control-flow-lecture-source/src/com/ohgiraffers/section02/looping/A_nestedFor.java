package com.ohgiraffers.section02.looping;

public class A_nestedFor {

    public void printGugudanFromTwoToNine(){

        /*중첩된 for문의 흐름을 이해하고 적용할 수 있다(1)
        * for문 안에서 for문을 이용할 수 있다
        * 2단부터 단을 1씩 증가시키는 반복문*/
        for(int dan = 2; dan < 10; dan++){

            /*단이 1개씩 증가하는 동안 수행할 내용은 해당 단의 구구단을 출력하는 것이다*/
            for(int su =1; su < 10; su++){

                System.out.println(dan +" * "+ su + " = " + (dan * su));
            }
            /*한 단이 출력되고 나면 한줄ㅇㄹ 띄운다*/
            System.out.println();
        }
    }
}
