package culture.learning.ci.steps;

import com.decathlon.tzatziki.steps.SpringJPASteps;
import com.decathlon.tzatziki.utils.Asserts;
import culture.learning.ci.FormationGherkinApplication;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;
import java.time.Duration;
import java.util.Map;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = RANDOM_PORT,
        classes = {FormationGherkinApplication.class})
@ContextConfiguration(initializers = TestFormationGherkinApplication.Initializer.class)
@Slf4j
public class TestFormationGherkinApplication {

    @Autowired
    private DataSource dataSource;

    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15.6")
            .withTmpFs(Map.of("/var/lib/postgresql/data", "rw")) // faster since it's all in memory
            .withDatabaseName("test").withUsername("test").withPassword("test");

    static {
        // change default values for await methods
        Asserts.defaultTimeOut = Duration.ofSeconds(3);
        Asserts.defaultPollInterval = Duration.ofMillis(200);
    }

    @Before
    public void before() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        TestHelper.reinitDb(jdbcTemplate, postgres.getDatabaseName());
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {

            postgres.start();

            log.info(String.format("Database config => bdd:%s, username:%s, mdp:%s",
                    postgres.getDatabaseName(), postgres.getUsername(), postgres.getPassword()));
            TestPropertyValues.of(
                            "spring.datasource.url=" + postgres.getJdbcUrl(),
                            "spring.datasource.username=" + postgres.getUsername(),
                            "spring.datasource.password=" + postgres.getPassword(),
                            "spring.flyway.schemas=" + postgres.getDatabaseName(),
                            "spring.jpa.properties.hibernate.default_schema=" + postgres.getDatabaseName()
                    )
                    .applyTo(applicationContext.getEnvironment());
            SpringJPASteps.autoclean = false;
        }
    }
}
