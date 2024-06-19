/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mustafa Kılıç
 */
public class Processes {
        
    private Connection con = null;
    
    private Statement statement = null;
    
    private PreparedStatement preparedStatement = null;
            
    public ArrayList<Product> showOrdersInfo(String username) {
        
        ArrayList<Product> output = new ArrayList<>();
        
        try {
            String query = "Select * FROM orders WHERE username = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                String name = rs.getString("product_name");
                String category = rs.getString("product_category");
                
                output.add(new Product(name, category));
                               
            }
            
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }       
    public ArrayList<Product> showFavorites(String username) {
        
        ArrayList<Product> output = new ArrayList<>();
        
        try {            
            String query = "Select * FROM favorites WHERE username = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                String name = rs.getString("product_name");
                String category = rs.getString("product_category");
                
                output.add(new Product(name, category));
                               
            }
            
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }    
    public ArrayList<Product> showProductsInfo() {
        
        ArrayList<Product> output = new ArrayList<>();
        
        try {
            statement = con.createStatement();
            
            String query = "Select * From products";
            
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()) {
                String product_name = rs.getString("product_name");
                String product_color = rs.getString("product_color");
                String product_category = rs.getString("product_category");
                int product_stock_info = rs.getInt("product_stock_info");
                double product_weight = rs.getDouble("product_weight");
                String product_description = rs.getString("product_description");
                
                output.add(new Product(product_name, product_color, product_category, product_stock_info, product_weight, product_description));
            }
            
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
    }
    
    
    public ArrayList<User> showUsersInfo() {
        
        ArrayList<User> output = new ArrayList<>();
        
        try {
            statement = con.createStatement();
            
            String query = "Select * From users";
            
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()) {
                String username = rs.getString("username");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String birthofday = rs.getString("birthofday");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String home_adress = rs.getString("home_adress");
                String work_adress = rs.getString("work_adress");
                
                output.add(new User(username, name, surname, birthofday, password, email, home_adress, work_adress));
                               
            }
            
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    
    
    public ArrayList<User> showThisUserInfo(String username) {
        
        ArrayList<User> output = new ArrayList<>();
        
        try {
            String query = "Select * From users Where username = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                String username2 = rs.getString("username");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String birthofday = rs.getString("birthofday");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String home_adress = rs.getString("home_adress");
                String work_adress = rs.getString("work_adress");
                
                output.add(new User(username2, name, surname, birthofday, password,email, home_adress, work_adress));
                               
            }
            
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }      
    
    public ArrayList<CreditCard> showThisCreditCard(String username) {
        
        ArrayList<CreditCard> output = new ArrayList<>();
        
        try {
            String query = "Select * FROM credit_cards WHERE card_user = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                String card_number = rs.getString("card_number");
                String card_user = rs.getString("card_user");
                String security_code = rs.getString("security_code");
                String expration_date = rs.getString("expration_date");

                output.add(new CreditCard(card_number, card_user, security_code, expration_date));
            }
            
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }      
    public boolean logIn(String username, String password) {
        
        String query = "Select * From users where username = ? and password = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next(); 
            
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void updatedUser(String username,String name, String surname,String birthofday,String password,String email,String homeAdress,String workAdress) {
        
            try{
                String query = "UPDATE users SET username = ?, name = ?, surname = ?, birthofday = ?,password = ?, email = ?, home_adress = ?,work_adress = ? WHERE username = ? ";
              
                preparedStatement = con.prepareStatement(query);

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, surname);
                preparedStatement.setString(4, birthofday);
                preparedStatement.setString(5, password);
                preparedStatement.setString(6, email);
                preparedStatement.setString(7, homeAdress);
                preparedStatement.setString(8, workAdress);
                preparedStatement.setString(9, username);
                
                preparedStatement.executeUpdate();  


            } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void addCreditCard(String card_number, String card_user, String security_code, String expration_date) {
       
        try {
            String query = "INSERT INTO credit_cards (card_number, card_user, security_code, expration_date) VALUES (?, ?, ?, ?)";
            
            
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, card_number);
            preparedStatement.setString(2, card_user);
            preparedStatement.setString(3, security_code);
            preparedStatement.setString(4, expration_date);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            
    }
    
    
    public void updatedCreditCard(String card_number, String card_user, String security_code, String expration_date) {
            
            try{
                String query = "UPDATE credit_cards SET card_number = ?, card_user = ?, security_code = ?, expration_date = ? WHERE card_user = ? ";
              
                preparedStatement = con.prepareStatement(query);

                preparedStatement.setString(1, card_number);
                preparedStatement.setString(2, card_user);
                preparedStatement.setString(3, security_code);
                preparedStatement.setString(4, expration_date);
                preparedStatement.setString(5, card_user);
                
                preparedStatement.executeUpdate();  


            } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }    
    public boolean hasSignUp(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next(); // If it returns true, it means the user is registered in the system.
            
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public boolean hasCreditCard(CreditCard creditcard, String username) {
        String query = "SELECT * FROM credit_cards WHERE card_user = ?";

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next(); // If rs.next() returns true, it means the user has previously added credit card information.
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean addUser(String username,String name, String surname,String birthofday,String password,String email,String homeAdress,String workAdress) {
                
        String checkQuery = "SELECT * FROM users WHERE username = ?";
        
        try{
            preparedStatement = con.prepareStatement(checkQuery);
            preparedStatement.setString(1, username);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(!resultSet.next()) {                
                String query = "Insert Into users (username,name,surname,birthofday,password,email,home_adress,work_adress) VALUES(?,?,?,?,?,?,?,?)";
        
                preparedStatement = con.prepareStatement(query);
        
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, surname);
                preparedStatement.setString(4, birthofday);
                preparedStatement.setString(5, password);
                preparedStatement.setString(6, email);
                preparedStatement.setString(7, homeAdress);
                preparedStatement.setString(8, workAdress);
            
                preparedStatement.executeUpdate();  
                
                return true;
                
              }
              else {
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean isFavorite(Product product, String username) {
        String query = "SELECT * FROM favorites WHERE product_name = ? AND username";
        String name = product.getProductName();

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next(); // If rs.next() returns true, it means the product has been marked as a favorite previously.
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }       
   
    public boolean addToOrders(Product product, String username) {
                
        String query = "INSERT INTO orders (product_name, product_color, product_category, product_weight, product_description, username) VALUES (?, ?, ?, ?, ?, ?)";
        
        String name = product.getProductName();
        String color = product.getProductColor();
        String category = product.getProductCategory();
        int stock = product.getProductStokInformation();
        double weight = product.getProductWeight();
        String description = product.getProductDescriptionInformation();
                
        try {
            if(product.stockControl()) {
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, color);
                preparedStatement.setString(3, category);
                preparedStatement.setDouble(4, weight);
                preparedStatement.setString(5, description);        
                preparedStatement.setString(6, username);        

            
                int addedRow = preparedStatement.executeUpdate();

                while(true) {
                    String query2 = "UPDATE products SET product_stock_info = ? where product_name = ?";
                    preparedStatement = con.prepareStatement(query2);

                    preparedStatement.setInt(1, stock - 1);
                    preparedStatement.setString(2, name);

                    int updadedRow = preparedStatement.executeUpdate();
                    break;
                }

                return true;
            }
            else{
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
    public void deleteFav(String name, String username) {
        
        String query = "DELETE FROM favorites where product_name = ? AND username = ? ";
        
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);

            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    public boolean addToFavorite(Product product,String username) {
        
        String query = "INSERT INTO favorites (product_name, product_color, product_category, product_stock_info, product_weight, product_description, username) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        String name = product.getProductName();
        String color = product.getProductColor();
        String category = product.getProductCategory();
        int stock = product.getProductStokInformation();
        double weight = product.getProductWeight();
        String description = product.getProductDescriptionInformation();
                
        try {
            if(!isFavorite(product,username)) {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, color);
            preparedStatement.setString(3, category);
            preparedStatement.setInt(4, stock);
            preparedStatement.setDouble(5, weight);
            preparedStatement.setString(6, description);    
            preparedStatement.setString(7, username);
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            return rowsAffected == 1;                   
            }
            else{
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
        
    
    
    public Processes() {
        //           "jdbc:mysql://localhost:3306/ecommercial
        String url = "jdbc:mysql://" + Database.HOST + ":" + Database.PORT + "/" + Database.DB_NAME + "?useUnicode=true&characterEncoding=utf8";
       
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Driver can not found!");
        }
        
        try {
            con = DriverManager.getConnection(url,Database.USERNAME,Database.PASSWORD);
       
            System.out.println("Connection successful.");
            
        } catch (SQLException ex) {
            System.out.println("Connection failed!!");
        }        
        
        
    }        
        
        
}