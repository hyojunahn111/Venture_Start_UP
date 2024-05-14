package com.ohgiraffers.section02.annotation.sub05.inject;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;

@Service("pokemonFieldInject")
public class PokemonField {

    private Pokemon pokemon;

//    /* 1. 힐드 주입 */
//    @Inject
//    @Named("pikachu")
//    private Pokemon pokemon;

    /* 2. 생성자 주입*/
//    @Inject
/*    @Named 어노테이션은 메소드 레벨, 파라미터 레벨에서 사용 가능하다 */
//    public PokemonField(@Named("charmander") Pokemon pokemon){
//        this.pokemon = pokemon;
//    }


    /*3, setter 주입*/
    @Inject
    public void setPokemon(@Named("charmander")Pokemon pokemon) {
        this.pokemon = pokemon;
    }


    public void pokemonAttack(){
        pokemon.attack();
    }
}
