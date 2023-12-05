/**
* @Title: StepDefinitions.java
* @Package com.osxm.je.topic.bdd
* @Description: TODO
* @author XM
* @date 2023年10月9日 下午10:03:34
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.topic.bdd;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import com.osxm.je.basic.entity.User;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	private Map<Integer, User> userRepo = new HashMap<Integer, User>();
	private User user;

	@Given("User {int} not exist")
	public void user_not_exist(Integer userId) {
		assertFalse(userRepo.containsKey(userId));
	}

	@When("create User {int}")
	public void create_user(Integer userId) {
		user = new User(userId);
		userRepo.put(userId, user);
	}

	@Then("can query User {int}")
	public void query_user(Integer userId) {
		user = userRepo.get(userId);
		assertNotNull(user);
	}
}
