package org.planificando.client.widgets;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.grid.ListGrid;

public class UsuariosGrid extends ListGrid
{
	public UsuariosGrid()
	{
		DataSource dataSource = new DataSource();

		DataSourceTextField nombre = new DataSourceTextField("nombre", "Nombre");
		DataSourceTextField apellidos = new DataSourceTextField("apellidos", "Apellidos");
		DataSourceTextField password = new DataSourceTextField("password", "Password");

		DataSourceDateField fechaNacimiento = new DataSourceDateField("fechaNacimiento", "Fecha de nacimiento");

		DataSourceTextField email = new DataSourceTextField("email", "E-mail");

		email.setRequired(true);
		
		dataSource.setFields(nombre, apellidos, password, fechaNacimiento, email);

		setDataSource(dataSource);
		setWidth100();
		setHeight100();
		setSaveLocally(true);
		setSelectionAppearance(SelectionAppearance.CHECKBOX);
		setSelectionType(SelectionStyle.SIMPLE);
		setAutoSaveEdits(false);
	}
}
