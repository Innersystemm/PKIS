package com.spring.rest.client.service;

import com.spring.rest.client.bean.DealBean;
import com.spring.rest.client.bean.ParsedParameter;

public interface ParameterParserService {
    ParsedParameter parseParameter(final String parameter);

    <T extends DealBean> Object getFieldValue(T item, final String fieldName);

    default boolean compare(double first, double second, ParameterParserServiceImpl.TOKENS token) {
        switch (token) {
            case BIGGER: {
                return first > second;
            }
            case EQUALS: {
                return first == second;
            }
            case SMALLER: {
                return first < second;
            }
            case NOT_EQUALS: {
                return first != second;
            }
            case BIGGER_OR_EQUALS: {
                return first >= second;
            }
            case SMALLER_OR_EQUALS: {
                return first <= second;
            }
            default: {
                throw new IllegalArgumentException("Invalid token");
            }
        }
    }

    default boolean compare(String first, String second, ParameterParserServiceImpl.TOKENS token) {
        switch (token) {
            case BIGGER: {
                return false;
            }
            case EQUALS: {
                return first.equalsIgnoreCase(second);
            }
            case SMALLER: {
                return false;
            }
            case NOT_EQUALS: {
                return !first.equalsIgnoreCase(second);
            }
            case BIGGER_OR_EQUALS: {
                return false;
            }
            case SMALLER_OR_EQUALS: {
                return false;
            }
            default: {
                throw new IllegalArgumentException("Invalid token");
            }
        }
    }
}
