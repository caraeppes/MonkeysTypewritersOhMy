package io.zipcoder.Copiers;

import java.util.concurrent.locks.ReentrantLock;

public class LockedCopier extends SafeCopier {

    ReentrantLock lock;

    public LockedCopier(String toCopy, ReentrantLock lock) {
        super(toCopy);
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        makeCopy();
        lock.unlock();
    }
}
