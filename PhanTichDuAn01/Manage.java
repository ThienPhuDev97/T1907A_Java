/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhanTichDuAn01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Thien Phu
 */
public class Manage {

    public Manage() {

    }
//login dang nhap
    //lấy dữ liệu từ bảng user

    public List<User> checkLogin(String sql) {
        List<User> myarray = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");

            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //doc du lieu từng hàng trong mysql
            while (resultSet.next()) {
                User user = new User();
                user.setID_user(resultSet.getString("ID_user"));
                user.setUserName(resultSet.getString("Username"));
                user.setPassWord(resultSet.getString("PASSWORD"));
                user.setID_person(resultSet.getString("ID_person"));
                user.setRole(resultSet.getString("Role"));
                myarray.add(user);

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

        return myarray;
        ///

    }

    //insert datta my sql
    public void insertData(Order order) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            //query

            String sql = "insert into orders(ID_order ,ID_customer ,ID_user ,date_Order,TotalMoney)values (?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, order.getIdOrder());
            preparedStatement.setString(2, order.getIdCustomer());
            preparedStatement.setString(3, order.getIdUser());
            preparedStatement.setString(4, order.getDateOrder());
            preparedStatement.setInt(5, order.getTotalMoney());
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

    public void insertDataOrderDetail(List<OrderDetail> order) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            //query

            for (OrderDetail order1 : order) {
                String sql = "insert into orderdetail(ID_order ,ID_product,Price,Quantity,TotalMoney )values (?,?,?,?,?)";
                preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(1, order1.getIdOrder());
                preparedStatement.setString(2, order1.getIdProduct());
                preparedStatement.setInt(3, order1.getPrice());
                preparedStatement.setInt(4, order1.getQuantity());
                preparedStatement.setInt(5, order1.getTotalMoney());

                preparedStatement.execute();

            }

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

    //lay thong tin chi tiet hoa don ve cho khach hang
    public Order getOrder(String ma) {
        Order order = new Order();
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            String sql = "SELECT * FROM `orders` where ID_order ='" + ma + "'";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //doc du lieu từng hàng trong mysql
            while (resultSet.next()) {

                order.setIdOrder(resultSet.getString("ID_order"));
                order.setIdCustomer(resultSet.getString("ID_customer"));
                order.setIdUser(resultSet.getString("ID_user"));
                order.setDateOrder(resultSet.getString("date_Order"));

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
        return order;
        ///

    }

    public List<OrderDetail> getOrderSp(String ma) {
        List<OrderDetail> mylist = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            String sql = "SELECT * FROM `OrderDetail` where ID_order ='" + ma + "'";
            System.out.println(sql);
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //doc du lieu từng hàng trong mysql
            while (resultSet.next()) {
                OrderDetail order = new OrderDetail();
                order.setIdOrder(resultSet.getString("ID_order"));
                //System.out.println(order.getId_order());
                order.setIdProduct(resultSet.getString("ID_product"));
                order.setPrice(resultSet.getInt("Price"));
                order.setQuantity(resultSet.getInt("Quantity"));
                order.setTotalMoney(resultSet.getInt("TotalMoney"));
                mylist.add(order);

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
//        for (OrderDetail mylist1 : mylist) {
//            mylist1.display();
//        }
        return mylist;
        ///

    }

    //code add tai khoan acc trong quantiacc.java
    public void insertUser(User us) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            //query
            us.display();
            String sql = "insert into users(ID_user  ,Username  ,PASSWORD,ID_person,Role)values (?,?,?,?,?)";
            System.out.println(sql);
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, us.getID_user());
            preparedStatement.setString(2, us.getUserName());
            preparedStatement.setString(3, us.getPassWord());
            preparedStatement.setString(4, us.getID_person());
            preparedStatement.setString(5, us.getRole());

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

    // update user
    public static void updateUser(User us) {
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            String sql = "UPDATE users SET Username =" + "'" + us.getUserName() + " ' ,PASSWORD=' " + us.getPassWord()
                    + "',Role ='" + us.getRole() + "' where ID_user = '" + us.getID_user() + "'";
            System.out.println(sql);

            statement = conn.createStatement();

            statement.executeUpdate(sql);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    //deleted user
    public static void deleteUser(String data) {
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");

            String sql = "DELETE FROM users WHERE ID_user   =" + "'" + data + "'";

            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //code jfram quan li thong tin nhan vien
    // 1: lấy dữ liệu person về 
    public List<Person> getPerson() {
        List<Person> mylist = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            String sql = "SELECT * FROM `person";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //doc du lieu từng hàng trong mysql
            while (resultSet.next()) {
                Person ps = new Person();

                ps.setID_person(resultSet.getString("ID_person"));
                ps.setFullName(resultSet.getString("FullName"));
                ps.setBirthday(resultSet.getString("Birthday"));
                ps.setGender(resultSet.getString("Gender"));
                ps.setAddress(resultSet.getString("Address"));
                ps.setPhone(resultSet.getString("phone"));
                ps.setIdentity_card(resultSet.getInt("identity_card"));
                mylist.add(ps);
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
        return mylist;
        ///
    }

    //2: add 1 person vao bang
    public void insertPerson(Person ps) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            //query

            String sql = "insert into person(ID_person,FullName,Birthday,Gender,Address,phone,identity_card)values (?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, ps.getID_person());
            preparedStatement.setString(2, ps.getFullName());
            preparedStatement.setString(3, ps.getBirthday());
            preparedStatement.setString(4, ps.getGender());
            preparedStatement.setString(5, ps.getAddress());
            preparedStatement.setString(6, ps.getPhone());
            preparedStatement.setInt(7, ps.getIdentity_card());
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

    //3: Update trong person
    public void updatePerson(Person ps) {
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            String sql = "UPDATE person SET FullName =" + "'" + ps.getFullName() + "',Birthday ="
                    + "'" + ps.getBirthday() + "',Gender = '" + ps.getGender() + "',Address = '" + ps.getAddress() + "',phone = '"
                    + ps.getPhone() + "',identity_card  = '" + ps.getIdentity_card() + "' where ID_person= '" + ps.getID_person() + "'";

            statement = conn.createStatement();

            statement.executeUpdate(sql);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    //code danh muc sp
    public static List<Category> fillAll() {//k ấn đc chượt a ơi
        List<Category> categoryList = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", ""); // chỗ bigC nhungw e xua van the
            String sql = "select * from category";

            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Category cgr = new Category(resultSet.getString("ID_category"),
                        resultSet.getString("name_category"), resultSet.getString("ID_user"));

                categoryList.add(cgr);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return categoryList;
    }

    public static void insertDM(Category dm) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            //query

            String sql = "insert into category(ID_category  ,name_category  ,ID_user)values (?,?,?)";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, dm.getiD_category());
            preparedStatement.setString(2, dm.getNameCategory());
            preparedStatement.setString(3, dm.getIdUser());

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

    //update dm
    public static void updateDM(Category dm) {
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            String sql = "UPDATE category SET name_category  =" + "'" + dm.getNameCategory() + "' where ID_category = '" + dm.getiD_category() + "'";

            statement = conn.createStatement();

            statement.executeUpdate(sql);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    //deleted danh muc
    public static void delete(String data) {
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");

            String sql = "DELETE FROM category WHERE ID_category  =" + "'" + data + "'";

            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //quan li san pham
    //1.getdata san pham 
    public static List<Product> getProduct() {
        List<Product> mylist = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            String sql = "SELECT * FROM `product";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //doc du lieu từng hàng trong mysql
            while (resultSet.next()) {
                Product sp = new Product();

                sp.setIdProduct(resultSet.getString("ID_product"));
                sp.setIdCategory(resultSet.getString("ID_category"));
                sp.setNameProduct(resultSet.getString("name_product"));
                sp.setQuantity(resultSet.getInt("quantity"));
                sp.setPrice(resultSet.getInt("price"));
                sp.setDateManufacture(resultSet.getString("date_manufacture"));
                sp.setExpiryDate(resultSet.getString("expiry_date"));
                mylist.add(sp);
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
        return mylist;
        ///
    }

    //2: insert san pham
    public static void insertProduct(Product sp) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            //query

            String sql = "insert into product(ID_product,ID_category,name_product,quantity ,price ,date_manufacture ,expiry_date )values (?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, sp.getIdProduct());
            preparedStatement.setString(2, sp.getIdCategory());
            preparedStatement.setString(3, sp.getNameProduct());
            preparedStatement.setInt(4, sp.getQuantity());
            preparedStatement.setInt(5, sp.getPrice());
            preparedStatement.setString(6, sp.getDateManufacture());
            preparedStatement.setString(7, sp.getExpiryDate());
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

    //update san pham
    public static void updateProduct(Product sp) {
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");
            String sql = "UPDATE product SET ID_category =" + "'" + sp.getIdCategory() + "',name_product ="
                    + "'" + sp.getNameProduct() + "',quantity = '" + sp.getQuantity() + "',price ='"
                    + sp.getPrice() + "',date_manufacture ='" + sp.getDateManufacture() + "',expiry_date ='"
                    + sp.getExpiryDate() + "' where ID_product  = '" + sp.getIdProduct() + "'";

            statement = conn.createStatement();

            statement.executeUpdate(sql);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    //3 deleted san pham
    public static void deleteProduct(String data) {
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan1", "root", "");

            String sql = "DELETE FROM product WHERE ID_product   =" + "'" + data + "'";

            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //check hạn sử dụng
    public static long checkHsd(String d1) {

        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date currentDate = new Date();
        Date date1 = null;
        Date date2 = null;
        long getDaysDiff = 0;
        try {
           
            String endDate = simpleDateFormat.format(currentDate);

            date1 = simpleDateFormat.parse(d1);
            date2 = simpleDateFormat.parse(endDate);

            long getDiff = date2.getTime() - date1.getTime();

            getDaysDiff = getDiff / (24 * 60 * 60 * 1000);

            System.out.println("Differance between date " + d1 + " and " + endDate + " is " + getDaysDiff + " days.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDaysDiff;
    }

    public static List<Product> hsd() {
        List<Product> listsp = getProduct();

        List<Product> listExpiry_date = new ArrayList<>();
        for (Product sp : listsp) {
            System.out.println("hsd: " + sp.getExpiryDate());;
            if (checkHsd(sp.getExpiryDate()) > 0) {
                listExpiry_date.add(sp);
            }
        }
        return listExpiry_date;
    }

}
