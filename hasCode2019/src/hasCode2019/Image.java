package hasCode2019;

import java.util.ArrayList;

public class Image {
	private Orientation orientation;
	private ArrayList<String> tags;
	private int numberOfTags;
	
	public Image (Orientation orientation, ArrayList<String> tags, int numberOfTags) {
		this.orientation = orientation;
		this.tags= tags;
		this.numberOfTags = numberOfTags;
	}
	
	
}
