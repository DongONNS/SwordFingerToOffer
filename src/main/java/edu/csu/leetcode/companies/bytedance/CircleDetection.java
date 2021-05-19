package edu.csu.leetcode.companies.bytedance;

import java.util.*;

public class CircleDetection {
    public static void main(String[] args) {
        List<Character[]> originData = getData();
        Map<Character, List<Character>> cm = getMap(originData);
        System.out.println(circleDetection(cm, 'A'));
    }

    /**
     * 输入数组
     * @return
     */
    public static List<Character[]> getData() {
        List<Character[]> data = new ArrayList<>();
        data.add(new Character[]{'A', 'B'});
        data.add(new Character[]{'B', 'C'});
        data.add(new Character[]{'C', 'B'});
//        data.add(new Character[]{'B', 'F'});
//        data.add(new Character[]{'E', 'B'});
//        data.add(new Character[]{'B', 'C'});
//        data.add(new Character[]{'C', 'A'});
        System.out.println("输出源数组:");
        for (Character[] c : data) {
            System.out.println(Arrays.toString(c));
        }
        System.out.println();
        return data;

    }

    /**
     * 遍历列表得到每一个节点启动所需要的依赖
     * @param originData
     * @return
     */
    public static Map<Character, List<Character>> getMap(List<Character[]> originData) {
        Map<Character, List<Character>> res = new HashMap<>();
        for (Character[] c : originData) {
            if (res.containsKey(c[0])) {
                res.get(c[0]).add(c[1]);
            } else {
                List<Character> temp = new ArrayList<>();
                temp.add(c[1]);
                res.put(c[0], temp);
            }
        }
        System.out.println("节点的依赖关系为:");
        System.out.println(res);
        System.out.println();
        return res;
    }

    /**
     * 检测c节点是否处在环上
     * @param cm 节点依赖关系
     * @param c  待检测节点
     * @return
     */
    public static boolean circleDetection(Map<Character, List<Character>> cm, Character c) {
        Queue<Character> queue = new LinkedList<>();
        List<Character> existCharacters = new ArrayList<>();
        queue.add(c);
        while (!queue.isEmpty()) {
            Character current = queue.remove();
            existCharacters.add(current);
            List<Character> temp = cm.get(current);
            if (temp != null && !temp.isEmpty()) {
                for (Character out : temp) {
                    if (out.equals(c)) {
                        return true;
                    }
//                    if (existCharacters.contains(out)) break;
                    queue.add(out);
                }
            }
        }
        return false;
    }
}
