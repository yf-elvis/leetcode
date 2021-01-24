package com.hyf.leetcode.dp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huyufei on 2021/1/19
 * @Desc: TODO
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int length = height.length;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int k = i; k < length; k++) {
                maxRight = Math.max(maxRight, height[k]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    public int trap2(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        maxLeft[0] = height[0];
        maxRight[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 1; i < len; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return ans;
    }

    public int trap3(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int len = height.length;
        int ans = 0;
        for(int i = 0;  i < len; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer top = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                ans = ans  +  distance * boundedHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int trap = new TrappingRainWater().trap3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }
}
