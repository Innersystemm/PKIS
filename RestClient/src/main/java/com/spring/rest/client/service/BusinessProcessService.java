package com.spring.rest.client.service;

import com.spring.rest.client.bean.AverageStatisticBean;
import com.spring.rest.client.bean.DealBean;
import com.spring.rest.client.bean.DetailedStatisticBean;
import wsdl.deal.bean.Deal;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BusinessProcessService {
    /**
     * <p>Развернутая статистика</p>
     * @param from начальная дата
     * @param to конечная дата
     * @return <p>количество проданных кваритр, общую стоиомсть сделок <b>за период</b></p>
     */
    List<DealBean> getDetailedStatistic(Date from, Date to);

    /**
     * <p>Усреденнные данные за интервал</p>
     * @param from начальная дата
     * @param to конечная дата
     * @return <p>среднюю стоимость сделки, а так же средняя площать и количество комнат проданных квартир</p>
     */
    AverageStatisticBean getAverageStatistic(Date from, Date to);

    /**
     * <p>Развернутая статистика поз начениям</p>
     * @param parameterNames список имен параметров по которым выполняется развернутая статистика
     * @return <p></p>
     */
    List<DealBean> getDetailedStatisticByParameters(final Map<String,String[]> parameterNames);
}
