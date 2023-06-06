package seminar_2;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5,6,7};
        System.out.println(binSearch(array, 5));
    }
    public static int binSearch (int[] array, int value) {
        return binSearch(array, value, 0, array.length - 1);
    }
    public static int binSearch (int[] array, int value, int min, int max) {
        int midPoint;
        if (max < min) {
            return -1;
        } else {
            midPoint = (max - min) / 2 + min;
        }
        if (array[midPoint] < value) {
            return binSearch(array, value, midPoint + 1, max);
        } else {
            if (array[midPoint] > value) {
                return binSearch(array, value, min, midPoint - 1);
            } else {
                return midPoint;
            }
        }
    }
}
