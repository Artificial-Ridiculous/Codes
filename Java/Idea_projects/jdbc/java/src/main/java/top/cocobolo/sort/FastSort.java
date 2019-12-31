package top.cocobolo.sort;

/**
 * @auther lz
 * @create 2019-08-22 16:09
 */
public class FastSort {
    public void sort(int[] nums){
        sort(nums,0,nums.length-1);
    }

    private void sort(int[] nums, int start, int end){
        int split = nums[start];
        int i = start;
        int j = end;
        while(i < j){
            while(i<j && nums[j]>=split){
                j-=1;
            }
            while(i<j && nums[i]<= split){
                i+=1;
            }
            swap(nums,i,j);
        }
        swap(nums,start,j);
        if(j-start >= 2){
            sort(nums, start, j-1);
        }
        if(end-j >= 2){
            sort(nums, j+1, end);
        }
    }

    private void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void print(int[] nums){
        for(int i : nums){
            System.out.print(i+" ");

        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] nums = {3,1,6,2,5,8,4,7};
        FastSort fastSort = new FastSort();
        fastSort.print(nums);
        fastSort.sort(nums);
        fastSort.print(nums);
    }
}
