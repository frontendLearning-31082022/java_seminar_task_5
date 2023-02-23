package sort_algorithms;

import java.util.Arrays;

import static sort_algorithms.Actions.*;

public class LSD {
    int digitPlace = 1;
    int size;

    Comparable[] array;
    Comparable temp[];

    int coord[]=new int[10];

    Comparable Cur;
    Comparable max;

    public LSD(Comparable[] array) {
        this.array=array;
        this.size = array.length;
        temp = new Comparable[size];
        max =getMax(array);
    }

    public Comparable getMax(Comparable a[]) {
        Comparable max = a[0];
        for (int i = 1; i < a.length; i++) if (less(max, a[i])) max = a[i];
        return max;
    }

    public int D(){
        return (intGet(this.Cur)/digitPlace)%10;
    }


    public static void sort(Comparable[] array) {
        LSD lsd = new LSD(array);
        lsd.sort();

//        change clone to loop - decrease arrays copies
        for (int i = 0; i < array.length; i++)array[i]= lsd.array[i];


        new String();
    }

    private void sort() {
        while(intGet(max)/digitPlace>0){
            int[] count =new int[10];
            for (int i = 0; i < size; i++){
                Cur=array[i];
                count[D()]++;
            }
            showIteration(count,null,null,"Подсчет колиствка в ячейках");

            coord =count;
            showComment("Добавление предыдущего числа в каждую");
            for (int i = 1; i < 10; i++) coord[i] += coord[i - 1];
            showIteration(coord,null,null,"                           ");

            for (int i = size - 1; i >= 0; i--)
            {
                Cur=array[i];
                temp[coord[D()] - 1] = Cur;
                coord[D()]--;
            }
            showIteration(temp,null,null,"Сортировано по разряду "+digitPlace);

            array=temp.clone();
            digitPlace*=10;
        }
    }

    static void showIteration(Object[] array, Integer el_i, Integer el_j, String comment){
        int[] arr=new int[array.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int) array[i];
        }

        showIteration(arr,el_i,el_j,comment);
    }

    static void showIteration(int[] array, Integer el_i, Integer el_j, String comment){
//        return;

//        if (el_i==el_j)return;

        String[] array_in=new String[array.length];
        for (int i = 0; i < array.length; i++) {
            array_in[i]= String.valueOf(array[i]);
        }

        if (el_i!=null)array_in[el_i]="{"+array_in[el_i]+"}";
        if (el_j!=null)array_in[el_j]="{"+array_in[el_j]+"}";

        String print_res=String.join("\t",array_in);
        System.out.println(comment+"||||\t"+ print_res);
    }
    static void showComment(String msg,Object... args){
        System.out.printf(msg+"\n",args);
    }

    public static void main(String[] args) {
        Comparable[] array = {932, 311, 457, 163, 330, 118, 953, 949, 381, 166};
        LSD.sort(array);
        new String();
    }
}
