package restful.demo.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restful.demo.customer.object.Cook;
import restful.demo.customer.object.Cooking;
import restful.demo.customer.object.MenuItem;

import static org.assertj.core.api.Assertions.assertThat;

public class CookingTest {

    @Test
    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    void makeCookTest() {
        Cooking cooking = new Cooking();
        MenuItem menuItem = new MenuItem("돈까스",5000);

        Cook cook = cooking.makeCook(menuItem);

        // 객체들끼리 비교할때는 cook 객체에 equals and hashCode
        assertThat(cook).isEqualTo(new Cook("돈까스",5000));
    }
}
