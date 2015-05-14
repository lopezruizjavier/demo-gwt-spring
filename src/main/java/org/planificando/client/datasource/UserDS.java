package org.planificando.client.datasource;

import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourcePasswordField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class UserDS extends JSONRestDataSource
{
	private static final String FETCH_URL = "UserController/fetch";

	private static final String SAVE_URL = "UserController/save";

	private static final String REMOVE_URL = "UserController/remove";

	public UserDS()
	{
		DataSourceIntegerField codUser = new DataSourceIntegerField("codUser");

		DataSourceTextField nick = new DataSourceTextField("nick", "Nick");
		DataSourcePasswordField pass = new DataSourcePasswordField("pass", "Password");
		DataSourceTextField email = new DataSourceTextField("email", "E-mail");
		DataSourceBooleanField banned = new DataSourceBooleanField("banned", "Banned");

		DataSourceDateTimeField registered = new DataSourceDateTimeField("registered", "Registered");

		DataSourceTextField username = new DataSourceTextField("username", "Name");
		DataSourceTextField surname = new DataSourceTextField("surname", "Surname");

		codUser.setHidden(true);
		codUser.setPrimaryKey(true);

		nick.setRequired(true);
		pass.setRequired(true);
		email.setRequired(true);

		registered.setCanEdit(false);

		setFetchDataURL(FETCH_URL);
		setAddDataURL(SAVE_URL);
		setRemoveDataURL(REMOVE_URL);
		setUpdateDataURL(SAVE_URL);
		setFields(nick, pass, email, banned, registered, username, surname);
	}
}
