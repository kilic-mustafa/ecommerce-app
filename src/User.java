
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mustafa Kılıç
 */
public class User {
    
    private String username;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String password;
    private String email;
    private String homeAddress;
    private String workAdress;
    private ArrayList<Product> productsOrdered;
    private ArrayList<Product> favoriteProducts;
    private CreditCard creditCard;

    public User(String username) {
        this(username, "name", "surname", "dateOfBirth", "password", "email", "homeAddress", "workAdress");
    }    
    public User(String username, String name, String surname, String dateOfBirth, String password, String email, String homeAddress, String workAdress) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.email = email;
        this.homeAddress = homeAddress;
        this.workAdress = workAdress;
        this.productsOrdered = new ArrayList<>();
        this.favoriteProducts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getWorkAdress() {
        return workAdress;
    }

    public void setWorkAdress(String workAdress) {
        this.workAdress = workAdress;
    }

    public ArrayList<Product> getProductsOrdered() {
        return productsOrdered;
    }

    public void setProductsOrdered(ArrayList<Product> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }

    public ArrayList<Product> getFavoriteProducts() {
        return favoriteProducts;
    }

    public void setFavoriteProducts(ArrayList<Product> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
    
    public void addOrdering(Product product, String username) {
        this.productsOrdered.add(product);
        this.username = username;
    }
    
    public void addFavorites(Product favoriteProduct, String username) {
        this.favoriteProducts.add(favoriteProduct);
        this.username = username;
    }
}
