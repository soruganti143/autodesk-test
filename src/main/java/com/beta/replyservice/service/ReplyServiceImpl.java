package com.beta.replyservice.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.springframework.stereotype.Service;

@Service("replyServiceImpl")
public class ReplyServiceImpl implements ReplyServive {

	@Override
	public String processMessage(String message) {
		// TODO Auto-generated method stub
		String replyMessge = "";
		String[] messageCommand = message.split("-");
		String firstPart = messageCommand[0];
		String secondPart = messageCommand[1];

		for (byte i : firstPart.getBytes()) {
			if (i == '1')
				secondPart = this.reverse(secondPart);
			else
				secondPart = md5(secondPart);

		}
		return secondPart;

	}

	public String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s).reverse();
		return sb.toString();
	}

	public String md5(String s) {
		MessageDigest mDigest = null;
		String md5ResMessgae = "";
		try {
			mDigest = MessageDigest.getInstance("MD5");

		} catch (Exception e) {
			System.out.print("Execption in ");
		}
		byte[] input = s.getBytes(StandardCharsets.UTF_8);
		byte[] output = mDigest.digest(input);
		BigInteger biInteger = new BigInteger(1, output);
		md5ResMessgae = String.format("%0" + (output.length << 1) + "x", biInteger);
		return md5ResMessgae;
	}
}
