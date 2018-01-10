package com.external.components.controller;

import com.external.components.mapper.ComponentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/xml/components")
public class XMLComponentsController {

    @Autowired
    public ComponentsMapper componentsMapper;

    @PostMapping("/order")
    public Object addOrder(@RequestBody Map<Object,Object> requestBody){

        HashMap<String, String> response = new HashMap<>();
        try {
            componentsMapper.addOrder(new Integer(requestBody.get("componentsId").toString()),
                    new Integer(requestBody.get("componentsNo").toString()));
            response.put("code", "0");
            response.put("msg", "success");
            return map2str(response);
        }catch (Exception e){
            response.put("code", "1");
            response.put("msg", "Error request parameter");
            return map2str(response);
        }
    }

    public String map2str(Map<String, String> map){
        String xmlStr = null;
        StringBuffer sbf = new StringBuffer();
        sbf.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        for(Map.Entry<String, String> s: map.entrySet()){

            sbf.append("<")
                    .append(s.getKey())
                    .append(">")
                    .append(s.getValue())
                    .append("</")
                    .append(s.getKey())
                    .append(">")
                    .append("\n");

        }
        xmlStr = sbf.toString();
        return xmlStr;
    }

}
