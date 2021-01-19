package com.yuyy.algorithm.leetcode.editor.cn;

/**
 * description: 矩阵中的路径 <br>
 * date: 2020/8/14 12:34 <br>
 * author: 余游洋 <br>
 * version: 1.0 <br>
 */
public class 矩阵中的路径 {
    private final int[][] arr={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    private int xLength;
    private int yLength;
    private String word;
    private char[][] board;
    private Boolean[][] isVisited;
    private String resultString;

    public 矩阵中的路径(){
        resultString= "";
    }

    public boolean exist(char[][] board, String word) {
        this.xLength = board.length;
        this.yLength = board[0].length;
        this.isVisited=new Boolean[xLength][yLength];
        this.board=board;
        this.word=word;
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++){
                if(dfs(i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean dfs(int x,int y){
        if (x<0 || x>= xLength
                || y<0 || y>=yLength
                || (null!=isVisited[x][y]&&isVisited[x][y])
                || resultString.length()>=word.length()
        ){
            return Boolean.FALSE;
        }
        isVisited[x][y]=Boolean.TRUE;
        resultString+=board[x][y];
        if(resultString.equals(word)){
            return Boolean.TRUE;
        }
        for (int i = 0; i < 4; i++) {
            if(dfs(x+arr[i][0],y+arr[i][1])){
                return Boolean.TRUE;
            }
        }
        isVisited[x][y]=Boolean.FALSE;
        resultString=resultString.substring(0,resultString.length()-1);
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        矩阵中的路径 clazz = new 矩阵中的路径();
        System.out.println(clazz.exist(new char[][]{
                {'A', 'B'}
        }, "BA"));
    }
}
