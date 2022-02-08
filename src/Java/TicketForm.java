import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import static java.lang.System.lineSeparator;



public class TicketForm extends JFrame implements ActionListener, Price {

  //Components of the Form
  private Container c;
  private JLabel title;
  private JLabel title2;
  private JLabel name;
  private JTextField tName;
  private JLabel email;
  private JTextField tEmail;
  private JLabel dob;
  private JComboBox date;
  private JComboBox month;
  private JComboBox year;
  private JLabel phoneNumber;
  private JTextField tPhoneNumber;
  private JLabel gender;
  private JRadioButton male;
  private JRadioButton female;
  private ButtonGroup genderGroup;
  private JLabel destination;
  private JComboBox destinationList;
  private JLabel boardingLocation;
  private JComboBox boardingLocationList;
  private JLabel numberOfTickets;
  private JSpinner numOfTicSpinner;
  private JCheckBox term;
  private JButton submit;
  private JButton reset;
  private JTextArea tout;
  private JLabel res;
  private JTextArea resadd;
  private JLabel departureTime;
  private JComboBox departureTimeList;
  private JComboBox ampmOption;
  private JLabel departureDate;
  private JButton pickDate;
  private JTextField departDate;
  private JLabel children;
  private JSpinner numOfChildren;
  private JLabel seniors;
  private JSpinner numOfSeniors;


  // method to bring up  and choose date...
  public void Picker() {
    JLabel label = new JLabel("Selected Date:");
    final JTextField text = new JTextField(20);
    JButton b = new JButton("Pull Up");
    JButton s = new JButton("Submit");
    JPanel p = new JPanel();
    p.add(label);
    p.add(text);
    p.add(b);
    p.add(s);
    final JFrame f = new JFrame();
    f.getContentPane().add(p);
    f.pack();
    f.setVisible(true);
    f.setResizable(false);
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
          text.setText(new DatePicker(f).setPickedDate());
      }
    });
    s.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent se) {
          departDate.setText(text.getText());
          f.setVisible(false);
      }
    });
  }


  // Date of Birth Data for ComboBox
  private String[] dates
      = { "1", "2", "3", "4", "5",
      "6", "7", "8", "9", "10",
      "11", "12", "13", "14", "15",
      "16", "17", "18", "19", "20",
      "21", "22", "23", "24", "25",
      "26", "27", "28", "29", "30",
      "31" };
  private String[] months
      = { "Jan", "Feb", "Mar", "Apr",
      "May", "Jun", "July", "Aug",
      "Sep", "Oct", "Nov", "Dec" };

  private String[] listOfYears = years();
  private String[] years () {
    ArrayList<String> listOfYears = new ArrayList<>();
    for(var i = 1950; i < 2022; i++) {
      listOfYears.add(String.valueOf(i));
    }
    String[] years = new String[listOfYears.size()];
      for(var i=0; i < years.length; i++) {
        for(var j =0; j < listOfYears.size(); j++) {
          years[i] = listOfYears.get(i);
        }
      }
    return years;
  };

  //Data for From and To Destinations;
  String[] destinations = {
      "Los Angeles, CA",
      "San Francisco, CA",
      "Chicago, IL",
      "Raleigh, NC",
      "Charlotte, NC",
      "Charleston, SC",
      "Myrtle Beach, SC",
      "Atlanta, GA",
      "Savannah, GA",
      "Miami, FL",
      "Orlando, FL",
      "New Orleans, LA",
      "Las Vegas, NV",
      "New York City, NY",
      "Houston, TX",
      "San Antonio, Texas",
      "Richmond, VA",
      "Hampton, VA"
  };
  String[] to = {
      "Los Angeles, CA",
      "San Francisco, CA",
      "Chicago, IL",
      "Raleigh, NC",
      "Charlotte, NC",
      "Charleston, SC",
      "Myrtle Beach, SC",
      "Atlanta, GA",
      "Savannah, GA",
      "Miami, FL",
      "Orlando, FL",
      "New Orleans, LA",
      "Las Vegas, NV",
      "New York City, NY",
      "Houston, TX",
      "San Antonio, Texas",
      "Richmond, VA",
      "Hampton, VA"
  };

  // for JSpinner
  String[] numberOfTics = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                           "13", "14", "15", "16", "17", "18", "19", "20"};
