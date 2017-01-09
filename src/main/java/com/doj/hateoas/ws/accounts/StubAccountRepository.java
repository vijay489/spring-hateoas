package com.doj.hateoas.ws.accounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * @author Dinesh.Rajput
 *
 */
@Repository
public class StubAccountRepository implements AccountRepository {
	
	private Map<String, Account> accountsByNumber = new HashMap<String, Account>();
	
	public StubAccountRepository() {
		AccountHolder accountHolder = new AccountHolder(5115l, "Arnav", "Noida");
		Account account = new Account(1000l, accountHolder, 1039.13, "AA992QA");
		accountsByNumber.put("1000", account);
		accountHolder = new AccountHolder(2089l, "Anamika", "Noida");
		account = new Account(2000l, accountHolder, 1239.43, "AB966QJ");
		accountsByNumber.put("2000", account);
		accountHolder = new AccountHolder(1286l, "Dinesh", "Noida");
		account = new Account(3000l, accountHolder, 3339.61, "AD912SA");
		accountsByNumber.put("3000", account);
		Logger.getLogger(StubAccountRepository.class).info("Created StubAccountRepository");
	}
	
	@Override
	public List<Account> getAllAccounts() {
		return new ArrayList<Account>(accountsByNumber.values());
	}

	@Override
	public Account getAccount(String number) {
		return accountsByNumber.get(number);
	}
}
