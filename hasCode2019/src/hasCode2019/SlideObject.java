package hasCode2019;

import java.util.ArrayList;

public class SlideObject {
    ArrayList<Image> images:
    ArrayList<String> tags;
    int numberOfTags;

public SlideObject(Image image){
    this.images.add(image);
    this.tags.add(image.getTags());
    this.numberOfTags += image.getNumberOfTags();
}
    public SlideObject(Image image, Image image2){
        this.images.add(image);
        this.tags.add(image.getTags());
        this.numberOfTags += image.getNumberOfTags();
        this.images.add(image2);
        this.tags.add(image2.getTags());
        this.numberOfTags += image2.getNumberOfTags();

    }
}

