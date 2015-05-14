package org.planificando.server.service.impl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.planificando.server.dao.UserMapper;
import org.planificando.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserMapper clienteMapper;

	@Override
	@Transactional
	public String saveUsers(String json)
	{
		String respuesta = "";

		try
		{
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
		}
		catch (ParseException e)
		{

		}

		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public String fetchUsers(String json)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public String removeUsers(String json)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
