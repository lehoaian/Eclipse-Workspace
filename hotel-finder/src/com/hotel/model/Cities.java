package com.hotel.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Cities extends JSONObject {
	
	public final static String STATUS_TAG = "status";
	public final static String COUNT_TAG = "countries_count";
	public final static String COUNTRIES_TAG = "countries";
	public final static String COUNTRY_CODE_TAG = "CountryCode";
	public final static String COUNTRY_NAME_TAG = "CountryName";
	
	
	
	public class City {
		String _country_code;
		String _country_name;
		
		public City(String _country_code, String _country_name) {
			super();
			this._country_code = _country_code;
			this._country_name = _country_name;
		}
		public String get_country_code() {
			return _country_code;
		}
		public void set_country_code(String _country_code) {
			this._country_code = _country_code;
		}
		public String get_country_name() {
			return _country_name;
		}
		public void set_country_name(String _country_name) {
			this._country_name = _country_name;
		}
		
	}
	
	public Cities(String json) throws JSONException{
		super(json);
	}
	
	public Cities(JSONObject _obj) throws JSONException {
		// TODO Auto-generated constructor stub
		super(_obj.toString());
	}

	public String getStatus(){
		try {
			return (String) super.get(COUNTRY_CODE_TAG);
		} catch (JSONException e) {
			Log.e("API", e.getMessage());
			return "fail";
		}
	}
	
	public List<City> getAllCities() throws JSONException{
		JSONArray lst = super.getJSONArray(COUNTRIES_TAG);
		List<City> retLst = new ArrayList<Cities.City>();
		String tmpCode, tmpName;
		
		for(int i = 0; i < lst.length(); i++){
			tmpCode = lst.getJSONObject(i).getString(COUNTRY_CODE_TAG);
			tmpName = lst.getJSONObject(i).getString(COUNTRY_NAME_TAG);		
			retLst.add(new City(tmpCode, tmpName));
		}
		return retLst;
	}
}

