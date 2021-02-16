package com.demo.testing.mockito.case1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SpyTest2 {

    @Spy
    List<String> listSpy = new ArrayList<>();

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMethod() {
        // Arrange (Given)

        // Act (When)
        listSpy.add("first-element");

        // Assert (Then)
        assertEquals("first-element", listSpy.get(0));

        // Act (When) -- be careful!
        when(listSpy.get(0)).thenReturn("second-element");

        // Assert (Then)
        assertEquals("second-element", listSpy.get(0));
    }
}
