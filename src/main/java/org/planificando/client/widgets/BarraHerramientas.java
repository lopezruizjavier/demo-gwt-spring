package org.planificando.client.widgets;

import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public class BarraHerramientas extends ToolStrip
{
	public BarraHerramientas(final ListGrid grid)
	{
		ToolStripButton botonNuevo = new ToolStripButton("Nuevo");
		ToolStripButton botonGuardar = new ToolStripButton("Guardar");
		ToolStripButton botonBorrar = new ToolStripButton("Borrar");

		botonNuevo.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				grid.startEditingNew();
			}
		});

		botonGuardar.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				grid.saveAllEdits();
			}
		});

		botonBorrar.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				grid.removeSelectedData();
			}
		});

		addButton(botonNuevo);
		addButton(botonGuardar);
		addButton(botonBorrar);
	}
}
