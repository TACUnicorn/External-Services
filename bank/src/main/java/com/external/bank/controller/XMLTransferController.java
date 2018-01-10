package com.external.bank.controller;

import com.external.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/xml/bank")
public class XMLTransferController {

    @Autowired
    private BankService bankService;

    @PostMapping(value = "/transfer")
    public Object transfer(@RequestBody Map<Object, Object> requestBody){

//        return "hello";

        String fromAcount;
        String toAcount;
        Float sum;
        HashMap<String, String> response = new HashMap<>();
        try {
            try {
                fromAcount = requestBody.get("fromAcount").toString();
                toAcount = requestBody.get("toAcount").toString();
                sum = new Float(requestBody.get("sum").toString());
            }
            catch (Exception e){
                response.put("code", "1");
                response.put("msg", "Error post parameter");
                return map2str(response);
            }
            Float balance = bankService.getBalance(fromAcount);
            if(balance < sum ){
                response.put("code", "1");
                response.put("msg", "Balance is not enough");
                return map2str(response);
            }

            bankService.change(fromAcount, toAcount, sum);
            response.put("code","0");
            response.put("msg", "Success");
            return map2str(response);
        }
        catch (Exception e){
            response.put("code", "1");
            response.put("msg", "The bank system exists faults");
            return map2str(response);
        }


    }

    @GetMapping(value = "/balance/{account}")
    public Object getBalance(@PathVariable String account){

        HashMap<String, String> response = new HashMap<>();
        try {
            Float b = bankService.getBalance(account);
            response.put("num", b.toString());
            return map2str(response);
        }
        catch (Exception e){
            response.put("num", "-1");
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
