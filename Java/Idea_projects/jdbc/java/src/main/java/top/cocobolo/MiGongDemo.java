package top.cocobolo;

public class MiGongDemo {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(8,7);
        matrix.print();
        findWay(matrix,1,1);
        matrix.print();
    }

    //0代表没走过  1 代表墙   2代表通路   3代表死路  策略:上下左右
    static public boolean findWay(Matrix matrix,int i,int j){
        if(i==matrix.rows-2 && j==matrix.columns-2){//走到终点了
            matrix.map[i][j]=2;//标记终点为2(可达)
            return true;
        }else{//还没走到终点
            if(matrix.map[i][j]== 0){//还没走过 那就走吧
                matrix.map[i][j]=2;
                if(findWay(matrix,i+1,j)){//向下走
                    return true;
                }else if(findWay(matrix,i,j+1)){//向右走
                    return true;
                }else if(findWay(matrix,i-1,j)){//向上走
                    return true;
                }else if(findWay(matrix,i,j-1)){//向左走
                    return true;
                }else{  //全部走不通 标记死路
                    matrix.map[i][j]=3;
                    return false;
                }
            }else { // 只剩1墙  2走过  3死路  都不行
                return false;
            }
        }
    }
}

class Matrix{
    int[][] map;
    int rows;
    int columns;

    public Matrix(int rows,int columns){
        this.rows=rows;
        this.columns = columns;
        map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            map[i][0] = 1;
            map[i][columns-1] = 1;
        }
        for (int j = 0; j < columns; j++) {
            map[0][j]=1;
            map[rows-1][j]=1;

        }
    }

    public void print(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print((map[i][j]+" "));
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

}
