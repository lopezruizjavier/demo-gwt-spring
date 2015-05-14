package org.planificando.client.widgets;

import org.planificando.client.datasource.UserDS;

import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.grid.ListGrid;

public class UserGrid extends ListGrid
{
	public UserGrid()
	{
		setDataSource(new UserDS());
		setWidth100();
		setHeight100();
		setSaveLocally(false);
		setSelectionAppearance(SelectionAppearance.CHECKBOX);
		setSelectionType(SelectionStyle.SIMPLE);
		setAutoSaveEdits(false);
		setAutoFetchData(true);
	}
}
