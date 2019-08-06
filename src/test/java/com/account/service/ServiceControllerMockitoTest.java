package com.account.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.account.entity.Account;
import com.account.repository.AccountRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceControllerMockitoTest {
 
	@InjectMocks
	AccountServiceImplementation service;
 	
	@Mock
	AccountRepository repo;
	
	private static final Account MOCK_ACCOUNT_1 = new Account(1L, "a124676", "Gemma", "Fields", "Nothing");
	private static final Account MOCK_ACCOUNT_2 = new Account(2L, "b975335", "Harry", "Williams", "£50");
	private static final String MOCK_DELETE_SUCCESS_MESSAGE = "Account has been deleted!";
	
	@Test
	public void getAccountsTest() {
		List<Account> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);
		
		Mockito.when(repo.findAll()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.getAllAccounts());
		
		Mockito.verify(repo).findAll();
		
	}
	
	@Test
	public void createAccountTest() {
		Mockito.when(repo.save(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1);
		
		assertEquals(MOCK_ACCOUNT_1, service.createAccount(MOCK_ACCOUNT_1));
		Mockito.verify(repo).save(MOCK_ACCOUNT_1);
		
	}
	

	
}
