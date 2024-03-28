package com.ohgiraffers.setction03.overriding;

public class SubCalss extends SuperClass{

    /*extends SuperClass를 추가해야 오버라이딩이 가능하다*/

    /*1. 메소드 이름 변경하면 에러 발생*/
//    @Override
//    public void method(int num){}

    /*2. 메소드의 리턴타입 변경하면 에러 발생*/
//    @Override
//    public int method(int num){return 0;}

    /*3. 매개변수 갯수나, 타입이 변경되면 에러가 발생한다*/
//    @Override
//    public void method(String num){}

    /*4. 메소드 이름, 리턴타입, 매개변수의 갯수, 타입, 순서, 일치할 경우 오버라이딩 성립*/
    @Override
    public void method(int num){}

    /*private은 오버로딩이 불가능하다*/
//    @Override
//    private void privateMethod(){}

    /*6. final 키워드가 사용된 메소드는 오버라이딩 불가능*/
//    @Override
//    public final void finalMethod(){}

//    @Override
//    void protectedMethod(){}

//    @Override
//    protected void protectedMethod(){}

    @Override
    public void protectedMethod(){}

    /*참고로 클래스에도 final 키워드를 추가할 수 있는데 이는 상속을 제한하는 키워드이다(클래스 확장 불가)*/
}
