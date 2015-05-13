package org.planificando.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.layout.VLayout;

public class Demo implements EntryPoint
{
	public void onModuleLoad()
	{
		final VLayout pagina = new VLayout();

		pagina.setWidth100();
		pagina.setHeight100();
		pagina.setMembers(new Button("Prueba"));

		pagina.draw();

		Window.enableScrolling(false);
	}
}
