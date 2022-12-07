package com.pkaras;

public class Driver {
    public static void main(String[] args) {
        Resource resource = new Resource(2137);
        Library library = new Library(resource);
        Reader[] readers = new Reader[10];
        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Reader(i, library, 0);
            readers[i].start();
        }
        Writer[] writers = new Writer[3];
        for (int i = 0; i < writers.length; i++) {
            writers[i] = new Writer(i, library, 0);
            writers[i].start();
        }
    }
}
