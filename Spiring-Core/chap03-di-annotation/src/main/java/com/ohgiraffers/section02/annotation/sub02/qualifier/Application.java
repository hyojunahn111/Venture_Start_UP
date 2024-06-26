package com.ohgiraffers.section02.annotation.sub02.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        PokemonField field = context.getBean("pokemonFieldQualifier", PokemonField.class);

        field.pokemonAttack();

    }
}
