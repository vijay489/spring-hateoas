/**
 * 
 */
package com.doj.hateoas.ws.accounts;

import java.io.Serializable;

/**
 * @author Dinesh.Rajput
 *
 */
public class AccountHolder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String name;
	private String address;
	public AccountHolder(Long userId, String name, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "AccountHolder [userId=" + userId + ", name=" + name + ", address=" + address + "]";
	}
	
}
