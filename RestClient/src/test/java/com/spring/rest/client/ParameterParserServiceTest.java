package com.spring.rest.client;

import com.spring.rest.client.service.ParameterParserServiceImpl;
import com.spring.rest.client.service.ParameterParserService;
import org.junit.Test;

public class ParameterParserServiceTest {
    private ParameterParserService service = new ParameterParserServiceImpl();

    @Test
    public void correctArgumentsTest(){
        System.out.println(service.parseParameter("region>=flats"));
    }
}
