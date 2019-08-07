package com.account.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.account.service.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
public class AccountControllerWebMockTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private AccountService service;
	
}
