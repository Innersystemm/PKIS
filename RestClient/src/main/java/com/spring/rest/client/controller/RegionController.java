package com.spring.rest.client.controller;

import com.spring.rest.client.bean.RegionBean;
import com.spring.rest.client.service.LocalRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/region/")
public class RegionController {
    @Autowired
    private LocalRegionService service;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<RegionBean> getAllRegions() {
        return service.getRegions();
    }

    @RequestMapping
    public RegionBean getRegion(@RequestParam("regionId") final int regionId) {
        return service.getRegion(regionId);
    }

    @RequestMapping(value = "/update/")
    public String updateRegion(@RequestParam("regionId") final int regionId,
                               @RequestParam("regionName") final String regionName) {
        return service.updateRegion(service.convertRegionBean(new RegionBean(regionId, regionName)));
    }

    @RequestMapping(value = "/add/")
    public String addRegion(@RequestParam("regionId") final int regionId,
                            @RequestParam("regionName") final String regionName) {
        return service.addRegion(service.convertRegionBean(new RegionBean(regionId, regionName)));
    }

    @RequestMapping(value = "/remove/")
    public String removeRegion(@RequestParam("regionId") final int regionId) {
        return service.removeRegion(regionId);
    }
}
