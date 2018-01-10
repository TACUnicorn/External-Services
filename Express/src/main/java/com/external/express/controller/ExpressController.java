package com.external.express.controller;

import com.external.express.mapper.ExpressMapper;
import com.external.express.model.BasicResponse;
import com.external.express.model.Express;
import com.external.express.model.ExpressTmp;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Create by xuantang
 * @date on 1/10/18
 */
@RestController
public class ExpressController {

    @Autowired
    ExpressMapper expressMapper;
    private final Logger logger = Logger.getLogger(getClass());

    @GetMapping(value = "/express/deliveries")
    public BasicResponse<List<Express>> getExpresses() {
        BasicResponse<List<Express>> response = new BasicResponse<>();
        try {
            // Get product from database
            List<Express> expresses = expressMapper.getExpresses();
            if (expresses != null) {
                response.setCode(200);
                response.setMessage("success");
                response.setContent(expresses);
                return response;
            } else {
                response.setCode(300);
                response.setMessage("not found expresses");
                response.setContent(null);
                return response;
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.setCode(500);
            response.setMessage("error");
            return response;
        }
    }

    @PostMapping(value = "/express/deliver")
    public BasicResponse<String> addExpresses(@RequestBody ExpressTmp expressTmp) {
        BasicResponse<String> response = new BasicResponse<>();
        try {
            expressMapper.addExpress(expressTmp);
            response.setCode(200);
            response.setMessage("success");
            return response;
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.setCode(500);
            response.setMessage("error");
            return response;
        }
    }
}
