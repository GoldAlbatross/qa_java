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

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Spy
    Feline felineSpy;

    @Test
    public void testEatMeat() throws Exception {
        // Ожидаемый результат
        List<String> expectedFood = Arrays.asList("Мясо", "Курица", "Рыба");

        Mockito.doReturn(expectedFood).when(felineSpy).getFood("Хищник");

        List<String> actualFood = felineSpy.eatMeat();
        Assertions.assertEquals(expectedFood, actualFood);
    }
    @Test
    public void testGetFamily() {
        Assertions.assertEquals("Кошачьи", felineSpy.getFamily());
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
