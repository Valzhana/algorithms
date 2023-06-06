package seminar_2;

public class Find {
    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,6,7,4,5};
        System.out.println(find(array, 7));
    }

    public static int find (int[] array, int value) {
        for (int i = 0; i < array.length; i ++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
