package com.macys.macysorder;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
import com.macys.macysorder.service.UpdateOrderService;



@RunWith(SpringRunner.class)
//@WebMvcTest(OrderController.class)
@AutoConfigureMockMvc
@SpringBootTest
class MACYSOrderControllerTest {
	
	@MockBean
    UpdateOrderService orderMessageService;
	
	@Autowired
    private MockMvc mockMvc;

	@Test
    void testUpdateOrderStatus() throws Exception {
		
		//OrderMessageService orderMessageService = mock(OrderMessageService.class);
		//UpdateOrderStatusRequest updateOrderStatusRequest = mock(UpdateOrderStatusRequest.class);
		UpdateOrderStatusRequest updateOrderStatusRequest = new UpdateOrderStatusRequest();
		
		when(orderMessageService.updateOrder(updateOrderStatusRequest)).thenReturn(new ResponseEntity<>(true, HttpStatus.OK));
		
		mockMvc.perform(post("/macys/order/update")
                //.content(updateOrderStatusRequest.toString())
                .content(asJsonString(updateOrderStatusRequest))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        //.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
        .andDo(print());
		
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
