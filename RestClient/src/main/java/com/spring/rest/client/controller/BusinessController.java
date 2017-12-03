package com.spring.rest.client.controller;

import com.spring.rest.client.bean.AverageStatisticBean;
import com.spring.rest.client.bean.DealBean;
import com.spring.rest.client.bean.DetailedStatisticBean;
import com.spring.rest.client.service.BusinessProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/statistic/")
public class BusinessController {
    @Autowired
    BusinessProcessService businessProcessService;

    @RequestMapping("/getDetailedStatistic/")
    public List<DealBean> getDetailedStatistic(@RequestParam("from") final String from,
                                               @RequestParam("to")final String to) {
        try {
            final Date fromDate = new SimpleDateFormat("dd-MM-yyyy").parse(from);
            final Date toDate = new SimpleDateFormat("dd-MM-yyyy").parse(to);
            return businessProcessService.getDetailedStatistic(fromDate, toDate);
        }catch (ParseException e){
            return null;
        }
    }

    @RequestMapping("/getAverageStatistic/")
    public AverageStatisticBean getAverageStatistic(@RequestParam("from") final String from,
                                                    @RequestParam("to")final String to){
        try {
            final Date fromDate = new SimpleDateFormat("dd-MM-yyyy").parse(from);
            final Date toDate = new SimpleDateFormat("dd-MM-yyyy").parse(to);
            return businessProcessService.getAverageStatistic(fromDate, toDate);
        }catch (ParseException e){
            return null;
        }
    }

    @RequestMapping("/getDetailedStatisticByValue/")
    public Map<String,String[]> getDetailedStatisticByValue(@RequestParam("recordsCount") final int recordsCount,
                                                          HttpServletRequest request){
        return request.getParameterMap();
    }
}
