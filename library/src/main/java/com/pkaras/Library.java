package com.pkaras;

import java.util.concurrent.Semaphore;

public class Library {
    public static final int SIZE = 5;

    private Resource resource;
    final Semaphore semaphore = new Semaphore(SIZE, true);

    Library(Resource resource) {
        this.resource = resource;
    }

    Resource getResource() {
        return resource;
    }

    void setResource(Resource resource) {
        this.resource = resource;
    }

    void requestPermits(int permits) throws InterruptedException {
        semaphore.acquire(permits);
    }

    void finishPermits(int permits) {
        semaphore.release(permits);
    }
}
