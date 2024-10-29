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

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String PREDATOR = "";
    private static final String NEUTRAL = "Нейтральный";
    private static final int NUMBER_OF_CATS = 3;
    @Mock
    private Feline feline;

    static Stream<Object[]> data() {
        return Stream.of(new Object[][]{
                {MALE, true},
                {FEMALE, false}
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
            new Lion(NEUTRAL, feline);
        });
        Assertions.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
    @Test
    public void testGetKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(NUMBER_OF_CATS);

        Lion lion = new Lion(MALE, feline);

        Assertions.assertEquals(NUMBER_OF_CATS, lion.getKittens());
    }
    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood(PREDATOR)).thenReturn(expectedFood);

        Lion lion = new Lion(MALE, feline);

        Assertions.assertEquals(expectedFood, lion.getFood());
    }

}
