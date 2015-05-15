package org.planificando.server.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;

public class JsonBuilder
{
	private JSONObject respuesta;

	public JsonBuilder()
	{
		respuesta = new JSONObject();
	}

	@SuppressWarnings("unchecked")
	public void generateResponse(JSONObject response)
	{
		respuesta.put("response", response);
	}

	@SuppressWarnings("unchecked")
	public JSONObject generateJson(Object object) throws IllegalArgumentException, IllegalAccessException
	{
		JSONObject jsonObject = new JSONObject();

		Field[] campos = object.getClass().getDeclaredFields();

		for (Field campo : campos)
		{
			campo.setAccessible(true);

			Object valor = campo.get(object);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

			if (valor instanceof Date)
				jsonObject.put(campo.getName(), sdf.format((Date) valor));
			else
				jsonObject.put(campo.getName(), valor);
		}

		return jsonObject;
	}

	public String getRespuesta()
	{
		return respuesta.toString();
	}
}
