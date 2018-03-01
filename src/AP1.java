import java.util.Arrays;
import java.util.ArrayList;
import java.util.Objects;

public class AP1 {

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
    boolean isEndy(int n) {
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

    int specialScore(int[] a) {
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

    /**
     * Given two strings, base and remove, return a version of the base string where all instances
     * of the remove string have been removed (not case sensitive). You may assume that the remove
     * string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing
     * "xx" leaves "x".
     *
     * @param base
     * @param remove
     * @return
     */
    public String withoutString(String base, String remove) {
        if (!base.toLowerCase().contains(remove.toLowerCase())) return base; // Return the string if
        // remove is not in the string
        StringBuilder sb = new StringBuilder(); // Initiate the StringBuilder
        int length = remove.length(); // Store remove string length in a variable
        for (int i = 0; i < base.length(); i++) {
            if (i + length > base.length()) { // If the remainder of the string is shorter than remove word
                sb.append(base.substring(i, base.length())); // append the remaining string to sb
                break; // end the loop
            } else {
                String check = base.substring(i, i + length).toLowerCase(); // Store the substring of the length of remove
                if (!check.equals(remove.toLowerCase())) { // If the substring does NOT match
                    sb.append(base.substring(i, i + 1)); // Append the current letter to the String
                } else {
                    i += length - 1;
                }

            }

        }
        return sb.toString();
    }

    private int countX(String str) {
        if (str.length() < 1) return 0;
        String letter = str.substring(str.length() - 1, str.length());
        char temp = letter.charAt(0);
        return temp == 'x' ? 1 + countX(str.substring(0, str.length() - 1)) :
                countX(str.substring(0, str.length() - 1));
    }


    public int countHi(String str) {
        if (str.length() < 2) return 0;
        String word = str.substring(str.length() - 2, str.length());
        return Objects.equals(word, "hi") ? 1 + countHi(str.substring(0, str.length() - 1)) :
                countHi(str.substring(0, str.length() - 1));
    }

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and
     * the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y
     * or z is at the end of a word if there is not an alphabetic letter immediately following it.
     * (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * countYZ("fez day") → 2
     * countYZ("day fez") → 2
     * countYZ("day fyyyz") → 2
     *
     * @param str The given string to count yz
     * @return The yz count in the string
     */
    public int countYZ(String str) {

        if (str.length() < 2) return 0;
        str = str.toLowerCase();
        int count = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            char check = str.charAt(i); // Store the current character
            if (check == 'y' || check == 'z') { // Is it the character I'm looking for?
                if (i + 1 < str.length() &&
                        !Character.isLetter(str.charAt(i + 1))) count++;
            }
        }
        count += str.charAt(str.length() - 1) == 'y' || str.charAt(str.length() - 1) == 'z' ? 1 : 0;

        return count;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is
     * equal to the number of appearances of "not" anywhere in the string (case sensitive).
     * <p>
     * equalIsNot("This is not") → false
     * equalIsNot("This is notnot") → true
     * equalIsNot("noisxxnotyynotxisi") → true
     *
     * @param str
     * @return
     */
    public boolean equalIsNot(String str) {
        if (!str.contains("is") || !str.contains("not")) return true;
        int count = 0;
        for (int i = 3; i <= str.length(); i++) {
            String check = str.substring(i - 3, i);
            if (check.contains("is")) {
                count++;
                i += 1;
            } else {
                if (check.contains("not")) {
                    count--;
                    i += 1;
                }
            }
        }

        return count == 0;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately
     * to its left or right. Return true if all the g's in the given string are happy.
     * <p>
     * gHappy("xxggxx") → true
     * gHappy("xxgxx") → false
     * gHappy("xxggyygxx") → false
     *
     * @param str
     * @return
     */
    public boolean gHappy(String str) {
        if (!str.contains("g")) return true; // If there are no 'g' characters

        boolean check = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'g') { // check for a char 'g'
                if (i > 0 && str.charAt(i - 1) == 'g' || i + 1 < str.length() && str.charAt(i + 1) == 'g') {
                    check = true;
                } else {
                    check = false;
                }
            }
        }
        return check;
    }

    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row. Return the
     * number of triples in the given string. The triples may overlap.
     * <p>
     * countTriple("abcXXXabc") → 1
     * countTriple("xxxabyyyycd") → 3
     * countTriple("a") → 0
     *
     * @param str
     * @return
     */
    public int countTriple(String str) {
        if (str.length() < 3) return 0;

        int count = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            char check = str.charAt(i);
            if (str.charAt(i + 1) == check && str.charAt(i + 2) == check) count++;
        }
        return count;
    }

    /**
     * Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all
     * other characters. Return 0 if there are no digits in the string.
     * (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
     * Integer.parseInt(string) converts a string to an int.)
     * <p>
     * sumDigits("aa1bc2d3") → 6
     * sumDigits("aa11b33") → 8
     * sumDigits("Chocolate") → 0
     *
     * @param str
     * @return
     */
    public int sumDigits(String str) {

    }


}
