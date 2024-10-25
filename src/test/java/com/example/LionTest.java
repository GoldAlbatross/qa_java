package com.example;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline feline;

    static Stream<Object[]> data() {
        return Stream.of(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testLionHasMane(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, feline);
        Assertions.assertEquals(expectedHasMane, lion.doesHaveMane());
    }
    @Test
    public void testLionHasManeException() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            new Lion("Нейтральный", feline);
        });
        Assertions.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
    @Test
    public void testGetKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);

        Assertions.assertEquals(3, lion.getKittens());
    }
    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", feline);

        Assertions.assertEquals(expectedFood, lion.getFood());
    }

}
