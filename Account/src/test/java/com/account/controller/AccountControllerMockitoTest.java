package com.account.controller;

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
import com.account.service.AccountService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerMockitoTest {
 
	@InjectMocks
	AccountController controller;
	
	@Mock
	AccountService service;
	
	private static final Account MOCK_ACCOUNT_1 = new Account(1L, "a124676", "Gemma", "Fields", "Nothing");
	private static final Account MOCK_ACCOUNT_2 = new Account(2L, "b975335", "Harry", "Williams", "£50");
	private static final String MOCK_DELETE_SUCCESS_MESSAGE = "Account has been deleted!";
 	
	@Test
	public void getAccountsTest() {
		
		List<Account> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);
		
		Mockito.when(service.getAllAccounts()).thenReturn(MOCK_LIST);
		
		assertEquals(MOCK_LIST, controller.getAllAccounts());
		Mockito.verify(service).getAllAccounts();
	}
 	
	@Test
	public void getAccountTest() {
		
		List<Account> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(MOCK_ACCOUNT_1);
		
		Mockito.when(service.getAnAccount(Mockito.anyLong())).thenReturn(MOCK_ACCOUNT_1);
		
		assertEquals(MOCK_ACCOUNT_1, controller.getAnAccount(1L));
		Mockito.verify(service).getAnAccount(Mockito.anyLong());
	}
	
	//@Test
	//public void createAccountTest() {
	//	Mockito.when(service.createAccount(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1);
	//	
	//	assertEquals(MOCK_ACCOUNT_1, controller.createAccount(MOCK_ACCOUNT_1));
	//	Mockito.verify(service).createAccount(MOCK_ACCOUNT_1);
	//}
		
	@Test
	public void deleteAccountSuccessTest() {
		Mockito.when(service.deleteAccount(1L)).thenReturn(MOCK_DELETE_SUCCESS_MESSAGE);
		
		assertEquals(MOCK_DELETE_SUCCESS_MESSAGE, controller.deleteAnAccount(1L));
		Mockito.verify(service).deleteAccount(1L);
	}
	
	
}


