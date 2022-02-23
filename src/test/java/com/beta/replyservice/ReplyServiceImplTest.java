package com.beta.replyservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.beta.replyservice.service.ReplyServiceImpl;

@SpringBootTest
public class ReplyServiceImplTest {

	@Autowired
	private ReplyServiceImpl serviceImpl;

	@Test
	public void testRevese() {
		// given
		String input = "kbzw9ru";
		String exepectedResult = "ur9wzbk";
		// when
		String result = serviceImpl.reverse(input);
		// then
		Assert.isTrue(result.equals(exepectedResult));

	}

	public void testMD5() {
		// given
		String input = "kbzw9ru";
		String exepectedResult = "0fafeaae780954464c1b29f765861fad";
		// when
		String result = serviceImpl.md5(input);
		// then
		Assert.isTrue(result.equals(exepectedResult));
	}

	@Test
	public void testProcessMessage1() {
		// given
		String input = "11-kbzw9ru";
		String exepectedResult = "kbzw9ru";
		// when
		String result = serviceImpl.processMessage(input);
		// then
		Assert.isTrue(result.equals(exepectedResult));
	}

	@Test
	public void testProcessMessage2() {
		// given
		String input = "12-kbzw9ru";
		String exepectedResult = "5a8973b3b1fafaeaadf10e195c6e1dd4";
		// when
		String result = serviceImpl.processMessage(input);
		// then
		Assert.isTrue(result.equals(exepectedResult));
	}

}
