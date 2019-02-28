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

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public int getNumberOfTags() {
		return numberOfTags;
	}

	public void setNumberOfTags(int numberOfTags) {
		this.numberOfTags = numberOfTags;
	}
	
	
}
