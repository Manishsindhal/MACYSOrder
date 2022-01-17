package com.macys.macysorder;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.macys.macysorder.dto.UpdateOrderStatusRequest;
import com.macys.macysorder.entity.xml.FulfillmentOrderEntity;
import com.macys.macysorder.repository.JsonMsgRepository;
import com.macys.macysorder.repository.XmlMsgRepository;
import com.macys.macysorder.service.UpdateOrderService;
import com.macys.macysorder.service.UpdateOrderServiceImpl;

@RunWith(SpringRunner.class)
//@WebMvcTest(OrderController.class)
@AutoConfigureMockMvc
@SpringBootTest
class UpdateOrderServiceImplTests {

	@Mock
	XmlMsgRepository xmlMessageRepository;

	@Mock
	JsonMsgRepository jsonMessageRepository;

	@MockBean
	UpdateOrderService updateOrderService;

	@Test
	void testUpdateOrderStatus() throws Exception {

		UpdateOrderStatusRequest updateOrderStatusRequest = new UpdateOrderStatusRequest();
		updateOrderStatusRequest.setId(1);
		updateOrderStatusRequest.setStatus("CONFIRMED");
		
		
		
		FulfillmentOrderEntity xmlEntity = xmlMessageRepository.getById(updateOrderStatusRequest.getId());
		//when(xmlEntity).thenReturn(new ResponseEntity<Boolean>(true, HttpStatus.OK));
		//when(xmlMessageRepository.getById(updateOrderStatusRequest.getId()).thenReturn(new ResponseEntity<>(true, HttpStatus.OK)));
		
		//ResponseEntity<Boolean> result = updateOrderService.updateOrder(updateOrderStatusRequest);
		
		//UpdateOrderService updateOrderService = new UpdateOrderServiceImpl();
		//updateOrderService.updateOrder(updateOrderStatusRequest);
		
		Assertions.assertEquals(xmlEntity.getId(), updateOrderStatusRequest.getId());
		

	}

//	UpdateOrderStatusRequest updateOrderStatusRequest = new UpdateOrderStatusRequest();
//	
//	FulfillmentOrderEntity xmlEntity = xmlMessageRepository.getById(updateOrderStatusRequest.getId());
//	//when(xmlEntity).thenReturn(new ResponseEntity<Boolean>(true, HttpStatus.OK));
//	ResponseEntity<Boolean> result = updateOrderService.updateOrder(updateOrderStatusRequest);
//	
//	Assertions.assertEquals(updateOrderService.updateOrder(updateOrderStatusRequest), result);

}
