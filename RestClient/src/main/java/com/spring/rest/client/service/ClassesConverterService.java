package com.spring.rest.client.service;

import com.spring.rest.client.bean.DealBean;
import com.spring.rest.client.bean.DetailedStatisticBean;
import com.spring.rest.client.bean.FlatBean;
import com.spring.rest.client.bean.RegionBean;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.springframework.stereotype.Service;
import wsdl.deal.bean.Deal;
import wsdl.flat.bean.Flat;
import wsdl.region.bean.Region;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassesConverterService {
    public List<DealBean> convertDeals(List<Deal> deals) {
        return deals.stream().map(n -> new DealBean(
                Optional.of(n.getDealID()).orElse(-1),
                Optional.of(n.getDealDate().toGregorianCalendar().getTime()).orElse(new Date()),
                new FlatBean(
                        Optional.of(n.getDealFlat().getValue().getFlatID()).orElse(-1),
                        Optional.of(n.getDealFlat().getValue().getArea()).orElse(-1F),
                        Optional.of(n.getDealFlat().getValue().getRooms()).orElse(-1),
                        Optional.of(n.getDealFlat().getValue().isBalcony()).orElse(false),
                        new RegionBean(
                                null !=n.getDealFlat().getValue().getFlatRegion().getValue()?n.getDealFlat().getValue().getFlatRegion().getValue().getRegionID():-1,
                                null !=n.getDealFlat().getValue().getFlatRegion().getValue()?n.getDealFlat().getValue().getFlatRegion().getValue().getRegionName().getValue():"")
                ),
                Optional.of(n.getPrice()).orElse(-1F)
        )).collect(Collectors.toList());
    }

    public List<RegionBean> convertRegions(List<Region> regions) {
        return regions.stream().map(n -> new RegionBean(
                Optional.of(n.getRegionID()).orElse(-1),
                Optional.of(n.getRegionName().getValue()).orElse("null")
        )).collect(Collectors.toList());
    }

    public List<FlatBean> convertFlats(List<Flat> flats) {
        return flats.stream().map(n -> new FlatBean(
                Optional.of(n.getFlatID()).orElse(-1),
                Optional.of(n.getArea()).orElse(-1F),
                Optional.of(n.getRooms()).orElse(-1),
                Optional.of(n.isBalcony()).orElse(false),
                new RegionBean(
                        Optional.of(n.getFlatRegion().getValue().getRegionID()).orElse(-1),
                        Optional.of(n.getFlatRegion().getValue().getRegionName().getValue()).orElse("null")
                )
        )).collect(Collectors.toList());
    }

    public RegionBean convertRegion(final Region region) {
        return new RegionBean(
                region.getRegionID(),
                region.getRegionName().getValue()
        );
    }

    public FlatBean convertFlat(final Flat flat) {
        return new FlatBean(
                Optional.of(flat.getFlatID()).orElse(-1),
                Optional.of(flat.getArea()).orElse(-1F),
                Optional.of(flat.getRooms()).orElse(-1),
                Optional.of(flat.isBalcony()).orElse(false),
                new RegionBean(
                        flat.getFlatRegion().getValue()
                                .getRegionID(),
                        flat.getFlatRegion().getValue()
                                .getRegionName().getValue()));
    }

    public DealBean convertDeal(final Deal deal) {
        return new DealBean(
                Optional.of(deal.getDealID()).orElse(-1),
                Optional.of(deal.getDealDate().toGregorianCalendar().getTime()).orElse(new Date()),
                new FlatBean(
                        Optional.of(deal.getDealFlat().getValue().getFlatID()).orElse(-1),
                        Optional.of(deal.getDealFlat().getValue().getArea()).orElse(-1F),
                        Optional.of(deal.getDealFlat().getValue().getRooms()).orElse(-1),
                        Optional.of(deal.getDealFlat().getValue().isBalcony()).orElse(false),
                        new RegionBean(
                                Optional.of(deal.getDealFlat().getValue().getFlatRegion().getValue()).orElse(new wsdl.deal.bean.region.Region())
                                        .getRegionID(),
                                Optional.of(deal.getDealFlat().getValue().getFlatRegion().getValue()).orElse(new wsdl.deal.bean.region.Region())
                                        .getRegionName().getValue())
                ),
                Optional.of(deal.getPrice()).orElse(-1F));
    }

    public Region convertRegionBean(RegionBean region) {
        Region reg = new wsdl.region.bean.ObjectFactory().createRegion();
        reg.setRegionID(region.getRegionID());
        reg.setRegionName(new wsdl.region.bean.ObjectFactory().createRegionRegionName(region.getRegionName()));
        return reg;
    }

    public Flat convertFlatBean(FlatBean flat) {
        Flat fl = new wsdl.flat.bean.ObjectFactory().createFlat();
        fl.setArea(flat.getFlatArea());
        fl.setBalcony(flat.isHaveBalcony());
        fl.setRooms(flat.getFlatRooms());
        fl.setFlatID(flat.getFlatId());
        wsdl.flat.bean.region.Region region = new wsdl.flat.bean.region.ObjectFactory().createRegion();
        region.setRegionID(flat.getFlatRegion().getRegionID());
        region.setRegionName(new wsdl.flat.bean.region.ObjectFactory().createRegionRegionName(flat.getFlatRegion().getRegionName()));
        fl.setFlatRegion(new wsdl.flat.bean.ObjectFactory().createFlatFlatRegion(region));
        return fl;
    }

    public wsdl.deal.bean.Deal convertDealBean(DealBean dealBean) {
        Deal deal = new wsdl.deal.bean.ObjectFactory().createDeal();
        deal.setDealID(dealBean.getDealId());
        deal.setDealDate(XMLGregorianCalendarImpl.createDateTime(
                dealBean.getDealDate().getYear(),
                dealBean.getDealDate().getMonth(),
                dealBean.getDealDate().getDay(),
                dealBean.getDealDate().getHours(),
                dealBean.getDealDate().getMinutes(),
                dealBean.getDealDate().getSeconds()
        ));
        deal.setPrice(dealBean.getPrice());
        wsdl.deal.bean.flat.Flat flat = new wsdl.deal.bean.flat.ObjectFactory().createFlat();
        flat.setFlatID(dealBean.getFlat().getFlatId());
        flat.setArea(dealBean.getFlat().getFlatArea());
        flat.setBalcony(dealBean.getFlat().isHaveBalcony());
        flat.setRooms(dealBean.getFlat().getFlatRooms());
        wsdl.deal.bean.region.Region region = new wsdl.deal.bean.region.ObjectFactory().createRegion();
        region.setRegionID(dealBean.getFlat().getFlatRegion().getRegionID());
        region.setRegionName(new wsdl.deal.bean.region.ObjectFactory().createRegionRegionName(dealBean.getFlat().getFlatRegion().getRegionName()));
        flat.setFlatRegion(new wsdl.deal.bean.region.ObjectFactory().createRegion(region));
        deal.setDealFlat(new wsdl.deal.bean.flat.ObjectFactory().createFlat(flat));
        return deal;
    }
}
