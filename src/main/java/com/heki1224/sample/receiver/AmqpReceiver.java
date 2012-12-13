package com.heki1224.sample.receiver;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.heki1224.sample.bean.SampleQueueMessage;

@Service
public class AmqpReceiver {

	@Autowired
	@Qualifier("sampleQueueTemplate")
	private AmqpTemplate template;

	/**
	 * 
	 * @return
	 */
	public SampleQueueMessage receive() {
		return (SampleQueueMessage) template.receiveAndConvert();
	}

}
