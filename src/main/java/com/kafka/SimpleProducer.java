package com.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * Created by zhang on 2015/7/16.
 */
public class SimpleProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("zk.connect", "Naruto.ccntgrid.zju.edu:2181");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "Naruto.ccntgrid.zju.edu:9092");
        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(config);
        for (int i = 0; i < 10; i++)
            producer.send(new KeyedMessage<String, String>("testapi", "hello" + i));
    }
}