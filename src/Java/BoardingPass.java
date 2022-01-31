import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.io.File;

public class BoardingPass implements Price {
  String ticketNumber;
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
    this.ticketNumber = genTicNum();
  }

  public String genTicNum () {
    Random num = new Random();
    int ticketNum = num.nextInt(1, 2000);
    return String.valueOf(ticketNum);
  }


  public void writeToAFile() throws IOException {
    Files.write(Paths.get("verifyTicketNum.txt"), genTicNum().getBytes());
  }


  @Override
  public String toString() {
    return "Ticket Confirmed : " + date +
        "\nDepart From: " + from +
        "\nDeparture Time: " + departureTime +
        "\nEstimated Arrival Time: " + arrivalTime +
        "\nArriving at: " + to +
        "\nYour Ticket Number is : " + ticketNumber;
  }


  public static void main(String[] args){
    Random ticketNumber = new Random(200);
    Date created = new Date();
    BoardingPass pass = new BoardingPass(created, "Richmond, VA", "Raleigh, NC");
    Client newClient = new Client("Kendricka", "Sonder", "ks@something.com", "9107291805", 'M', 45);
    System.out.println(pass + "\n" + pass.message() + "Your Ticket Price is " + pass.price(newClient.age, newClient.gender));
  }
}
