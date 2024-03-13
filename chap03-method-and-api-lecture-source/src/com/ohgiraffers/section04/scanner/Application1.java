package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        /*java,util.Scanner를 이용한 다양한 자료형 값 입력 받기*/
        /*콘솔 화면에 값을 입력 받아 출력해보기*/
        /*이런 어려운 기능 또한 미리 JDK를 설치하면 손쉽게 사용할 수 있도록 구현해 놓았다*/


        /*1. Scanner 객체 생성*/
        /*1-1 원래 이렇게 Scanner 객체를 만들어야 한다*/
//        java.util.Scanner sc = new java.util.Scanner(java.lang.System.in);

        /*1-2 하지만 java.lang은 패키지 이름 생략 가능하다*/
//        java.util.Scanner sc = new java.util.Scanner(System.in);

        /*1-3 다른 패키지에 있는 클래스 사용 시 패키지명 생략하기 위해 사용하는 구문 사용(import)*/
        Scanner sc = new Scanner(System.in);

        /*2. 자료형별 값 이력받기*/
        /*입력받을 때 안내문구는 별도로 출력해주지 않으니 우리가 작성해줘야한다*/
        /*print와 prinln은 줄 바꿈 차이이다
        * 다음줄에 입력을 대기시키자는 것이 아니고 줄바꿈하지 않고 입력받게 하기 위해 pront를 사용했다
        * */

        /*nextByte()/nextShort{}는 생략한다*/
        /*매개변수로 사용할 수 radix는 진법을 지정할 수 있다*/
        /*숫자가 아닌 값을 입력하게 되면 inputMismatchException이 발생한다
        * \Exception은 나중에 다시 다루게 되겠지만 쉽게 표현하자면 에러 같은 개념이라고 생각하자*/

        System.out.println("나이를 입력하세요 : ");
        int age = sc.nextInt();
        System.out.println("입력하신 나이는 " + age + "입니다.");

        /*nextLong() : 입력받은 값을 long형으로 반환한다
        * nextInt와 Exceoption이 발생하는 이유는 동일하다*/

        System.out.println("금액을 입력해주세요 : ");
        long money = sc.nextLong();
        System.out.println(("입력하신 금액은 : " + money + "원 입니다"));

        /*2-3 실수형 값 이력 받기
        * nextFloat() : 입력받은 값은 float형으로 반환한다
        * 정수형태로 입력받으면 실수로 변환 후 정상 동작
        * 숫자 형태의 값이 아닌 경우 InputMismatchException 발생
        * */
//        System.out.println("키를 입력해주세요 : ");
//        float height = sc.nextFloat();
//        System.out.println("입력하신 키는 : " + height +"cm 입니다.");

        /*nextDouble() :  입력받은 값을 double형으로 반환한다
        * 정수 형태로 입력받으면 실수로 변환 후 정상 동작
        * 숫자 형의 값이 아닌 경우 InputmatchException 발생
        *
        * */
//        System.out.println("원하는 실수를 입력하세요 : ");
//        double number = sc.nextDouble();
//        System.out.println("입력하신 실수는 : " + number + "입니다. ");

        /*2-4 논리형 값 입력받기
        * nextBoolean() : 입력받는 값을 boolean형으로 반환한다
        * true or false 외에 다른 값을 입력하게 되면 InputMismatchException 발생함*/
//        System.out.println("참과 거짓 중 한가지를 true or false로 입력해주세요 : ");
//        boolean isTrue = sc.nextBoolean();
//        System.out.println("입력하신 논리 값은 " + isTrue + "입니다.");

        /*2-5 문자형 값 입력받기*/
        /*아쉽게도 문자를 직접 입력 받는 기능을 제공하지는 않는다*/
        /*따라서 문자열로 입력을 받고, 입력받은 문자에서 원하는 순번째 문자를 분리해서 사용해야 한다*/
        /*java.lang.String에 charAt(int index)를 사용한다*/
        /*index를 정수형으로 입력하면 문자열에서 해당 인덱스에 있는 한 문자를 문자형으로 반환해주는 기능을 한다
        * index 0부터 시작하는 숫자 체계이며 컴퓨터에서 주로 사용되는 방식이다
        * 만약 존재하지 않는 인덱스를 입력하게 되면 IndexOutOfBoundsException이 발생한다*/

        sc.nextLine();
        System.out.println("아무 문자나 입력해주세요 : ");
        char ch = sc.nextLine().charAt(0);
        System.out.println("입력하신 문자는 " + ch + "입니다.");




    }
}
