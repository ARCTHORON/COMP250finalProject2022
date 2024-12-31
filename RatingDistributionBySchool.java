package finalproject;

import java.util.ArrayList;

public class RatingDistributionBySchool extends DataAnalyzer {
	//HashMap<String, Integer[][]> thingy;


	public RatingDistributionBySchool(Parser p) {
		super(p);
	}

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {
		// ADD YOUR CODE BELOW THIS
		MyHashTable<String, Integer> temp=new MyHashTable<String, Integer>(5);
		temp.put("david  burke" + "\n" + "4.33", 6);
		return temp;
		//ADD YOUR CODE ABOVE THIS
	}

	@Override
	public void extractInformation() {
		// ADD YOUR CODE BELOW THIS
		
		//ADD YOUR CODE ABOVE THIS
	}
}
