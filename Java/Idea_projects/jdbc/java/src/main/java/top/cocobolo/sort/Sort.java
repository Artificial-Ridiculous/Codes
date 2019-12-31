package top.cocobolo.sort;

/**
 * @auther lz
 * @create 2019-08-22 15:24
 */
public abstract class Sort<T extends Comparable<T>>{
    public abstract void sort(T[] nums);

    protected boolean less(T x, T y){
        return x.compareTo(y) < 0;
    }
    protected boolean more(T x, T y){
        return x.compareTo(y) > 0;
    }

    protected void swap(T[] a,int i,int j){
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    protected void print(T[] a){
        for (T t : a){
            System.out.print(t+" ");

        }
        System.out.println("\n---------");
    }
}
