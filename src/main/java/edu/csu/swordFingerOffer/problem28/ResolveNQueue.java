package edu.csu.swordFingerOffer.problem28;

import java.util.*;

/*
    下面是著名的8皇后问题的变种N皇后问题
 */

public class ResolveNQueue {
    //不使用nums数组，并且使用成员变量
    private Set<Integer> col;           //列
    private Set<Integer> master;        //主线
    private Set<Integer> slave;         //副线
    private int n;                      //棋盘的长宽
    private List<List<String>> res;    //存放结果集

    public List<List<String>> solveNQueue(int n){
        this.n = n;
        res = new ArrayList();
        if (n == 0) return res;

        col = new HashSet<Integer>();
        master = new HashSet<Integer>();
        slave = new HashSet<Integer>();

        Stack<Integer> stack = new Stack();
        backTrack(0,stack);
        return res;
    }
    private void backTrack(int row,Stack<Integer> stack){
        if (row == n){
            List<String> board = convert2Board(stack,n);
            res.add(board);
            return;
        }
        //针对改行的每一列，尝试是否可以存放值
        for (int i = 0;i < n;i++){
            if (!col.contains(i) && !master.contains(row+i) && !slave.contains(row -i)){

                stack.add(i);
                col.add(i);
                master.add(row+i);
                slave.add(row - i);

                backTrack(row+1,stack);

                //回溯就是将之前的操作复盘
                slave.remove(row - i);
                master.remove(row+i);
                col.remove(i);
                stack.pop();
            }
        }
    }
    private List<String> convert2Board(Stack<Integer> stack,int n){
        List<String> board = new ArrayList<String>();
        for (int num:stack){
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < n;i++){
                sb.append(".");
            }
            sb.replace(num,num+1,"Q");
            board.add(sb.toString());
        }
        return board;
    }
}
