package lesson8.home2;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Course course1 = new Course(new Date(), "Course 1", 120, "teacherName1", null);
        System.out.println(course1);
        Course course2 = new Course(new Date(), "Course 2", 140, "teacherName2", null);
        System.out.println(course2);
        Course[] courses = {course1, course2};
        System.out.println(Arrays.deepToString(courses));

        Student student = new Student("Denis", "Ivanov", 14, courses);
        System.out.println(student);
        Student student2 = new Student("Ann", "Ivanova", 14, null);
        System.out.println(student2);
        student2.coursesTaken = courses;
        System.out.println(student2);

        SpecialStudent specialStudent = new SpecialStudent("Petr", "Petrov", 12, courses, 54654654, "test@test.com");
        System.out.println(specialStudent);
        SpecialStudent specialStudent2 = new SpecialStudent(null, "Petrov", 12, null, 54654654, "test@test.com");
        System.out.println(specialStudent2);

        CollegeStudent collegeStudent = new CollegeStudent("Pavel", "Ivanov", 14, courses);
        System.out.println(collegeStudent);
        CollegeStudent collegeStudent2 = new CollegeStudent("Karim", "Ivanov", 14, courses, "KPI", 15, 1521);
        System.out.println(collegeStudent2);
    }

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
