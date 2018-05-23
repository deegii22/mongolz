package com.mongolz.rest.service;

import com.mongolz.domain.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountRestService {

 	public List<Account> findAll();

	public List<Account> findByUser(Long userId);

}
