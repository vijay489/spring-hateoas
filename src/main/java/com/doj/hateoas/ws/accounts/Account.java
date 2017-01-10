/**
 * 
 */
package com.doj.hateoas.ws.accounts;

import java.io.Serializable;

/**
 * @author Dinesh.Rajput
 *
 */
public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long accountId;
	private AccountHolder accountHolder;
	private Double amount;
	private String ifscCode;
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public Account(Long accountId, AccountHolder accountHolder, Double amount, String ifscCode) {
		super();
		this.accountId = accountId;
		this.accountHolder = accountHolder;
		this.amount = amount;
		this.ifscCode = ifscCode;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountHolder=" + accountHolder + ", amount=" + amount
				+ ", ifscCode=" + ifscCode + "]";
	}
	
}
