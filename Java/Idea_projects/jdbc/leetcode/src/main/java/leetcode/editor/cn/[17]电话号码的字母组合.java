////给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
////
//// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
////
////
////
////
////
//// 示例 1：
////
////
////输入：digits = "23"
////输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
////
////
//// 示例 2：
////
////
////输入：digits = ""
////输出：[]
////
////
//// 示例 3：
////
////
////输入：digits = "2"
////输出：["a","b","c"]
////
////
////
////
//// 提示：
////
////
//// 0 <= digits.length <= 4
//// digits[i] 是范围 ['2', '9'] 的一个数字。
////
//// Related Topics 深度优先搜索 递归 字符串 回溯算法
//// 👍 1312 👎 0
//package leetcode.editor.cn;
//
//import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
//
//import java.util.*;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public List<String> letterCombinations(String digits) {
//        // 空，待返回的结果
//        List<String> path = new ArrayList<String>();
//        // 输入转化成List方便操作
//        List<Character> choice =new LinkedList<>();
//        for(char c : digits.toCharArray()){
//            choice.add(c);
//        }
//        // 数字映射
//        Map<Character,List<Character>> map = new HashMap<>();
//        map.put('2', Arrays.asList('a','b','c'));
//        map.put('3',Arrays.asList('d','e','f'));
//        map.put('4',Arrays.asList('g','h','i'));
//        map.put('5',Arrays.asList('j','k','l'));
//        map.put('6',Arrays.asList('m','n','o'));
//        map.put('7',Arrays.asList('p','q','r','s'));
//        map.put('8',Arrays.asList('t','u','v'));
//        map.put('9',Arrays.asList('w','x','y','z'));
//        return back(map,choice,path);
//
//
//    }
//    public List<String> back(Map<Character,List<Character>> map,List<Character> choice, List<String> path){
//        while(!choice.isEmpty()){
//            char i = choice.remove(0);
//            List<Character> list = map.get(i);
//            if(path.size() == 0){
//                for (char c : list){
//                    path.add(String.valueOf(c));
//                }
//            }else{
//                int size  =  path.size();
//                for(int j = 0; j < size; j++){
//                    String s = path.remove(0);
//                    for(char c: list)
//                        path.add(s+c);
//                }
//            }
//        }
//        return path;
//
//    }
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.letterCombinations("23");
//    }
//
//
//}
////leetcode submit region end(Prohibit modification and deletion)
