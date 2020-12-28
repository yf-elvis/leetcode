package com.hyf.leetcode.tanxin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @Author huyufei on 2020/11/24
 * @Desc: 最少的箭引爆气球
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        List<List<Integer>> pointsList = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            List<Integer> internalList = new ArrayList<>();
            for (int j = 0; j < points[0].length; j++) {
                internalList.add(points[i][j]);
            }
            pointsList.add(internalList);
        }
        pointsList.sort(Comparator.comparingInt(o -> o.get(1)));
        int maxLeft = pointsList.get(0).get(1);
        int arrow = 1;
        while (pointsList.size() != 0) {
            Iterator<List<Integer>> iterator = pointsList.iterator();
            while (iterator.hasNext()) {
                List<Integer> next = iterator.next();
                if (maxLeft>=next.get(0) && maxLeft<=next.get(1)) {
                    iterator.remove();
                } else {
                    arrow++;
                    maxLeft = pointsList.get(0).get(1);
                    break;
                }
            }

        }
        return arrow;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 2}};
        int minArrowShots = new FindMinArrowShots().findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
}
