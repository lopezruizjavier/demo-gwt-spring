package org.planificando.server.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONGenerator
{
	private JSONGenerator()
	{

	}

	@SuppressWarnings("unchecked")
	public static String getResponse(List<?> objects) throws IllegalArgumentException, IllegalAccessException
	{
		JSONObject respuesta = new JSONObject();

		JSONArray jsonArray = new JSONArray();

		for (Object object : objects)
			jsonArray.add(toJSONObject(object));

		JSONObject response = new JSONObject();

		response.put("totalRows", objects.size());
		response.put("endRow", objects.size());
		response.put("startRow", 0);
		response.put("status", 0);
		response.put("data", jsonArray);

		respuesta.put("response", response);

		return respuesta.toString();
	}

	public static String getSaveResponse(Object object) throws IllegalArgumentException, IllegalAccessException
	{
		List<Object> objects = new ArrayList<Object>();
		objects.add(object);

		return getResponse(objects);
	}

	@SuppressWarnings("unchecked")
	public static String getRemoveResponse()
	{
		JSONObject respuesta = new JSONObject();
		JSONObject response = new JSONObject();

		response.put("status", 0);
		respuesta.put("response", response);

		return respuesta.toString();
	}

	@SuppressWarnings("unchecked")
	public static String getValidationErrorResponse(String field, String error)
	{
		JSONObject respuesta = new JSONObject();
		JSONObject response = new JSONObject();
		JSONObject errors = new JSONObject();

		errors.put(field, error);

		response.put("errors", errors);
		response.put("status", -4);
		respuesta.put("response", response);

		return respuesta.toString();
	}

	@SuppressWarnings("unchecked")
	public static String getErrorResponse()
	{
		JSONObject respuesta = new JSONObject();
		JSONObject response = new JSONObject();

		response.put("status", -1);
		response.put("data", "There was an unexpected error.");
		respuesta.put("response", response);

		return respuesta.toString();
	}

	@SuppressWarnings("unchecked")
	private static JSONObject toJSONObject(Object object) throws IllegalArgumentException, IllegalAccessException
	{
		JSONObject jsonObject = new JSONObject();

		Field[] campos = object.getClass().getDeclaredFields();

		for (Field campo : campos)
		{
			campo.setAccessible(true);

			Object valor = campo.get(object);

			if (valor != null)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

				if (valor instanceof Date)
					jsonObject.put(campo.getName(), sdf.format((Date) valor));
				else
					jsonObject.put(campo.getName(), valor);
			}
		}

		return jsonObject;
	}
}
