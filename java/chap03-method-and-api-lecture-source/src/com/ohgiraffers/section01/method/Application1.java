package com.ohgiraffers.section01.method;

public class Application1 {
    public static void main(String[] args) {

        /*메소드 호출 흐름에 대해 이해할 수 있다*/
        /*메소드란?
         * 메소드(method)는 어떤 특정 작업을 수행하기 위한 명령문의 집합이라고 할 수 있다*/

        System.out.println("main() 시작됨...");

        /*1. main method밖에 하단에 methodA라는 메소드를 추가한다*/

        /*2. 작성한 메소드를 호출하는 부분을 작성한다*/
        /*메소드 호출 방법
         * 클래스명 사용할이름 = new 클래스명();
         * 사용할이름.메소드명();*/


        Application1 app1 = new Application1();
        app1.methodA();

        System.out.println("main() 종료됨...");
    }

        /*1-1 methodA 작성*/
        public void methodA(){

            System.out.println("methodA() 호출함...");

            /*1-2 methodB 호출*/
        methodB();

            System.out.println("methodA() 종료됨...");

        }



        /*1-3 methodB 작성*/

        public void methodB(){
            System.out.println("methodB() 호출함...");

            /*1-4 methodC호출*/
            methodC();

            System.out.println("methodB종료됨...");
        }

        public void methodC(){
            System.out.println("methodC()호출함...");
            System.out.println("methodC()종료됨...");
        }
    }
