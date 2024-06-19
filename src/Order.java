/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mustafa Kılıç
 */
public class Order {
    private User user;
    private Product product;
    private CreditCard creditCard;

    public Order(User user, Product product, CreditCard creditCard) {
        this.user = user;
        this.product = product;
        this.creditCard = creditCard;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
    
    public void accessControl() {
        
        boolean isAvailable = product.stockControl();
    
        if (isAvailable) {
            user.addOrdering(product, user.getUsername());
            System.out.println("The product order has been successfully completed.");
        } 
        else {
            System.out.println("The product doesn't exist in stock!");
        }
    }
}
