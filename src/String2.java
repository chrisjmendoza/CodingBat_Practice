import java.util.Objects;

public class String2 {

    /**
     * Given an array of positive ints, return a new array of length "count" containing the first even numbers from the original array. The original array will contain at least "count" even numbers.
     *
     * @param nums
     * @param count
     * @return
     */
    public int[] copyEvens(int[] nums, int count) {
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; index < count; i++) {
            if (nums[i] % 2 == 0) {
                result[index] = nums[i];
                index++;
            }
        }
        return result;
    }


    /**
     * Return the number of times that the string "hi" appears anywhere in the given string.
     *
     * @param str
     * @return
     */
    public int countHi(String str) {
        if (str.length() < 2) return 0;
        String word = str.substring(str.length() - 2, str.length());
        return Objects.equals(word, "hi") ? 1 + countHi(str.substring(0, str.length() - 1)) :
                countHi(str.substring(0, str.length() - 1));
    }
}
