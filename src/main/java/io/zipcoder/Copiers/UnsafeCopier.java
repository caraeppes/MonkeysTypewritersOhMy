package io.zipcoder.Copiers;

import java.util.NoSuchElementException;

import static java.lang.Thread.sleep;

public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        while (stringIterator.hasNext()) {
            try {
                sleep(10);
                    copied += stringIterator.next() + " ";
            } catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}