package guru.springframework.msscbeerservice;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Modified by Pierrot on 2022-10-01.
 */
@SpringBootTest
public class MsscBeerServiceApplicationTests {

    @Test
    public void contextLoads(ApplicationContext appCtx) {
        assertThat(appCtx).isNotNull();
    }

}
