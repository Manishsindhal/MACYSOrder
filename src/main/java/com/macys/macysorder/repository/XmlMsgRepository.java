package com.macys.macysorder.repository;

import com.macys.macysorder.entity.xml.FulfillmentOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XmlMsgRepository extends JpaRepository<FulfillmentOrderEntity, Integer> {
}