package com.zhdan.algorithms.io;

import org.junit.Test;

public class IOWriterTest {

    @Test
    public void test() {
        IOWriter writer = new IOWriter(System.out);
        writer.append("test ").append(123).printlnAll();
        writer.close();
    }
    
}