package com.macys.macysorder.utils;

import com.macys.macysorder.dto.json.OrderMessageJson;
import com.macys.macysorder.dto.xml.FulfillmentOrder;
import com.macys.macysorder.entity.json.OrderMessageJsonEntity;
import com.macys.macysorder.entity.xml.FulfillmentOrderEntity;
import org.modelmapper.ModelMapper;

public class EntityPojoConverterUtil {

    public static OrderMessageJson jsonEntityToPojo(ModelMapper modelMapper, OrderMessageJsonEntity orderMessageJsonEntity) {
        return modelMapper.map(orderMessageJsonEntity, OrderMessageJson.class);
    }

    public static OrderMessageJsonEntity jsonPojoToEntity(ModelMapper modelMapper, OrderMessageJson orderMessageJson) {
        return modelMapper.map(orderMessageJson, OrderMessageJsonEntity.class);
    }

    public static FulfillmentOrderEntity xmlPojoToEntity(ModelMapper modelMapper, FulfillmentOrder fulfillmentOrder) {
        return modelMapper.map(fulfillmentOrder, FulfillmentOrderEntity.class);
    }

    public static FulfillmentOrder xmlEntityToPojo(ModelMapper modelMapper, FulfillmentOrderEntity fulfillmentOrderEntity) {
        return modelMapper.map(fulfillmentOrderEntity, FulfillmentOrder.class);
    }
}
