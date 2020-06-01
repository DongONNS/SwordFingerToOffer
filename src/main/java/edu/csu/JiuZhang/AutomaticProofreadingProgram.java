package edu.csu.JiuZhang;

import java.util.ArrayList;
import java.util.List;

public class AutomaticProofreadingProgram {
    public String automaticProofreadingProgram(String str){
        List<Character> res = new ArrayList<Character>();
        for (int i = 0;i <str.length();i++){
            res.add(str.charAt(i));
            if (res.size() < 3) continue;
            if (res.get(res.size()-1) == res.get(res.size()-2)){
                //为AAA类型
                if(res.size() >= 3 && res.get(res.size()-1) == res.get(res.size()-3)){
                    res.remove(res.size()-1);
                    continue;
                }
                //为AABB类型
                if (res.size() >= 4 && res.get(res.size()-3) == res.get(res.size()-4)){
                    res.remove(res.size()-1);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0;i < res.size();i++){
            ans.append(res.get(i));
        }
        return ans.toString();
    }
}
