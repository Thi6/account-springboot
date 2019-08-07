package com.numgen.service;

import static org.junit.Assert.assertEquals;

import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
public class NumGenServiceTest {
    @InjectMocks
    private NumGenServiceImplementation service;
    
    @Test
    public void generate6DigitAccountNumTest() {
        Boolean matches = Pattern.matches("[abc]{1}\\d{6}", service.generateAccountNum());
        assertEquals(true, matches);
    }
}
	

