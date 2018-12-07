package lesson8.home2;

import java.util.Date;

public class Demo {
    public Student createHighestParent() {
        Course[] courses = getCourses();

        Student student = new Student("Petr", "Petrov", 12, courses);

        return student;
    }

    public SpecialStudent createLowestChild() {
        Course[] courses = getCourses();

        SpecialStudent specialStudent = new SpecialStudent("Petr", "Petrov", 12, courses, 54654654, "test@test.com");

        return specialStudent;
    }

    public static Course[] getCourses() {
        Course course1 = new Course(new Date(), "Test1", 120, "teacherName1", null);
        Course course2 = new Course(new Date(), "Test1", 120, "teacherName2", null);
        Course[] courses = {course1, course2};

        return courses;
    }

}
