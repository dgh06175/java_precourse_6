package christmas.domain.events;

import static christmas.domain.testUtil.createBigOrder;
import static christmas.domain.testUtil.createSampleOrder2;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Date;
import christmas.domain.OrderedMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WeekEndEventTest {
    private WeekEndEvent event;
    private OrderedMenu bigOrder;
    private Date date;

    @BeforeEach
    void setGiveAwayEvent() {
        event = new WeekEndEvent();
        bigOrder = createBigOrder();
    }

    @DisplayName("주말 할인 이벤트 적용 검사")
    @ParameterizedTest
    @ValueSource(ints = {1, 9, 15, 23, 29, 30})
    void checkValidWeekEndEvent(int validDay) {
        date = new Date(validDay);
        int discount = event.getDiscountOf(date, bigOrder);

        assertThat(discount).isEqualTo(4 * 2023);
    }

    @DisplayName("주말 할인 이벤트 날짜 미적용 검사")
    @ParameterizedTest
    @ValueSource(ints = {4, 12, 17, 20, 24, 25, 28, 31})
    void checkInvalidDateWeekEndEvent(int invalidDay) {
        date = new Date(invalidDay);
        int discount = event.getDiscountOf(date, bigOrder);

        assertThat(discount).isEqualTo(0);
    }

    @DisplayName("주말 할인 이벤트 메뉴 미적용 검사")
    @Test
    void checkInvalidMenuWeekEndEvent() {
        OrderedMenu order = createSampleOrder2();
        date = new Date(16);
        int discount = event.getDiscountOf(date, order);

        assertThat(discount).isEqualTo(0);
    }
}
