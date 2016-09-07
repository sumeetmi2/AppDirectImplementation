/*
 *  
 * Created on Sep 7, 2016
 *
 */
package com.appdirect.dto;

import java.io.Serializable;

/**
 * @author SumeetS
 *
 */
public class ResponseWrapperObject implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String success;
    private String errorCode;
    private String message;
    private String accountIdentifier;
    /**
     * @return the success
     */
    public String getSuccess() {
        return success;
    }
    /**
     * @param success the success to set
     */
    public void setSuccess(String success) {
        this.success = success;
    }
    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }
    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * @return the accountIdentifier
     */
    public String getAccountIdentifier() {
        return accountIdentifier;
    }
    /**
     * @param accountIdentifier the accountIdentifier to set
     */
    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }
    
    
}
