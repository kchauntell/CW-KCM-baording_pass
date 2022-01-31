public interface Price {
  default String message() {return "Thank you for purchasing a ticket";}
  default String message2() {return "You on getting there safely!";}

  default double price (int age, char gender) {
    double ticketPrice = 100.00;
    if(age <= 12) ticketPrice = ticketPrice / 2.00;
    if(age >= 60) ticketPrice = ticketPrice - (ticketPrice * 0.60);
    if(gender == 'F') ticketPrice = ticketPrice - (ticketPrice * 0.25);

    return ticketPrice;
  }


}
