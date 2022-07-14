package com.virus.gst_api.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
@PropertySource("classpath:gst.properties")
public class GSTServiceImpl implements GSTService {

    @Autowired
    private Environment env;

    @Override
    public String accessToken() {
        String accessToken = "";
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", env.getProperty("USER_NAME"));
        requestBody.put("password", env.getProperty("PASSWORD"));
        requestBody.put("client_id", env.getProperty("CLIENT_ID"));
        requestBody.put("client_secret", env.getProperty("CLIENT_SECRET"));
        requestBody.put("grant_type", env.getProperty("GRANT_TYPE"));

        try {
            HttpURLConnection con = (HttpURLConnection) new URL(env.getProperty("GET_ACCESS_TOKEN")).openConnection();
            con.setRequestProperty("Content-type", "application/json");
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            OutputStream outputStream = con.getOutputStream();
            outputStream.write(requestBody.toString().getBytes(StandardCharsets.UTF_8), 0
                    , requestBody.toString().length());

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (con.getInputStream())));
            String output;
            StringBuilder res = new StringBuilder();
            while ((output = br.readLine()) != null) {
                res.append(output);
            }

            JSONObject jsonObject = new JSONObject(res.toString());
            accessToken = (String) jsonObject.get("access_token");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accessToken;
    }

    @Override
    public JSONObject getGSTInfo(String accessToken, String gst) {

        JSONObject jsonObject = null;
        String output;
        StringBuilder jsonStr = new StringBuilder();
        String url = "";

        try {
            url = env.getProperty("GET_GST_INFO") + gst;
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);
            conn.setRequestProperty("client_id", env.getProperty("CLIENT_ID"));
            conn.setDoOutput(true);


            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            while ((output = br.readLine()) != null) {
                jsonStr.append(output);
            }
            jsonObject = new JSONObject(jsonStr.toString());
            conn.disconnect();
        } catch (
                IOException e) {

            e.printStackTrace();

        }

        return jsonObject;
    }
}

