import java.util.Date;
import java.sql.Timestamp;

public class BoardingPass implements TestingInterface {
  int ticketNumber;
  Date date = new Date();
  String from;
  String to;
  public Timestamp departureTime;
  public Timestamp arrivalTime;
  public Timestamp boardingTime;


  BoardingPass (Date date, String from, String to) {
    this.date = date;
    this.from = from;
    this.to = to;
  }


  @Override
  public String toString() {
    return "Ticket Confirmed : " + date +
        "\nDepart From: " + from +
        "\nDeparture Time: " + departureTime +
        "\nEstimated Arrival Time: " + arrivalTime +
        "\nArriving at: " + to;
  }




  public static void main(String[] args){
    Date created = new Date();
    BoardingPass pass = new BoardingPass(created, "Richmond, VA", "Raleigh, NC");
    Client newClient = new Client("Kendricka", "Sonder", "ks@something.com", "9107291805", 'M', 45);
    System.out.println(pass + "\n" + pass.message() + "Your Ticket Price is " + pass.price(newClient.age, newClient.gender));
    System.out.println(pass.message2());

//    System.out.println(newClient);


  }
}
