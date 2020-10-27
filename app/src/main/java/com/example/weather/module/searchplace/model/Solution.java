package com.example.weather.module.searchplace.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: klasu
 * @date: 2020/10/24
 */
public class Solution {
    public int longestConsecutive(int[] nums){
        Set<Integer> num_set = new HashSet<>();
        for (int num:nums) {
            num_set.add(num);
        }
        // 最终的连续元素个数
        int longestStreak = 0;
        // 迭代hash表中的元素, 若表中不存在 num-1的数, 便开始向后查找与当前元素连续的数
        // 此目的是为了避免多次遍历一组连续的数
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;   // 当前数
                int currentStreak = 1;  // 连续数个数计数器
                // 若存在连续的数,则计数器+1
                while (num_set.contains(++currentNum) && (++currentStreak >0));

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public String reverseWords(String s) {
        if (s.length()==0) return "";
        StringBuffer str=new StringBuffer();
        return str.toString();
    }

}
