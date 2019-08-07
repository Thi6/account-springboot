package com.prizegen.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PrizeGenServiceTests {
    
    @InjectMocks
    private PrizeGenServiceImplementation service;
    
//    @Test
//    public void prizeGen6Test() {
//        assertEquals("Nothing", service.generatePrize("a123456"));
//        assertEquals("£50", service.generatePrize("b123456"));
//        assertEquals("£100", service.generatePrize("c123456"));
//    }
//    
//    @Test
//    public void prizeGen8Test() {
//        assertEquals("Nothing", service.generatePrize("a12345678"));
//        assertEquals("£500", service.generatePrize("b12345678"));
//        assertEquals("£750", service.generatePrize("c12345678"));
//    }
//    
//    @Test
//    public void prizeGen10Test() {
//        assertEquals("Nothing", service.generatePrize("a0123456789"));
//        assertEquals("£5,000", service.generatePrize("b0123456789"));
//        assertEquals("£10,000", service.generatePrize("c0123456789"));
//    }
}
