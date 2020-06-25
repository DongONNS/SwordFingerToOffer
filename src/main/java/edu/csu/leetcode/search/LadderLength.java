package edu.csu.leetcode.search;

import java.util.*;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //用于判断某个单词是否在哈希表中
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;

        //删除我们的开始字符，这个是会默认的添加到queue中的
        wordSet.remove(beginWord);

        //图的广度优先遍历，必须使用的队列和表示是否被访问过的visited数组
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);

        Set<String> visited = new HashSet();
        visited.add(beginWord);

        //对于单词长度的每一位字符都要进新替换
        int wordLen = beginWord.length();

        //包含起点，因为初始化的时候步数为1
        int setep = 1;

        while(!queue.isEmpty()){
            //因为在弹出过程中，queue的大小是会变化的
            int size = queue.size();

            //依次遍历当前队列中的每一个单词
            for(int i = 0;i < size;i++){
                String word = queue.poll();
                char[] charArray = word.toCharArray();

                //修改每一个字符
                for(int j = 0;j < wordLen;j++){
                    char origin = charArray[j];

                    //对我们的每一个位字符，用a - z的字符进行替换
                    for(char k = 'a';k <= 'z';k++){
                        if(k == origin) continue;

                        charArray[j] = k;
                        String next = String.valueOf(charArray);

                        //如果已经访问到了最后一个字符，那么返回 setep + 1;
                        if(wordSet.contains(next)){
                            if(next.equals(endWord)) return setep + 1;

                            //不是最后一个字符，并且尚未被访问,那么将其加入到队列中并且标记为被访问过
                            if(!visited.contains(next)){
                                queue.add(next);
                                visited.add(next);
                            }
                        }
                    }
                    //恢复字符
                    charArray[j] = origin;
                }
            }
            //从当前层找到唯一一个位置
            setep++;
        }
        return 0;
    }
}
