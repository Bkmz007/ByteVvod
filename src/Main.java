import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> pcomp = new PersonfirstNameComparator();
        TreeSet<Integer> misha = new TreeSet<Integer>(pcomp);
        try(FileInputStream fin = new FileInputStream("./src/byteVision"))
        {int i = -1;
            System.out.printf("File size: %d bytes \n", fin.available());
           while((i = fin.read()) != -1)
           {
               misha.add(i);
           }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        for(int i:misha)
            System.out.println(i);
    }
}
class PersonfirstNameComparator implements Comparator<Integer>
{
    public int compare(Integer a, Integer b)
    {
        if(a < b)
            return 1;
        else if(a > b)
            return -1;
        else
            return 0;
    }
}

