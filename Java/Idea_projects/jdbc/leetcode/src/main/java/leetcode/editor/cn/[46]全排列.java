//package leetcode.editor.cn;//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
////
////
////
//// 示例 1：
////
////
////输入：nums = [1,2,3]
////输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
////
////
//// 示例 2：
////
////
////输入：nums = [0,1]
////输出：[[0,1],[1,0]]
////
////
//// 示例 3：
////
////
////输入：nums = [1]
////输出：[[1]]
////
////
////
////
//// 提示：
////
////
//// 1 <= nums.length <= 6
//// -10 <= nums[i] <= 10
//// nums 中的所有整数 互不相同
////
//// Related Topics 回溯算法
//// 👍 1352 👎 0
//
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public List<List<Integer>> permute(int[] nums) {
//        // 结果
//        List<List<Integer>> result = new LinkedList<>();
//        // 结果的元素，单词排列
//        LinkedList<Integer> path = new LinkedList<>();
//        LinkedList<Integer> choice = new LinkedList<>();
//        for(int num : nums){
//            choice.add(num);
//        }
//        helper(result,choice,path);
//        return result;
//    }
//    public void helper(List<List<Integer>> result,LinkedList<Integer> choice, LinkedList<Integer> path){
//        if(choice.size() == 0){
//            // 触底返回
//            result.add(new ArrayList<>(path));
//        }else{
//            // 做选择
//            for(int i = 0; i < choice.size(); i ++){
//                int currentNum = choice.remove(i);
//                path.add(currentNum);
//                helper(result,choice,path);
//                path.removeLast();
//                choice.add(i,currentNum);
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        int[] nums = new int[3];
//        nums[0] = 1;
//        nums[1] = 2;
//        nums[2] = 3;
////        LinkedList l = new LinkedList(Arrays.asList(nums));
////        System.out.println(l);
//        Solution s = new Solution();
//        s.permute(nums);
//
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
