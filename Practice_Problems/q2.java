package Practice_Problems;

public class q2 {
    public static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int val = grid[i][j];
                total += val;
                if (val > maxVal) {
                    maxVal = val;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new int[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        int[] res = warehouseSummary(grid);
        System.out.println("total = " + res[0] + ", maxCoordinate = (" + res[1] + "," + res[2] + ")");
    }
}