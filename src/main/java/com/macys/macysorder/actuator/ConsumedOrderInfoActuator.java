package com.macys.macysorder.actuator;

import com.macys.macysorder.repository.JsonMsgRepository;
import com.macys.macysorder.repository.XmlMsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class ConsumedOrderInfoActuator implements InfoContributor {

	@Autowired
	JsonMsgRepository jsonMessageRepository;

	@Autowired
	XmlMsgRepository xmlMessageRepository;

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("Total count of XML Messages Consumed into database: ", xmlMessageRepository.count())
				.withDetail("Total count of JSON Messages Consumed into database: ", jsonMessageRepository.count()).build();
	}
}
