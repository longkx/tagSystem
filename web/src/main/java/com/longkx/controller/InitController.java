package com.longkx.controller;

import com.alibaba.fastjson.JSON;
import com.longkx.Property;
import com.longkx.PropertyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/init")
@Controller
@Slf4j
public class InitController {

    @Autowired
    @Qualifier("propertyRepository")
    private PropertyRepository propertyRepository;

    @RequestMapping(value = "init", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String init() {
        Property property = new Property();
        property.setId(1L);
        property.setName("longkx");
        Property save = propertyRepository.save(property);
        log.info("save={}", JSON.toJSONString(save));
        return "ok";
    }

}
