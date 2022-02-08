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
  String boardAndArrivalTime;
//  public Timestamp boardingTime;


  BoardingPass (Date date, String from, String to, String depart, ArrayList<String> ticketNum, int hour, int min, String amPm) throws IOException {
    this.date = date;
    this.from = from;
    this.to = to;
    this.ticketNumber = String.valueOf(ticketNum);
    this.departureTime = depart;
    this.boardAndArrivalTime = boardingTimes(hour, min, amPm);
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
  public static String boardingTimes(int hour, int min, String amPm) throws IOException {

      long currentTime = minutesToMills(min) + hoursToMills(hour);


      long totalBoardingTime = minutesToMills(45);
      Random flight = new Random();
      long flightLengthHours = flight.nextInt(1,5);


      long boardingTimeMills = currentTime - totalBoardingTime;
      long boardMin = TimeUnit.MILLISECONDS.toMinutes(boardingTimeMills) % 60;
      long boardHour = TimeUnit.MILLISECONDS.toHours(boardingTimeMills);

      long arrival = currentTime + hoursToMills(flightLengthHours);
      long arrivalHour = TimeUnit.MILLISECONDS.toHours(arrival);
      long arrivalMin = TimeUnit.MILLISECONDS.toMinutes(arrival) % 60;

      if(arrivalHour > 12) {
          arrivalHour = arrivalHour - 12;
          if(amPm.equals("AM")) amPm = "PM";
          else amPm = "AM";

      };

      return "Boarding Time: " + boardHour + ":" + boardMin + " " + amPm +"\n" +
          "Arrival Time: " + arrivalHour + ":" + arrivalMin + " " + amPm ;
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
        "\n" + boardAndArrivalTime +
        "\nArriving at: " + to +
        "\nYour Ticket Number(s) is : " + ticketNumber;
  }

}
