package edu.csu.leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ReConstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                //按照h降序，k升序进行排列
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            //这里的逻辑是个子矮的人相对于个子高的人是看不见的
            output.add(p[1],p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}
