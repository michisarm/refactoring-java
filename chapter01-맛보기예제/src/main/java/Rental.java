import lombok.Getter;

@Getter
public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie _movie, int _daysRented) {
        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    double getCharge() {
        double result = 0;
        switch (get_movie().get_priceCode()) {
            case Movie.REGULAR:
                result += 2;
                if(get_daysRented() > 2)
                    result += (get_daysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += get_daysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if(get_daysRented() > 3)
                    result += (get_daysRented() - 3) * 1.5;
                break;
        }
        return result;
    }
}
