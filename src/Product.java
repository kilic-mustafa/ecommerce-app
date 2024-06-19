/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mustafa Kılıç
 */
public class Product {
    
    private String productName;
    private String productColor;
    private String productCategory;
    private int productStokInformation;
    private double productWeight;
    private String productDescriptionInformation;    

    public Product(String productName, String productCategory) {
        this(productName, "productColor", productCategory, 0, 0, "productDescriptionInformation");
    }
    public Product(String productName, String productColor, String productCategory, int productStokInformation, double productWeight, String productDescriptionInformation) {
        this.productName = productName;
        this.productColor = productColor;
        this.productCategory = productCategory;
        this.productStokInformation = productStokInformation;
        this.productWeight = productWeight;
        this.productDescriptionInformation = productDescriptionInformation;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductStokInformation() {
        return productStokInformation;
    }

    public void setProductStokInformation(int productStokInformation) {
        this.productStokInformation = productStokInformation;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
    }

    public String getProductDescriptionInformation() {
        return productDescriptionInformation;
    }

    public void setProductDescriptionInformation(String productDescriptionInformation) {
        this.productDescriptionInformation = productDescriptionInformation;
    }
    
    
    public boolean stockControl() {
        
        if(this.productStokInformation > 0) {
            productStokInformation--;
            return true;
        }
        else {
            return false;
        }
        
    }
}
