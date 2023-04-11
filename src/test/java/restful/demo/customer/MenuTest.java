package restful.demo.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restful.demo.customer.object.Menu;
import restful.demo.customer.object.MenuItem;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;

public class MenuTest {

    @DisplayName("메뉴판에서 메뉴이름에 해당하는 메뉴를 반환한다.")
    @Test
    void chooseTest() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스",5000),new MenuItem("냉면",7000)));

        MenuItem menuItem = menu.choose("돈까스");

        // 객체들 끼리 비교는 equals hashCode
        assertThat(menuItem).isEqualTo(new MenuItem("돈까스",5000));
    }

    @DisplayName("메뉴판에 없는 메뉴를 선택할시 예외를 반환한다.")
    @Test
    void chooseTest2() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스",5000), new MenuItem("냉면",7000)));

        assertThatCode(()-> menu.choose("통닭"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 이름입니다.");
    }
}
