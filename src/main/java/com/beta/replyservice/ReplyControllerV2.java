package com.beta.replyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.beta.replyservice.service.ReplyServive;

@RestController
public class ReplyControllerV2 {
	String inputPattern = "^[12]*-[a-z0-9]*$";
	@Autowired
	private ReplyServive replyService;

	@GetMapping("/v2/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Messgae is empty value");
	}

	@GetMapping("/v2/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) throws Exception {
		String responseMessage = "";
		if (!message.matches(inputPattern))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Input");
		responseMessage = replyService.processMessage(message);
		return new ReplyMessage(responseMessage);
	}
}
