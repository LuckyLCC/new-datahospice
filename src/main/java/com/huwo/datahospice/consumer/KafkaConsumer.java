package com.huwo.datahospice.consumer;

import com.huwo.datahospice.handler.HwBasicEventHandler;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-10-17  15:15
 */
@Component
public class KafkaConsumer {

    private ScheduledExecutorService service = Executors.newScheduledThreadPool(10);


    @KafkaListener(topics = {"lx-datahospice.liuchang.basic.quality"}, containerFactory = "kafkaListenerContainerFactory")
    public void basic(List<ConsumerRecord<String, byte[]>> recordList) {
        System.out.println("lx-datahospice.liuchang.basic.quality"+"======="+Thread.currentThread().getName());
        recordList.forEach((record) -> {
            service.execute(new HwBasicEventHandler(record.topic(), new String(record.value())));
        });
    }

    //不指定group，默认取yml里配置的
//    @KafkaListener(topics = {"lx-datahospice.1111order1.operate"}, containerFactory = "kafkaListenerContainerFactory")
    public void order(List<ConsumerRecord<String, byte[]>> recordList) {
        System.out.println("callmeappgps"+"======="+Thread.currentThread().getName());
        recordList.forEach((record) -> {
//            service.execute(new HwPositionEventHandler(record.topic(), new String(record.value())));
        });

    }

    //不指定group，默认取yml里配置的
//    @KafkaListener(topics = {"lx-datahospice.111position1"}, containerFactory = "kafkaListenerContainerFactory")
    public void position(List<ConsumerRecord<String, byte[]>> recordList) {
        System.out.println("callmeappgps"+"======="+Thread.currentThread().getName());
        recordList.forEach((record) -> {
//            service.execute(new HwPositionEventHandler(record.topic(), new String(record.value())));
        });

    }

}
