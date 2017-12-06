package com.spring.rest.client.service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <p>Преобразует дату из java.util.Date в java.time.LocalDate</p>
 */
public interface DateConverterService {
    default LocalDate toLocalDate(final Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    default LocalDate toLocalDate(final String date){
        return LocalDate.parse(date);
    }

    default XMLGregorianCalendar toGregorianCalender(final LocalDate date) throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
    }

    default XMLGregorianCalendar toGregorianCalender(final LocalDateTime date) throws DatatypeConfigurationException {
        if (date.getSecond() == 0 || date.getNano() == 0)
        {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(
                    date.toString()+":00");
        }
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
    }

    default LocalDate toLocalDate(final XMLGregorianCalendar date) {
        return date.toGregorianCalendar().toZonedDateTime().toLocalDate();
    }

    default LocalDateTime toLocalDateTime(final XMLGregorianCalendar date){
        return toLocalDate(date).atStartOfDay();
    }

    default LocalDateTime toLocalDateTime(final String date){
        return LocalDate.parse(date).atStartOfDay();
    }
}
