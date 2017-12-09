package com.spring.rest.client.service;

import com.spring.rest.client.bean.DealBean;
import com.spring.rest.client.bean.FlatBean;
import com.spring.rest.client.bean.ParsedParameter;
import com.spring.rest.client.bean.RegionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class ParameterParserServiceImpl implements ParameterParserService {
    private final Logger log = LoggerFactory.getLogger(ParameterParserServiceImpl.class);

    public enum TOKENS {
        BIGGER_OR_EQUALS(">="),
        BIGGER(">"),
        EQUALS("=="),
        SMALLER_OR_EQUALS("<="),
        SMALLER("<"),
        NOT_EQUALS("!=");

        private String token;

        TOKENS(String token) {
            this.token = token;
        }

        public String TOKEN() {
            return token;
        }
    }

    @Override
    public ParsedParameter parseParameter(final String parameter) {
        int index;
        if ((index = parameter.indexOf(TOKENS.BIGGER_OR_EQUALS.TOKEN())) != -1 && index < parameter.length()) {
            return new ParsedParameter(parameter.substring(0, index),
                    TOKENS.BIGGER_OR_EQUALS,
                    parameter.substring(index + TOKENS.BIGGER_OR_EQUALS.TOKEN().length()));
        } else if ((index = parameter.indexOf(TOKENS.SMALLER_OR_EQUALS.TOKEN())) != -1 && index < parameter.length()) {
            return new ParsedParameter(parameter.substring(0, index),
                    TOKENS.SMALLER_OR_EQUALS,
                    parameter.substring(index + TOKENS.SMALLER_OR_EQUALS.TOKEN().length()));
        } else if ((index = parameter.indexOf(TOKENS.EQUALS.TOKEN())) != -1 && index < parameter.length()) {
            return new ParsedParameter(parameter.substring(0, index),
                    TOKENS.EQUALS,
                    parameter.substring(index + TOKENS.EQUALS.TOKEN().length()));
        } else if ((index = parameter.indexOf(TOKENS.NOT_EQUALS.TOKEN())) != -1 && index < parameter.length()) {
            return new ParsedParameter(parameter.substring(0, index),
                    TOKENS.NOT_EQUALS,
                    parameter.substring(index + TOKENS.NOT_EQUALS.TOKEN().length()));
        } else if ((index = parameter.indexOf(TOKENS.SMALLER.TOKEN())) != -1 && index < parameter.length()) {
            return new ParsedParameter(parameter.substring(0, index),
                    TOKENS.SMALLER,
                    parameter.substring(index + TOKENS.SMALLER.TOKEN().length()));
        } else if ((index = parameter.indexOf(TOKENS.BIGGER.TOKEN())) != -1 && index < parameter.length()) {
            return new ParsedParameter(parameter.substring(0, index),
                    TOKENS.BIGGER,
                    parameter.substring(index + TOKENS.BIGGER.TOKEN().length()));
        }
        return null;
    }

    @Override
    public <T extends DealBean> Object getFieldValue(T item, final String fieldName) {
        DealBean object = item;
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log.warn(String.format("In %s field not found, going deeper", item.getClass().getName()));
            try {
                return getFlatFieldValue(fieldName, object.getFlat());
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                log.warn(String.format("In %s field not found, going deeper", item.getFlat().getClass().getName()));
                try {
                    return getRegionFieldValue(fieldName, object.getFlat().getFlatRegion());
                } catch (NoSuchFieldException | IllegalAccessException exx) {
                    log.error(String.format("In %s field not found", item.getFlat().getFlatRegion().getClass().getName()), exx);
                    return "";
                }
            }
        }
    }

    private Object getFlatFieldValue(String fieldName, FlatBean object) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(object);

    }

    private Object getRegionFieldValue(String fieldName, RegionBean object) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(object);
    }
}
