package com.sms.service;

import com.sms.dao.CourseDAO;
import com.sms.model.Course;
import java.util.List;

public class CourseService {
    private CourseDAO courseDAO = new CourseDAO();

    public void addCourse(Course course) {
        courseDAO.addCourse(course);
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }
}

