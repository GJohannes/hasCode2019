package hasCode2019;

import java.io.IOException;
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

            images.add(new Image(orientation, tags, numTags));
        }

        if (images.isEmpty()) {
            System.exit(1);
        }
        return images;
	}
}
