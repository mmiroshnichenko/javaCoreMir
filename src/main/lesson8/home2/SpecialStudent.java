package main.lesson8.home2;

import java.util.Arrays;

public class SpecialStudent extends CollegeStudent {
    long secretKey;
    String email;

    public SpecialStudent(String firstName, String lastName, int group, Course[] coursesTaken, long secretKey, String email) {
        super(firstName, lastName, group, coursesTaken);
        this.secretKey = secretKey;
        this.email = email;
    }

    @Override
    public String toString() {
        return "SpecialStudent{" +
                "secretKey=" + secretKey +
                ", email='" + email + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", rating=" + rating +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group=" + group +
                ", coursesTaken=" + Arrays.toString(coursesTaken) +
                ", age=" + age +
                '}';
    }
}
