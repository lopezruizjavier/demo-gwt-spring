package org.planificando.client;

import org.planificando.client.widgets.CRUDToolStrip;
import org.planificando.client.widgets.UserGrid;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.widgets.layout.VLayout;

public class Demo implements EntryPoint
{
	public void onModuleLoad()
	{
		VLayout hLayout = new VLayout();

		UserGrid usuariosGrid = new UserGrid();
		
		CRUDToolStrip barraHerramientas = new CRUDToolStrip(usuariosGrid);

		hLayout.addMember(barraHerramientas);
		hLayout.addMember(usuariosGrid);
		hLayout.setWidth100();
		hLayout.setHeight100();
		hLayout.setPadding(50);
		hLayout.setMembersMargin(20);

		hLayout.draw();
	}
}
