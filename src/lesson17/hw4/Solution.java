package lesson17.hw4;

public class Solution {

    public boolean validate(String address) {

        String[] parts = address.split("//");
        if (parts.length != 2 || (!parts[0].equals("http:") && !parts[0].equals("https:"))) {
            return false;
        }

        String[] addressParts = parts[1].split("\\.");
        String siteName;
        String domain;

        if (addressParts.length == 3 && addressParts[0].equals("www")) {
            siteName = addressParts[1];
            domain = addressParts[2];
        } else if (addressParts.length == 2) {
            siteName = addressParts[0];
            domain = addressParts[1];
        } else {
            return false;
        }

        if (!validateAddressPart(siteName) || (!domain.equals("com") && !domain.equals("org") && !domain.equals("net"))) {
            return false;
        }

        return true;
    }

    private boolean validateAddressPart(String addressPart) {
        char[] chars = addressPart.toCharArray();

        for (char ch : chars) {
            if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }
}
