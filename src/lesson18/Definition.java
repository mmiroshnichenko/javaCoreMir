package lesson18;

public class Definition {
    private void notifyUsers(String[] userEmails) {
        for (String email : userEmails) {
            try {
                //send email to user - error
                System.out.println("Email " + email + " was sent");
                //
                //

            } catch (Exception e) {
                //how should I handle exception
                System.err.println("Email " + email + " was not sent");
            } finally {
                //updateStatus
            }
//            catch (type2) {
//
//            }
        }
    }
}
