package org.planificando.client.datasource;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.util.JSON;

public class JSONRestDataSource extends RestDataSource
{
	public JSONRestDataSource()
	{
		super();

		OperationBinding fetch = new OperationBinding();
		fetch.setOperationType(DSOperationType.FETCH);
		fetch.setDataProtocol(DSProtocol.POSTMESSAGE);

		OperationBinding add = new OperationBinding();
		add.setOperationType(DSOperationType.ADD);
		add.setDataProtocol(DSProtocol.POSTMESSAGE);

		OperationBinding update = new OperationBinding();
		update.setOperationType(DSOperationType.UPDATE);
		update.setDataProtocol(DSProtocol.POSTMESSAGE);

		OperationBinding remove = new OperationBinding();
		remove.setOperationType(DSOperationType.REMOVE);
		remove.setDataProtocol(DSProtocol.POSTMESSAGE);

		setOperationBindings(fetch, add, update, remove);
		setDataFormat(DSDataFormat.JSON);
	}

	@Override
	protected Object transformRequest(DSRequest dsRequest)
	{
		dsRequest.setContentType("application/json");
		dsRequest.setAttribute("dataFormat", "json");
		return JSON.encode(dsRequest.getData());
	}

	@Override
	protected void transformResponse(DSResponse response, DSRequest request, Object data)
	{
		super.transformResponse(response, request, data);
	}
}
