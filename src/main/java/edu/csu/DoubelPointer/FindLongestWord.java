package edu.csu.DoubelPointer;

public class FindLongestWord {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for(String target : d){
            int l1 = longestWord.length(),l2 = target.length();

            //如果目标值比当前的最长字符串短或者长度相等但是首字母要比target小的话也不用考虑
            if(l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0))
                continue;
            if(isSubstr(s,target))
                longestWord = target;

        }
        return longestWord;
    }
    private boolean isSubstr(String s,String target){
        int i = 0,j = 0;
        while(i < s.length() && j < target.length()){
            //如果s中的字符串可以与target中的字符串匹配，那么将target的字符指针后移
            if(s.charAt(i) == target.charAt(j))
                j++;
            //将i后移
            i++;
        }
        return j == target.length();
    }
}
