public abstract class Sort<T extends Comparable<T>>{
    public abstract void sort(T[] nums);

    protected boolean less(T x, T y){
        return x.compareTo(y) < 0;
    }

    protected void swap(T[] a,int i,int j){
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

public class Selection<T extends Comparable<T>> extends Sort<T>{
    @Override
    public void Sort(T[] nums){
        
        for(int i = 0; i< nums.length; i++){
            min = i;
            for(int j =i; j< nums.length;j++){
                if (less(nums[j],nums[min])){
                    min = j;
                }
            }
            swap(nums, min, i);            
        }
    }
}

