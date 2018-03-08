import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AP1 {

    /**
     * Given an array of scores, return true if each score is equal or greater than the one before.
     * The array will be length 2 or more.
     * <p>
     * scoresIncreasing([1, 3, 4]) → true
     * scoresIncreasing([1, 3, 2]) → false
     * scoresIncreasing([1, 1, 4]) → true
     *
     * @param scores
     * @return
     */
    public boolean scoresIncreasing(int[] scores) {
        boolean check = true;
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] > scores[i + 1]) {
                check = false;
            }
        }
        return check;
    }

    /**
     * Given an array of scores, return true if there are scores of 100 next to each other in the
     * array. The array length will be at least 2.
     * <p>
     * scores100([1, 100, 100]) → true
     * scores100([1, 100, 99, 100]) → false
     * scores100([100, 1, 100, 100]) → true
     *
     * @param scores
     * @return
     */
    public boolean scores100(int[] scores) {
        boolean check = false;
        for (int i = 0; i < scores.length - 1 && !check; i++) {
            check = scores[i] == 100 && scores[i + 1] == 100;
        }
        return check;
    }

    /**
     * Given an array of scores sorted in increasing order, return true if the array contains 3
     * adjacent scores that differ from each other by at most 2, such as with {3, 4, 5} or
     * {3, 5, 5}.
     * <p>
     * scoresClump([3, 4, 5]) → true
     * scoresClump([3, 4, 6]) → false
     * scoresClump([1, 3, 5, 5]) → true
     *
     * @param scores
     * @return
     */
    public boolean scoresClump(int[] scores) {

        for (int i = 0; i < scores.length - 2; i++) {
            if (scores[i + 2] - scores[i] <= 2) return true;
        }

        return false;
    }

    /**
     * Given an array of scores, compute the int average of the first half and the second half, and
     * return whichever is larger. We'll say that the second half begins at index length/2. The
     * array length will be at least 2. To practice decomposition, write a separate helper method
     * int average(int[] scores, int start, int end) { which computes the average of the elements
     * between indexes start..end. Call your helper method twice to implement scoresAverage().
     * Write your helper method after your scoresAverage() method in the JavaBat text area.
     * Normally you would compute averages with doubles, but here we use ints so the expected
     * results are exact.
     * <p>
     * scoresAverage([2, 2, 4, 4]) → 4
     * scoresAverage([4, 4, 4, 2, 2, 2]) → 4
     * scoresAverage([3, 4, 5, 1, 2, 3]) → 4
     *
     * @param scores
     * @return
     */
    public int scoresAverage(int[] scores) {
        int avg1 = 0, avg2 = 0;
        avg1 = average(scores, 0, scores.length / 2);
        avg2 = average(scores, scores.length / 2, scores.length);
        return avg1 > avg2 ? avg1 : avg2;
    }

    private int average(int[] scores, int start, int end) {
        int result = 0;

        for (int i = start; i < end; i++) {
            result += scores[i];
        }
        return result / (end - start);
    }

    /**
     * Given an array of strings, return the count of the number of strings with the given length.
     * <p>
     * wordsCount(["a", "bb", "b", "ccc"], 1) → 2
     * wordsCount(["a", "bb", "b", "ccc"], 3) → 1
     * wordsCount(["a", "bb", "b", "ccc"], 4) → 0
     *
     * @param words
     * @param len
     * @return
     */
    public int wordsCount(String[] words, int len) {
        int count = 0;
        for (String s : words) {
            if (s.length() == len) count++;
        }
        return count;
    }

    /**
     * Given an array of strings, return a new array containing the first N strings. N will be in
     * the range 1..length.
     * <p>
     * wordsFront(["a", "b", "c", "d"], 1) → ["a"]
     * wordsFront(["a", "b", "c", "d"], 2) → ["a", "b"]
     * wordsFront(["a", "b", "c", "d"], 3) → ["a", "b", "c"]
     *
     * @param words
     * @param n
     * @return
     */
    public String[] wordsFront(String[] words, int n) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = words[i];
        }
        return result;
    }

    /**
     * Given an array of strings, return a new List (e.g. an ArrayList) where all the strings of the
     * given length are omitted. See wordsWithout() below which is more difficult because it uses
     * arrays.
     * <p>
     * wordsWithoutList(["a", "bb", "b", "ccc"], 1) → ["bb", "ccc"]
     * wordsWithoutList(["a", "bb", "b", "ccc"], 3) → ["a", "bb", "b"]
     * wordsWithoutList(["a", "bb", "b", "ccc"], 4) → ["a", "bb", "b", "ccc"]
     *
     * @param words
     * @param len
     * @return
     */
    public List wordsWithoutList(String[] words, int len) {
        LinkedList<String> list = new LinkedList<>();

        for (String s : words) {
            if (s.length() != len) {
                list.add(s);
            }
        }
        return list;
    }

    /**
     * Given a positive int n, return true if it contains a 1 digit. Note: use % to get the
     * rightmost digit, and / to discard the rightmost digit.
     *
     * @param n The integer to check
     * @return True if the
     */
    boolean hasOne(int n) {
        if (n < 10) return n == 1;

        int value = n;
        int check;

        while (value > 9) {
            check = value % 10;
            value = value / 10;
            if (check == 1 || value == 1) return true;
        }

        return false;
    }

    /**
     * We'll say that a positive int divides itself if every digit in the number divides into the
     * number evenly. So for example 128 divides itself since 1, 2, and 8 all divide into 128
     * evenly. We'll say that 0 does not divide into anything evenly, so no number with a 0 digit
     * divides itself. Note: use % to get the rightmost digit, and / to discard the rightmost
     * digit.
     *
     * @param n The integer to check
     * @return True is all the numbers of the int divide into itself
     */
    public boolean dividesSelf(int n) {
        int value = n;
        int divisor;

        while (value > 0) {
            divisor = value % 10;
            if (divisor == 0 || n % divisor != 0) return false;
            value /= 10;
        }

        return true;
    }

    /**
     * Given an array of positive ints, return a new array of length "count" containing the first
     * even numbers from the original array. The original array will contain at least "count" even
     * numbers.
     *
     * copyEvens([3, 2, 4, 5, 8], 2) → [2, 4]
     * copyEvens([3, 2, 4, 5, 8], 3) → [2, 4, 8]
     * copyEvens([6, 1, 2, 4, 5, 8], 3) → [6, 2, 4]
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
     * We'll say that a positive int n is "endy" if it is in the range 0..10 or 90..100 (inclusive).
     * Given an array of positive ints, return a new array of length "count" containing the first
     * ndy numbers from the original array. Decompose out a separate isEndy(int n) method to test
     * if a number is endy. The original array will contain at least "count" endy numbers.
     *
     * @param nums
     * @param count
     * @return
     */
    public int[] copyEndy(int[] nums, int count) {
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; index < count; i++) {
            if (isEndy(nums[i])) {
                result[index] = nums[i];
                index++;
            }
        }
        return result;
    }

    /**
     * Helper method for copyEndy() method
     *
     * @param n
     * @return
     */
    private boolean isEndy(int n) {
        return n >= 0 && n <= 10 || n >= 90 && n <= 100;
    }

    /**
     * Given 2 arrays that are the same length containing strings, compare the 1st string in
     * one array to the 1st string in the other array, the 2nd to the 2nd and so on. Count the
     * number of times that the 2 strings are non-empty and start with the same char. The
     * strings may be any length, including 0.
     *
     * @param a
     * @param b
     * @return
     */
    public int matchUp(String[] a, String[] b) {
        if (a.length < 1) return 0;
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() > 0 && b[i].length() > 0) {
                result = a[i].substring(0, 1).equals(b[i].substring(0, 1)) ?
                        result + 1 : result;
            }
        }
        return result;
    }

    /**
     * The "key" array is an array containing the correct answers to an exam, like
     * {"a", "a", "b", "b"}. the "answers" array contains a student's answers, with "?"
     * representing a question left blank. The two arrays are not empty and are the same length.
     * Return the score for this array of answers, giving +4 for each correct answer, -1 for each
     * incorrect answer, and +0 for each blank answer.
     * <p>
     * scoreUp(["a", "a", "b", "b"], ["a", "c", "b", "c"]) → 6
     * scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "c"]) → 11
     * scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "b"]) → 16
     *
     * @param key
     * @param answers
     * @return
     */
    public int scoreUp(String[] key, String[] answers) {
        int score = 0;

        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(answers[i])) score += 4;
            else if (!key[i].equals(answers[i]) && answers[i] != "?") score -= 1;
        }

        return score;
    }

    /**
     * Given an array of strings, return a new array without the strings that are equal to the
     * target string. One approach is to count the occurrences of the target string, make a
     * new array of the correct length, and then copy over the correct strings.
     *
     * @param words
     * @param target
     * @return
     */
    public String[] wordsWithout(String[] words, String target) {
        ArrayList<String> arrayList = new ArrayList<>();

        for (String s : words) if (!s.equals(target)) arrayList.add(s);

        return arrayList.toArray(new String[arrayList.size()]);
    }

    /**
     * Given two arrays, A and B, of non-negative int scores. A "special" score is one which
     * is a multiple of 10, such as 40 or 90. Return the sum of largest special score in A and
     * the largest special score in B. To practice decomposition, write a separate helper
     * method which finds the largest special score in an array. Write your helper method
     * after your scoresSpecial() method in the JavaBat text area.
     *
     * @param a
     * @param b
     * @return
     */
    public int scoresSpecial(int[] a, int[] b) {

        return specialScore(a) + specialScore(b);

    }

    /**
     * Helper method for scoresSpecial()
     *
     * @param a
     * @return
     */
    private int specialScore(int[] a) {
        int max = 0;
        for (int i : a) max = i % 10 == 0 && max < i ? i : max;
        return max;
    }

    /**
     * @param heights
     * @param start
     * @param end
     * @return
     */
    public int sumHeights(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += heights[i + 1] > heights[i] ? heights[i + 1] - heights[i] :
                    heights[i] - heights[i + 1];
        }

        return sum;
    }

    /**
     * (A variation on the sumHeights problem.) We have an array of heights, representing the
     * altitude along a walking trail. Given start/end indexes into the array, return the sum of
     * the changes for a walk beginning at the start index and ending at the end index, however
     * increases in height count double. For example, with the heights {5, 3, 6, 7, 2} and start=2,
     * end=4 yields a sum of 1*2 + 5 = 7. The start end end index will both be valid indexes into
     * the array with start <= end.
     * <p>
     * sumHeights2([5, 3, 6, 7, 2], 2, 4) → 7
     * sumHeights2([5, 3, 6, 7, 2], 0, 1) → 2
     * sumHeights2([5, 3, 6, 7, 2], 0, 4) → 15
     *
     * @param heights
     * @param start
     * @param end
     * @return
     */
    public int sumHeights2(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += heights[i + 1] > heights[i] ? (heights[i + 1] - heights[i]) * 2 :
                    (heights[i] - heights[i + 1]);
        }

        return sum;
    }

    /**
     * (A variation on the sumHeights problem.) We have an array of heights, representing the
     * altitude along a walking trail. Given start/end indexes into the array, return the number of
     * "big" steps for a walk starting at the start index and ending at the end index. We'll say
     * that step is big if it is 5 or more up or down. The start end end index will both be valid
     * indexes into the array with start <= end.
     * <p>
     * bigHeights([5, 3, 6, 7, 2], 2, 4) → 1
     * bigHeights([5, 3, 6, 7, 2], 0, 1) → 0
     * bigHeights([5, 3, 6, 7, 2], 0, 4) → 1
     *
     * @param heights
     * @param start
     * @param end
     * @return
     */
    public int bigHeights(int[] heights, int start, int end) {
        int steps = 0;
        for (int i = start; i < end; i++) {
            steps += Math.abs(heights[i + 1] - heights[i]) >= 5 ? 1 : 0;
        }
        return steps;
    }

    /**
     * We have data for two users, A and B, each with a String name and an int id. The goal is to
     * order the users such as for sorting. Return -1 if A comes before B, 1 if A comes after B,
     * and 0 if they are the same. Order first by the string names, and then by the id numbers if
     * the names are the same. Note: with Strings str1.compareTo(str2) returns an int value which
     * is negative/0/positive to indicate how str1 is ordered to str2 (the value is not limited to
     * -1/0/1). (On the AP, there would be two User objects, but here the code simply takes the two
     * strings and two ints directly. The code logic is the same.)
     * <p>
     * userCompare("bb", 1, "zz", 2) → -1
     * userCompare("bb", 1, "aa", 2) → 1
     * userCompare("bb", 1, "bb", 1) → 0
     *
     * @param aName
     * @param aId
     * @param bName
     * @param bId
     * @return
     */
    public int userCompare(String aName, int aId, String bName, int bId) {
        if (aName.compareTo(bName) == 0 && aId == bId) return 0;
        if (aName.compareTo(bName) == 0) {
            return aId > bId ? 1 : -1;
        }
        return aName.compareTo(bName) > 0 ? 1 : -1;
    }

    /**
     * Start with two arrays of strings, A and B, each with its elements in alphabetical order and
     * without duplicates. Return a new array containing the first N elements from the two arrays.
     * The result array should be in alphabetical order and without duplicates. A and B will both
     * have a length which is N or more. The best "linear" solution makes a single pass over A and
     * B, taking advantage of the fact that they are in alphabetical order, copying elements
     * directly to the new array.
     * <p>
     * mergeTwo(["a", "c", "z"], ["b", "f", "z"], 3) → ["a", "b", "c"]
     * mergeTwo(["a", "c", "z"], ["c", "f", "z"], 3) → ["a", "c", "f"]
     * mergeTwo(["f", "g", "z"], ["c", "f", "g"], 3) → ["c", "f", "g"]
     *
     * @param a
     * @param b
     * @param n
     * @return
     */
    public String[] mergeTwo(String[] a, String[] b, int n) {
        String[] result = new String[n];
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            if (a[x].compareTo(b[y]) == 0) {
                result[i] = a[x];
                x++;
                y++;
            } else {
                if (a[x].compareTo(b[y]) < 0) {
                    result[i] = a[x];
                    x++;
                } else {
                    result[i] = b[y];
                    y++;
                }
            }
        }
        return result;
    }

    /**
     * Start with two arrays of strings, a and b, each in alphabetical order, possibly with
     * duplicates. Return the count of the number of strings which appear in both arrays. The best
     * "linear" solution makes a single pass over both arrays, taking advantage of the fact that
     * they are in alphabetical order.
     *
     * @param a
     * @param b
     * @return
     */
    public int commonTwo(String[] a, String[] b) {
        int result = 0;
        int x = 0; // index for a[]
        int y = 0; // index for b[]
        String lastMatch = "";
        int counter = a.length + b.length;
        for (int i = 0; i < counter; i++) {
            if (a[x].compareTo(b[y]) == 0) { // If the letters are the same
                result += a[x].compareTo(lastMatch) != 0 ? 1 : 0;
                lastMatch = a[x];
                if (x + 1 >= a.length) return result;
                if (y + 1 >= b.length) return result;
                x += x + 1 < a.length ? 1 : 0;
                y += y + 1 < b.length ? 1 : 0;
                i++;
            } else if (a[x].compareTo(b[y]) < 0) { // If a is lower than b, increment a
                if (x + 1 >= a.length) return result;
                else x++;
            } else { // If not, increment b
                if (y + 1 >= b.length) return result;
                else y++;
            }
        }
        return result;
    }

}
