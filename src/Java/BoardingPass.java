import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.sql.Timestamp;

public class BoardingPass implements Price {
  String ticketNumber;
  Date date = new Date();
  String from;
  String to;
  public Timestamp departureTime;
  public Timestamp arrivalTime;
  public Timestamp boardingTime;


  BoardingPass (Date date, String from, String to) throws IOException {
    this.date = date;
    this.from = from;
    this.to = to;
    this.ticketNumber = genTicNum();
  }

  public String genTicNum () throws IOException {
    FileWriter fw = new FileWriter("verifyTicketNum.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);

    Random num = new Random();
    int ticketNum = num.nextInt(1, 2000);


    pw.println(ticketNum);
    pw.flush();
    return String.valueOf(ticketNum);
  }

  public void writeToAFile() throws IOException {
    Files.write(Paths.get("verifyTicketNum.txt"), this.ticketNumber.getBytes());
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


  public static void main(String[] args) throws IOException {
    Random ticketNumber = new Random(200);
    Date created = new Date();
    BoardingPass pass = new BoardingPass(created, "Richmond, VA", "Raleigh, NC");
    Client newClient = new Client("Kendricka", "Sonder", "ks@something.com", "9107291805", 'M', 45);
    System.out.println(pass + "\n" + pass.message() + "Your Ticket Price is " + pass.price(newClient.age, newClient.gender));
  }
}
