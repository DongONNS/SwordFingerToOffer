package edu.csu.swordFingerOffer.problem28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public String[] permutation(String s) {
        int length = s.length();
        if(length == 0) return new String[0];
        char[] charArr = s.toCharArray();
        //便于去重操作
        Arrays.sort(charArr);

        //操作的都是字符，所以使用StringBuilder
        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[length];

        //便于收集结果，使用动态数组
        List<String> res = new ArrayList();
        dfs(charArr,length,0,used,path,res);
        return res.toArray(new String[0]);
    }
    public void dfs(char[] charArr,int len,int depth,boolean[] used,StringBuilder path,List<String> res){
        if(depth == len){
            //要注意，这里生成的是新的字符串，不会因为后面的path改变而发生改变
            res.add(path.toString());
            return;
        }
        for(int i = 0;i < len;i++){
            if(!used[i]){
                //注意这里的剪枝操作，这里的 !used[i-1] 是保证这个撤销是因为当前值于前一个刚撤销的值相等
                if(i > 0 && charArr[i] == charArr[i-1] && !used[i-1]){
                    continue;
                }
                used[i] = true;
                path.append(charArr[i]);
                dfs(charArr,len,depth+1,used,path,res);
                //递归完成后，需要撤销选择，递归方法之前做了什么，递归方法执行之后就需要做相应的逆向操作
                path.deleteCharAt(path.length()-1);
                used[i] = false;
            }
        }
    }
}
