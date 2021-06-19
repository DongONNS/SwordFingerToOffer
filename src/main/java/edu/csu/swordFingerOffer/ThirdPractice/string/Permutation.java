package edu.csu.swordFingerOffer.ThirdPractice.string;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        String string = "aa";
        Permutation permutation = new Permutation();
        ArrayList<String> res = permutation.Permutation(string);
        System.out.println(res);
    }

    ArrayList<String> res = new ArrayList();
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0) return res;
        backTracking(str.toCharArray(),new StringBuilder(),new boolean[str.length()]);
        return res;
    }

    private void backTracking(char[] arr,StringBuilder path,boolean[] visited){
        if(path.length() == arr.length){
            res.add(path.toString());
            return;
        }
        for(int i = 0;i < arr.length;i++){
            if(visited[i]) continue;
            if(i != 0 && arr[i] == arr[i - 1] && !visited[i - 1]){
                continue;
            }
            visited[i] = true;
            path.append(arr[i]);
            backTracking(arr,path,visited);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }
    }
}
