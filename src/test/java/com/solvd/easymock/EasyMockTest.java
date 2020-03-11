package com.solvd.easymock;

import com.solvd.util.Calculator;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;

public class EasyMockTest {

    @Mock
    private Calculator mockCalculator;

    @Test
    public void testList() {
        List<Integer> mockList = mock(ArrayList.class);
        expect(mockList.add(10)).andReturn(true);
        expect(mockList.add(20)).andReturn(true);
        expect(mockList.size()).andReturn(2);
        expect(mockList.get(0)).andReturn(10);
        expect(mockList.get(1)).andReturn(20);
        replay(mockList);

        mockList.add(10);
        mockList.add(20);

        Assert.assertEquals(mockList.get(1), Integer.valueOf(20));
        Assert.assertEquals(mockList.get(0), Integer.valueOf(10));
        Assert.assertEquals(mockList.size(), 2);
    }

    @Test
    public void testAddWithoutMock() {
        int a = 5;
        int b = 6;
        int expected = 11;
        int actual = new Calculator().add(a, b).intValue();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAddWithMock() {
        int expected = 5;
        EasyMockSupport.injectMocks(this);
        expect(mockCalculator.add(2, 2)).andReturn(5);
        replay(mockCalculator);
        Assert.assertEquals(mockCalculator.add(2, 2).intValue(), expected);
    }

}
