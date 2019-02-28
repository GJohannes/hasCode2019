package hasCode2019;

import java.util.ArrayList;


public class SlideObject implements Comparable<SlideObject> {
    ArrayList<Image> images;
    ArrayList<String> tags;
    int numberOfTags;

public SlideObject(Image image){
    this.images.add(image);
    this.tags = image.getTags();
    this.numberOfTags += image.getNumberOfTags();
}
    public SlideObject(Image image, Image image2){
        this.images.add(image);
        this.tags = image.getTags();
        this.numberOfTags += image.getNumberOfTags();
        this.images.add(image2);
        this.tags = image2.getTags();
        this.numberOfTags += image2.getNumberOfTags();

    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
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

    @Override
    public int compareTo(SlideObject slideObject) {
        if(this.numberOfTags > slideObject.getNumberOfTags()) {
            return -1;
        } else if(this.numberOfTags<slideObject.getNumberOfTags()) {
            return 1;
        } else {
            return 0;
        }
    }
}

