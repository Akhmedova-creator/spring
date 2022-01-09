import doman.People;
import doman.Soul;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface Angel {

    @Gateway(requestChannel = "itemChannel")
    Soul process (People people);

}
