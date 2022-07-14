package com.virus.gst_api.service;

import org.json.JSONObject;

public interface GSTService {

    public String accessToken();

    public JSONObject getGSTInfo(String accessToken, String gst);
}
