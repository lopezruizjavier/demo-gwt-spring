package org.planificando.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.planificando.server.dao.UserMapper;
import org.planificando.server.model.User;
import org.planificando.server.service.UserService;
import org.planificando.server.utils.JSONGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional
	public String saveUsers(String json)
	{
		String response;

		try
		{
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);

			User user = new User();

			if (jsonObject.get("codUser") != null)
				user.setCodUser(Long.parseLong(jsonObject.get("codUser").toString()));

			if (jsonObject.get("nick") != null)
				user.setNick(jsonObject.get("nick").toString());

			if (jsonObject.get("pass") != null)
				user.setPass(jsonObject.get("pass").toString());

			if (jsonObject.get("email") != null)
				user.setEmail(jsonObject.get("email").toString());

			if (jsonObject.get("username") != null)
				user.setUsername(jsonObject.get("username").toString());

			if (jsonObject.get("surname") != null)
				user.setSurname(jsonObject.get("surname").toString());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

			if (jsonObject.get("registered") != null)
				user.setRegistered(sdf.parse(jsonObject.get("registered").toString()));

			if (jsonObject.get("banned") != null)
				user.setBanned(Boolean.parseBoolean(jsonObject.get("banned").toString()));

			User duplicate = userMapper.selectByNick(user.getNick());

			if (duplicate == null || duplicate.getCodUser().equals(user.getCodUser()))
			{
				if (user.getCodUser() == null)
				{
					user.setRegistered(new Date());
					
					userMapper.insert(user);
				}
				else
					userMapper.update(user);

				response = JSONGenerator.getSaveResponse(userMapper.selectByCodUser(user.getCodUser()));
			}
			else
				response = JSONGenerator.getValidationErrorResponse("nick", "Nick is already taken.");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();

			response = JSONGenerator.getErrorResponse();
		}

		return response;
	}

	@Override
	@Transactional(readOnly = true)
	public String fetchUsers(String json)
	{
		String response;

		try
		{
			List<User> users = new ArrayList<User>();
			users = userMapper.selectAll();
			response = JSONGenerator.getResponse(users);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			response = JSONGenerator.getErrorResponse();
		}

		return response;
	}

	@Override
	@Transactional
	public String removeUsers(String json)
	{
		String response;

		try
		{
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);

			Long codUser = Long.parseLong(jsonObject.get("codUser").toString());

			userMapper.deleteByPrimaryKey(codUser);

			response = JSONGenerator.getRemoveResponse();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			response = JSONGenerator.getErrorResponse();
		}

		return response;
	}
}
