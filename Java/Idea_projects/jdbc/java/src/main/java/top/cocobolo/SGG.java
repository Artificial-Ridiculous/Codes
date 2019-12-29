package top.cocobolo;

public class SGG {
    public static void main(String[] args) {
        int[][] matrix = new int[11][11];
        matrix[1][2] = 1;
        matrix[2][4] = 2;
//        for (int[] row : matrix){
//            for (int val : row){
//                System.out.printf("%d\t",val);
//            }
//            System.out.printf("\n");
//        }


        int n = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                if (val != 0) {
                    n++;
                }
            }
        }

        int[][] sparse = new int[n + 1][3];
        sparse[0][0] = matrix.length;
        sparse[0][1] = matrix[0].length;
        sparse[0][2] = n;
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    index++;
                    sparse[index][0] = i;
                    sparse[index][1] = j;
                    sparse[index][2] = matrix[i][j];
                }
            }
        }

        for (int[] row : sparse) {
            for (int val : row) {
                System.out.printf("%d\t", val);
            }
            System.out.printf("\n");
        }

        System.out.println("--------\t");

        int[][] rec = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i<= sparse[0][2];i++){
            rec[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }
        for (int[] row : rec) {
            for (int val : row) {
                System.out.printf("%d\t", val);
            }
            System.out.printf("\n");
        }


    }
}
