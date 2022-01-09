import doman.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.stereotype.Component;

@IntegrationComponentScan
@Component
@ComponentScan("endpoints")
@Configuration
@EnableIntegration
public class AppConfig {

    private Object people;

    @Bean
    public PublishSubscribeChannel itemChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean
    QueueChannel kindSoulChannel() {
        return MessageChannels.queue( 10 ).get();
    }

    @Bean
    QueueChannel NoKindSoulChannel() {
        return MessageChannels.queue( 10 ).get();
    }


    @Bean
    IntegrationFlow angel1Flow() {
        return IntegrationFlows.from("itemChannel")
                .filter(people->(((People)people).getIsKind().equals(false)))
                .handle("hell", "died")
                .channel("NoKindSoulChannel")
                .get();
    }
    @Bean
    IntegrationFlow angel2Flow() {
        return IntegrationFlows.from("itemChannel")
                .filter(people->(((People)people).getIsKind().equals(true)))
                .handle("paradise", "died")
                .channel("kindSoulChannel")
                .get();
    }


}

