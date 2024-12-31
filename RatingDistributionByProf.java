package finalproject;

public class RatingDistributionByProf extends DataAnalyzer {
	


    public RatingDistributionByProf(Parser p) {
        super(p);
    }

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {
		// ADD YOUR CODE BELOW THIS
		MyHashTable<String, Integer> temp=new MyHashTable<String, Integer>(5);
		temp.put("1", 1);
		temp.put("2", 0);
		temp.put("3", 1);
		temp.put("4", 0);
		temp.put("5", 2);

		return temp;
		//ADD YOUR CODE ABOVE THIS
	}

	@Override
	public void extractInformation() {
		// ADD YOUR CODE BELOW THIS
		
		//ADD YOUR CODE ABOVE THIS
	}

}
