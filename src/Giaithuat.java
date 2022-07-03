public class Giaithuat {


    public static void main(String[] args) {
        int[] list = {-1, 150, 190, 170, -1, -1, 160, 180};
        selectionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == -1) continue;
            int currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j] && list[j] != -1) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

}
