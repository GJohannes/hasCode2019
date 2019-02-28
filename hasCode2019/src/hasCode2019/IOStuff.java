package hasCode2019;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IOStuff {

    public static List<Image> readFile(Path path) {
        List<String> lines = new ArrayList<String>();
        List<Image> images = new ArrayList<Image>();

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Read number of images
        int numImages = Integer.parseInt(lines.remove(0));
        System.out.println("Reading " + numImages + " images");

        int counter = 0;
        // Iterate over lines to read images
        for (String line : lines) {

            String[] components = line.split(" ");

            // Determine orientation
            Orientation orientation;
            if (components[0].equals("H")) {
                orientation = Orientation.Horizontal;
            } else {
                orientation = Orientation.Veritcal;
            }

            // Determine num of tags
            int numTags = Integer.parseInt(components[1]);

            // Determine tags
            ArrayList<String> tags = new ArrayList<String>();
            for (int i = 2; i < components.length; i++) {
                tags.add(components[i]);
            }

            images.add(new Image(orientation, tags, numTags, counter));
            counter++;
        }

        if (images.isEmpty()) {
            System.exit(1);
        }
        return images;
	}

	public static void writeFiles(ArrayList<SlideObject>  listOfSlideObjects) throws IOException {

		File file = new File("newOut");
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(fileWriter);
		for (int i = 0; i < listOfSlideObjects.size(); i++) {
			 for(Image image: listOfSlideObjects.get(i).images){
				 System.out.println(image.getId());
				 writer.write(Integer.toString(image.getId()) + " ");
	            }
			 writer.newLine();	
		}

		// file does not already exist
		writer.flush();
		writer.close();
//		
//		
//        String path = "out.txt";
//
//		File fout = new File(path);
//		FileOutputStream fos = new FileOutputStream(fout);
//
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
//
//		bw.write(listOfSlideObjects.size());
//
//        for (SlideObject listOfSlideObject : listOfSlideObjects) {
//            bw.newLine();
//            for(Image image: listOfSlideObject.images){
//                bw.write(image.getId());
//                bw.write(" ");
//            }
//
//        }
//
//		bw.close();

	}
}
