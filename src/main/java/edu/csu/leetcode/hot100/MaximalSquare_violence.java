package edu.csu.leetcode.hot100;

public class MaximalSquare_violence {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;

        // 判空
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return maxSide;
        }

        // 记录下行数和列数
        int rows = matrix.length;
        int columns = matrix[0].length;

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < columns;j++){
                if(matrix[i][j] == '1'){
                    // 遇到一个1作为正方形的左上角
                    maxSide = Math.max(maxSide,1);

                    // 计算可能最大的正方形边长
                    // 也就是到边界能构成的最大正方形
                    int currentMaxSide = Math.min(rows - i,columns - j);

                    for(int k = 1;k < currentMaxSide;k++){
                        // 判断新增加的一行一列是否都为1
                        boolean flag = true;

                        // 判断最边上的那个点是否为1
                        if(matrix[i + k][j + k] == '0'){
                            break;
                        }

                        // 判断新增的一行和一列是否都为1
                        for(int m = 0;m < k;m++){
                            if(matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0'){
                                flag = false;
                                break;
                            }
                        }

                        // 从(i,j)坐标扩展k位得到的正方形存在，最大边长与原来的最大变长和k + 1中的较大值
                        if(flag){
                            maxSide = Math.max(maxSide,k + 1);
                            // 不是正方形 后面也可能也得不到正方形了 直接退出for循环
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        // 计算最大面积
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
