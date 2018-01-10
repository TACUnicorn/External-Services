package com.external.components.controller;

import com.external.components.mapper.ComponentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Action;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/components")
public class ComponentsController {

    @Autowired
    public ComponentsMapper componentsMapper;

    @PostMapping("/order")
    public Object addOrder(@RequestBody Map<Object, Object> requestBody) {

        HashMap<String, String> response = new HashMap<>();
        try {
            componentsMapper.addOrder(new Integer(requestBody.get("componentsId").toString()),
                    new Integer(requestBody.get("componentsNo").toString()));
            response.put("code", "0");
            response.put("msg", "success");
            return response;
        } catch (Exception e) {
            response.put("code", "1");
            response.put("msg", "Error request parameter");
            return response;
        }
    }
}
