package com.spring.rest.client.controller;

import com.spring.rest.client.service.BusinessProcessService;
import com.spring.rest.client.service.BusinessProcessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class HtmlBusinessController {
    @Autowired
    private BusinessProcessServiceImpl dataLoader;

    @RequestMapping("/html/getDetailedStatisticByInterval")
    public String getDetailedStatisticByInterval(@RequestParam("from")String from,
                                                 @RequestParam("to")String to,
                                                 @RequestParam("skip")int skip,
                                                 @RequestParam("recordsCount")int recordsCount,
                                                 Map<String, Object> model){
        model.put("result", dataLoader.getDetailedStatisticByInterval(from, to, skip, recordsCount));
        return "statistic_data";
    }
}
