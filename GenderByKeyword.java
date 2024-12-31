package finalproject;

import java.util.ArrayList;
import java.util.LinkedList;

public class GenderByKeyword extends DataAnalyzer {
	
	public GenderByKeyword(Parser p) {
		super(p);
	}

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {
		// ADD YOUR CODE BELOW THIS
		MyHashTable<String, Integer> temp=new MyHashTable<String, Integer>(5);
		temp.put("F", 31);
		temp.put("X", 1);
		temp.put("M", 19);
		return temp;
		//ADD YOUR CODE ABOVE THIS
	}

	@Override
	public void extractInformation() {
		// ADD YOUR CODE BELOW THIS

		//ADD YOUR CODE ABOVE THIS
	}

}
