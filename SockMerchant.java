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

    public static int sockMerchant(int n, List<Integer> ar) {
      HashMap<Integer,Integer> pairCounter = new HashMap<Integer,Integer>();
      for(int i=0; i< ar.size();i++){
          Integer element = pairCounter.get(ar.get(i));
          if(element==null){
            pairCounter.put(ar.get(i), 1);
          } else {
                pairCounter.put(ar.get(i), element+1);
          }
      }
      int count =0;
      Collection<Integer> list = pairCounter.values();
      List<Integer> valuesList = new ArrayList<>(list);
      for (int j = 0; j < list.size(); j++) {
          float item = valuesList.get(j) / 2;
          System.out.println(item);
            if(item >=1 ){
                count += (int) item;
            }
        }

    return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
