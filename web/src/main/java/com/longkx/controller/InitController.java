package com.longkx.controller;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.longkx.Property;
import com.longkx.PropertyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/init")
@Controller
@Slf4j
@RequiredArgsConstructor
public class InitController {


    private final PropertyRepository propertyRepository;

    @RequestMapping(value = "init", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String init() {
        Property property = new Property();
//        property.setId(2L);
        property.setName("test");
        property.setDesc("hello test");
        property.setCreateTime(new Date());

        Property save = propertyRepository.save(property);
        Pageable pageable = PageRequest.of(0, 100);
        Iterable<Property> all = propertyRepository.findByName("test", pageable);
        log.info("save={}", JSON.toJSONString(save));
        log.info("all={}", JSON.toJSONString(all));
        return JSON.toJSONString(all);
    }

}
