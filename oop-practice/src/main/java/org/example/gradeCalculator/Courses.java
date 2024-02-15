package org.example.gradeCalculator;

import java.util.List;

public class Courses {

    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        double multiplyCreditAndCourseGrade = 0;
        for(Course course: courses) {
            multiplyCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }
        return multiplyCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
         return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
