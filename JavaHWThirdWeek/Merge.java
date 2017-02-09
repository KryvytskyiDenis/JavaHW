import java.util.Arrays;

public class Merge {

    public static int[] merge(int[] arr0, int[] arr1) {

        int[] result = new int[arr0.length + arr1.length];

        System.out.println("arr0 - " + Arrays.toString(arr0));
        System.out.println("arr1 - " + Arrays.toString(arr1));

        int index0 = 0;
        int index1 = 0;

        while (index0 + index1 != result.length) { //сравнивать нужно не с result.length - 2, а с result.length
            if (index0 < arr0.length && index1 < arr1.length) {
                if (arr0[index0] <= arr1[index1]) {
                    result[index0 + index1] = arr0[index0++];
                } else {
                    result[index0 + index1] = arr1[index1++];
                }
            } else if (index0 == arr0.length) {
                index0 = arr0.length - 1;
                System.arraycopy(arr1, index1, result, index0 + index1 + 1, arr1.length - index1);
                index1 = arr1.length + 1;//индекс нужн оуеличить на один, а не уменьшить
            } else if (index1 == arr1.length) {
                index1 = arr1.length - 1;
                System.arraycopy(arr0, index0, result, index0 + index1 + 1, arr0.length - index0);
                index0 = arr0.length + 1;//индекс нужн оуеличить на один, а не уменьшить
            }

            System.out.println("---" + Arrays.toString(result));

        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr0 = {2, 4, 5, 10, 67};
        int[] arr1 = {1, 2, 5, 6, 8, 13, 35};

        System.out.println(Arrays.toString(merge(arr0, arr1)));
    }
}