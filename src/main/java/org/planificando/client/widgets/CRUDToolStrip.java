package org.planificando.client.widgets;

import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public class CRUDToolStrip extends ToolStrip
{
	public CRUDToolStrip(final ListGrid grid)
	{
		ToolStripButton buttonNew = new ToolStripButton("New");
		ToolStripButton buttonSave = new ToolStripButton("Save");
		ToolStripButton buttonRemove = new ToolStripButton("Remove");

		buttonNew.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				grid.startEditingNew();
			}
		});

		buttonSave.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				grid.saveAllEdits();
			}
		});

		buttonRemove.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				grid.removeSelectedData();
			}
		});

		addSpacer(10);
		addButton(buttonNew);
		addSpacer(10);
		addButton(buttonSave);
		addSpacer(10);
		addButton(buttonRemove);
	}
}
