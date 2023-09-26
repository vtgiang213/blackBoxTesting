package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class calcWaterBillTest {
    private calcWaterBill tester;

    @BeforeEach
    public void setUp() {
        tester = new calcWaterBill();
    }

    public static Stream<Arguments> dataEcpMethod() {
        return Stream.of (
                Arguments.of(7, 3, 0),
                Arguments.of(7, 9, 0),
                Arguments.of(7, -7, -1),
                Arguments.of(7, 22, -1),
                Arguments.of(23, 3, 160000),
                Arguments.of(23, 9, 80000),
                Arguments.of(23, -7, -1),
                Arguments.of(23, 22, -1),
                Arguments.of(38, 3, 575000),
                Arguments.of(38, 9, 287500),
                Arguments.of(38, -7, -1),
                Arguments.of(38, 22, -1),
                Arguments.of(-5, 3, -1),
                Arguments.of(-5, 9, -1),
                Arguments.of(-5, -7, -1),
                Arguments.of(-5, 22, -1));
    }

    @ParameterizedTest
    @MethodSource("dataEcpMethod")
    void waterCostTest1(int u, int m, int result) {
        assertEquals(result, tester.waterCost(u, m));
    }

    public static Stream<Arguments> dataDeciTableMethod() {
        return Stream.of (
                Arguments.of(-2, -5, -1),
                Arguments.of(-2, 4, -1),
                Arguments.of(-2, 8, -1),
                Arguments.of(-2, 15, -1),
                Arguments.of(6, -5, -1),
                Arguments.of(6, 4, 0),
                Arguments.of(6, 8, 0),
                Arguments.of(6, 15, -1),
                Arguments.of(30, -5, -1),
                Arguments.of(30, 4, 300000),
                Arguments.of(30, 8, 150000),
                Arguments.of(30, 15, -1),
                Arguments.of(40, -5, -1),
                Arguments.of(40, 4, 625000),
                Arguments.of(40, 8, 312500),
                Arguments.of(40, 15, -1));
    }

    @ParameterizedTest
    @MethodSource("dataDeciTableMethod")
    void waterCostTest2(int u, int m, int result) {
        assertEquals(result, tester.waterCost(u, m));
    }
}