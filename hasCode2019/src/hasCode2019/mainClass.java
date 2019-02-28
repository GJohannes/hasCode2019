package hasCode2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mainClass {

    static List<Image> images;

    private static void readImages() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which input file do you want to read? (a, b, c, d, e)");
        try {
            String input = br.readLine();

            if (!input.equals("a") && !input.equals("b") && !input.equals("c") && !input.equals("d") && !input.equals("e")) {
                System.out.println("Invalid input");
                System.exit(1);
            }

            Path path = null;

            switch (input) {
                case "a":
                    path = Paths.get("input/a_example.txt");
                    break;
                case "b":
                    path = Paths.get("input/b_lovely_landscapes.txt");
                    break;
                case "c":
                    path = Paths.get("input/c_memorable_moments.txt");
                    break;
                case "d":
                    path = Paths.get("input/d_pet_pictures.txt");
                    break;
                case "e":
                    path = Paths.get("input/e_shiny_selfies.txt");
                    break;
                default:
                    System.out.println("Invalid input");
                    System.exit(1);
            }

            // Read images from input file
            images = IOStuff.readFile(path);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Couldn't close buffered reader");
            }
        }
    }

	public static void main(String[] args) {
		System.out.println("standart syso");
//		System.out.println(IOStuff.loadMainInputFile());
		
		
		
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
