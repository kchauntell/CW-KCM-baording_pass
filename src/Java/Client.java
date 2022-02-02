

public class Client {
  String firstAndLastName;
  String email;
  String phoneNumber;
  char gender;
  int age;


  Client(String name, String email, String pN, char g, int age){

    if(!email.contains("@") || !email.contains(".com")) {
      throw new Error("Your email is not valid. Please enter valid email. ");
    }
    if(pN.length() != 10 && pN.length() != 7) {
      throw new Error("Your number is not a valid length. " +
          "\nUS numbers are: " +
          "\n    Local - 7 Digits;" +
          "\n    With area code: 10 digits.");
    }
    if((g != 'M' && g != 'F') || String.valueOf(g).equals("")) {
      throw new Error("You must enter a single character Value of 'M' for Male or 'F' for Female");
    }

    this.firstAndLastName = name;
    this.email = email;
    this.phoneNumber = pN;
    this.gender = g;
    this.age = age;

  }

  @Override
  public String toString() {
    return "Name: " + firstAndLastName +
        "\n Email: " + email +
        "\n Phone: " + phoneNumber +
        "\n Gender: " + gender +
        "\n Age: " + age;
  }

}
