class Solution {
    class DisjointSet
    {
        ArrayList<Integer> parent= new ArrayList<>();
        ArrayList<Integer> rank= new ArrayList<>();
        ArrayList<Integer> size= new ArrayList<>();

        public DisjointSet(int n)
        {
            for(int i=0; i<n; i++)
            {
                parent.add(i);
                rank.add( 0);
                size.add(1);
            }            
        }

        public int findUp(int node)
        {
            if(parent.get(node) == node) return node;
            else
            {
                int ulp= findUp( parent.get(node));
                parent.set(node, ulp);
                return parent.get(node);
            }           
        }

        void unionByRank(int u, int v)
        {
            int pu= findUp(u);
            int pv= findUp(v);

            if(pu == pv) return; //same leader of both, no need further

            if(rank.get(pu) < rank.get(pv))
            {
                parent.set(pu, pv);
            }

            else if(rank.get(pu) > rank.get(pv))
            {
                parent.set(pv, pu);
            }

            else //both ranks same, rank+1, join any 
            {
                parent.set(pu, pv);
                rank.set(pv, rank.get(pv) +1);
            }
        }

        void unionBySize(int u, int v)
        {
            int pu= findUp(u);
            int pv= findUp(v);

            if(pu == pv) return;

            if(size.get(pu) > size.get(pv))
            {
                parent.set(pv, pu);
                size.set(pu, size.get(pv) + size.get(pu));
            }
            else
            {
                parent.set(pu, pv);
                size.set(pu, size.get(pv) + size.get(pu));
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) 
    {
        //Emails are nodes.
        //If two accounts share an email → they are connected.
        //whereever overlap, we connect the sets
        int n= accounts.size();
        DisjointSet ds= new DisjointSet(n);
        HashMap<String, Integer> map= new HashMap<String, Integer>();

        //Step 1: Union accounts using emails
        for(int i=0; i<n; i++)
        {
            for(int j=1; j< accounts.get(i).size(); j++) //as in the given arrays, the 1st ele is the name
            {
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail) == false)
                {
                    map.put(mail, i);
                }
                else //when the string is alredy present in the map for another index, we join the nodes
                {
                    ds.unionBySize(i, map.get(mail));

                }
            }
        }
        //now, we have the ds created with the components created as well

        //Step 2: Takes each email-> Finds its ultimate parent using DSU-> Puts that email into a bucket for that parent
        // Group emails by their DSU ultimate parent, parent index -> list of emails
        
        HashMap<Integer, List<String>> grouped= new HashMap<>();
       
        for( String mail : map.keySet())
        {
            int accIndex= map.get(mail);
            int parent= ds.findUp(accIndex);

            //if parent not present, create list
            if(!grouped.containsKey(parent))
            {
                grouped.put(parent, new ArrayList<>());
            }

            grouped.get(parent).add(mail);
        }

        //Step 3: Build the final answer
        List<List<String>> result= new ArrayList<>();

        for(int parent: grouped.keySet())
        {
            List<String> emails = grouped.get(parent);
            // Sort emails as required by problem
        Collections.sort(emails);

        List<String> temp = new ArrayList<>();

        // Add name (from original accounts list)
        temp.add(accounts.get(parent).get(0));

        // Add all sorted emails
        temp.addAll(emails);

        result.add(temp);
    }

    return result;
}
        }

        
    
