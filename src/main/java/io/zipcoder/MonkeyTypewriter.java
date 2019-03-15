package io.zipcoder;

import io.zipcoder.Copiers.*;

import java.util.concurrent.locks.ReentrantLock;

public class MonkeyTypewriter {
    static String intro = "It was the best of times,\n" +
            "it was the blurst of times,\n" +
            "it was the age of wisdom,\n" +
            "it was the age of foolishness,\n" +
            "it was the epoch of belief,\n" +
            "it was the epoch of incredulity,\n" +
            "it was the season of Light,\n" +
            "it was the season of Darkness,\n" +
            "it was the spring of hope,\n" +
            "it was the winter of despair,\n" +
            "we had everything before us,\n" +
            "we had nothing before us,\n" +
            "we were all going direct to Heaven,\n" +
            "we were all going direct the other way--\n" +
            "in short, the period was so far like the present period, that some of\n" +
            "its noisiest authorities insisted on its being received, for good or for\n" +
            "evil, in the superlative degree of comparison only.";

    public static void main(String[] args) {
        unsafeCopierMonkeys();
        lockedCopierMonkeys();
        synchronizedCopierMonkeys();
        synchronizedBlockCopierMonkeys();
    }

    public static void unsafeCopierMonkeys(){
        Copier unsafeCopier = new UnsafeCopier(intro);
        startMonkeys(unsafeCopier);
        printResults(unsafeCopier);
    }

    public static void lockedCopierMonkeys(){
        ReentrantLock lock = new ReentrantLock();
        Copier lockedCopier = new LockedCopier(intro, lock);
        startMonkeys(lockedCopier);
        printResults(lockedCopier);
    }

    public static void synchronizedCopierMonkeys(){
        Copier synchronizedCopier = new SynchronizedCopier(intro);
        startMonkeys(synchronizedCopier);
        printResults(synchronizedCopier);
    }

    public static void synchronizedBlockCopierMonkeys(){
        Copier synchronizedBlockCopier = new SynchronizedBlockCopier(intro);
        startMonkeys(synchronizedBlockCopier);
        printResults(synchronizedBlockCopier);
    }

    public static Integer getDifference(String s1, String s2){
        return s1.length() - s2.length();
    }

    public static String removeLastSpace(String s){
        return s.substring(0, s.length() - 1);
    }

    public static void waitToPrint(){
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }
    }

    public static void printResults(Copier copier){
        waitToPrint();
        String copy = removeLastSpace(copier.copied);
        System.out.println("\n"+ copier.getClass().getSimpleName()+ " Copy:  Difference = "
                + getDifference(intro, copy) + "\n" + copy);
    }

    public static void startMonkeys(Copier copier){
        for(int i = 0; i < 5; i++){
            Thread monkey = new Thread(copier);
            monkey.start();
        }
    }
}