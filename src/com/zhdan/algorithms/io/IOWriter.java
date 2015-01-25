package com.zhdan.algorithms.io;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Fast writer
 *
 * @author Egor Zhdan
 */
public class IOWriter {

    private PrintWriter writer;
    private StringBuilder builder;

    public IOWriter(String filename) {
        try {
            writer = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public IOWriter(OutputStream stream) {
        writer = new PrintWriter(stream);
    }

    public IOWriter append(Object obj) {
        if (builder == null) {
            builder = new StringBuilder();
        }
        builder.append(obj.toString());
        
        return this;
    }

    public void print(Object obj) {
        writer.print(obj);
    }

    public void println(Object obj) {
        writer.println(obj);
    }

    public void printAll() {
        writer.print(builder.toString());
        builder = new StringBuilder();
    }

    public void printlnAll() {
        writer.println(builder.toString());
        builder = new StringBuilder();
    }
    
    public void close() {
        writer.close();
    }

}
