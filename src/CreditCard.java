/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mustafa Kılıç
 */
public class CreditCard {
    
    private String creditCardNumber;
    private String creditCardUser;
    private String securityCode;
    private String exprationDate;

    public CreditCard(String creditCardNumber, String creditCardUser, String securityCode, String exprationDate) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardUser = creditCardUser;
        this.securityCode = securityCode;
        this.exprationDate = exprationDate;
    }
    public CreditCard(String username) {
        this("creditCardNumber", "creditCardUser", "securityCode", "exprationDate");
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardUser() {
        return creditCardUser;
    }

    public void setCreditCardUser(String creditCardUser) {
        this.creditCardUser = creditCardUser;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getExprationDate() {
        return exprationDate;
    }

    public void setExprationDate(String exprationDate) {
        this.exprationDate = exprationDate;
    }
    
    
}
