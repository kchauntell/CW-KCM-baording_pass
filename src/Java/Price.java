import java.time.LocalDate;
import java.time.Period;

public interface Price {
  default String message() {return "Thank you for purchasing a ticket! ";}
  default String message2() {return "You are getting there safely!";}

  default double price (int age, char gender) {
    double ticketPrice = 100.00;
    if(age <= 12) ticketPrice = ticketPrice / 2.00;
    if(age >= 60) ticketPrice = ticketPrice - (ticketPrice * 0.60);
    if(gender == 'F') ticketPrice = ticketPrice - (ticketPrice * 0.25);
    return ticketPrice;
  }

  default int ageSetter(String day, String month, String year){
    int mnth = switch (month) {
      case "Jan" -> 1;
      case "Feb" -> 2;
      case "Mar" -> 3;
      case "Apr" -> 4;
      case "May" -> 5;
      case "Jun" -> 6;
      case "July" -> 7;
      case "Aug" -> 8;
      case "Sep" -> 9;
      case "Oct" -> 10;
      case "Nov" -> 11;
      case "Dec" -> 12;
      default -> Integer.parseInt(null);
    };
    int dayday = Integer.parseInt(day);
    int yea = Integer.parseInt(year);
    LocalDate today = LocalDate.now(); //Today's date
    LocalDate birthday = LocalDate.of(dayday, mnth, yea);
    Period p = Period.between(birthday, today); //Calculates the age
    return p.getYears();
  }

}
