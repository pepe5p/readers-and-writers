package com.pkaras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test
    void requestReadScenario() throws InterruptedException {
        Resource resource = new Resource(2137);
        Library library = new Library(resource);
        assertEquals(5, library.semaphore.availablePermits());
        library.requestPermits(1);
        assertEquals(4, library.semaphore.availablePermits());
        Resource readResource = library.getResource();
        assertEquals(resource, readResource);
        library.finishPermits(1);
        assertEquals(5, library.semaphore.availablePermits());
    }

    @Test
    void requestWriteScenario() throws InterruptedException {
        Resource resource = new Resource(2137);
        Resource newResource = new Resource(997);
        Library library = new Library(resource);
        assertEquals(5, library.semaphore.availablePermits());
        library.requestPermits(5);
        assertEquals(0, library.semaphore.availablePermits());
        library.setResource(newResource);
        assertEquals(newResource, library.getResource());
        library.finishPermits(5);
        assertEquals(5, library.semaphore.availablePermits());
    }
}