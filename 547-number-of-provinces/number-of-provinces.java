class Solution {
    public int findCircleNum(int[][] isConnected) 
    {
        //1. Converting matrix-> list
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        int n= isConnected.length;
        for(int i=0; i< n; i++)
        {
            adj.add(new ArrayList<>()); //for each row, added a column
        }        

        //Added the values of the inner arraylist, with the condn that the io!=j and both have 1 in the matrix i.e., connected hai
        for(int i =0; i< n; i++)
        {for(int j=0 ; j< n; j++)
            { if(isConnected[i][j] == 1 && i!=j)
                {
                    adj.get(i).add(j);
                }
            }
        }

        //2. LOgic of the code: DFS Using adj list
        boolean[] visited= new boolean[n];
        int province_num =0;
        for(int i=0; i<n; i++)
        {
            if(!visited[i]) //agar false hai i.e., 0 hai in the visited array
            {
                dfs(i, visited, adj);
                province_num = province_num + 1;
            }
        }
        return province_num;
    }

        //3. DFS on list
        public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj)
        {
            visited[node] = true; //pehle is node ko 1 kiya
            //ab neighbour pe aenge
            for(int neighbour: adj.get(node))
            {
                if(!visited[neighbour])
                {
                    dfs(neighbour, visited, adj);
                }
            }

        }

}




/*class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;  // each DFS call discovers one province
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
}
*/