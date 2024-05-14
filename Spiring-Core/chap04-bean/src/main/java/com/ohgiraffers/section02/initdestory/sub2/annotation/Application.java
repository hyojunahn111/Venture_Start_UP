package com.ohgiraffers.section02.initdestory.sub2.annotation;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        /* 1. 첫 번째 손님이 쇼핑 카트를 꺼낸다*/
        ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);

        /* 2. 붕어빵과 초코우유를 담는다*/
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("[cart1 내용]" + cart1.getItems());
        /* 3. 두 번째 손님이 쇼핑 카트를 꺼낸다*/
        ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);

        /* 4. 지리산암반수를 담는다*/
        cart2.addItem(water);

        System.out.println("[cart2 내용]" + cart2.getItems());


        /*
        * init 메소드는 bean 객체 생성 시점에 동작하므로 바로 확인할 수 있지만,
        * destroy 메소드는 bean 객체 소멸 시점에 동작하므로 컨테이너가 종료되지 않은 경우 확인할 수 없다
        * GC(garbage Collection)가 해당 bean을 메모리에서 지울 때 destory 메소드가 동작하는데, 메모리에서 지우기 전에 프로세스는 종료되기 때문이다
        * 따라서 아래와 같이 강제로 컨테이너를 종료시키면 destory 메소드가 동작하는 것을 확인할 수 있다.
        * */
        ((AnnotationConfigApplicationContext) context).close();
    }
}
