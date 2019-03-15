package io.zipcoder.Copiers;

import java.util.Arrays;
import java.util.Iterator;

public abstract class Copier implements Runnable {
    public Iterator<String> stringIterator;
    public String copied;

    public Copier(String toCopy) {
        this.stringIterator = Arrays.asList(toCopy.split(" ")).iterator();
        this.copied = "";
    }

    public abstract void run();

    public void makeCopy(){
        while (stringIterator.hasNext()) {
            copied += stringIterator.next() + " ";
        }
    }
}
