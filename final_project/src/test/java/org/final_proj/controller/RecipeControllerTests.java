package org.final_proj.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class RecipeControllerTests {
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext wctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wctx).build();
	}
	
	@Test
	public void testAllRecipes() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/recipe/all"))
				.andReturn().
				getModelAndView().
				getModelMap());
	}
	
	@Test
	public void testDetail() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/recipe/detail").param("id", "201"))
				.andReturn()
				.getModelAndView().getModelMap());
	}
}
