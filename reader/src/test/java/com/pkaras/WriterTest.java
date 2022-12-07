package com.pkaras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WriterTest {
    @Test
    void requestReadScenario() {
        Resource resource = new Resource(2137);
        Library library = new Library(resource);
        Writer writer = new Writer(0, library, 1);
        writer.run();
        assertFalse(writer.isAlive());
    }
}