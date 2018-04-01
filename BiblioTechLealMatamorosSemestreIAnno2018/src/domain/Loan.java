/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author maikel
 */
public class Loan implements Serializable{
    private String code;
    private String loanDate;
    private String returnDate;
    private String ID;

    public Loan(){
        this.code = "";
        this.loanDate = "";
        this.returnDate = "";
        this.ID ="";
    
    }
    
    public Loan(String code, String loanDate,String returnDate, String ID) {
        this.code = code;
        this.loanDate = loanDate;
        this.returnDate=returnDate;
        this.ID = ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    
}
