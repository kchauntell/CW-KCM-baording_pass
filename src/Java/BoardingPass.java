import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import static java.lang.System.lineSeparator;

public class BoardingPass implements Price {
  String ticketNumber;
  Date date = new Date();
  String from;
  String to;
  String departureTime;
  public Timestamp arrivalTime;
  public Timestamp boardingTime;


  BoardingPass (Date date, String from, String to, String depart, ArrayList<String> ticketNum) throws IOException {
    this.date = date;
    this.from = from;
    this.to = to;
    this.ticketNumber = String.valueOf(ticketNum);
    this.departureTime = depart;
  }

  BoardingPass(){

  }

  public static String genTicNum() throws IOException {
    Random num = new Random();
    int ticketNum = num.nextInt(1, 200000000);
    addToTicketFile(String.valueOf(ticketNum));
    return String.valueOf(ticketNum);
  }

  public static void addToTicketFile(String ticNum) throws IOException{

      Files.write(Paths.get("verifyTicketNumber.txt"),
          (ticNum + lineSeparator()).getBytes(),
          StandardOpenOption.CREATE,
          StandardOpenOption.APPEND);

  }
  public static BoardingPass boardingTimes() throws IOException {
      BoardingPass bpETA = new BoardingPass();

      long current = System.currentTimeMillis();

      long minutesUntilBoarding = (long)(Math.random() * 30);

      long totalBoardingTime = 45;
      long flightLengthHours = (long)(Math.random() * 5 + 1);

      long boardingMills = current + minutesToMills(minutesUntilBoarding);
      long departure = boardingMills + minutesToMills(totalBoardingTime);
      long arrival = departure + hoursToMills(flightLengthHours);
      return null;
  }

    private static long minutesToMills(long minutes) {
        return TimeUnit.MINUTES.toMillis(minutes);
    }

    private static long hoursToMills(long hours) {
        return TimeUnit.HOURS.toMillis(hours);
    }

  @Override
  public String toString() {
    return "Ticket Confirmed : " + date +
        "\nDepart From: " + from +
        "\nDeparture Time: " + departureTime +
        "\nEstimated Arrival Time: " + arrivalTime +
        "\nArriving at: " + to +
        "\nYour Ticket Number(s) is : " + ticketNumber;
  }

}
