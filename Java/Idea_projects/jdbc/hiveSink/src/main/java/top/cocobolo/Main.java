package top.cocobolo;

import com.alibaba.fastjson.JSON;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import java.util.Properties;

public class Main {
    private static final long interval = 30 * 1000;
    private static final int countThreshold = 500;


    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();



        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.229.129:9092");
        props.put("zookeeper.connect", "192.168.229.129:2181");
        props.put("group.id", "metric-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "latest");

        env.addSource(
            new FlinkKafkaConsumer<>(
                "transaction"
                ,new SimpleStringSchema()
                , props
            )
                .setStartFromLatest()
        )
            .setParallelism(1)
            .map(string -> JSON.parseObject(string, Transaction.class))
            .addSink(new HiveSinkBatch(countThreshold, interval)).setParallelism(1); //数据 sink 到 mysql

        env.execute("Flink add sink");
    }

}
