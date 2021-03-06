package com.spring.rest.client.controller;

import com.spring.rest.client.service.BusinessProcessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BusinessHtmlController {
    @Autowired
    private BusinessProcessServiceImpl dataLoader;

    @RequestMapping("/html/getDetailedStatisticByInterval")
    public String getDetailedStatisticByInterval(@RequestParam("from") String from,
                                                 @RequestParam("to") String to,
                                                 @RequestParam("skip") int skip,
                                                 @RequestParam("recordsCount") int recordsCount,
                                                 Map<String, Object> model) {
        model.put("result", dataLoader.getDetailedStatisticByInterval(from, to, skip, recordsCount));

        return "statistic_data";
    }
    @RequestMapping("/")
    public String getIndex(Map<String, Object> model) {
        return "index";
    }

    @RequestMapping("/business")
    public String getBusinessIndexPage(Map<String, Object> model){
        model.put("selection_data", dataLoader.getRequiredParameters());

        return "extended_statistic";
    }
}
