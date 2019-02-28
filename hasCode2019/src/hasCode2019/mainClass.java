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

			if (!input.equals("a") && !input.equals("b") && !input.equals("c") && !input.equals("d")
					&& !input.equals("e")) {
				System.out.println("Invalid input");
				System.exit(1);
			}

			System.out.println("Who are you? (c, f, j, s)");
			String name = br.readLine();

			if (!name.equals("c") && !name.equals("f") && !name.equals("j") && !name.equals("s")) {
				System.out.println("Invalid input");
				System.exit(1);
			}

			String prefix = "";

			if (name.equals("c") || name.equals("f")) {
				prefix = "hasCode2019/";
			}

			Path path = null;

			switch (input) {
			case "a":
				path = Paths.get(prefix + "input/a_example.txt");
				break;
			case "b":
				path = Paths.get(prefix + "input/b_lovely_landscapes.txt");
				break;
			case "c":
				path = Paths.get(prefix + "input/c_memorable_moments.txt");
				break;
			case "d":
				path = Paths.get(prefix + "input/d_pet_pictures.txt");
				break;
			case "e":
				path = Paths.get(prefix + "input/e_shiny_selfies.txt");
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

	public static void main(String[] args) throws IOException {
		System.out.println("standart syso");
		readImages();

		
		
		List<Image> ioImages = images;
		
		System.out.println(ioImages.size());
		
		ArrayList<Image> verticalImages = new ArrayList<Image>();
		ArrayList<SlideObject> allSlideObjects = new ArrayList<>();

		for (Image image : ioImages) {
			if (image.getOrientation().equals(Orientation.Veritcal)) {
				verticalImages.add(image);
			} else {
				SlideObject horizontalSlideObject = new SlideObject(image);
				allSlideObjects.add(horizontalSlideObject);
			}
		}
		System.out.println("---merged vertical images---");

		Collections.sort(verticalImages);
		ArrayList<Image> removedImages = new ArrayList<>();

		System.out.println("---sorted vertical images---");
		
		for (Image image : verticalImages) {
			Image bestMatch = null;
			int numberOfDifferentTagsToAnImage = -1;
			for (Image imageToMatch : verticalImages) {
				if(!removedImages.contains(imageToMatch)) {
					DifferentAndSameNumberOfTags numberOfDifferentTags = algorithmen.numberOfDifferentTags(image,
							imageToMatch);
					if (numberOfDifferentTags.getNumberOfDifferentTags() > numberOfDifferentTagsToAnImage) {
						bestMatch = imageToMatch;
						numberOfDifferentTagsToAnImage = numberOfDifferentTags.getNumberOfDifferentTags();
					}
				}
			}
			System.out.println(bestMatch);
			System.out.println(image);
			if(bestMatch != null) {
				SlideObject slide2Vertical = new SlideObject(image, bestMatch);
				removedImages.add(image);
				removedImages.add((bestMatch));
				
//				verticalImages.remove(image);
//				verticalImages.remove(bestMatch);
				allSlideObjects.add(slide2Vertical);
			}

		}
		System.out.println("---all slide shopw Objects created---");
		
		Collections.sort(allSlideObjects);

		System.out.println("---sorted slide show objects---");
		
		ArrayList<SlideObject> slideShow = new ArrayList<>();

		slideShow.add(allSlideObjects.get(0));
		allSlideObjects.remove(0);

		
		ArrayList<SlideObject> removedObjects = new ArrayList<>();
		
		for (SlideObject slideObject : allSlideObjects) {
			SlideObject bestMatch = null;
			int bestScore = -1;
			for (SlideObject slideObjectToMatch : allSlideObjects) {
				if(!removedObjects.contains(slideObjectToMatch)) {
					int compareScore = algorithmen.scoreOfTwoSlideObjects(slideShow.get(slideShow.size() - 1),slideObjectToMatch);
					if (compareScore > bestScore) {
						bestMatch = slideObjectToMatch;
						bestScore = compareScore;
					}					
				}
			}
			System.out.println("---found an match ----");
			slideShow.add(bestMatch);
			removedObjects.add(bestMatch);
//			allSlideObjects.remove(bestMatch);
		}

		System.out.println("done");

		System.out.println(slideShow);
		
		IOStuff.writeFiles(slideShow);
	}

}
