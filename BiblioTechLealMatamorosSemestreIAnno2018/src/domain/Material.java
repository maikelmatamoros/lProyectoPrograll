package domain;

import java.io.Serializable;

public class Material implements Serializable{
    
    private int code;
    private String type;
    private int amount;
    private int amountAvaiable;
    private int loanCode;

    public Material() {
        this.code = -1;
        this.type = "";
        this.amount = 0;
        this.amountAvaiable = 0;
        this.loanCode = -1;
    } // constructor

    public Material(int code, String type) {
        this.code = code;
        this.type = type;
        this.amount = 1;
        this.amountAvaiable = -1;
        this.loanCode = -1;
    }

    public Material(int code, String type, int amount, int amountAvaiable) {
        this.code = code;
        this.type = type;
        this.amount = amount;
        this.amountAvaiable = amountAvaiable;
        this.loanCode = -1;
    } // constructor sobrecargado

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmountAvaiable() {
        return amountAvaiable;
    }

    public void setAmountAvaiable(int amountAvaiable) {
        this.amountAvaiable = amountAvaiable;
    }

    public int getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(int loanCode) {
        this.loanCode = loanCode;
    }

    @Override
    public String toString() {
        return "Material{" + "code=" + code + ", type=" + type + ", amount=" + amount + ", amountAvaiable=" + amountAvaiable + ", loanCode=" + loanCode + "} ";
    }

    public void addUnit(int quantity){
        setAmount(getAmount()+quantity);
        setAmountAvaiable(getAmountAvaiable()+quantity);
    } // addUnit
    
} //fin de la clase
