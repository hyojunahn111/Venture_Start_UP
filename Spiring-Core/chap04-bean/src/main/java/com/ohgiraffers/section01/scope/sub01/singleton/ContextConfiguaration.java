package com.ohgiraffers.section01.scope.sub01.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguaration {


    @Bean
    public Product carpBread(){
        return new Bread("붕어빵", 1500, new java.util.Date());
    }

    @Bean
    public Product milk(){
        return new Beverage("초코우유", 1800, 300);
    }

    @Bean
    public Product water(){
        return new Beverage("지리산암반수", 2000, 500);
    }

    @Bean
    @Scope("singleton")
    public ShoppingCart shoppingCart(){
        return new ShoppingCart();
    }
}
