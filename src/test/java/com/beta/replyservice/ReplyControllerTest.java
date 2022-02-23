package com.beta.replyservice;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ReplyControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testReplySucess() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/reply/helloworld").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_ATOM_XML.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("helloworld")));
	}

	@Test
	public void testReplyV2Failuer() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/v2/reply/11kbzw9ru").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_ATOM_XML.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("Invalid Input")));
	}

	@Test
	public void testReplyV2Success() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/v2/reply/11-kbzw9ru").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_ATOM_XML.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("kbzw9ru")));
	}

}
