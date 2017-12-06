package com.spring.rest.client.service;

import com.spring.rest.client.bean.AverageStatisticBean;
import com.spring.rest.client.bean.DealBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BusinessProcessService {
    /**
     * <p>Развернутая статистика за интервал</p>
     *
     * @param from         начальная дата
     * @param to           коненая дата
     * @param skip        сколько записей будет пропущено
     * @param recordsCount необходимое количество записей
     * @return <p>коллекцию DealBean отфильтрованную по дате и ограниченную параметрами skip, recordsCount</p>
     */
    List<DealBean> getDetailedStatisticByInterval(LocalDateTime from, LocalDateTime to, int skip, int recordsCount);

    /**
     * <p>Усреденнные данные за интервал</p>
     *
     * @param from начальная дата
     * @param to   конечная дата
     * @return <p>среднюю стоимость сделки, а так же средняя площать и количество комнат проданных квартир</p>
     */
    AverageStatisticBean getAverageStatisticByInterval(LocalDateTime from, LocalDateTime to);


    /**
     * <p>Развернутая статистика по значениям</p>
     *
     * @param parameterNames значения по которым производить фильтрацию
     * @param skip          сколько записей будет пропущено
     * @param recordsCount   необходимое количество записей
     * @return <p>коллекцию DealBean отфильтрованную по указанным параметрам ограниченную параметрами skip, recordsCount</p>
     */
    List<DealBean> getDetailedStatisticByParameters(final List<String> parameterNames, int skip, int recordsCount);

    /**
     * <p>усредненная статистика по значениям</p>
     *
     * @param parameters <p>значения по которым будет выполняться фильтрация</p>
     * @return <p>среднюю стоимость сделки, среднее количество комнат, среднюю площадь</p>
     */
    AverageStatisticBean getAverageStatisticByParameters(final List<String> parameters);
}
