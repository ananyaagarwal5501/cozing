/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) 
    {
        if(root == null) return 0;

        int max=0;
        for(Node child: root.children)
        {
        int childdepth= maxDepth(child);
        max= Math.max(childdepth, max);
        }
       return 1 + max;
    }
}

/*
class Solution {
    public int maxDepth(Node root) 
    {
        int depth=0; 
        if(root == null) return 0;

        Queue<Node> q= new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size= q.size();
            depth++;

            for(int i=0; i<size; i++)
            {
                Node node= q.poll();
                for(Node child : node.children)
                {
                    q.add(child);
                }
            }
        }  
        return depth;      
    }
}*/