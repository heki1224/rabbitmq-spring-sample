package com.heki1224.sample;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heki1224.sample.bean.SampleQueueMessage;
import com.heki1224.sample.receiver.AmqpReceiver;
import com.heki1224.sample.sender.AmqpSender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"file:src/main/resources/spring/app-config.xml",
	"file:src/main/resources/spring/amqp-config.xml" })
public class AmqpSenderAndReceiverTest {

	@Autowired
	private AmqpSender sender;

	@Autowired
	private AmqpReceiver receiver;

	@Test
	public void test() {
		SampleQueueMessage message = new SampleQueueMessage();
		message.setId(1L);
		message.setName("hoge");
		message.setBirthday(new Date());

		sender.send(message);
		SampleQueueMessage result = receiver.receive();

		assertThat(result.getId(), is(message.getId()));
		assertThat(result.getName(), is(message.getName()));
		assertThat(result.getBirthday(), is(message.getBirthday()));
	}
}
