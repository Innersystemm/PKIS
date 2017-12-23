package com.spring.rest.client.service;

import com.spring.rest.client.bean.AverageStatisticBean;
import com.spring.rest.client.bean.DealBean;
import com.spring.rest.client.bean.ParsedParameter;
import com.spring.rest.client.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
public class BusinessProcessServiceImpl implements BusinessProcessService {
    private final Logger log = LoggerFactory.getLogger(BusinessProcessServiceImpl.class);

    @Autowired
    private LocalDealService dealService;

    @Autowired
    private ParameterParserService parameterParser;

    @Autowired
    private Configuration configuration;

    public List<DealBean> getDetailedStatisticByInterval(String from, String to, int skip, int recordsCount) {
        LocalDateTime fromDate = LocalDateTime.parse(from);
        LocalDateTime toDate = LocalDateTime.parse(to);
        return getDetailedStatisticByInterval(fromDate, toDate, skip, recordsCount);
    }

    @Override
    public List<DealBean> getDetailedStatisticByInterval(LocalDateTime from, LocalDateTime to, int skip, int recordsCount) {
        try {
            return dealService.getDeals(from, to).stream().skip(skip).limit(recordsCount).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("getDetailedStatisticByInterval", e);
            return new ArrayList<>();
        }
    }

    public AverageStatisticBean getAverageStatisticByInterval(List<DealBean> dataSource, LocalDateTime from, LocalDateTime to) {
        try {
            List<DealBean> dealsFilteredByDate = dataSource.stream()
                    .filter(n -> n.getDealDate().isBefore(to) && n.getDealDate().isAfter(from)).collect(Collectors.toList());

            return new AverageStatisticBean(
                    dealsFilteredByDate.stream()
                            .mapToDouble(n -> n.getPrice().orElse(-1)).average().orElse(-1),
                    dealsFilteredByDate.stream()
                            .mapToDouble(n -> n.getFlat().getFlatArea().orElse(-1))
                            .average().orElse(-1),
                    dealsFilteredByDate.stream()
                            .mapToDouble(n -> n.getFlat().getFlatRooms().orElse(-1))
                            .average().orElse(-1));
        } catch (Exception e) {
            log.error("getDetailedStatisticByInterval", e);
            return new AverageStatisticBean(-1, -1, -1);
        }
    }

    @Override
    public AverageStatisticBean getAverageStatisticByInterval(LocalDateTime from, LocalDateTime to) {
        return getAverageStatisticByInterval(dealService.getDeals(), from, to);
    }

    public List<DealBean> getDetailedStatisticByParameters(final List<String> parameterNames, int skip, int recordsCount) {
        List<DealBean> localCollection = dealService.getDeals();
        for (String request : parameterNames) {
            ParsedParameter parsedParameter = parameterParser.parseParameter(request);
            if (configuration.getIntKeys().contains(parsedParameter.getParameterName())) {
                localCollection = localCollection.stream().filter(
                        n -> parameterParser.compare(
                                (double) ((OptionalInt) parameterParser.getFieldValue(n, parsedParameter.getParameterName())).orElse(-1),
                                parsedParameter.doubleValue(),
                                parsedParameter.getToken()
                        ))
                        .collect(Collectors.toList());
            } else if (configuration.getDoubleKeys().contains(parsedParameter.getParameterName())) {
                localCollection = localCollection.stream().filter(
                        n -> parameterParser.compare(
                                ((OptionalDouble) parameterParser.getFieldValue(n, parsedParameter.getParameterName())).orElse(-1),
                                parsedParameter.doubleValue(),
                                parsedParameter.getToken()
                        ))
                        .collect(Collectors.toList());
            } else if (configuration.getStringKeys().contains(parsedParameter.getParameterName())) {
                localCollection = localCollection.stream().filter(
                        n -> parameterParser.compare(
                                (String) parameterParser.getFieldValue(n, parsedParameter.getParameterName()),
                                parsedParameter.stringValue(),
                                parsedParameter.getToken()
                        ))
                        .collect(Collectors.toList());
            }
        }
        return localCollection.stream().skip(skip).limit(recordsCount).collect(Collectors.toList());
    }

    @Override
    public AverageStatisticBean getAverageStatisticByParameters(final List<String> parameterNames) {
        return getAverageStatisticByInterval(
                getDetailedStatisticByParameters(parameterNames, 0, 999999999),
                LocalDateTime.of(1500, 12, 1, 0, 0, 0),
                LocalDateTime.now());
    }

    public List<String> getRequiredParameters(){
        List<String> parameters = new ArrayList<>();
        parameters.addAll(configuration.getDoubleKeys());
        parameters.addAll(configuration.getIntKeys());
        parameters.addAll(configuration.getBoolKeys());
        parameters.addAll(configuration.getStringKeys());
        return parameters;
    }
}
