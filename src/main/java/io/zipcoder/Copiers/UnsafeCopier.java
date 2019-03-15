package io.zipcoder.Copiers;


import io.zipcoder.Copiers.Copier;

public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        makeCopy();
    }
}