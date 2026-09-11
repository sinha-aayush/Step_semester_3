package WEEK_5.Practice_Problems;

public class q2 {

    static String findDuplicateTeam(String[] teamNames)
    {
        for (int i=0;i<teamNames.length;i++)
        {
            int found=0;
            if (teamNames[i].equals(teamNames[i]))
            {
                System.out.println("Duplicate found:"+teamNames[i]);
                found=1;
                break;
            }

            if (found==0)
            {
                System.out.println("No duplicates found.");
            }
        }
        return "OK";
    }

    public static void main(String[] args) {
        String[] teamNames={"ByteForce", "CodeCrafters", "ByteForce"};
        String[] teamNames1={"ByteForce", "CodeCrafters", "NullPointers"};

        findDuplicateTeam(teamNames);
        findDuplicateTeam(teamNames1);
    }
    
}
