/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pb.converter;

import javax.persistence.Converter;
import javax.persistence.AttributeConverter;

/**
 *
 * @author macxi
 */
@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Boolean value) {
        return (Boolean.TRUE.equals(value) ? 1 : 0);
    }

    @Override
    public Boolean convertToEntityAttribute(Integer value) {
        return (1 == value);
    }
    
}
