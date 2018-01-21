public class count {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String srcText = "he orange is the fruit of the citrus species Citrus x sinensis in the family Rutaceae. It is also called sweet orange, to distinguish it from the related Citrus x aurantium, referred to as bitter orange. The sweet orange reproduces asexually (apomixis through nucellar embryony); varieties of sweet orange arise through mutations. The orange is a hybrid between pomelo (Citrus maxima) and mandarin (Citrus reticulata). It has genes that are ~25% pomelo and ~75% mandarin; however, it is not a simple backcrossed BC1 hybrid, but hybridized over multiple generations. The chloroplast genes, and therefore the maternal line, seem to be pomelo. The sweet orange has had its full genome sequenced. Earlier estimates of the percentage of pomelo genes varying from ~50% to 6% have been reported. Sweet oranges were mentioned in Chinese literature in 314 BC. As of 1987, orange trees were found to be the most cultivated fruit tree in the world. Orange trees are widely grown in tropical and subtropical climates for their sweet fruit. The fruit of the orange tree can be eaten fresh, or processed for its juice or fragrant peel. As of 2012, sweet oranges accounted for approximately 70% of citrus production. In 2014, 70.9 million tonnes of oranges were grown worldwide, with Brazil producing 24% of the world total followed by China and India.";
		String findText = "ng";
		int num = appearNumber(srcText, findText);
		System.out.println("Count the number of ng:");
		System.out.println(num);
	}
	
	
	/**
	 * public int indexOf(int ch, int fromIndex)
	 *
	 * @param srcText
	 * @param findText
	 * @return
	 */
	public static int appearNumber(String srcText, String findText) {
		int count = 0;
		int index = 0;
		int secondPos = -1;
		int lastTemp = 0;
		while ((index = srcText.indexOf(findText, index)) != -1) {
			index = index + findText.length();
			lastTemp = index;
			count++;
			if (count == 2) secondPos = index;
		}
		if (secondPos == -1) {
			System.out.println("No second occurrence");
		} else {
			System.out.println("From second to last indices of n is:");
			System.out.println(lastTemp - secondPos);
		}
		return count;
	}
}
