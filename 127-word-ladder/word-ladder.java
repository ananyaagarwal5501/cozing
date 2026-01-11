class Solution {
    // Step 0: Pair to store (current word, steps taken till now)
    class Pair
    {
        String string;
        int level;
        Pair(String _st, int _level)
        {
            this.string= _st;
            this.level= _level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        //bfs// as min seq length
        // 🧠Step 1: Put all dictionary words into a HashSet (fast lookup + visited control)
        Set<String> set= new HashSet<String>(); //set created to update after each tratment from remiovel of q.
            for(String word: wordList)
            set.add(word); 
        

        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(beginWord, 1));

         
        if(set.contains(beginWord)) set.remove(beginWord);

         // Step 2: If endWord not present, no valid transformation possible
        //edge: endword should exist in the list
        if(!set.contains(endWord)) return 0;
        
        while(!q.isEmpty())
        {
            Pair p= q.poll();
            String st= p.string;
            int level= p.level;
            
            if (st.equals(endWord)) return level;

                //🧠Making of new words
                //🧠word ko char array me convert karo, the make the enw word and cgeck further
                char[] arr= st.toCharArray();
                for(int j=0; j<arr.length; j++) //outr loop for position to be replaced
                {
                    char originalchar= arr[j]; 

                    for(char ch= 'a'; ch<= 'z'; ch++) //replacing
                    {
                        if(originalchar == ch) continue; //no sense of replacinh h with h
                        arr[j] = ch; //🧠Replaces the character with a-> z
                        String nword= new String(arr);

                        if(set.contains(nword))
                        {
                            set.remove(nword);
                            q.add(new Pair(nword, level+1));
                        }
                    }
                    arr[j] = originalchar; // restore
                }
                
            }
        
        return 0;
    }    
}