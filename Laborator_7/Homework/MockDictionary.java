package lab7;

import java.io.*;

public class MockDictionary {

    public boolean isWord(String str) throws IOException {

        File f1=new File("wordsList.txt");
        String[] words = null;
        FileReader fr = new FileReader(f1);
        BufferedReader br = new BufferedReader(fr);
        String s;
        int count=0;

        while((s=br.readLine())!=null)
        {
            words=s.split(" ");
            for (String word : words)
            {
                if (word.equals(str))
                {
                    count++;
                    break;
                }
            }
            if(count != 0)
                break;
        }
        if(count!=0)  //Check for count not equal to zero
        {
            System.out.println("The given word is present for "+count+ " Times in the file");
            fr.close();
            return true;
        }
        else
        {
            System.out.println("The given word is not present in the file");
            fr.close();
            return false;
        }

    }
}
