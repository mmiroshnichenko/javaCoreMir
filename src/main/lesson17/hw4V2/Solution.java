package main.lesson17.hw4V2;

public class Solution {
    public boolean validate(String address) {
        address = address.toLowerCase();

        String[] startStrings = new String[]{"https://", "http://", "https://www.", "http://www."};
        String[] endStrings = new String[]{".com", ".org", ".net"};

        for (String startString : startStrings) {
            for (String endString : endStrings) {
                int minLength = startString.length() + endString.length() + 1;
                if (address.length() >= minLength
                        && startString.equals(address.substring(0, startString.length()))
                        && endString.equals(address.substring(address.length() - endString.length()))
                        && validateSiteName(address.substring(startString.length(), address.length() - endString.length()))) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean validateSiteName(String siteName) {
        char[] chars = siteName.toCharArray();

        for (char ch : chars) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }

        return true;
    }
}
