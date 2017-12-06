package com.spring.rest.client.service;

import com.spring.rest.client.Constants;
import com.spring.rest.client.bean.FlatBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wsdl.bean.Flat;
import wsdl.flat.FlatService;

import java.util.List;

@Repository
public class LocalFlatService {
    private final Logger Log = LoggerFactory.getLogger(LocalFlatService.class);
    private FlatService flatService = new FlatService();

    @Autowired
    private ClassesConverterService converter;

    public List<FlatBean> getFlats() {
        try {
            return converter.convertFlats(flatService.getBasicHttpBindingIFlatService().getAllFlats().getFlat());
        } catch (Exception e) {
            Log.error(String.format(Constants.Errors.GETTING_ERROR_PATTERN, "flats", 0), e);
            return null;
        }

    }

    public FlatBean getFlat(final int flatId) {
        try {
            return converter.convertFlat(flatService.getBasicHttpBindingIFlatService().getFlat(flatId));
        } catch (Exception e) {
            Log.error(String.format(Constants.Errors.GETTING_ERROR_PATTERN, "flat", flatId), e);
            return null;
        }
    }

    public String addFlat(final Flat flat) {
        try {
            flatService.getBasicHttpBindingIFlatService().addFlat(flat);
            return String.format(Constants.SuccessfulOperations.SUCCESS_ADDING_PATTERN, flat);
        } catch (Exception e) {
            Log.error(String.format(Constants.Errors.ADDING_ERROR_PATTERN, flat), e);
            return String.format(Constants.Errors.ADDING_ERROR_PATTERN, flat);
        }
    }

    public String updateFlat(final Flat flat) {
        try {
            flatService.getBasicHttpBindingIFlatService().updateFlat(flat);
            return String.format(Constants.SuccessfulOperations.SUCCESS_UPDATING_PATTERN, "region", flat);
        } catch (Exception e) {
            Log.error(String.format(Constants.Errors.UPDATING_ERROR_PATTERN, "region", flat), e);
            return String.format(Constants.Errors.UPDATING_ERROR_PATTERN, "region", flat);
        }
    }

    public String removeFlat(final int flat) {
        try {
            flatService.getBasicHttpBindingIFlatService().removeFlat(flat);
            return String.format(Constants.SuccessfulOperations.SUCCESS_REMOVING_PATTERN, "flat", flat);
        } catch (Exception e) {
            Log.error(String.format(Constants.Errors.REMOVING_ERROR_PATTERN, "flat", flat), e);
            return String.format(Constants.Errors.REMOVING_ERROR_PATTERN, "flat", flat);
        }
    }

    public Flat convertFlatBean(final FlatBean item) {
        return converter.convertFlatBean(item);
    }
}
