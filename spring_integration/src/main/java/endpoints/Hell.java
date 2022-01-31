package endpoints;

import doman.People;
import doman.Soul;
import org.springframework.stereotype.Component;

@Component
public class Hell {
    public Soul died(People people) throws InterruptedException {
        System.out.println("death " + people.getName());
        Thread.sleep(3000);
        System.out.println(people.getName() + " enter in hell");
        return new Soul(people.getName());
    }
}

