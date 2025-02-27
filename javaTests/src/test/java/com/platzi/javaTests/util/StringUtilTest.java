package com.platzi.javaTests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeatStringOnce() {
        Assert.assertEquals("Hola", StringUtil.repeat("Hola", 1));
        Assert.assertEquals("HolaHolaHolaHolaHola", StringUtil.repeat("Hola", 5));
    }

    @Test
    public void repeatStringMultipleTimes() {
        Assert.assertEquals("HolaHolaHola", StringUtil.repeat("Hola", 3));
    }

    @Test
    public void repeatStringZeroTimes() {
        Assert.assertEquals("", StringUtil.repeat("Hola", 0 ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeatStringNegativeTimes() {
        Assert.assertEquals("", StringUtil.repeat("Hola", -1));
    }


}