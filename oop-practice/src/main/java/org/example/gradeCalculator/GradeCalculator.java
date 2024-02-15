package org.example.gradeCalculator;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculateGrade() {
        double totalMultipliedCreditAndCourseGrade = 0;
        for(Course course: courses) {
            totalMultipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }

        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
