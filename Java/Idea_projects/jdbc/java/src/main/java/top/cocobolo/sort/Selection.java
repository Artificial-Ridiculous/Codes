package top.cocobolo.sort;

/**
 * @auther lz
 * @create 2019-08-22 15:24
 */
public class Selection<T extends Comparable<T>> extends Sort<T>{
    @Override
    public void sort(T[] nums){

        for(int i = 0; i< nums.length; i++){
            int min = i;
            for(int j =i; j< nums.length;j++){
                if (less(nums[j],nums[min])){
                    min = j;
                }
            }
            swap(nums, min, i);
        }
    }


    public static void main(String[] args) {
        Selection<Integer> selection = new Selection<Integer>();
        Integer[] nums = {3,5,2,4,1};
        selection.print(nums);
        selection.sort(nums);
        selection.print(nums);

    }
}
