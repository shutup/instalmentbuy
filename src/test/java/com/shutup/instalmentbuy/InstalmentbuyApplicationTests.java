package com.shutup.instalmentbuy;

import com.shutup.instalmentbuy.service.Web3jService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstalmentbuyApplicationTests {
	@Autowired
	Web3jService web3jService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateContract() {
		web3jService.createInstalmentBuyContract();
	}
}
