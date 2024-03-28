package com.ohgiraffers.section01.conditional;

public class Application {
    public static void main(String[] args) {

        /*여기서 테스트 할 클래스들은 클래스 네이밍 규칙에 어긋나긴 하지만 정렬을 위해 이름 지은거라 생각하면 된다
        * 모든 메소드는 해당 메소드 내에서 호출할 것이기 때문에 하나 확인 후 다음 메소드 호출하여 다른 것을 확인할 때
        * 주석처리 해서 매번 싦망하지 않도록 한다*/

        A_if a = new A_if();
        /*단독 if문 흐름 확인용 메소드 호출*/
//        a.testSimpleIfStatement();

        /*중첩 if문 흐름 확인용 메소드 호출*/
//        a.testNestedIfStatement();

        B_ifElse b = new B_ifElse();

        /*단독 if-else문 흐름 확인용 메소드*/
//        b.testSimpleIfElseStatement();

        /*중첩 if-else문 흐름 확인용 메소드 호출*/
//        b.testNestedIfElseSatement();

        C_ifElseIf c = new C_ifElseIf();
        /*단독 if-else문 흐름 확인용 메소드 호출 =*/

//        c.testSimpleIfElseIfStatement();

        /*중첩 if-else-if문 흐름 확인용 메소드*/
        c.testNestedIfElseIfStatement();
    }
}