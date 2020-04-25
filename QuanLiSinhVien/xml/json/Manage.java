/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiSinhVien.xml.json;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thien Phu
 */
public class Manage {

    public Manage() {
    }

    public void insert(Student st) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/t1907a", "root", "");

            String sql = "insert into student(rollNo ,fullname,gender,address,email)values (?,?,?,?,?)";

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, st.getRollNo());
            preparedStatement.setString(2, st.getHoten());
            preparedStatement.setString(3, st.getGioiTinh());
            preparedStatement.setString(4, st.getDiaChi());
            preparedStatement.setString(5, st.getEmail());

            preparedStatement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
