package com.pkaras;

import java.security.SecureRandom;


public class Writer extends BaseWorker {
    static final int WRITER_SIZE = 5;
    SecureRandom random;

    Writer(
        Integer writerNumber,
        Library library,
        int numberOfWrites
    ) {
        super(writerNumber, library, numberOfWrites, WRITER_SIZE);
        random = new SecureRandom();
    }

    @Override
    void execute() throws InterruptedException {
        Thread.sleep(2500);
        Resource newResource = new Resource(random.nextInt());
        library.setResource(newResource);
        print(String.format("finished writing %s", newResource));
    }

    @Override
    void print(String message) {
        Console.print(
            "\u001B[31m",
            String.format("[writer:%d] %s", number, message)
        );
    }
}
