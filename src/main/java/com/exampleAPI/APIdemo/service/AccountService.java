package com.exampleAPI.APIdemo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleAPI.APIdemo.model.Account;
import com.exampleAPI.APIdemo.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
    AccountRepository AccountRepository;
	
	
	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	public List<Account> List_Account()
	{
		return em.createNamedStoredProcedureQuery("List_Account").getResultList();
	}
	
	// CREATE 
	public Account createAccount(Account emp) {
	    return AccountRepository.save(emp);
	}

	// READ
	public List<Account> getAccount() {
	    return AccountRepository.findAll();
	}

	// DELETE
	public void deleteAccount(Long AccountId) {
		AccountRepository.deleteById(AccountId);
	}
	
	// UPDATE
	public Account updateEmployee(Long AccountId, Account accountDetails) {
		Account account = AccountRepository.findById(AccountId).get();
		account.setUserName(accountDetails.getUserName());
		account.setPassword(accountDetails.getPassword());
		
	    return AccountRepository.save(account);                                
	}
}
