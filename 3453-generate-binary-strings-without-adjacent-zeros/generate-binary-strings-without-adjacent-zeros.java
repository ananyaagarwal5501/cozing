class Solution {
    public List<String> validStrings(int n) 
    {
        ArrayList<String> list= new ArrayList<>();
        recursiveBuild(list, "", n,'#');
        return list;
    }

        //recursive function
        void recursiveBuild(ArrayList<String> list, String current, int n, char prev)
        {
            //base case: if the n length is reached
            if(current.length()== n)
            {
                list.add(current);
                return; //imp to rerurn here, o/w will keep adding extra chars
                
            }

            //putting 0, if the last is not 0.
            if(prev!='0')
            {
            recursiveBuild(list, current+"0", n,'0');//add 0, if prev becomes 0.                
            }

            //can always add 1, no matter what [also storing the prev with 1]

            recursiveBuild(list, current+"1", n,'1');

        }
}















       /*int ze=1; //"0"
       int oe=1; //"1"
       String zerend= "0";
       String oneend= "1";

        if(n==1)
        {
            list.add(zerend);
            list.add(oneend);
            return list;
        }

        else
        {
            for(int i=0; i<n ; i++)
            {

            }

        }

    }
}*/