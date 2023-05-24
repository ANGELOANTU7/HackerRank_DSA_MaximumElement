import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operation) {
        int[] stack = new int[10000000];
        int ptr=-1;
        List<Integer> myList = new ArrayList<Integer>();
    for(int i=0;i<operation.size();i++)
    {
        if(operation.get(i).charAt(0)=='1')
        {
            ptr+=1;

            int num=Integer.parseInt(operation.get(i).split(" ")[1]);

            stack[ptr] = num;


        }
        
        
        if(operation.get(i).charAt(0)=='2')
        {
            stack[ptr]=0;
            ptr-=1;
        }
        
        if(operation.get(i).charAt(0)=='3')
        {
            int max=stack[0];
            for(int j=1;j<ptr+1;j++)
            {
                if(stack[j]>max)
                {
                    max=stack[j];
                }
            }
            myList.add(max);
        }
        
    }
return(myList);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
