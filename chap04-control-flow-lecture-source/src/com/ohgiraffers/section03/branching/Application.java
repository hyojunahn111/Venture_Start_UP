package com.ohgiraffers.section03.branching;

public class Application {
    public static void main(String[] args) {
        A_break ab = new A_break();
        /*break문 흐름 확인용 메소드 호출*/

//        ab.testSimpleBreakStatement();

//        ab.testSimpleBreakStatement2();

//        ab.testJumpBreak();

        B_contiue bc = new B_contiue();

//        bc.testSimpleContinueStatement();

//        bc.TestSimpleContinueStatement2();

        bc.testJumContinue();


    }

}
