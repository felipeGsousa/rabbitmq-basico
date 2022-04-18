import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Produtor {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.newConnection();
             Channel canal = connection.createChannel();
        ) {
            /*
            String mensagem = "Olá";

            //(queue, passive, durable, exclusive, autoDelete, arguments)
            canal.queueDeclare(NOME_FILA, false, false, false, null);

            // ​(exchange, routingKey, mandatory, immediate, props, byte[] body)
            canal.basicPublish("", NOME_FILA, false, false, null, mensagem.getBytes());
            */
            String NOME_FILA = "plica";
            String qName = canal.queueDeclare(NOME_FILA, false, false, false, null).getQueue();
            String mensagem = "Felipe Galdino de Sousa";
            BasicProperties properties = new BasicProperties.Builder().replyTo(qName).build();

            canal.basicPublish("", NOME_FILA, properties, mensagem.getBytes());
        }
    }
}


