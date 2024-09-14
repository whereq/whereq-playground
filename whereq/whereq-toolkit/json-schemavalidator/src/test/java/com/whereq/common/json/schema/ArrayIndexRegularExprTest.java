package com.whereq.common.json.schema;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class ArrayIndexRegularExprTest {
    @Test
    public void testArrayIndexPattern() {
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9$_]+)\\[([0-9\\s]*)\\]$");
        Matcher m1 = pattern.matcher("a[3]");
        Assert.assertTrue(m1.find());
        Assert.assertEquals("3", m1.group(m1.groupCount()));
        Assert.assertEquals("a", m1.group(1));
        Matcher m2 = pattern.matcher("a[     ]");
        Assert.assertTrue(m2.find());
        Assert.assertEquals("", StringUtils.trim(m2.group(m2.groupCount())));
        Assert.assertEquals("a", m2.group(1));
    }
}
