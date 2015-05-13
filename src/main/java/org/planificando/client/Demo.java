package org.planificando.client;

import org.planificando.client.widgets.BarraHerramientas;
import org.planificando.client.widgets.UsuariosGrid;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.widgets.layout.HLayout;

public class Demo implements EntryPoint
{
	public void onModuleLoad()
	{
		HLayout hLayout = new HLayout();

		UsuariosGrid usuariosGrid = new UsuariosGrid();
		
		BarraHerramientas barraHerramientas = new BarraHerramientas(usuariosGrid);

		hLayout.addMember(barraHerramientas);
		hLayout.addMember(usuariosGrid);
		hLayout.setWidth100();
		hLayout.setHeight100();

		hLayout.draw();
	}
}
