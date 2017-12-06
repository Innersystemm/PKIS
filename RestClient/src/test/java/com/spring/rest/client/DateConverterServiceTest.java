package com.spring.rest.client;

import com.spring.rest.client.service.DateConverterService;
import com.spring.rest.client.service.DateConverterServiceImpl;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateConverterServiceTest {
    DateConverterService converter = new DateConverterServiceImpl();

    @Test
    public void toGregorianCalendarTest(){
        try{
            System.out.println(LocalDate.parse("2017-12-20").atStartOfDay());
            System.out.println(converter.toGregorianCalender(LocalDateTime.parse("2017-02-11T00:00")));
        }catch (DatatypeConfigurationException e){
        }

    }
}
