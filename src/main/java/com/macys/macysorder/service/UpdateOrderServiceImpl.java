package com.macys.macysorder.service;

import com.macys.macysorder.dto.OrderStatus;
import com.macys.macysorder.dto.UpdateOrderStatusRequest;
import com.macys.macysorder.entity.json.OrderMessageJsonEntity;
import com.macys.macysorder.entity.xml.FulfillmentOrderEntity;
import com.macys.macysorder.exxception.CustomException;
import com.macys.macysorder.repository.JsonMsgRepository;
import com.macys.macysorder.repository.XmlMsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@Service
public class UpdateOrderServiceImpl implements UpdateOrderService {

    @Autowired
    XmlMsgRepository xmlMessageRepository;

    @Autowired
    JsonMsgRepository jsonMessageRepository;

    @ExceptionHandler(CustomException.class)
    @Override
    public ResponseEntity<Boolean> updateOrder(UpdateOrderStatusRequest updateOrderStatusRequest) {
        try {
            FulfillmentOrderEntity xmlEntity = xmlMessageRepository.getById(updateOrderStatusRequest.getId());
            return updateXmlOrder(xmlEntity, updateOrderStatusRequest);
        } catch (EntityNotFoundException e) {
            try {
                OrderMessageJsonEntity jsonEntity = jsonMessageRepository.getById(updateOrderStatusRequest.getId());
                return updateJsonOrder(jsonEntity, updateOrderStatusRequest);
            } catch (EntityNotFoundException ex) {
                throw new CustomException();
            }
        }
    }

    private ResponseEntity<Boolean> updateXmlOrder(FulfillmentOrderEntity entity, UpdateOrderStatusRequest updateOrderStatusRequest) throws EntityNotFoundException {
        entity.setOrderStatus(OrderStatus.valueOf(updateOrderStatusRequest.getStatus().toUpperCase()));
        xmlMessageRepository.save(entity);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> updateJsonOrder(OrderMessageJsonEntity jsonEntity, UpdateOrderStatusRequest updateOrderStatusRequest) throws EntityNotFoundException {
        jsonEntity.setOrderStatus(OrderStatus.valueOf(updateOrderStatusRequest.getStatus().toUpperCase()));
        jsonMessageRepository.save(jsonEntity);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
