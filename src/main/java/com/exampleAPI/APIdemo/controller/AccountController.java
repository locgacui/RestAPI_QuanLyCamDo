package com.exampleAPI.APIdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exampleAPI.APIdemo.exception.ResourceNotFoundException;
import com.exampleAPI.APIdemo.model.Account;
import com.exampleAPI.APIdemo.repository.AccountRepository;
import com.exampleAPI.APIdemo.service.AccountService;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

	@Autowired
	AccountService AccountService;

	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@GetMapping("/accountById")
	public ResponseEntity<Account> getAccountById(@RequestParam(value = "id") Long accountId)
			throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("account not found for this id :: " + accountId));
		return ResponseEntity.ok().body(account);
	}

	@PostMapping("/accounts")
	public Account createAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}

	@PutMapping("/accounts/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value = "id") Long accountId,
			@RequestBody Account accountDetails) throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("account not found for this id :: " + accountId));

		account.setUserName(accountDetails.getUserName());
		account.setPassword(accountDetails.getPassword());

		final Account updatedaccount = accountRepository.save(account);
		return ResponseEntity.ok(updatedaccount);
	}

	@DeleteMapping("/accounts/{id}")
	public Map<String, Boolean> deleteAccount(@PathVariable(value = "id") Long accountId)
			throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("account not found for this id :: " + accountId));

		accountRepository.delete(account);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/sp_List_Account")
	public List<Account> List_Account()
	{
		return accountRepository.List_Account();
	}

//	 @RequestMapping(value="/accounts", method=RequestMethod.POST)
//	 public Account createaccount(@RequestBody Account emp) {
//	     return AccountService.createAccount(emp);
//	 }
//	 
//	 @RequestMapping(value="/accounts", method=RequestMethod.GET)
//	 public List<Account> getAllaccounts() {
//	     return AccountService.getAccount();
//	 }
//
//	 @RequestMapping(value="/accounts/{AccountId}", method=RequestMethod.PUT)
//	 public Account readaccounts(@PathVariable(value = "AccountId") Long id, @RequestBody Account AccountDetails) {
//	     return AccountService.updateaccount(id, AccountDetails);
//	 }
//
//	 @RequestMapping(value="/accounts/{AccountId}", method=RequestMethod.DELETE)
//	 public void deleteaccounts(@PathVariable(value = "AccountId") Long id) {
//		 AccountService.deleteAccount(id);
//	 }
}
