/**
 *
 *  @author Weikert Robert S17092
 *
 */

package zad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
	
	public static int max = 0;
	public static void main(String[] args) throws MalformedURLException, IOException {
		
	   InputStream inputStream = new URL("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt").openStream();
	   BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
	  
	   Map<String, List<String>> mapAnagrams = bufferReader.lines()
			                                               .sorted()
			                                               .collect(Collectors.groupingBy(e -> sort(e)));
	   mapAnagrams.forEach((e1, e2) -> checkMaxSize(e2));
	   Map<String, List<String>> resMap = mapAnagrams.entrySet().stream()
			  													.filter(e -> max == e.getValue().size())
			  													.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	   resMap.forEach((e1,e2) -> System.out.println(e1 + " = " +e2));
   }	
  
   public static String sort(String s) {
		 char[] chars = s.toCharArray();
		 Arrays.sort(chars);
		 return new String(chars);
   }

    public static int checkMaxSize(List<String> e) {
	  	 if(max < e.size()) max = e.size();
		 return max;
	}
}
