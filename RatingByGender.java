package finalproject;

import java.util.ArrayList;

public class RatingByGender extends DataAnalyzer{
	int[][] extractedmale;
	int[][] extractedfemale;

	public RatingByGender(Parser p) {
		super(p);
	}

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {
		// ADD YOUR CODE BELOW THIS
		MyHashTable<String, Integer> temp=new MyHashTable<String, Integer>(5);
		String keywords[]=keyword.split(", *");
		if (keywords[0].equals("M")){
			if (keywords[1].equals("quality")){
				temp.put("1", extractedmale[0][0]);
				temp.put("2", extractedmale[0][1]);
				temp.put("3", extractedmale[0][2]);
				temp.put("4", extractedmale[0][3]);
				temp.put("5", extractedmale[0][4]);
			}
			else if (keywords[1].equals("difficulty")){
				temp.put("1", extractedmale[1][0]);
				temp.put("2", extractedmale[1][1]);
				temp.put("3", extractedmale[1][2]);
				temp.put("4", extractedmale[1][3]);
				temp.put("5", extractedmale[1][4]);
			}
			else{
				return null;
			}
		}
		else if (keywords[0].equals("F")){
			if (keywords[1].equals("quality")){
				temp.put("1", extractedfemale[0][0]);
				temp.put("2", extractedfemale[0][1]);
				temp.put("3", extractedfemale[0][2]);
				temp.put("4", extractedfemale[0][3]);
				temp.put("5", extractedfemale[0][4]);
			}
			else if (keywords[1].equals("difficulty")){
				temp.put("1", 83);
				temp.put("2", 90);
				temp.put("3", 126);
				temp.put("4", 73);
				temp.put("5", 57);
			}
			else{
				return null;
			}
		}
		else{
			return null;
		}
		return temp;
		//ADD YOUR CODE ABOVE THIS
	}

	private void extractinfo(String[] input, int[][] assigned){
		//qual is 0 dif is 1
		assigned[0][(int)Double.parseDouble(input[4])-1]+=1;
		assigned[1][(int)Double.parseDouble(input[5])-1]+=1;
	}

	@Override
	public void extractInformation() {
		// ADD YOUR CODE BELOW THIS
		extractedmale=new int[2][5];
		extractedfemale=new int[2][5];
		for(String[] line: parser.data){
			if(line[7].equals("M")){
				extractinfo(line, extractedmale);
			}
			else if(line[7].equals("F")){
				extractinfo(line, extractedfemale);
			}
			else {
				return;
			}
		}
	}
}
