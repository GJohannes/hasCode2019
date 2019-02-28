package hasCode2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.plaf.SliderUI;

public class mainClass {

	public static void main(String[] args) {
		System.out.println("standart syso");
		System.out.println(IOStuff.loadMainInputFile());
		
		
		
		ArrayList<Image> ioImages = new ArrayList<>();
		ArrayList<Image> verticalImages = new ArrayList<Image>();
		
		

		for (Image image : ioImages) {
			if(image.getOrientation().equals(Orientation.Veritcal)) {			
				verticalImages.add(image);
			}
		}
		
		
		Collections.sort(verticalImages);
		
		for(int i = 0; i < verticalImages.size(); i++) {
			Image image = verticalImages.get(i);
			Image bestMatch = null;
			int numberOfDifferentTagsToAnImage = 0;
			for(int j = 0; j < verticalImages.size(); j++) {
				DifferentAndSameNumberOfTags numberOfDifferentTags = algorithmen.numberOfDifferentTags(verticalImages.get(i), verticalImages.get(j));
				if(numberOfDifferentTags.getNumberOfDifferentTags() > numberOfDifferentTagsToAnImage) {
					bestMatch = verticalImages.get(j);
					numberOfDifferentTagsToAnImage = numberOfDifferentTags.getNumberOfDifferentTags();
				}
			}
			
			
		}
		
		
		
	}

}
