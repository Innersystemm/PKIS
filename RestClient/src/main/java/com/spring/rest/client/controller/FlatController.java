package com.spring.rest.client.controller;

import com.spring.rest.client.bean.FlatBean;
import com.spring.rest.client.bean.RegionBean;
import com.spring.rest.client.service.LocalFlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flat/")
public class FlatController {
    @Autowired
    private LocalFlatService service;

    @RequestMapping(value = "/all/")
    public List<FlatBean> getFlats() {
        return service.getFlats();
    }

    @RequestMapping
    public FlatBean getFlat(@RequestParam("flatId") final int flatId) {
        return service.getFlat(flatId);
    }

    @RequestMapping(value = "/update/")
    public String updateFlat(@RequestParam("flatId") final int flatId,
                             @RequestParam("flatArea") final float flatArea,
                             @RequestParam("flatRooms") final int flatRooms,
                             @RequestParam("haveBalcony") final boolean haveBalcony,
                             @RequestParam("regionId") final int regionId,
                             @RequestParam("regionName") final String regionName) {
        return service.updateFlat(service.convertFlatBean(new FlatBean(
                flatId,
                flatArea,
                flatRooms,
                haveBalcony,
                new RegionBean(
                        regionId,
                        regionName)
        )));
    }

    @RequestMapping(value = "/add/")
    public String addFlat(@RequestParam("flatId") final int flatId,
                          @RequestParam("flatArea") final float flatArea,
                          @RequestParam("flatRooms") final int flatRooms,
                          @RequestParam("haveBalcony") final boolean haveBalcony,
                          @RequestParam("regionId") final int regionId,
                          @RequestParam("regionName") final String regionName) {
        return service.addFlat(service.convertFlatBean(new FlatBean(
                flatId,
                flatArea,
                flatRooms,
                haveBalcony,
                new RegionBean(
                        regionId,
                        regionName)
        )));
    }

    @RequestMapping(value = "/remove/")
    public String removeFlat(@RequestParam("flatId") final int flatId) {
        return service.removeFlat(flatId);
    }
}
