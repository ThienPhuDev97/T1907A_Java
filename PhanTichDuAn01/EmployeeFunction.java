/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhanTichDuAn01;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class EmployeeFunction {

    public static List<Order> thongkeorder() {
        List<Order> list = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1?serverTimezone=UTC", "root", "");
            String sql = "SELECT * FROM `orders`";
            System.out.println(sql);
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //doc du lieu từng hàng trong mysql
            while (resultSet.next()) {
                Order order = new Order();

                order.setIdOrder(resultSet.getString("ID_order"));
                order.setIdCustomer(resultSet.getString("ID_customer"));
                order.setIdUser(resultSet.getString("ID_user"));
                order.setDateOrder(resultSet.getString("date_Order"));
                order.setTotalMoney(resultSet.getInt("TotalMoney"));
                list.add(order);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manage.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
        return list;

    }

    public static List<Customer> thongkeCustomers() {
        List<Customer> listcustomer = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1?serverTimezone=UTC", "root", "");
            String sql = "SELECT * FROM `customer`";
            System.out.println(sql);
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //doc du lieu từng hàng trong mysql
            while (resultSet.next()) {
                Customer cus = new Customer();
                cus.setAddress(resultSet.getString("address"));
                cus.setID_customer(resultSet.getString("ID_customer"));
                cus.setID_user(resultSet.getString("ID_user"));
                cus.setName_customer(resultSet.getString("nameCustomer"));
                cus.setPhone(resultSet.getString("phone"));
                cus.setGender(resultSet.getString("gender"));
                cus.setIdentity_card(resultSet.getInt("identity_card"));
                listcustomer.add(cus);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeFunction.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return listcustomer;

    }

    public void insertCustomer(Customer customer) {
        System.out.println(customer.toString());
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1?serverTimezone=UTC", "root", "");
            //query

            String sql = "INSERT INTO `customer`(`ID_customer`,`nameCustomer`, `gender`, `address`, `phone`, `identity_card`, `ID_user`) values (?,?,?,?,?,?,?)";
            System.out.println("SQL: "+sql);
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, customer.getID_customer());
            preparedStatement.setString(2, customer.getName_customer());
            preparedStatement.setString(3, customer.getGender());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setInt(6, customer.getIdentity_card());
            preparedStatement.setString(7, customer.getID_user());

            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Manage.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manage.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
