package edu.csu.JiuZhang;

import java.util.HashMap;

public class FeatureExtraction {

    public int featureExtraction(int[][] frames){
        //上一帧的特征存储
        HashMap<String,Integer> preFeatTimes = new HashMap<>();
        //当前帧的特征存储
        HashMap<String,Integer> currFeatTimes = new HashMap<>();

        //存储返回结果
        int count = 0;
        //遍历每一行
        for (int i = 0;i < frames.length;i++){
            //遍历当前行所有的特征,第一个元素为本行所行特征的数量
            for (int j = 0;j < frames[i][0];j++){
                String feat = String.valueOf(frames[i][j*2+1])+String.valueOf(frames[i][j*2+2]);

                if (preFeatTimes.containsKey(feat)) currFeatTimes.put(feat,preFeatTimes.get(feat)+1);
                else currFeatTimes.put(feat,1);

                count = Math.max(count,currFeatTimes.get(feat));
            }

            //变量完之后需要将前一帧特征存储转化当前帧的特征存储
            preFeatTimes.clear();
            preFeatTimes.putAll(currFeatTimes);
            currFeatTimes.clear();
        }
        return count;
    }
}
