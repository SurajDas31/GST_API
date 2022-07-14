package com.virus.gst_api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virus.gst_api.service.GSTServiceImpl;
import com.virus.gst_api.model.GST;
import com.virus.gst_api.model.Root;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class _Controller {

    @Autowired
    private GSTServiceImpl gstService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, GST gst) {
        model.addAttribute("gst", gst);
        return "index";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getGstInfo(@ModelAttribute("gst") GST gst, Model model) {
        String accessToken = gstService.accessToken();

        JSONObject gstInfo = gstService.getGSTInfo(accessToken, gst.getGstNo());
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Root root = objectMapper.readValue(gstInfo.toString(), Root.class);
            model.addAttribute("root", root);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "view";
    }
}
