public class Recursion1 {

    /**
     * Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the
     * string.
     * <p>
     * countX("xxhixx") → 4
     * countX("xhixhix") → 3
     * countX("hi") → 0
     *
     * @param str
     * @return
     */
    private int countX(String str) {
        if (str.length() < 1) return 0;
        String letter = str.substring(str.length() - 1, str.length());
        char temp = letter.charAt(0);
        return temp == 'x' ? 1 + countX(str.substring(0, str.length() - 1)) :
                countX(str.substring(0, str.length() - 1));
    }

}
