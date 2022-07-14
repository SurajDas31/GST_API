package com.virus.gst_api.controller;

import com.virus.gst_api.service.GSTServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class _RestController {

    @Autowired
    private GSTServiceImpl gstService;

    @GetMapping("/get")
    public String getGSTIN(@RequestParam String gst) {
        String accessToken = gstService.accessToken();
        return gstService.getGSTInfo(accessToken, gst).toString();
    }
}
