package sort_algorithms;

import java.util.ArrayList;
import java.util.stream.Stream;

import static sort_algorithms.Actions.*;

public class Bucket_loop {

    public static void sort(Comparable[] array) {
        showIteration(array,null,null,"Изначальный массив");
        int size = array.length;
        Comparable min = array[0];Comparable max = array[0];

        for (int i = 1; i < size; i++) {
            if (less(max, array[i])) max = array[i];
            if (less(array[i], min)) min = array[i];
        }
//        showComment("Найдены max-%d и min-%d . Ведро из %d ячеек",max,min,max);
        ArrayList<Comparable>[] bucket=Stream.generate(ArrayList::new)
                .limit(intGet(max) - intGet(min) + 1).toArray(ArrayList[]::new);

//        showComment("Каждый элемент массива помещаем в ячейку ведра номер \"текущий элемент массива-минимальный\"");
        for (int i = 0; i < array.length; i++){
            bucket[intGet(array[i]) - intGet(min)].add(array[i]);
            showIteration(bucket,intGet(array[i]) - intGet(min),null,"элемент "+array[i]);
        }

        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i].isEmpty()) continue;
            for (int j = 0; j < bucket[i].size(); j++) {
                array[k]=bucket[i].get(j);
                k++;
            }

        }

    }

    static void showComment(String msg,Object... args){
        System.out.printf(msg+"\n",args);
    }
    static void showIteration(Object[] array, Integer el_i, Integer el_j, String comment){
//        return;

//        if (el_i==el_j)return;

        String[] array_in=new String[array.length];
        for (int i = 0; i < array.length; i++) {
            array_in[i]=array[i].toString();
        }

        if (el_i!=null)array_in[el_i]="{"+array_in[el_i]+"}";
        if (el_j!=null)array_in[el_j]="{"+array_in[el_j]+"}";

        String print_res=String.join("\t",array_in);
        System.out.println(comment+"||||\t"+ print_res);
    }

    public static void main(String[] args) {
//        Comparable[] array = {16, 2, 3, 1, 5, 9, 22, 55, 8};
        Comparable[] array = {7,6,4,8,6,5,7,8,6,6,4,2,6,1,3,5};
        Bucket_loop.sort(array);
        new String();
    }
}
