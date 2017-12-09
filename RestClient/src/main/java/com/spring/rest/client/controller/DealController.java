package com.spring.rest.client.controller;

import com.spring.rest.client.bean.DealBean;
import com.spring.rest.client.bean.FlatBean;
import com.spring.rest.client.bean.RegionBean;
import com.spring.rest.client.service.DateConverterService;
import com.spring.rest.client.service.LocalDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/deal")
public class DealController {
    @Autowired
    private LocalDealService service;

    @Autowired
    private DateConverterService dateConverter;

    @CrossOrigin
    @RequestMapping(value = "/all")
    public List<DealBean> getFlats() {
        return service.getDeals();
    }

    @RequestMapping
    public DealBean getFlat(@RequestParam("dealId") final int dealId) {
        return service.getDeal(dealId);
    }

    @RequestMapping(value = "/update")
    public String updateFlat(@RequestParam("dealId") final int dealId,
                             @RequestParam("dealDate") final String dealDate,
                             @RequestParam("dealPrice") final double dealPrice,
                             @RequestParam("flatId") final int flatId,
                             @RequestParam("flatArea") final double flatArea,
                             @RequestParam("flatRooms") final int flatRooms,
                             @RequestParam("haveBalcony") final boolean haveBalcony,
                             @RequestParam("regionId") final int regionId,
                             @RequestParam("regionName") final String regionName) {
        return service.updateDeal(service.convertDealBean(new DealBean(
                dealId,
                dealPrice,
                dateConverter.toLocalDateTime(dealDate),
                new FlatBean(
                        flatId,
                        flatArea,
                        flatRooms,
                        haveBalcony,
                        new RegionBean(
                                regionId,
                                regionName))

        )));
    }

    @RequestMapping(value = "/add")
    public String addFlat(@RequestParam("dealId") final int dealId,
                          @RequestParam("dealDate") final String dealDate,
                          @RequestParam("dealPrice") final float dealPrice,
                          @RequestParam("flatId") final int flatId,
                          @RequestParam("flatArea") final float flatArea,
                          @RequestParam("flatRooms") final int flatRooms,
                          @RequestParam("haveBalcony") final boolean haveBalcony,
                          @RequestParam("regionId") final int regionId,
                          @RequestParam("regionName") final String regionName) {
        return service.addDeal(service.convertDealBean(new DealBean(
                dealId,
                dealPrice,
                dateConverter.toLocalDateTime(dealDate),
                new FlatBean(
                        flatId,
                        flatArea,
                        flatRooms,
                        haveBalcony,
                        new RegionBean(
                                regionId,
                                regionName))

        )));

    }

    @RequestMapping(value = "/remove")
    public String removeFlat(@RequestParam("dealId") final int dealId) {
        return service.removeDeal(dealId);
    }
}
