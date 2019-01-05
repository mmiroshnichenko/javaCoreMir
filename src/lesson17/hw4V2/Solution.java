package lesson17.hw4V2;

public class Solution {
    public boolean validate(String address) {

        address = address.toLowerCase()
                .replace("//www.", "//");

        if (address.length() < 12) {
            return false;
        }
        String[] protocols = {"https://", "http://"};
        for (String availableProtocol : protocols) {
            String protocol = address.substring(0, availableProtocol.length());
            String domain = address.substring(address.length() - 4);
            String siteName = address.substring(availableProtocol.length(), address.length() - 4);
            if (availableProtocol.equals(protocol) && validateSiteName(siteName)
                    && (domain.equals(".com")) || domain.equals(".org") || domain.equals(".net")) {
                return true;
            }
        }


        return false;
    }

    private boolean validateSiteName(String siteName) {
        char[] chars = siteName.toCharArray();

        for (char ch : chars) {
            if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }
}
