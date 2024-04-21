package sample.cafekiosk.spring.domain.stock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @DisplayName("재고의 수량이 제공된 수량보다 작은지 확인한다.")
    @Test
    void isQuantityLessThan() {
        Stock stock = Stock.create("001", 1);
        int quantity = 2;

        boolean result = stock.isQuantityLessThan(quantity);

        assertThat(result).isTrue();
    }

    @DisplayName("재고의 주어진 개수만큼 차감할 수 있다.")
    @Test
    void deductQuantity() {
        Stock stock = Stock.create("001", 2);
        int quantity = 1;

        stock.deductQuantity(quantity);

        assertThat(stock.getQuantity()).isEqualTo(1);
    }

    @DisplayName("재고보다 많은 수의 수량으로 차감을 시도하면 예외가 발생한다.")
    @Test
    void deductQuantity2() {
        Stock stock = Stock.create("001", 0);
        int quantity = 1;

        assertThatThrownBy(() -> stock.deductQuantity(quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("재고가 부족한 상품이 있습니다.");

    }
}