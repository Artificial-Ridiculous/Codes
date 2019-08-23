package top.cocobolo.sort;

/**
 * @auther lz
 * @create 2019-08-22 15:50
 */
public class Insertion<T extends Comparable<T>> extends Sort<T> {
    public void sort(T[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j >= 0; j--) {
                if (less(nums[j], nums[j - 1])) {
                    swap(nums, j, j - 1);
                }

            }
        }
    }

    public static void main(String[] args) {
        Selection<Integer> selection = new Selection<Integer>();
        Integer[] nums = {3, 5, 2, 4, 1};
        selection.print(nums);
        selection.sort(nums);
        selection.print(nums);

    }
}
