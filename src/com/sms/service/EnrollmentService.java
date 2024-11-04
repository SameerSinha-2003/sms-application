package com.sms.service;

import com.sms.dao.EnrollmentDAO;
import com.sms.model.Enrollment;

public class EnrollmentService {
    private EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

    public void enrollStudent(Enrollment enrollment) {
        enrollmentDAO.enrollStudent(enrollment);
    }
}

