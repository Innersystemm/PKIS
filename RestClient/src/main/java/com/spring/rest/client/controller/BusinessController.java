package com.spring.rest.client.controller;

import com.spring.rest.client.bean.AverageStatisticBean;
import com.spring.rest.client.bean.DealBean;
import com.spring.rest.client.service.BusinessProcessService;
import com.spring.rest.client.service.DateConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistic/")
public class BusinessController {
    @Autowired
    private BusinessProcessService businessProcessService;
    @Autowired
    private DateConverterService dateConverterService;

    @RequestMapping("/byInterval/detailed")
    public List<DealBean> getDetailedStatistic(@RequestParam("from") final String from,
                                               @RequestParam("to") final String to,
                                               @RequestParam("skip") final int skip,
                                               @RequestParam("recordsCount") final int recordsCount) {
        return businessProcessService.getDetailedStatisticByInterval(
                dateConverterService.toLocalDateTime(from),
                dateConverterService.toLocalDateTime(to), skip, recordsCount);
    }

    @RequestMapping("/byInterval/average")
    public AverageStatisticBean getAverageStatistic(@RequestParam("from") final String from,
                                                    @RequestParam("to") final String to) {
        return businessProcessService.getAverageStatisticByInterval(
                dateConverterService.toLocalDateTime(from),
                dateConverterService.toLocalDateTime(to));
    }

    @RequestMapping("/byParameters/detailed")
    public List<DealBean> getDetailedStatisticByValue(@RequestParam("params") final List<String> params,
                                                      @RequestParam("skip") final int skip,
                                                      @RequestParam("recordsCount") final int recordsCount) {
        return businessProcessService.getDetailedStatisticByParameters(params, skip, recordsCount);
    }

    @RequestMapping("/byParameters/average")
    public AverageStatisticBean getAverageStatisticByValue(@RequestParam("params") final List<String> params) {
        return businessProcessService.getAverageStatisticByParameters(params);
    }
}
