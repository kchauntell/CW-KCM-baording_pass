import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.sql.Timestamp;

import static java.lang.System.lineSeparator;

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
    Random num = new Random();
    int ticketNum = num.nextInt(1, 200000000);
    addToTicketFile(String.valueOf(ticketNum));
    return String.valueOf(ticketNum);
  }

  public void addToTicketFile (String ticNum) throws IOException{

      Files.write(Paths.get("verifyTicketNumber.txt"),
          (ticNum + lineSeparator()).getBytes(),
          StandardOpenOption.CREATE,
          StandardOpenOption.APPEND);
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

}
