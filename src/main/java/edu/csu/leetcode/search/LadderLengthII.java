package edu.csu.leetcode.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LadderLengthII {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N - 1;
        int end = 0;
        //start对应beginWord的位置，而end对应endWord的位置
        while(end < N && !wordList.get(end).equals(endWord))
            end++;

        // 如果end不存在于wordList中，直接返回错误
        if (end == N - 1) return 0;

        //构建图
        List<Integer>[] graphic = buildGraphic(wordList);

        //获取图中的最短路径
        return getShortestPath(graphic,start,end);
    }

    /**
     * 构建图
     * @param wordList 数据源
     * @return
     */
    private List<Integer>[] buildGraphic(List<String> wordList){
        int N = wordList.size();

        List<Integer>[] graphic = new List[N];

        for (int i = 0;i < N;i++){
            graphic[i] = new ArrayList<>();
            for (int j = 0;j < N;j++){
                //如果两个字符只相差一个字符，那么将其连接
                if (isConnect(wordList.get(i),wordList.get(j)))
                    graphic[i].add(j);
            }
        }
        return graphic;
    }

    /**
     * 判断是否相连，也即二者是否只相差一个字符
     * @param s1
     * @param s2
     * @return
     */
    private boolean isConnect(String s1,String s2){
        int diffCnt = 0;
        for (int i = 0;i < s1.length() && diffCnt <= 1;i++){
            if (s1.charAt(i) != s2.charAt(i))
                diffCnt++;
        }
        return diffCnt == 1;
    }


    private int getShortestPath(List<Integer>[] graphic,int start,int end){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[graphic.length];

        //添加初始化数据
        queue.add(start);
        marked[start] = true;

        int path = 1;

        //按层次进行遍历
        while(!queue.isEmpty()){
            //queue在弹出数据过程中大小是变化的
            int size = queue.size();
            path++;
            while(size-- > 0){
                //弹出上一层遍历存储的节点，判断其相邻节点是否符合条件
                int cur = queue.poll();
                for(int next : graphic[cur]){
                    if (next == end) return path;

                    if (marked[next]) continue;

                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }
}
