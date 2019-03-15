package io.zipcoder.Copiers;

public class SynchronizedBlockCopier extends SafeCopier{

    public SynchronizedBlockCopier(String toCopy) {
        super(toCopy);
    }

    @Override
    public void run() {
        synchronized(this){
            makeCopy();
        }
    }
}
