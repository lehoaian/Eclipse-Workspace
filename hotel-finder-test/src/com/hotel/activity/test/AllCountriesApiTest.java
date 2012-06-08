package com.hotel.activity.test;

import java.net.URISyntaxException;
import java.net.URL;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.hotel.activity.HotelFinderActivity;
import com.hotel.api.AllCountriesApi;
import com.hotel.activity.R;

public class AllCountriesApiTest extends ActivityInstrumentationTestCase2<HotelFinderActivity> {

	AllCountriesApi mApi;
	HotelFinderActivity mActivity;
	
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

	public void testGetResponse() {
		try {
			mApi.getResponse();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			Log.e("API",e.getMessage());
		}
	}

}
