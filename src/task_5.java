import sort_algorithms.Bucket_loop;
import sort_algorithms.LSD;

public class task_5 {
    public static void main(String[] args) {
        Comparable[] array=null;

        array= getArray();
        Bucket_loop.sort(array);

        array= getArray();
        LSD.sort(array);

        new String();
    }
    static Comparable[] getArray(){
        return new Comparable[]{2, 5, 9, 1, 3, 8, 3, 6};
    }
}
