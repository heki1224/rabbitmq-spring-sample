package com.heki1224.sample.sender;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.heki1224.sample.bean.SampleQueueMessage;

@Service
public class AmqpSender {

	private static final Log LOG = LogFactory.getLog(AmqpSender.class);

	@Autowired
	@Qualifier("sampleQueueTemplate")
	private AmqpTemplate template;

	/**
	 * 
	 * @param message
	 */
	public void send(SampleQueueMessage message) {
		LOG.info("send message");
		template.convertAndSend(message);
	}
}
