package com.virus.gst_api.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@RestController
public class _RestController {
    @GetMapping("/get/gstin={gst}")
    public String getGSTIN(@PathVariable String gst) {
        StringBuilder jsonStr = new StringBuilder();
        try {
            String url = "https://commonapi.mastersindia.co/commonapis/searchgstin?gstin=" + gst;
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + getAccessToken());
            conn.setRequestProperty("client_id", "MKzllgFwuvSqmJlQEU");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;

            while ((output = br.readLine()) != null) {
                jsonStr.append(output);

            }
            JSONObject jsonObject = new JSONObject(jsonStr.toString());
            conn.disconnect();
        } catch (
                IOException e) {

            e.printStackTrace();

        }
        return jsonStr.toString();
    }

    private static String getAccessToken() {
        String accessToken = "";
        String requestbody = "{\n" +
                "    \"username\":\"sanjeev_rathi@usha.com\",\n" +
                "    \"password\": \"Usha@123\",\n" +
                "    \"client_id\":\"MKzllgFwuvSqmJlQEU\",\n" +
                "    \"client_secret\":\"2qv1EMW0XvpdVt0sLFPIZEKX\",\n" +
                "    \"grant_type\":\"password\"\n" +
                "}";
        String url = "https://commonapi.mastersindia.co/oauth/access_token";
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestProperty("Content-type", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = requestbody.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            } catch (Exception e) {
                e.printStackTrace();
            }

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
}
