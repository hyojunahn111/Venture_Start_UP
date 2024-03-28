package com.ohgiraffers.section02.looping;

public class Application {
    public static void main(String[] args) {

        A_for a = new A_for();
        /*단독 for문 흐름 확인용 메소드 호출*/
//        a.testSimpleForStatement();

        /*반복문을 사용하는 예제*/
//        a.testForExample1();

//        a.testForExample2();

//        a.testForExample3();

//        a.testForExample4();

        /*반복문을 일상 생활에서 사용하는 예제*/
//        a.printSimpleGugudan();

        A_nestedFor an = new A_nestedFor();
        /*중첩 반복문을 사용하는 예제*/
//        an.printGugudanFromTwoToNine();

//        an.printGugudanFromTwoToNine();

//        an.printStarInputRowTimes();

//        an.printTriangleStars();

        B_while bw = new B_while();

//        bw.testSimpleWhileStatement();

//        bw.testWhileExample1();

//        bw.testWhileExample2();
//        bw.testWhileExample3();

        C_doWhile cd = new C_doWhile();

//        cd.testSimpleDoWhileStatement();

        cd.testDoWhileExample1();
    }
}
