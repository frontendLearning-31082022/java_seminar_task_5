package sort_algorithms;

import java.util.Random;

public class Actions {

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    public static void exch(Object[] array, int i, int j) {
        Object swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    public static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    public static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (less(a[i], a[i-h])) return false;
        return true;
    }

    public static void shuffle(Comparable[] array) {
        int size = array.length;
        Random gen=new Random();

        for (int i = 0; i < size; i++) {
            int rndIndex=i+gen.nextInt(size-i);
            exch(array,i,rndIndex);
        }

    }

    public static int intGet(Comparable elem){
        int val= (int) elem;
        return val;
    }

}
