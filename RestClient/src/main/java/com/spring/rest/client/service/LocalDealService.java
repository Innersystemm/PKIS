package com.spring.rest.client.service;

import com.spring.rest.client.Constants;
import com.spring.rest.client.bean.DealBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wsdl.bean.Deal;
import wsdl.deal.DealService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LocalDealService {
    private static final Logger log = LoggerFactory.getLogger(LocalDealService.class);
    private DealService dealService = new DealService();

    @Autowired
    private ClassesConverterService converter;

    @Autowired
    private DateConverterService dateConverterService;

    public List<DealBean> getDeals() {
        try {
            return converter.convertDeals(dealService.getBasicHttpBindingIDealService().getAllDeals().getDeal());
        } catch (Exception e) {
            log.error(String.format(Constants.Errors.GETTING_ERROR_PATTERN, "deals", 0), e);
            return null;
        }
    }

    public List<DealBean> getDeals(LocalDateTime from, LocalDateTime to) {
        if (from.isAfter(to)) {
            log.warn("Начальная дата (%s) больше конечной (%s)", from, to);
            return new ArrayList<>();
        }
        try {
            return converter.convertDeals(dealService.getBasicHttpBindingIDealService().getDealsByPeriod(
                    dateConverterService.toGregorianCalender(from), dateConverterService.toGregorianCalender(to)).getDeal());
        } catch (Exception e) {
            log.error(String.format(Constants.Errors.GETTING_ERROR_PATTERN, "deals", 0), e);
            return null;
        }
    }

    public DealBean getDeal(final int dealId) {
        try {
            return converter.convertDeal(dealService.getBasicHttpBindingIDealService().getDeal(dealId));
        } catch (Exception e) {
            log.error(String.format(Constants.Errors.GETTING_ERROR_PATTERN, "deal", dealId), e);
            return null;
        }
    }

    public String addDeal(final Deal deal) {
        try {
            dealService.getBasicHttpBindingIDealService().addDeal(deal);
            return String.format(Constants.SuccessfulOperations.SUCCESS_ADDING_PATTERN, deal);
        } catch (Exception e) {
            log.error(String.format(Constants.Errors.ADDING_ERROR_PATTERN, deal), e);
            return String.format(Constants.Errors.ADDING_ERROR_PATTERN, deal);
        }
    }

    public String updateDeal(final Deal deal) {
        try {
            dealService.getBasicHttpBindingIDealService().updateDeal(deal);
            return String.format(Constants.SuccessfulOperations.SUCCESS_UPDATING_PATTERN, "deal", deal);
        } catch (Exception e) {
            log.error(String.format(Constants.Errors.UPDATING_ERROR_PATTERN, "deal", deal), e);
            return String.format(Constants.Errors.UPDATING_ERROR_PATTERN, "deal", deal);
        }
    }

    public String removeDeal(final int dealId) {
        try {
            dealService.getBasicHttpBindingIDealService().removeDeal(dealId);
            return String.format(Constants.SuccessfulOperations.SUCCESS_REMOVING_PATTERN, "deal", dealId);
        } catch (Exception e) {
            log.error(String.format(Constants.Errors.REMOVING_ERROR_PATTERN, "deal", dealId), e);
            return String.format(Constants.Errors.REMOVING_ERROR_PATTERN, "deal", dealId);
        }
    }

    public Deal convertDealBean(DealBean item) {
        return converter.convertDealBean(item);
    }
}
