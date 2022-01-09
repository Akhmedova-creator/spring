import doman.People;
import doman.Soul;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import java.util.concurrent.ForkJoinPool;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext ctx =new AnnotationConfigApplicationContext(AppConfig.class);
        Angel angel = ctx.getBean(Angel.class);
        ForkJoinPool pool = ForkJoinPool.commonPool();

        People people1 = new People("Jesika",true);
        while ( true ) {
            try {
                Thread.sleep( 7000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pool.execute( () -> {
                System.out.println( "New orderItems: " +people1);
                Soul soul = angel.process(people1);
                System.out.println( "Ready soul: " + soul);
            } );
        }
    }

}
