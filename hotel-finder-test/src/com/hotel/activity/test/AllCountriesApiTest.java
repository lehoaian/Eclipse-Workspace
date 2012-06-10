package com.hotel.activity.test;

import java.net.URISyntaxException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.hotel.activity.HotelFinderActivity;
import com.hotel.api.AllCountriesApi;
import com.hotel.activity.R;
import com.hotel.model.Cities;

public class AllCountriesApiTest extends ActivityInstrumentationTestCase2<HotelFinderActivity> {

	AllCountriesApi mApi;
	HotelFinderActivity mActivity;
	JSONObject _obj;
	
	public AllCountriesApiTest() {
		super("com.hotel.activity", HotelFinderActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		mActivity = this.getActivity();
		mApi = new AllCountriesApi(mActivity);
	}

	public void testGetApi(){
		String api = mActivity.getString(R.string.api_json_all_cities);
		assertNotNull(api);
		
		URL url = mApi.getUrlApi(api);
		Log.i("API", url.toString());
		assertNotNull(url);
	}
	
	
	
	public void testAllCountriesApi() {
		// Add comment 
		fail("Not yet implemented");
	}

	public void testGetResponse() throws Exception {
		try {
			// mApi.getResponse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e("API",e.getMessage());
			//fail(e.getMessage());
		}
		
		Log.i("API", mApi.getResponse().toString());
		
		_obj = mApi.getResponse();
		assertNotNull(_obj);
	}
	
	public void testReturnStatus() throws JSONException, URISyntaxException{
		_obj = mApi.getResponse();
		assertEquals(_obj.get(Cities.STATUS_TAG), "success");
	}
	
	public void testCountriesSize() throws URISyntaxException, JSONException{
		_obj = mApi.getResponse();
		Cities allCities = new Cities(_obj);
		assertEquals(allCities.getAllCities().size(), 211);
	}
	
}
