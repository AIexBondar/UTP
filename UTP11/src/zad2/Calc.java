/**
 *
 *  @author Weikert Robert S17092
 *
 */

package zad2;

import java.util.HashMap;

public class Calc {
	String[] tokens;
	HashMap<String,Operation> map = new HashMap<String, Operation>();
	
	public String doCalc(String string) {
		map.put("+", new AdditionOperation());
		map.put("-", new SubtractionOperation());
		map.put("*", new MultiplicationOperation());
		map.put("/", new DivisionOperations());
		
		try {
			tokens = string.split("\\s+");
			double a = Double.parseDouble(tokens[0]);
			double b = Double.parseDouble(tokens[2]);
			Operation op = map.get(tokens[1]);
			
			return "" + op.count(a, b);
		} catch (Exception e) {
			return "Invalid command to calc";
		}	
	}
}  
