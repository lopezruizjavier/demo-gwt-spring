package org.planificando.server.controller;

import org.planificando.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/UserController")
public class UserController
{
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/fetch", method = RequestMethod.POST)
	public @ResponseBody String fetchUserPost(@RequestBody String json)
	{
		return userService.fetchUsers(json);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody String saveUserPost(@RequestBody String json)
	{
		return userService.saveUsers(json);
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public @ResponseBody String removeUserPost(@RequestBody String json)
	{
		return userService.removeUsers(json);
	}
}
