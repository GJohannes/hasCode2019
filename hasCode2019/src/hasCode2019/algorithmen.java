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

//	public Integer getScoreOfTwoObjects(Image image1, Image image2) {
//		return numberOfDifferentTags(image1, image2);
//
//		Math.min(numberOfDifferentTags(image1,image2), numberOfSameTags(image1,image2));
//	}

}
