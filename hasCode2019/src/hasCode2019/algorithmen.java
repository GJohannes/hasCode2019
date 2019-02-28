package hasCode2019;

public class algorithmen {

	private int numberOfSameTags(Image image1, Image image2) {
		
		return 0;
	}

	public static DifferentAndSameNumberOfTags numberOfDifferentTags(Image image1, Image image2) {
		int numberOfDifferentTag = 0;
		int numberOfSameTag = 0;
		if (image1.getNumberOfTags() > image2.getNumberOfTags()) {
			outerLoop: for (int i = 0; i < image1.getNumberOfTags(); i++) {
				for (int j = 0; j < image2.getNumberOfTags(); j++) {
					if(image1.getTags().get(i).equals(image2.getTags().get(j))){
						numberOfSameTag++;
						continue outerLoop;
					}
				}
				numberOfDifferentTag++;
			}
		} else {
			outerLoop: for (int i = 0; i < image2.getNumberOfTags(); i++) {
				for (int j = 0; j < image1.getNumberOfTags(); j++) {
					if(image2.getTags().get(i).equals(image1.getTags().get(j))){
						numberOfSameTag++;
						continue outerLoop;
					}
				}
				numberOfDifferentTag++;
			}
		}
		DifferentAndSameNumberOfTags differentAndSameNumberOfTags = new DifferentAndSameNumberOfTags(numberOfDifferentTag, numberOfSameTag);
		return differentAndSameNumberOfTags;
		
	}

//	public Integer getScoreOfTwoObjects(SlideObject slideObject1, SlideObject slideObject2) {
//		return numberOfDifferentTags(image1, image2);
//
//		Math.min(numberOfDifferentTags(image1,image2), numberOfSameTags(image1,image2));
//	}
//	
	
	public static int scoreOfTwoSlideObjects(SlideObject slideObject1, SlideObject slideObject2) {
		int numberOfDifferentTag = 0;
		int numberOfSameTag = 0;
		if (slideObject1.getNumberOfTags() > slideObject2.getNumberOfTags()) {
			outerLoop: for (int i = 0; i < slideObject1.getNumberOfTags(); i++) {
				for (int j = 0; j < slideObject2.getNumberOfTags(); j++) {
					if(slideObject1.getTags().get(i).equals(slideObject2.getTags().get(j))){
						numberOfSameTag++;
						continue outerLoop;
					}
				}
				numberOfDifferentTag++;
			}
		} else {
			outerLoop: for (int i = 0; i < slideObject2.getNumberOfTags(); i++) {
				for (int j = 0; j < slideObject1.getNumberOfTags(); j++) {
					if(slideObject2.getTags().get(i).equals(slideObject1.getTags().get(j))){
						numberOfSameTag++;
						continue outerLoop;
					}
				}
				numberOfDifferentTag++;
			}
		}
		return Math.min(numberOfDifferentTag, numberOfSameTag);
	}

}
