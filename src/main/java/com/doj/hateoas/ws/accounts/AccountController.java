/**
 * 
 */
package com.doj.hateoas.ws.accounts;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
public class AccountController {

	protected Logger logger = Logger
			.getLogger(AccountController.class.getName());

	@Autowired
	AccountRepository accountRepository;
	
	@RequestMapping("/accounts")
	public List<Resource<Account>> all() {
		logger.info("accounts all() invoked");
		List<Account> accounts = accountRepository.getAllAccounts();
		List<Resource<Account>> resources = new ArrayList<Resource<Account>>();
		for (Account account : accounts) {
	         resources.add(getAccountResource(account));
	      }
		logger.info("accounts all() found: " + accounts.size());
		return resources;
	}
	
	@RequestMapping(value= "/accounts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Account> byId(@PathVariable("id") Long id) {
		logger.info("accounts byId() invoked: " + id);
		Account account = accountRepository.getAccount(id.toString());
		Resource<Account> resource = new Resource<Account>(account);
		resource.add(linkTo(methodOn(AccountController.class).all()).withRel("accounts"));
		resource.add(linkTo(methodOn(AccountController.class).findAccountHolderById(account.getAccountId(), account.getAccountHolder().getUserId())).withRel("accountHolder"));
		logger.info("accounts byId() found: " + account);
		return resource;
	}
	
	@RequestMapping(value= "/accounts/{id}/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<AccountHolder> findAccountHolderById(@PathVariable("id") Long id, @PathVariable("userId") Long userId) {
		logger.info("accounts findAccountHolderById() invoked: " + id);
		Account account = accountRepository.getAccount(id.toString());
		AccountHolder accountHolder = account.getAccountHolder();
		Resource<AccountHolder> resource = new Resource<AccountHolder>(accountHolder);
		resource.add(linkTo(methodOn(AccountController.class).byId(account.getAccountId())).withRel("account"));
		logger.info("accounts findAccountHolderById() found: " + account);
		return resource;
	}
	
	private Resource<Account> getAccountResource(Account account) {
		Resource<Account> resource = new Resource<Account>(account);
		resource.add(linkTo(methodOn(AccountController.class).byId(account.getAccountId())).withSelfRel());
		resource.add(linkTo(methodOn(AccountController.class).findAccountHolderById(account.getAccountId(), account.getAccountHolder().getUserId())).withRel("accountHolder"));
		return resource;
	}
	
}
