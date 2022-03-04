import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository repository) {
        return (args) -> {
            // save a few BuddyInfos
            repository.save(new BuddyInfo("Jack", "3539535234"));
            repository.save(new BuddyInfo("Chloe", "435325454353"));
            repository.save(new BuddyInfo("Kim", "354254534543535"));
            repository.save(new BuddyInfo("David", "3458304859898"));
            repository.save(new BuddyInfo("Michelle", "374095739459"));

            // fetch all BuddyInfos
            log.info("BuddyInfos found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddyInfo : repository.findAll()) {
                log.info(buddyInfo.toString());
            }
            log.info("");

            // fetch an individual buddyInfo by ID
            BuddyInfo buddyInfo = repository.findById(1L);
            log.info("BuddyInfo found with findById(1L):");
            log.info("--------------------------------");
            log.info(buddyInfo.toString());
            log.info("");
        };
    }
}
