package com.staysync.usuarios.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.*;
import org.springframework.context.annotation.*;

@Configuration
public class RabbitMQConfig {

    public static final String NOTIFICACIONES_EXCHANGE = "staysync.notificaciones.exchange";

    @Bean
    public TopicExchange notificacionesExchange() {
        return ExchangeBuilder.topicExchange(NOTIFICACIONES_EXCHANGE).durable(true).build();
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
