//bfs
class Solution {
    public boolean isBipartite(int[][] graph) 
    {
        //edge case: can be several graphs

        //naap and needful
        int m= graph.length;
        int[] color= new int[m];
        Arrays.fill(color, -1);

        for(int i=0; i<m; i++) //starting node--->
        {
            if (color[i] == -1) //always check if the current node is colored or not
            {
                if(check(i, graph, color) == false)
                {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean check(int start, int[][] graph, int[] color)
    {
        Queue<Integer> q = new LinkedList<>();

        //start element ko color karo, any of choice && put in q
        color[start] = 0;
        q.add(start);  

        //now in the q:
        while(!q.isEmpty())
        {
            int node= q.poll();

            for(int init: graph[node])
            {
                //check for the padosi, if colored or not..
                if(color[init] == -1) //naya node hai
                {
                    color[init] = 1- color[node]; //LOGIC TO HAVE THE OPPO COLOR EVERYTIME!
                    q.add(init);
                }
                //Otherwise, if has the same color as the init node 
                else if(color[init] == color[node])
                {
                    return false;
                }

           }
        }
            return true;
        }

    }





       