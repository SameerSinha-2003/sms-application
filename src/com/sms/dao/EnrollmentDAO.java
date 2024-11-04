package com.sms.dao;
import com.sms.dao.DatabaseConnection;

import com.sms.model.Enrollment;
import java.sql.*;

public class EnrollmentDAO {
    public void enrollStudent(Enrollment enrollment) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Enrollments (student_id, course_id) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, enrollment.getStudentId());
            stmt.setInt(2, enrollment.getCourseId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

