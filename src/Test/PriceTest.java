import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PriceTest implements Price {


  @BeforeEach
  void setUp() {
  }

  @DisplayName("Test price method")
  @Test
  void price() throws Exception{
    assertEquals(50.0, price(10,'M'), "Should be half off the price.");
    assertEquals(40.0, price(66,'M'), "Should be 60% off for seniors");
    assertEquals(75.0,price(25,'F'), "Should be 25% off price for females.");
  }


  @DisplayName("Test ageSetter")
  @Test
  void ageSetter() {
    assertEquals(32, ageSetter("1989","Dec", "31"));
    assertEquals(31, ageSetter("1990", "July","2"));
  }

  @DisplayName("Test total price")
  @Test
  void totalPrice() {
    assertEquals(100.0, totalPrice(10,'M',"2"), "Should be 100 for 2 tickets");
    assertEquals(150.0, totalPrice(25,'F',"2"), "Should be 150 for 2 tickets");
    assertEquals(80.0, totalPrice(79,'M',"2"), "Should be 80 for 2 tickets");
  }


  @AfterEach
  void tearDown() {
  }
}