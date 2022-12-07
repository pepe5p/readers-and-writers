package com.pkaras;

import org.apache.commons.lang.NotImplementedException;

public class BaseWorker extends Thread {
    int size;
    Integer number;
    Library library;
    int numberOfActions;
    boolean finite;

    BaseWorker(
        Integer number,
        Library library,
        int numberOfActions,
        int size
    ) {
        this.number = number;
        this.library = library;
        this.numberOfActions = numberOfActions;
        this.size = size;
        finite = numberOfActions != 0;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; !finite || i < numberOfActions; i++) {
                performAction();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    void performAction() throws InterruptedException {
        print("is waiting");
        library.requestPermits(size);
        print(
            String.format(
                "is in library | available %d | in queue %d",
                library.semaphore.availablePermits(),
                library.semaphore.getQueueLength()
            )
        );
        execute();
        print("left library");
        library.finishPermits(size);
    }

    void execute() throws InterruptedException {
        throw new NotImplementedException();
    }

    void print(String message) {
        Console.print(
            "",
            String.format("[worker:%d] %s", number, message)
        );
    }
}
