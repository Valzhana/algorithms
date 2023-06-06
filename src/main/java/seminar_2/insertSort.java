package seminar_2;

public class insertSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 5, 8, 1, 3, 2, 6, 9, 5};

        insertSort(array);

        for(int i = 0; i<array.length -1; i++) {
            System.out.println(array[i] + "");
        }
    }
    public static void insertSort (int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
