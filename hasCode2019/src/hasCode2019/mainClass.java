package hasCode2019;

import java.util.ArrayList;
import java.util.Collections;

public class mainClass {

	public static void main(String[] args) {
		System.out.println("standart syso");
		System.out.println(IOStuff.loadMainInputFile());
		
		
		ArrayList<Image> images = new ArrayList<>();
		
		for(int i = 0;i < 10; i++) {
			Number a = Math.random()*100;
			Image imag = new Image(null, null, a.intValue());
			images.add(imag);
		}
		
		Collections.sort(images);
		
		for(int i =0; i < 10; i++ ) {
			System.out.println(images.get(i).getNumberOfTags());			
		}
	}

}
