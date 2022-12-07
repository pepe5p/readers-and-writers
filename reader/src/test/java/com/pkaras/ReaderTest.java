package com.pkaras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {
    @Test
    void requestReadScenario() {
        Resource resource = new Resource(2137);
        Library library = new Library(resource);
        Reader reader = new Reader(0, library, 1);
        reader.run();
        assertFalse(reader.isAlive());
    }
}