import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    Date created = new Date();
    BoardingPass pass = new BoardingPass(created, "Richmond, VA", "Raleigh, NC");
    Client newClient = new Client("Kendricka", "Sonder", "ks@something.com", "9107291805", 'M', 45);
    System.out.println(pass + "\n" + pass.message() + "Your Ticket Price is " + pass.price(newClient.age, newClient.gender));

    List<String> files  =  Files.readAllLines(Paths.get("verifyTicketNumber.txt"));
    System.out.println(files);

  }
}
