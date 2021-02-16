package com.demo.testing.mockito.case1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalcService1Test {

    @Test
    public void testCalc() {

        // Arrange (Given)
        AddService addService = mock(AddService.class);
        CalcService calcService = new CalcService(addService);

        int num1 = 11;
        int num2 = 12;
        int expected = 46;

        when(addService.add(num1, num2)).thenReturn(num1 + num2);

        // Act (When)
        int actual = calcService.calc(num1, num2);

        // Assert (Then)
        assertEquals(expected, actual);
    }
}