package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigMacTestSuite {

    @Test
    void testBigMacBuilder(){
        //given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun(Bun.WITH_SESAME)
                .burgers(2)
                .sauce("standard")
                .ingredient(Ingredient.BACON)
                .ingredient(Ingredient.CUCUMBER)
                .build();

        //when
        Bun bun = bigMac.getBun();
        int burgers = bigMac.getBurgers();
        String sauce = bigMac.getSauce();

        System.out.println(bigMac);

        //then
        assertEquals(Bun.WITH_SESAME, bun);
        assertEquals(2, burgers);
        assertEquals("standard", sauce);
        assertEquals(2, bigMac.getIngredientList().size());
    }
}
