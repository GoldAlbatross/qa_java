package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    private static final String MEAT = "Мясо";
    private static final String CHICKEN = "Курица";
    private static final String FISH = "Рыба";
    private static final String PREDATOR = "Хищник";
    private static final String FAMILY_CATS = "Кошачьи";
    @Spy
    private Feline felineSpy;

    @Test
    public void testEatMeat() throws Exception {
        // Ожидаемый результат
        List<String> expectedFood = Arrays.asList(MEAT, CHICKEN, FISH);

        Mockito.doReturn(expectedFood).when(felineSpy).getFood(PREDATOR);

        List<String> actualFood = felineSpy.eatMeat();
        Assertions.assertEquals(expectedFood, actualFood);
    }
    @Test
    public void testGetFamily() {
        Assertions.assertEquals(FAMILY_CATS, felineSpy.getFamily());
    }
    @Test
    public  void testGetKittens() {
        Assertions.assertEquals(1, felineSpy.getKittens());
    }
    @Test
    public void  testGetKittensWithCount() {
        Assertions.assertEquals(5, felineSpy.getKittens(5));
    }


}
