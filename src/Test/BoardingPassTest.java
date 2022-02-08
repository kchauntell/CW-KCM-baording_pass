import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BoardingPassTest {
  ArrayList<String> ticNum = new ArrayList<String>(Collections.singleton("1"));
  BoardingPass boardPass = new BoardingPass(new Date(), "Atlanta, GA", "Richmond, VA", "2:30", ticNum, 4, 30, "AM" );

  BoardingPassTest() throws IOException {
  }

  @BeforeEach
  void setUp() throws IOException {
//    ArrayList<String> ticNum = new ArrayList<String>(Collections.singleton("1"));
//    BoardingPass boardPass = new BoardingPass(new Date(), "Atlanta, GA", "Richmond, VA", "2:30", ticNum, 4, 30, "AM" );
  }

  @DisplayName("Test genTicNum()")
  @Test
  void genTicNum() throws IOException {
   assertNotNull(BoardingPass.genTicNum());
  }

  @DisplayName("Test addToTicketFile")
  @Test
  void addToTicketFile() throws IOException {
    BoardingPass.addToTicketFile(BoardingPass.genTicNum());
  }

  @DisplayName("Testing boardingTimes")
  @Test
  void boardingTimes() throws IOException {
    assertNotNull(BoardingPass.boardingTimes(4,30,"Am"));
  }

  @AfterEach
  void tearDown() {
  }

}