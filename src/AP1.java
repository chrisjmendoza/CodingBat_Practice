public class AP1 {

    /**
     * Given a positive int n, return true if it contains a 1 digit. Note: use % to get the
     * rightmost digit, and / to discard the rightmost digit.
     *
     * @param n The integer to check
     * @return True if the
     */
    boolean hasOne(int n) {
        if(n < 10) return n == 1;

        int value = n;
        int check;

        while(value > 9) {
            check = value % 10;
            value = value / 10;
            if(check == 1 || value == 1) return true;
        }

        return false;
    }
}
