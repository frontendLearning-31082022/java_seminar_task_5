package sort_algorithms;
import sort_algorithms.visualization.HeapVisualization;

import static sort_algorithms.Actions.*;

public class Heap {

    Comparable[] array;
    int size;
    HeapVisualization heapVisualization=new HeapVisualization();

    public Heap(Comparable[] array) {
        this.array=array;
        this.size=array.length;
    }

    private void sort(){
        for (int i = size/2; i >= 1; i--)sink( i, size);

        heapVisualization.markPoint(array,null,size,"с последнего элемента до\n начала. Каждый[i] меняес с первым и sink(1,size=i)");
        int i=size;
        while (i > 1) {
            exch(array,O(1),O(i--));
            heapVisualization.markPoint(array,1,i+1,i,"swaped() На итерации size->2");
            sink(1,i);
            heapVisualization.markPoint(array,i,size,"changeCursor(i), size="+(i));
        }
        new String();
    }

    public static void sort(Comparable[] array,boolean Visual) {
        Heap heap=new Heap(array);
        heap.heapVisualization.TurnOn=Visual;
        heap.sort();
    }

    private void sink(int from, int size) {
        heapVisualization.markPoint(array,from,size,"sink() from , size="+size);

        int lChild_i = 2*from;
        while (lChild_i <= size) {
            if (lChild_i < size && less(array[O(lChild_i)], array[O(lChild_i+1)]))lChild_i++;
            if (less(array[O(lChild_i)],array[O(from)]))break;
            exch(array, O(from), O(lChild_i));
            heapVisualization.markPoint(array,from,lChild_i,size,"swaped() , size="+size);
            from = lChild_i;
            heapVisualization.markPoint(array,from,size,"changeCursor(from), size="+size);
            lChild_i = 2*from;
        }
    }

    int O(int from1){
        return from1-1;
    }


    public static void main(String[] args) {
//        Comparable[] array = {16, 2, 3, 1, 5, 9, 22, 55, 8};
        Comparable[] array = {6,5,3,1,8,7,2,4};

        Heap.sort(array,false);
        new String();
    }
}
