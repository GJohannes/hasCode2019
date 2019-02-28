package hasCode2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

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
		//
		
		
		
	}

}
