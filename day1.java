import java.io.File; //Import the File Class
import java.io.FileNotFoundException; //Import this class to handle errors
import java.util.Scanner; //Import the Scanner class to read text files
import java.util.ArrayList;




public class MyClass {
  public static void main(String[] args) {
    ArrayList <Integer> caloriesTotal = new ArrayList<Integer>();
    int calories;
    int caloriesFirst = 0;
    int caloriesSecond = 0;
    int caloriesThird = 0;
    int caloriesMax = 0;
    String strLine;
    int i = 0;
    caloriesTotal.add(0);
    try {
      File myInput = new File("input.txt");
      Scanner myReader = new Scanner(myInput);
      while(myReader.hasNextLine()) {
        strLine = myReader.nextLine();
        
        if(strLine.length() < 1) {

          if (caloriesTotal.get(i) > caloriesFirst) {
            caloriesThird = caloriesSecond;
            caloriesSecond = caloriesFirst;
            caloriesFirst = caloriesTotal.get(i);
          }

          else if (caloriesTotal.get(i) > caloriesSecond && caloriesTotal.get(i) < caloriesFirst) {
            caloriesThird = caloriesSecond;
            caloriesSecond = caloriesTotal.get(i);
          }

          else if (caloriesTotal.get(i) > caloriesThird && caloriesTotal.get(i) < caloriesSecond) {
            caloriesThird = caloriesTotal.get(i);
          }

          i++;
          caloriesTotal.add(0);
        }
        else {
          calories = Integer.valueOf(strLine);
          caloriesTotal.set(i, calories + caloriesTotal.get(i));    
        }
      }
      myReader.close();
      System.out.println(caloriesTotal);
      caloriesMax = caloriesFirst + caloriesSecond + caloriesThird;
      System.out.println(caloriesMax);
    }
    catch (FileNotFoundException e) {
      System.out.println("An error ocurred.");
      e.printStackTrace();
    }
  }
}
