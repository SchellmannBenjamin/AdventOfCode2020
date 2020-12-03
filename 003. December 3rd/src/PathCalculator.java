public class PathCalculator {
    int [][] matrix;
    int x,y;

    public PathCalculator(int[][] matrix) {
        this.matrix = matrix;
        this.x = 0;
        this.y = 0;
    }

    public int calculateTrees(int len, int xmulti, int ymulti){
        int ret = 0;
        int count = 0;
        y+= ymulti;
        x+= xmulti;
        while (y < len){
                if (matrix[y][x] == 1) ret++;
                y += ymulti;
                x += xmulti;
        }
        return ret;
    }
}
