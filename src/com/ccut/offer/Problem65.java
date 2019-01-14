package com.ccut.offer;
/**
 * 矩阵中的路径
 */
public class Problem65 {

    private static boolean hasPath(char[][] matrix,String string){
        int rows=matrix.length;
        int cols=matrix[0].length;
        if (matrix==null||rows<1||cols<1||string==""){
            return false;
        }

        boolean[][] visited=new boolean[rows][cols];
        int pathLength=0;

        for (int row=0;row<rows;row++){
            for (int col=0;col<cols;col++){
                if (hasPathCore(matrix,rows,cols,row,col,string,pathLength,visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPathCore(char[][] matrix,int rows,int cols,int row,int col,String string,int pathLength,boolean[][] visited){
        if (pathLength==string.length()){
            return true;
        }
        boolean hasPath=false;
        if (row>=0&&row<rows&&col>=0&&col<cols
                &&matrix[row][col]==string.charAt(pathLength)
                &&!visited[row][col]){
            pathLength++;
            visited[row][col]=true;
             //向上下左右遍历
            hasPath=hasPathCore(matrix,rows,cols,row,col-1,string,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,row-1,col,string,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,row,col+1,string,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,row+1,col,string,pathLength,visited);
            //回溯
            if (!hasPath){
                pathLength--;
                visited[row][col]=false;
            }
        }

        return hasPath;
    }

    public static void main(String[] args) {
        char[][] matrix={{'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}};
        String string="bfce";
        System.out.println(Problem65.hasPath(matrix,string));
    }
}
