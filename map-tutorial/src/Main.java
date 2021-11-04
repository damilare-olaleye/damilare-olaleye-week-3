import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Map <String, String> studentMap = new HashMap<>();
		
		Integer myint = 2;
		
		studentMap.put("001", "John");
		studentMap.put("003", "David");
		
//		System.out.println(studentMap.get("001"));
		
		for(String student : studentMap.keySet()) {
			System.out.println(studentMap.get(student));
		}
	}

}
