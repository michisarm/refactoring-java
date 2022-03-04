import lombok.Getter;
import lombok.Setter;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    @Getter
    private String _title;

    private Price _price;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        set_priceCode(_priceCode);
    }

    public int get_priceCode() {
        return _price.getPriceCode();
    }

    private void set_priceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("가격 코드가 잘못됐습니다.");
        }
    }

    double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        // 최신물을 이틀 이상 대여하면 2포인트 지급하고 그 외엔 1포인트 지급하는 코드를
        // 빼내 getFrequentRenterPoints 메서드로 만들고 이 Rental 클래스로 옮겼다.
        if((get_priceCode() == Movie.NEW_RELEASE) && daysRented > 1)
            return 2;
        else
            return 1;
    }
}
