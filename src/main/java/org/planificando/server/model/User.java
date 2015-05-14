package org.planificando.server.model;

import java.util.Date;

public class User
{
	private Long codUser;

	private String nick;

	private String pass;

	private String email;

	private Boolean banned;

	private Date registered;

	private String username;

	private String surname;

	public Long getCodUser()
	{
		return codUser;
	}

	public void setCodUser(Long codUser)
	{
		this.codUser = codUser;
	}

	public String getNick()
	{
		return nick;
	}

	public void setNick(String nick)
	{
		this.nick = nick;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Boolean getBanned()
	{
		return banned;
	}

	public void setBanned(Boolean banned)
	{
		this.banned = banned;
	}

	public Date getRegistered()
	{
		return registered;
	}

	public void setRegistered(Date registered)
	{
		this.registered = registered;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}
}