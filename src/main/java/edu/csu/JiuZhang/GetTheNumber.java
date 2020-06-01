package edu.csu.JiuZhang;

import java.util.ArrayList;
import java.util.List;

public class GetTheNumber {
    public List<Integer> getTheNumber(int[] cards){
        //用于记录每张牌出现的次数
        int[] times = new int[10];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0;i < 13;i++) times[cards[i]]++;

        for (int i = 0;i < 10;i++){
            //尝试将一张还不够四张的牌加入牌堆验证能否胡牌
            if (times[i] < 4){
                times[i]++;
                if (check(times)) ans.add(i);
                times[i]--;
            }
        }
        //如果无法胡牌，那么就在结果集中添加0;
        if (ans.size() == 0) ans.add(0);
        return ans;
    }

    /**
     * 验证能否胡牌
     * @param times 添加了一张牌进去后的手牌
     * @return
     */
    private boolean check(int[] times){
        int[] tmp = new int[10];
        for (int i = 1;i < 10;i++){
            //将i作为雀子
            if (times[i] < 2) continue;
            //ok表示的是可胡的状态
            boolean ok = true;
            for (int k = 1;k < 10;k++) tmp[k] = times[i];
            tmp[i] -= 2;
            for (int j = 1;j < 10 && ok;j++){
                // 刻子jjj
                if (tmp[j] >= 3) tmp[j] -= 3;
                while(tmp[j] > 0 && ok){
                    //
                    if (j + 2 > 9){
                        ok = false;
                        break;
                    }
                    //顺子（j,j+1,j+2）
                    if (tmp[j+1] > 0 && tmp[j+2] > 0){
                        tmp[j]--;
                        tmp[j+1]--;
                        tmp[j+2]--;
                    }else ok = false;
                }
            }
            if (ok) return true;
        }
        return false;
    }
}
