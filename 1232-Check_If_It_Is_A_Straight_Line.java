// Tag: Array
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) return true;
        
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int diffX = coordinates[1][0] - x0;
        int diffY = coordinates[1][1] - y0;
        for (int i = 2; i < coordinates.length; i++) {
            int tmpDiffX = coordinates[i][0] - x0;
            int tmpDiffY = coordinates[i][1] - y0;
            
            //     x1 : y1 == x2 : y2 
            // ==> x1 * y2 == y1 * x2
            if (diffX * tmpDiffY != diffY * tmpDiffX) return false;
        }
        
        return true;
    }
}
