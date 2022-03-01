import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class CustomerTest {
    Customer customer;
    Movie movie;

    @BeforeEach
    @DisplayName("고객 생성")
    void createCustomer(){
        customer = new Customer("고객1");
        assertThat(customer.get_name()).isEqualTo("고객1");
    }

    @BeforeEach
    @DisplayName("영화 생성")
    void createMovie(){
        movie = new Movie("신규 영화", 1);
        assertThat(movie.get_title()).isEqualTo("신규 영화");
        assertThat(movie.get_priceCode()).isEqualTo(1);
    }

    @Test
    @DisplayName("영화 신규 대여")
    void rental(){
        Rental rental = new Rental(movie, 7);
        customer.addRental(rental);

        String result = customer.statement();
        assertThat(result).contains("누적 대여료: 21.0"); // 7 * 3
    }
}