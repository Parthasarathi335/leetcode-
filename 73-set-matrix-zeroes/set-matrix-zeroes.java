import java.util.HashSet;

class Solution {
    public void setZeroes(int[][] matrix) {

        HashSet<Integer> zeroRows = new HashSet<>();

        HashSet<Integer> zeroCols = new HashSet<>();

        int rows = matrix.length;

        
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (zeroRows.contains(i) || zeroCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}