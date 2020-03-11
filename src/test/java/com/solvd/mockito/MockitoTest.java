package com.solvd.mockito;

import com.solvd.util.Calculator;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoTest {

    @Mock
    private Calculator mockCalculator;

    @Test
    public void testList() {
        List mockList = mock(List.class);

        mockList.add(10);
        mockList.add(20);
        mockList.clear();

        verify(mockList).add(10);
        verify(mockList).add(30);

    }

    @Test
    public void testListStub() {
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("first");
        Assert.assertEquals(mockedList.get(0), "first");
    }

    @Test
    public void testCalculator() {
        int expected = 5;
        MockitoAnnotations.initMocks(this);
        when(mockCalculator.add(2, 2)).thenReturn(5);
        Assert.assertEquals(mockCalculator.add(2, 2).intValue(), expected);
    }
}
