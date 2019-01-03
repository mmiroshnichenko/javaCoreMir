package lesson17.hw4;

public class Solution {

    public boolean validate(String address) {

        address = address.replace("//www.", "//");

        String[] urlParts = address.split("//");
        if (urlParts.length != 2 || (!urlParts[0].equals("http:") && !urlParts[0].equals("https:"))) {
            return false;
        }

        String[] addressParts = urlParts[1].split("\\.");
        if (addressParts.length != 2 || !validateAddressPart(addressParts[0])
                || (!addressParts[1].equals("com") && !addressParts[1].equals("org") && !addressParts[1].equals("net"))) {
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
