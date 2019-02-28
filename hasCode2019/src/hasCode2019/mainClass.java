package hasCode2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
                    path = Paths.get("hasCode2019/input/b_lovely_landscapes.txt");
                    break;
                case "c":
                    path = Paths.get("hasCode2019/input/c_memorable_moments.txt");
                    break;
                case "d":
                    path = Paths.get("hasCode2019/input/d_pet_pictures.txt");
                    break;
                case "e":
                    path = Paths.get("hasCode2019/input/e_shiny_selfies.txt");
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
		
		readImages();
		
		
		
		List<Image> ioImages = images;
		ArrayList<Image> verticalImages = new ArrayList<Image>();
		ArrayList<SlideObject> allSlideObjects = new ArrayList<>();
		

		for (Image image : ioImages) {
			if(image.getOrientation().equals(Orientation.Veritcal)) {			
				verticalImages.add(image);
			} else {
				SlideObject horizontalSlideObject = new SlideObject(image);
				allSlideObjects.add(horizontalSlideObject);
			}
		}
		
		
		Collections.sort(verticalImages);
		
		
		
		for(Image image : verticalImages) {
			Image bestMatch = null;
			int numberOfDifferentTagsToAnImage = 0;
			for(Image imageToMatch : verticalImages) {
				DifferentAndSameNumberOfTags numberOfDifferentTags = algorithmen.numberOfDifferentTags(image, imageToMatch);
				if(numberOfDifferentTags.getNumberOfDifferentTags() > numberOfDifferentTagsToAnImage) {
					bestMatch = imageToMatch;
					numberOfDifferentTagsToAnImage = numberOfDifferentTags.getNumberOfDifferentTags();
				}
			}
			SlideObject slide2Vertical = new SlideObject(image, bestMatch);
			verticalImages.remove(image);
			verticalImages.remove(bestMatch);
			allSlideObjects.add(slide2Vertical);
		}
		
		
		
		
		
	}

}
