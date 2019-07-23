package top.cocobolo;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.Random;

/**
 * 向kafka中写数据
 * 可使用此main函数进行测试一下
 */

public class KafkaProduce {
    public static final String broker_list = "192.168.229.129:9092";
    public static final String topic = "transaction";  //kafka topic 需要和 flink 程序用同一个 topic

    public static void writeToKafka() throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", broker_list);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer producer = new KafkaProducer<String, String>(props);
        int totalTime = 40;
        int totalQuantity = 980;
        int shouldSleep = (int)(totalTime * 1000 / totalQuantity);
        int produceCounter = 0;
        while(produceCounter <= totalQuantity) {
            Transaction transaction = Transaction.getRandomTransaction();
            ProducerRecord record = new ProducerRecord<String, String>(topic, null, null, JSON.toJSONString(transaction));
            producer.send(record);
            String a = JSON.toJSONString(transaction);
            System.out.println("发送数据: " + a);
            Thread.sleep(shouldSleep);
            producer.flush();
            produceCounter+=1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        writeToKafka();
    }
}