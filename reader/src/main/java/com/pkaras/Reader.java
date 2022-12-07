package com.pkaras;


public class Reader extends BaseWorker {
    static final int READER_SIZE = 1;

    Reader(
        Integer readerNumber,
        Library library,
        int numberOfReads
    ) {
        super(readerNumber, library, numberOfReads, READER_SIZE);
    }

    @Override
    void execute() throws InterruptedException {
        Thread.sleep(1200);
        Resource resource = library.getResource();
        print(String.format("read %s", resource.toString()));
    }

    @Override
    void print(String message) {
        Console.print(
            "\u001B[32m",
            String.format("[reader:%d] %s", number, message)
        );
    }
}
