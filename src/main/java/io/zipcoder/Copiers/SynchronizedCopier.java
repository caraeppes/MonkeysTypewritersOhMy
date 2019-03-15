package io.zipcoder.Copiers;

public class SynchronizedCopier extends SafeCopier {

    public SynchronizedCopier(String toCopy) {
        super(toCopy);
    }

    @Override
    public void run() {
        syncMakeCopy();
    }

    public synchronized void syncMakeCopy(){
        makeCopy();
    }
}
