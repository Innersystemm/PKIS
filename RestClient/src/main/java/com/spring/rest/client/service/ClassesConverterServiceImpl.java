package com.spring.rest.client.service;

import com.spring.rest.client.bean.DealBean;
import com.spring.rest.client.bean.FlatBean;
import com.spring.rest.client.bean.RegionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wsdl.bean.Deal;
import wsdl.bean.Flat;
import wsdl.bean.ObjectFactory;
import wsdl.bean.Region;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
public class ClassesConverterServiceImpl implements ClassesConverterService {
    private final Logger log = LoggerFactory.getLogger(ClassesConverterServiceImpl.class);

    @Autowired
    DateConverterService dateConverterService;

    public RegionBean convertRegion(Region region) {
        return new RegionBean(
                OptionalInt.of(region.getRegionID()),
                region.getRegionName().getValue());
    }

    public FlatBean convertFlat(Flat flat) {
        return new FlatBean(
                OptionalInt.of(flat.getFlatID()),
                OptionalDouble.of(flat.getArea()),
                OptionalInt.of(flat.getRooms()),
                flat.isBalcony(),
                convertRegion(flat.getFlatRegion().getValue()));
    }

    public DealBean convertDeal(Deal deal) {
        return new DealBean(
                OptionalInt.of(deal.getDealID()),
                OptionalDouble.of(deal.getPrice()),
                dateConverterService.toLocalDateTime(deal.getDealDate()),
                convertFlat(deal.getDealFlat().getValue()));
    }


    public List<DealBean> convertDeals(List<Deal> deals) {
        return deals.stream().filter(n -> null != n).map(n -> convertDeal(n)).collect(Collectors.toList());
    }

    public List<RegionBean> convertRegions(List<Region> regions) {
        return regions.stream().filter(n -> null != n).map(n -> convertRegion(n)).collect(Collectors.toList());
    }

    public List<FlatBean> convertFlats(List<Flat> flats) {
        return flats.stream().filter(n -> null != n).map(n -> convertFlat(n)).collect(Collectors.toList());
    }


    public Region convertRegionBean(RegionBean region) {
        Region reg = new ObjectFactory().createRegion();
        reg.setRegionID(region.getRegionID().orElse(-1));
        reg.setRegionName(new ObjectFactory().createRegionRegionName(region.getRegionName()));
        return reg;
    }

    public Flat convertFlatBean(FlatBean flat) {
        Flat fl = new ObjectFactory().createFlat();
        fl.setArea(flat.getFlatArea().orElse(-1));
        fl.setBalcony(flat.getHaveBalcony());
        fl.setRooms(flat.getFlatRooms().orElse(-1));
        fl.setFlatID(flat.getFlatId().orElse(-1));
        fl.setFlatRegion(new ObjectFactory().createFlatFlatRegion(
                convertRegionBean(flat.getFlatRegion())));
        return fl;
    }

    public Deal convertDealBean(DealBean dealBean) {
        Deal deal = new ObjectFactory().createDeal();
        try {
            deal.setDealDate(dateConverterService.toGregorianCalender(dealBean.getDealDate()));
        } catch (DatatypeConfigurationException e) {
            log.error("Data parsing error", e);
        }
        deal.setDealFlat(new ObjectFactory().createFlat(convertFlatBean(dealBean.getFlat())));
        deal.setPrice(dealBean.getPrice().orElse(-1));
        deal.setDealID(dealBean.getDealId().orElse(-1));
        return deal;
    }
}
