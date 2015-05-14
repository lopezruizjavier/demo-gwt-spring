package org.planificando.server.dao;

import java.util.List;

import org.planificando.server.model.User;

public interface UserMapper
{
	public int deleteByPrimaryKey(Long codUser);

	public int insert(User user);

	public int update(User user);

	public List<User> selectAll();
}