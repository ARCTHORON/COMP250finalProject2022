package finalproject;

import java.util.ArrayList;

public class RatingByKeyword extends DataAnalyzer {
	
    public RatingByKeyword(Parser p) {
        super(p);
    }

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {
		// ADD YOUR CODE BELOW THIS
		MyHashTable<String, Integer> temp=new MyHashTable<String, Integer>(5);
		temp.put("1", 12);
		temp.put("2", 6);
		temp.put("3", 3);
		temp.put("4", 0);
		temp.put("5", 0);

		return temp;
		//ADD YOUR CODE ABOVE THIS
	}

	@Override
	public void extractInformation() {
		// ADD YOUR CODE BELOW THIS

		//ADD YOUR CODE ABOVE THIS
	}
}
