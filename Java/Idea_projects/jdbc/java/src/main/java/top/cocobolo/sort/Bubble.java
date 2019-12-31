package top.cocobolo.sort;

/**
 * @auther lz
 * @create 2019-08-22 15:36
 */
public class Bubble<T extends Comparable<T>> extends Sort<T>{

    public void sort(T[] nums) {
        boolean exchanged = false;
        for (int i=nums.length-1 ; i >=0; i--){
            for (int j = 0; j< i; j++){
                if(less(nums[j+1],nums[j])){
                    swap(nums,j+1,j);
                    exchanged = true;
                }
            }
            if(exchanged){
                break;
            }
        }
    }
    public static void main(String[] args) {
        Bubble<Integer> bubble = new Bubble<Integer>();
        Integer[] nums = {3,5,2,4,1};
        bubble.print(nums);
        bubble.sort(nums);
        bubble.print(nums);

    }
}
