package io.zipcoder;

import io.zipcoder.Copiers.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class MonkeyTypewriteTests {

    @Test
    public void MakeCopyTest(){
        // Given
        String toCopy = "I am iterating over this string.";
        Copier lockedCopier = new LockedCopier(toCopy, new ReentrantLock());
        Copier synchronizedCopier = new SynchronizedCopier(toCopy);
        Copier synchronizedBlockCopier = new SynchronizedBlockCopier(toCopy);
        Copier unsafeCopier = new UnsafeCopier(toCopy);
        String expected = toCopy + " ";

        // When
        lockedCopier.makeCopy();
        synchronizedCopier.makeCopy();
        synchronizedBlockCopier.makeCopy();
        unsafeCopier.makeCopy();
        String actualLockedCopy = lockedCopier.copied;
        String actualSynchronizedCopy = synchronizedCopier.copied;
        String actualSynchronizedBlockCopy = synchronizedBlockCopier.copied;
        String actualUnsafeCopy = unsafeCopier.copied;

        // Then
        Assert.assertEquals(expected, actualLockedCopy);
        Assert.assertEquals(expected, actualSynchronizedCopy);
        Assert.assertEquals(expected, actualSynchronizedBlockCopy);
        Assert.assertEquals(expected, actualUnsafeCopy);
    }


    @Test
    public void getDifferenceTest(){
        // Given
        String s1 = "Cara Marie Eppes";
        String s2 = "Cara Eppes";
        Integer expected = 6;

        // When
        Integer actual = MonkeyTypewriter.getDifference(s1, s2);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastSpaceTest(){
        // Given
        String string = "Remove the last space. ";
        String expected = "Remove the last space.";

        // When
        String actual = MonkeyTypewriter.removeLastSpace(string);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void runLockedCopierTest(){
        // Given
        String toCopy = "Copy with locked copier";
        ReentrantLock lock = new ReentrantLock();
        LockedCopier lockedCopier = new LockedCopier(toCopy, lock);
        String expected = toCopy + " ";

        // When
        lockedCopier.run();
        String actual = lockedCopier.copied;

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void runSynchronizedCopierTest(){
        // Given
        String toCopy = "Copy with synchronized copier";
        SynchronizedCopier synchronizedCopier = new SynchronizedCopier(toCopy);
        String expected = toCopy + " ";

        // When
        synchronizedCopier.run();
        String actual = synchronizedCopier.copied;

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void runSynchronizedBlockCopierTest(){
        // Given
        String toCopy = "Copy with synchronized block copier";
        SynchronizedBlockCopier synchronizedBlockCopier = new SynchronizedBlockCopier(toCopy);
        String expected = toCopy + " ";

        // When
        synchronizedBlockCopier.run();
        String actual = synchronizedBlockCopier.copied;

        // Then
        Assert.assertEquals(expected, actual);
    }
}
