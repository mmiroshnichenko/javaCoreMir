package lesson17.hw4V2;

public class Solution {
    public boolean validate(String address) {
        if (address == null || address.isEmpty()) {
            return false;
        }

        address = address.toLowerCase()
                .replace("https://", "http://")
                .replace("//www.", "//");

        if (address.length() < 12) {
            return false;
        }

        String protocol = address.substring(0, 7);
        String domain = address.substring(address.length() - 4);
        String siteName = address.substring(7, address.length() - 4);
        if (protocol.equals("http://") && validateSiteName(siteName)
            && (domain.equals(".com")) || domain.equals(".org") || domain.equals(".net")) {
            return true;
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
