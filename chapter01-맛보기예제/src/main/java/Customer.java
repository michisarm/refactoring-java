import lombok.Getter;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    @Getter
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String _name) {
        this._name = _name;
    }
    public void addRental(Rental arg){
        _rentals.addElement(arg);
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = get_name() + " 고객님의 대여기록\n";
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + each.get_movie().get_title() + "\t" + each.getCharge() + "\n";
        }
        // 푸터 행 추가
        result += "누적 대여료: " + getTotalCharge() + "\n";
        result += "적립 포인트: " + getTotalFrequentRenterPoints() + "\n";

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }
}
