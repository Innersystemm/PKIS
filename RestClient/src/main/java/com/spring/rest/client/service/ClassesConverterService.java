package com.spring.rest.client.service;

import com.spring.rest.client.bean.DealBean;
import com.spring.rest.client.bean.FlatBean;
import com.spring.rest.client.bean.RegionBean;
import wsdl.bean.Deal;
import wsdl.bean.Flat;
import wsdl.bean.Region;

import java.util.List;

public interface ClassesConverterService {
    RegionBean convertRegion(Region region);

    FlatBean convertFlat(Flat flat);

    DealBean convertDeal(Deal deal);

    List<DealBean> convertDeals(List<Deal> deals);

    List<RegionBean> convertRegions(List<Region> regions);

    List<FlatBean> convertFlats(List<Flat> flats);

    Region convertRegionBean(RegionBean region);

    Flat convertFlatBean(FlatBean flat);

    Deal convertDealBean(DealBean dealBean);
}
