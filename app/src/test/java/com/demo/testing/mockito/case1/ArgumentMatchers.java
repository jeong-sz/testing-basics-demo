package com.demo.testing.mockito.case1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalMatchers.or;
import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

interface PasswordEncoder {
    String encode(String plainText);
}

public class ArgumentMatchers {

    @Mock
    PasswordEncoder passwordEncoder;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testArgMatchers1() {
        // Arrange (Given)
        when(passwordEncoder.encode(eq("abc"))).thenReturn("DEF");

        // Act (When)
        String result = passwordEncoder.encode("abc");

        // Assert (Then)
        assertEquals("DEF", result);
    }

    @Test
    public void testArgMatchers2() {
        // Arrange (Given)
        when(passwordEncoder.encode(or(eq("a"), endsWith("b")))).thenReturn("ZZZ");

        // Act (When)
        String result = passwordEncoder.encode("dumb");

        // Assert (Then)
        verify(passwordEncoder).encode(or(eq("a"), endsWith("b")));
        assertEquals("ZZZ", result);
    }

}

