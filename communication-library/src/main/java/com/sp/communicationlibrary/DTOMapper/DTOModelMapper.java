package com.sp.communicationlibrary.DTOMapper;
import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;

public class DTOModelMapper {
    
    public static <D> D map(Object source, Class<D> destinationType) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(source, destinationType);
    }
}
