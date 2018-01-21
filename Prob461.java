public class Prob461 {
	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 2));
	}
	
	public static int hammingDistance(int x, int y) {
		return Integer.bitCount(x ^ y);
	}
}
