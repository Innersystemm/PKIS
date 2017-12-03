package com.spring.rest.client.service;

import com.spring.rest.client.bean.RegionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wsdl.region.RegionService;
import wsdl.region.bean.Region;

import java.util.List;

import static com.spring.rest.client.Constants.Errors;
import static com.spring.rest.client.Constants.SuccessfulOperations;

@Repository
public class LocalRegionService {
    private static final Logger Log = LoggerFactory.getLogger(LocalRegionService.class);
    private final RegionService regionService = new RegionService();

    @Autowired
    private ClassesConverterService converter;

    public List<RegionBean> getRegions() {
        try {
            return converter.convertRegions(regionService.getBasicHttpBindingIRegionService().getAllRegions().getRegion());
        } catch (Exception e) {
            Log.error(String.format(Errors.GETTING_ERROR_PATTERN, "regions", 0), e);
            return null;
        }

    }

    public RegionBean getRegion(final int regionId) {
        try {
            return converter.convertRegion(regionService.getBasicHttpBindingIRegionService().getRegion(regionId));
        } catch (Exception e) {
            Log.error(String.format(Errors.GETTING_ERROR_PATTERN, "region", regionId), e);
            return null;
        }
    }

    public String addRegion(final Region region) {
        try {
            regionService.getBasicHttpBindingIRegionService().addRegion(region);
            return String.format(SuccessfulOperations.SUCCESS_ADDING_PATTERN, region);
        } catch (Exception e) {
            Log.error(String.format(Errors.ADDING_ERROR_PATTERN, region), e);
            return String.format(Errors.ADDING_ERROR_PATTERN, region);
        }
    }

    public String updateRegion(final Region region) {
        try {
            regionService.getBasicHttpBindingIRegionService().updateRegion(region);
            return String.format(SuccessfulOperations.SUCCESS_UPDATING_PATTERN, "region", region);
        } catch (Exception e) {
            Log.error(String.format(Errors.UPDATING_ERROR_PATTERN, "region", region), e);
            return String.format(Errors.UPDATING_ERROR_PATTERN, "region", region);
        }
    }

    public String removeRegion(final int regionId) {
        try {
            regionService.getBasicHttpBindingIRegionService().removeRegion(regionId);
            return String.format(SuccessfulOperations.SUCCESS_REMOVING_PATTERN, "region", regionId);
        } catch (Exception e) {
            Log.error(String.format(Errors.REMOVING_ERROR_PATTERN, "region", regionId), e);
            return String.format(Errors.REMOVING_ERROR_PATTERN, "region", regionId);
        }
    }

    public Region convertRegionBean(final RegionBean item) {
        return converter.convertRegionBean(item);
    }
}
