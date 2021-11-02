package com.moglix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moglix.dto.Account;
import com.moglix.repository.AccountRepo;

@Service
public class AccountService {
	
	@Autowired
	AccountRepo dao;
	public void addAccount(Account account) {
		
		dao.save(account);
		
	}
	
	public List<Account> getAccount() {
		
		return dao.findAll();
		
	}

	public List<Account> getDatas() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public Account getData(int id) {
	
		return dao.findById(id).get();
	}

}