//  String[] numberOfTics2 = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
//                            "12", "13", "14", "15", "16", "17", "18", "19" };
  SpinnerListModel ticketNumModel = new SpinnerListModel(numberOfTics);
//  SpinnerListModel childNumModel = new SpinnerListModel(numberOfTics2);
//  SpinnerListModel seniorsNumModel = new SpinnerListModel(numberOfTics2);

  //for departure times
  String[] departTimes = {"12:00", "12:30", "01:00", "01:30", "02:00", "02:30", "03:00",
                          "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30",
                          "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00",
                          "10:30", "11:00", "11:30"};
  String[] amPM = {"AM", "PM"};

  //creating the form
  public TicketForm() {
    setTitle("Ced & Ken's Vibin' Ventures Travel Company");
    setBounds(300, 90, 900, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    c = getContentPane();
    c.setBackground(Color.darkGray);
    c.setLayout(null);

    title = new JLabel("Registration Form");
    title.setFont(new Font("Arial", Font.BOLD, 24));
    title.setForeground(new Color(34,205,247));
    title.setSize(300, 30);
    title.setLocation(150, 30);
    c.add(title);

    title2 = new JLabel("Receipt of Purchase");
    title2.setFont(new Font("Arial", Font.BOLD, 24));
    title2.setForeground(new Color(14,249,22));
    title2.setSize(300, 30);
    title2.setLocation(550, 30);
    c.add(title2);

    name = new JLabel("First and Last Name: ");
    name.setFont(new Font("Monospace", Font.PLAIN, 14));
    name.setForeground(new Color(34,205,247));
    name.setSize(200, 20);
    name.setLocation(100,100);
    c.add(name);

    tName = new JTextField();
    tName.setFont(new Font("Arial", Font.PLAIN, 12));
    tName.setSize(150, 20);
    tName.setLocation(245, 100);
    c.add(tName);

    email = new JLabel("Email: ");
    email.setFont(new Font("Monospace", Font.PLAIN, 14));
    email.setForeground(new Color(34,205,247));
    email.setSize(200, 20);
    email.setLocation(100, 125);
    c.add(email);

    tEmail = new JTextField();
    tEmail.setFont(new Font("Arial", Font.PLAIN, 12));
    tEmail.setSize(250, 20);
    tEmail.setLocation(150,125);
    c.add(tEmail);

    phoneNumber = new JLabel("Phone Number: ");
    phoneNumber.setFont(new Font("Monospace", Font.PLAIN, 14));
    phoneNumber.setForeground(new Color(34,205,247));
    phoneNumber.setSize(200, 20);
    phoneNumber.setLocation(100, 150);
    c.add(phoneNumber);

    tPhoneNumber = new JTextField();
    tPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
    tPhoneNumber.setSize(125,20);
    tPhoneNumber.setLocation(215,150);
    c.add(tPhoneNumber);

    gender = new JLabel("Gender");
    gender.setFont(new Font("Monospace", Font.PLAIN, 14));
    gender.setForeground(new Color(34,205,247));
    gender.setSize(100, 20);
    gender.setLocation(100, 175);
    c.add(gender);


    male = new JRadioButton("Male");
    male.setFont(new Font("Monospace", Font.PLAIN, 12));
    male.setForeground(new Color(34,205,247));
    male.setSelected(true);
    male.setSize(75, 20);
    male.setLocation(200, 175);
    c.add(male);

    female = new JRadioButton("Female");
    female.setFont(new Font("Monospace", Font.PLAIN, 12));
    female.setForeground(new Color(34,205,247));
    female.setSelected(false);
    female.setSize(80, 20);
    female.setLocation(275, 175);
    c.add(female);

    genderGroup = new ButtonGroup();
    genderGroup.add(male);
    genderGroup.add(female);

    dob = new JLabel("Date of Birth: ");
    dob.setFont(new Font("Monospace", Font.PLAIN, 14));
    dob.setForeground(new Color(34,205,247));
    dob.setSize(100, 20);
    dob.setLocation(100, 200);
    c.add(dob);

    date = new JComboBox(dates);
    date.setFont(new Font("Arial", Font.PLAIN, 12));
    date.setSize(75, 20);
    date.setLocation(200, 200);
    c.add(date);

    month = new JComboBox(months);
    month.setFont(new Font("Arial", Font.PLAIN, 12));
    month.setSize(100, 20);
    month.setLocation(275, 200);
    c.add(month);

    year = new JComboBox(listOfYears);
    year.setFont(new Font("Arial", Font.PLAIN, 12));
    year.setSize(100, 20);
    year.setLocation(375, 200);
    c.add(year);

    destination = new JLabel("Destination: ");
    destination.setFont(new Font("Monospace", Font.PLAIN, 14));
    destination.setForeground(new Color(34,205,247));
    destination.setSize(200, 20);
    destination.setLocation(100,225);
    c.add(destination);

    destinationList = new JComboBox(destinations);
    destinationList.setFont(new Font("Arial", Font.PLAIN, 12));
    destinationList.setSize(175, 20);
    destinationList.setLocation(225, 225);
    c.add(destinationList);

    boardingLocation = new JLabel("Boarding Location: ");
    boardingLocation.setFont(new Font("Monospace", Font.PLAIN, 14));
    boardingLocation.setForeground(new Color(34,205,247));
    boardingLocation.setSize(200, 20);
    boardingLocation.setLocation(100,250);
    c.add(boardingLocation);

    boardingLocationList = new JComboBox(to);
    boardingLocationList.setFont(new Font("Arial", Font.PLAIN, 12));
    boardingLocationList.setSize(175, 20);
    boardingLocationList.setLocation(225, 250);
    c.add(boardingLocationList);

    departureTime = new JLabel("Departure Time: ");
    departureTime.setFont(new Font("Arial", Font.PLAIN, 14));
    departureTime.setForeground(new Color(34,205,247));
    departureTime.setSize(150, 20);
    departureTime.setLocation(100, 275);
    c.add(departureTime);

    departureTimeList = new JComboBox(departTimes);
    departureTimeList.setFont(new Font("Arial", Font.PLAIN, 12));
    departureTimeList.setSize(100, 20);
    departureTimeList.setLocation(225, 275);
    c.add(departureTimeList);

    ampmOption = new JComboBox(amPM);
    ampmOption.setFont(new Font("Arial", Font.PLAIN, 12));
    ampmOption.setSize(75, 20);
    ampmOption.setLocation(325,275);
    c.add(ampmOption);

    numberOfTickets = new JLabel ("Total # of Tickets ");
    numberOfTickets.setFont(new Font("Monospace", Font.PLAIN, 14));
    numberOfTickets.setForeground(new Color(34,205,247));
    numberOfTickets.setSize(250, 20);
    numberOfTickets.setLocation(100,300);
    c.add(numberOfTickets);

    numOfTicSpinner = new JSpinner(ticketNumModel);
    numOfTicSpinner.setSize(50, 20);
    numOfTicSpinner.setLocation(225, 300);
    c.add(numOfTicSpinner);

//    children = new JLabel("# of Children under 12: ");
//    children.setFont(new Font("Monospace", Font.PLAIN, 14));
//    children.setForeground(new Color(34,205,247));
//    children.setSize(250, 20);
//    children.setLocation(100,325);
//    c.add(children);
//
//    numOfChildren = new JSpinner(childNumModel);
//    numOfChildren.setSize(50, 20);
//    numOfChildren.setLocation(270, 325);
//    c.add(numOfChildren);
//
//    seniors = new JLabel("# of Adults over 65: ");
//    seniors.setFont(new Font("Monospace", Font.PLAIN, 14));
//    seniors.setForeground(new Color(34,205,247));
//    seniors.setSize(250, 20);
//    seniors.setLocation(100,350);
//    c.add(seniors);
//
//    numOfSeniors = new JSpinner(seniorsNumModel);
//    numOfSeniors.setSize(50, 20);
//    numOfSeniors.setLocation(245, 350);
//    c.add(numOfSeniors);

    departureDate = new JLabel("Departure Date: ");
    departureDate.setFont(new Font("Monospace", Font.PLAIN, 14));
    departureDate.setForeground(new Color(34,205,247));
    departureDate.setSize(150, 20);
    departureDate.setLocation(100,325);
    c.add(departureDate);

    pickDate = new JButton("Pick Date");
    pickDate.setFont(new Font("Arial", Font.PLAIN, 14));
    pickDate.setSize(80, 20);
    pickDate.setLocation(350, 325);
    pickDate.addActionListener(this);
    c.add(pickDate);

    departDate = new JTextField();
    departDate.setFont(new Font("Arial", Font.PLAIN, 12));
    departDate.setSize(125,20);
    departDate.setLocation(215,325);
    c.add(departDate);

    term = new JCheckBox("Is you Vibin' with us or nah?");
    term.setFont(new Font("Arial", Font.PLAIN, 14));
    term.setForeground(new Color(34,205,247));
    term.setSize(250, 20);
    term.setLocation(150, 400);
    c.add(term);

    submit = new JButton("Submit");
    submit.setFont(new Font("Arial", Font.PLAIN, 14));
    submit.setSize(100, 20);
    submit.setLocation(150, 450);
    submit.addActionListener(this);
    c.add(submit);

    reset = new JButton("Reset");
    reset.setFont(new Font("Arial", Font.PLAIN, 14));
    reset.setSize(100, 20);
    reset.setLocation(275, 450);
    reset.addActionListener(this);
    c.add(reset);

    tout = new JTextArea();
    tout.setFont(new Font("Arial", Font.PLAIN, 15));
    tout.setSize(320, 400);
    tout.setLocation(500, 80);
    tout.setLineWrap(true);
    tout.setEditable(false);
//    c.add(tout);

    res = new JLabel("");
    res.setFont(new Font("Arial", Font.PLAIN, 20));
    res.setSize(500, 25);
    res.setLocation(100, 500);
//    c.add(res);

    resadd = new JTextArea();
    resadd.setFont(new Font("Arial", Font.PLAIN, 15));
    resadd.setSize(200, 75);
    resadd.setLocation(580, 175);
    resadd.setLineWrap(true);
//    c.add(resadd);


    setVisible(true);
  }

  //Setting new BoardingPass and Client information to class to add to file.
  public BoardingPass setBoardPass () throws IOException {
    ArrayList<String> ticketList = new ArrayList<String>();
    String amPm = (String)ampmOption.getSelectedItem();
    Date date;
    String from;
    String to;
    String depart;
    String tickets = (String) numOfTicSpinner.getValue();
    int ticketNum ;
    String time = (String) departureTimeList.getSelectedItem();
    String[] timeArr = time.split(":");
    int hour = Integer.parseInt(timeArr[0]);
    int min = Integer.parseInt(timeArr[1]);

    for(var i = 0; i < Integer.parseInt(tickets); i++) {
      ticketNum = Integer.parseInt(BoardingPass.genTicNum());
      ticketList.add(String.valueOf(ticketNum));
    }

    date = new Date();
    from = String.valueOf(boardingLocationList.getSelectedItem());
    to = String.valueOf(destinationList.getSelectedItem());
    depart = String.valueOf(departureTimeList.getSelectedItem()) + " " +
             String.valueOf(ampmOption.getSelectedItem());

    BoardingPass newBoardPass = new BoardingPass(date, from, to, depart,ticketList, hour, min, amPm);
    return newBoardPass;

  }
  public Client setNewClient() {
    String clientName;
    String clientEmail;
    String clientPhoneNumber;
    char clientGender;
    int clientAge;

    clientName = tName.getText();
    clientEmail = tEmail.getText();
    clientPhoneNumber = tPhoneNumber.getText();
    if (male.isSelected()) clientGender = 'M';
    else clientGender = 'F';
    clientAge = ageSetter((String) year.getSelectedItem(), (String) Objects.requireNonNull(month.getSelectedItem()), (String) date.getSelectedItem());

    Client newClient = new Client (clientName, clientEmail, clientPhoneNumber, clientGender, clientAge);
    return newClient;
  }

  //adding information to file.
  public void addToClientFile (String data) throws IOException {

    Files.write(Paths.get("clientList.txt"),
        (data + lineSeparator()).getBytes(),
        StandardOpenOption.CREATE,
        StandardOpenOption.APPEND);
  }

  //calculate total price
//  public double getTotalPrice() {
//    int numTotalTickets = (Integer)numOfTicSpinner.getValue();
//    int
//
//  }


  // Once Submit Button is hit....
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == pickDate) {
      Picker();
    }

    if (e.getSource() == submit) {

      if (term.isSelected()) {
        c.add(tout);
        c.add(res);
        c.add(resadd);

        String data1;
        char gender;
        String data
            = "Name : "
            + tName.getText() + "\n"
            + "Email : "
            + tEmail.getText() + "\n"
            + "Contact Number: "
            + tPhoneNumber.getText() + "\n";
        if (male.isSelected()) {
          gender = 'M';
          data1 = "Gender : Male"
              + "\n";
        }
        else {
          gender = 'F';
          data1 = "Gender : Female" +
              "\n";
        }
        String data2
            = "DOB : "
            + date.getSelectedItem()
            + "/" + month.getSelectedItem()
            + "/" + year.getSelectedItem()
            + "\n";
        String data3 =
            "Destination: " + destinationList.getSelectedItem() + "\n";
        String data4 =
            "Boarding Location: " + boardingLocationList.getSelectedItem() + "\n";
        String data5
            = "Departure Date: " + departDate.getText() + "\n";
        String data6
            = "Departure Time: " + departureTimeList.getSelectedItem() + " " + ampmOption.getSelectedItem() + "\n";
        String data7 =
            "You purchased " + numOfTicSpinner.getValue() + " ticket(s)" + "\n";

        //adding information to Client File.
        Client addClient = setNewClient();
        BoardingPass addBoardPass = null;
        try {
          addBoardPass = setBoardPass();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        try {
          addToClientFile(String.valueOf(addClient) + "\n" + String.valueOf(addBoardPass) +
              "\n" + "# Tickets Purchased: " + (String)numOfTicSpinner.getValue() +
              "\n" + "Total Price is: $" +
              totalPrice(ageSetter((String) year.getSelectedItem(), (String) Objects.requireNonNull(month.getSelectedItem()),
                  (String) date.getSelectedItem()), gender, (String)numOfTicSpinner.getValue()));
        } catch (IOException ex) {
          ex.printStackTrace();
        }


        StringBuilder data8 = new StringBuilder();
        String[] ticketNumArr = addBoardPass.ticketNumber.substring(1, addBoardPass.ticketNumber.length() - 1).split(", ");
        int count = 1;
        for (String s : ticketNumArr) {
          String answer = "Ticket " + count + " is: " + s + "\n";
          data8.append(answer);
          count++;
        }
        String data9
            = addBoardPass.boardAndArrivalTime + "\n";
        String data10
            = "Your Total Price is: $" +
            totalPrice(ageSetter((String) year.getSelectedItem(), (String) Objects.requireNonNull(month.getSelectedItem()),
                    (String) date.getSelectedItem()),
                    gender,
                    (String)numOfTicSpinner.getValue());

        tout.setText(data + data1 + data2 + data3 + data4 + data5 + data6 + data7 + data8 + data9 + data10);
        tout.setEditable(false);
        res.setText("Thank You! We ready to Vibe!");

      }
      else {
        tout.setText("");
        resadd.setText("");
        res.setText("Please accept the"
            + " terms & conditions...");
      }
    }

    else if (e.getSource() == reset) {
      String def = "";
      tName.setText(def);
      tEmail.setText(def);
      tPhoneNumber.setText(def);
      res.setText(def);
      tout.setText(def);
      term.setSelected(false);
      date.setSelectedIndex(0);
      month.setSelectedIndex(0);
      year.setSelectedIndex(0);
      resadd.setText(def);
      departDate.setText(def);
    }
  }
}
