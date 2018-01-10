package com.external.bank.controller;

import com.external.bank.mapper.BankMapper;
import com.external.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bank")
public class TransferController {
//
//    @Autowired
//    private BankMapper bankMapper;

    @Autowired
    private BankService bankService;

    @PostMapping(value = "/transfer")
    @ResponseBody
    public Object transfer(@RequestBody Map<Object, Object> requestBody){

        String fromAcount;
        String toAcount;
        Float sum;
        HashMap<Object, Object> response = new HashMap<>();
        try {
            try {
                fromAcount = requestBody.get("fromAcount").toString();
                toAcount = requestBody.get("toAcount").toString();
                sum = new Float(requestBody.get("sum").toString());
            }
            catch (Exception e){
                response.put("code", 1);
                response.put("msg", "Error post parameter");
                return response;
            }
            Float balance = bankService.getBalance(fromAcount);
            if(balance < sum ){
                response.put("code", 1);
                response.put("msg", "Balance is not enough");
                return response;
            }

            bankService.change(fromAcount, toAcount, sum);
            response.put("code", 0);
            response.put("msg", "Success");
            return response;
        }
        catch (Exception e){
            response.put("code", 1);
            response.put("msg", "The bank system exists faults");
            return response;
        }


    }

    @GetMapping(value = "/balance/{account}")
    public Object getBalance(@PathVariable String account){
        HashMap<Object, Object> response = new HashMap<>();
        try {
            Float b = bankService.getBalance(account);
            response.put("num", b);
            return response;
        }
        catch (Exception e){
            response.put("num", -1);
            return response;
        }
    }

}
