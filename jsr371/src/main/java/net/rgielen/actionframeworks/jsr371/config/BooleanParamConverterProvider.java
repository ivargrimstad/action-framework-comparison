/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rgielen.actionframeworks.jsr371.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@Provider
public class BooleanParamConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {

        if (rawType.getName().equals(boolean.class.getName())) {

            return new ParamConverter<T>() {
                @Override
                public T fromString(String value) {
                    return (T) Boolean.valueOf(value != null && value.equals("on"));
                }

                @Override
                public String toString(T value) {
                    return (Boolean) value ? "on" : "";
                }
            };
            
        } else {
            return null;
        }
    }
}
