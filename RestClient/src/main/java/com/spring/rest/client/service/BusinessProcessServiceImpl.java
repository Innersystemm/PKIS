package com.spring.rest.client.service;

import com.spring.rest.client.bean.AverageStatisticBean;
import com.spring.rest.client.bean.DealBean;
import com.spring.rest.client.bean.DetailedStatisticBean;
import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BusinessProcessServiceImpl implements BusinessProcessService {
    @Autowired
    private LocalDealService dealService;

    @Autowired
    private ClassesConverterService converter;


    @Override
    public List<DealBean> getDetailedStatistic(Date from, Date to) {
        if (from.after(to)) {
            return null;
        }
        return getDealBeans(from, to, -1);
    }

    @Override
    public AverageStatisticBean getAverageStatistic(Date from, Date to) {
        if (from.after(to)) {
            return null;
        }
        List<DealBean> dealsFilteredByDate = getDealBeans(from, to, -1);

        return new AverageStatisticBean(dealsFilteredByDate.stream().map(DealBean::getPrice).mapToLong(Float::longValue).sum(),
                dealsFilteredByDate.stream().map(n -> (double) n.getFlat().getFlatArea()).collect(Collectors.averagingDouble(Double::doubleValue)).floatValue(),
                new Double(dealsFilteredByDate.stream().mapToInt(n -> n.getFlat().getFlatRooms()).average().orElse(0)).intValue());
    }

    private List<DealBean> getDealBeans(Date from, Date to, int recordsCount) {
        List<DealBean> dealBeans = dealService.getDeals(recordsCount).stream()
                .filter(n -> n.getDealDate().after(from) && n.getDealDate().before(to)).collect(Collectors.toList());
        if (null == dealBeans || dealBeans.size() == 0) {
            return new ArrayList<>();
        }
        return dealBeans;
    }

    @Override
    public List<DealBean> getDetailedStatisticByParameters(final Map<String, String[]> parameterNames) {
        List<DealBean> filterByRegions = new ArrayList<>();
        List<DealBean> filterByArea = new ArrayList<>();
        List<DealBean> filterByRooms = new ArrayList<>();
        if (parameterNames.containsKey("region")) {
            filterByRegions = dealService.getDeals(-1).stream().filter(n -> n.getFlat().getFlatRegion()
                    .getRegionName().equalsIgnoreCase(parameterNames.get("region")[0])).collect(Collectors.toList());
        }
        if (parameterNames.containsKey("flatArea")) {
            filterByArea = dealService.getDeals(-1).stream().filter(n -> n.getFlat().getFlatArea() == Float
                    .valueOf(parameterNames.get("flatArea")[0])).collect(Collectors.toList());
        }
        if (parameterNames.containsKey("flatRooms")) {
            filterByRooms = dealService.getDeals(-1).stream().filter(n -> n.getFlat().getFlatRooms() == Float
                    .valueOf(parameterNames.get("flatRooms")[0])).collect(Collectors.toList());
        }

        return null;
    }


}
