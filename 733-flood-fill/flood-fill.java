class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int originalColor = image[sr][sc];
        if (originalColor == color) return image; // no change needed
        
        int rows = image.length;
        int cols = image[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;  // color the starting pixel
        
        // Directions: up, right, down, left
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1];
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // Check bounds + same original color
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && 
                    image[nr][nc] == originalColor) {
                    
                    image[nr][nc] = color; // fill new color
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        
        return image;
    }
}
