import java.util.ArrayList;

public class String3 {

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
        int sum = 0;
        StringBuilder temp = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) temp.append(c);
        }
        for (int i = 0; i < temp.toString().length(); i++) {
            sum += Integer.parseInt(temp.toString().substring(i, i + 1));
        }
        return sum;
    }

    /**
     * Given a string, return the longest substring that appears at both the beginning and end of
     * the string without overlapping. For example, sameEnds("abXab") is "ab".
     * <p>
     * sameEnds("abXYab") → "ab"
     * sameEnds("xx") → "x"
     * sameEnds("xxx") → "x"
     *
     * @param string
     * @return
     */
    public String sameEnds(String string) {

        for (int i = string.length() / 2; i > 0; i--) {
            String check = string.substring(0, i);
            if (string.lastIndexOf(check) > 0) {
                return check;
            }
        }
        return "";
    }

    /**
     * Given a string, look for a mirror image (backwards) string at both the beginning and end of
     * the given string. In other words, zero or more characters at the very beginning of the given
     * string, and at the very end of the string in reverse order (possibly overlapping). For
     * example, the string "abXYZba" has the mirror end "ab".
     * <p>
     * mirrorEnds("abXYZba") → "ab"
     * mirrorEnds("abca") → "a"
     * mirrorEnds("aba") → "aba"
     *
     * @param string
     * @return
     */
    public String mirrorEnds(String string) {
        StringBuilder sb = new StringBuilder(string);
        sb.reverse();

        for (int i = string.length(); i > 0; i--) {
            String check = string.substring(0, i);
            if (string.substring(0, i).contentEquals(sb.subSequence(0, i))) return check;
        }
        return "";
    }

    /**
     * Given a string, return the length of the largest "block" in the string. A block is a run of
     * adjacent chars that are the same.
     * <p>
     * <p>
     * maxBlock("hoopla") → 2
     * maxBlock("abbCCCddBBBxx") → 3
     * maxBlock("") → 0
     *
     * @param str
     * @return
     */
    public int maxBlock(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            int charCount = 0; // Temp variable to store the count of a char
            while (i < str.length() && str.charAt(i) == letter) {
                i++;
                charCount++;
                count = charCount > count ? charCount : count;
            }
            i--; // Move back one letter for the for loop incrementer
        }
        return count;
    }

    /**
     * Given a string, return the sum of the numbers appearing in the string, ignoring all other
     * characters. A number is a series of 1 or more digit chars in a row.
     * (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
     * Integer.parseInt(string) converts a string to an int.)
     * <p>
     * sumNumbers("abc123xyz") → 123
     * sumNumbers("aa11b33") → 44
     * sumNumbers("7 11") → 18
     *
     * @param str
     * @return
     */
    public int sumNumbers(String str) {
        ArrayList<Integer> nums = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                sb.append(Integer.parseInt(str.substring(i, i + 1)));
                i++;
            }
            if (sb.length() > 0) {
                nums.add(Integer.parseInt(sb.toString()));
                sb.delete(0, sb.length());
            }
        }
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }

    /**
     * Given a string, return a string where every appearance of the lowercase word "is" has been
     * replaced with "is not". The word "is" should not be immediately preceeded or followed by a
     * letter -- so for example the "is" in "this" does not count. (Note: Character.isLetter(char)
     * tests if a char is a letter.)
     * <p>
     * notReplace("is test") → "is not test"
     * notReplace("is-is") → "is not-is not"
     * notReplace("This is right") → "This is not right"
     *
     * @param str
     * @return
     */
    public String notReplace(String str) {
        if (!str.contains("is")) return str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i + 2 <= str.length() && str.substring(i, i + 2).equals("is")) { // Check for "is"
                if (i == 0 || !Character.isLetter(str.charAt(i - 1))) { // The beginning of the string
                    // or is not part of a word
                    if (i + 3 > str.length()) {
                        sb.append("is not");
                        i++;
                    } else if (!Character.isLetter(str.charAt(i + 2))) {
                        sb.append("is not");
                        i++;
                    } else {
                        sb.append(str.substring(i, i + 1));
                    }
                } else {
                    sb.append(str.substring(i, i + 2));
                    i++;
                }
            } else {
                sb.append(str.substring(i, i + 1)); // If "is" not present, append the current char
            }
        }

        return sb.toString();
    }
}
