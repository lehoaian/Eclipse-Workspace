package com.hotel.api;

import java.net.URISyntaxException;
import java.net.URL;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.hotel.activity.R;

public class AllCountriesApi {
    Context _context;
    URL _api;
    
    final static String TAG = "API";

    public AllCountriesApi(Context context){
        this._context = context;
    }

    public JSONObject getResponse() throws URISyntaxException{
        _api = getUrlApi(_context.getString(R.string.api_json_all_cities));
		Log.i(TAG, _api.toString());
		
        try {
            ApiHelper.prepareUserAgent(_context);
            Log.i(TAG, _api.toString());
            String response = ApiHelper.getUrlContent(_api.toURI());
            Log.i(TAG, response);
        } catch (ApiHelper.ApiException e) {
            Log.e(TAG, e.getMessage());
        }

        return new JSONObject();
    }

    public String[][] getListOfCities(int refreshFlg){
        return new String[][]{};
    }
    
    public URL getUrlApi(String param){
    	try {
        	URL mRoot = new URL(_context.getString(R.string.api_root));
        	//return new URL(mRoot, URLEncoder.encode(param));
        	return new URL(mRoot, param);
		} catch (Exception e) {
			return null;
		}
    }
}
