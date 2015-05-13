package org.planificando.client;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.layout.HLayout;

public class Demo implements EntryPoint
{
	public void onModuleLoad()
	{
		HLayout hLayout = new HLayout();
		
		Button boton = new Button("Probando");

		hLayout.addMember(boton);

		hLayout.draw();
	}
}
