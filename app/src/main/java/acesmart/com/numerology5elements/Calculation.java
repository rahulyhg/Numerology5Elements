package acesmart.com.numerology5elements;

import java.util.Map;

/**
 * Created by mylaptop on 8/9/2016.
 */
public class Calculation {
    int day, month, year;
    NumberObject objNumber;
    int first, second, third, fourth;


    public Calculation (int Day, int Month, int Year){
        this.day = Day;
        this.month = Month;
        this.year = Year;

        objNumber = new NumberObject();

        parsingDate();
        formulaDateOfBirth();
    }

    public Calculation (int digit1, int digit2, int digit3, int digit4){
        this.first = digit1;
        this.second = digit2;
        this.third = digit3;
        this.fourth = digit4;

        objNumber = new NumberObject();
        objNumber.changeValue("I",first);
        objNumber.changeValue("J", second);
        objNumber.changeValue("K", third);
        objNumber.changeValue("L", fourth);

        formulaBasic();
        formulaHidden();
    }


    public Map<String, Integer> getMap(){
        return objNumber.numberObject;

    }

    private void parsingDate() {
        Integer tmp, tmp1;
        tmp = day /10;
        objNumber.changeValue("A",tmp);
        tmp = day % 10; objNumber.changeValue("B",tmp);

        tmp = month/10; objNumber.changeValue("C", tmp);
        tmp = month % 10; objNumber.changeValue("D", tmp);

        tmp = year/1000; objNumber.changeValue("E",tmp);
        tmp = year % 1000;
        if (tmp < 10){
            objNumber.changeValue("F",0);
            objNumber.changeValue("G",0);
            objNumber.changeValue("H", tmp);
            return;
        }
        if (tmp < 100){
            objNumber.changeValue("F",0);
            tmp1 = tmp / 10; objNumber.changeValue("G",tmp1);
            tmp = tmp % 10; objNumber.changeValue("H", tmp);
            return;
        }
        tmp1 = tmp;
        tmp = tmp1 / 100; objNumber.changeValue("F",tmp);
        tmp1 = tmp1 % 100;
        tmp = tmp1 / 10;objNumber.changeValue("G",tmp);
        tmp = tmp1 % 10;objNumber.changeValue("H",tmp);

    }


    private Integer addTwoNumbers(Integer i, Integer j){

        Integer sum = i + j;
        if (sum > 9)
        {
            Integer ii = sum / 10;
            Integer jj = sum % 10;
            sum = addTwoNumbers(ii,jj);
        }
        return sum;
    }

    private void formulaDateOfBirth(){
        Integer tmp;

        objNumber.changeValue("I", addTwoNumbers(objNumber.getValue("A"), objNumber.getValue("B")));
        objNumber.changeValue("J",addTwoNumbers(objNumber.getValue("C"),objNumber.getValue("D")));
        objNumber.changeValue("K",addTwoNumbers(objNumber.getValue("E"),objNumber.getValue("F")));
        if (objNumber.getValue("G") == 0 && objNumber.getValue("H") == 0)
            objNumber.changeValue("L",5);
        else
            objNumber.changeValue("L",addTwoNumbers(objNumber.getValue("G"),objNumber.getValue("H")));

        formulaBasic();
        formulaHidden();

    }

    private void formulaBasic(){
        objNumber.changeValue("M",addTwoNumbers(objNumber.getValue("I"),objNumber.getValue("J")));
        objNumber.changeValue("N",addTwoNumbers(objNumber.getValue("K"),objNumber.getValue("L")));

        objNumber.changeValue("O",addTwoNumbers(objNumber.getValue("M"),objNumber.getValue("N")));

        objNumber.changeValue("P",addTwoNumbers(objNumber.getValue("N"),objNumber.getValue("O")));
        objNumber.changeValue("Q",addTwoNumbers(objNumber.getValue("M"),objNumber.getValue("O")));

        objNumber.changeValue("R",addTwoNumbers(objNumber.getValue("P"),objNumber.getValue("Q")));

        objNumber.changeValue("S",addTwoNumbers(objNumber.getValue("J"),objNumber.getValue("M")));
        objNumber.changeValue("T",addTwoNumbers(objNumber.getValue("I"),objNumber.getValue("M")));
        objNumber.changeValue("U",addTwoNumbers(objNumber.getValue("S"),objNumber.getValue("T")));

        objNumber.changeValue("V",addTwoNumbers(objNumber.getValue("K"),objNumber.getValue("N")));
        objNumber.changeValue("W",addTwoNumbers(objNumber.getValue("L"),objNumber.getValue("N")));
        objNumber.changeValue("X",addTwoNumbers(objNumber.getValue("V"),objNumber.getValue("W")));

    }

    private void formulaHidden(){
        objNumber.changeValue("H1",addTwoNumbers(objNumber.getValue("J"),objNumber.getValue("K")));
        objNumber.changeValue("H2",addTwoNumbers(objNumber.getValue("I"),objNumber.getValue("J")));
        objNumber.changeValue("H2",addTwoNumbers(objNumber.getValue("H2"),objNumber.getValue("M")));
        objNumber.changeValue("H3",addTwoNumbers(objNumber.getValue("K"),objNumber.getValue("L")));
        objNumber.changeValue("H3",addTwoNumbers(objNumber.getValue("H3"),objNumber.getValue("N")));
        objNumber.changeValue("H4",addTwoNumbers(objNumber.getValue("M"),objNumber.getValue("N")));
        objNumber.changeValue("H4",addTwoNumbers(objNumber.getValue("H4"),objNumber.getValue("O")));
        objNumber.changeValue("H5",addTwoNumbers(objNumber.getValue("I"),objNumber.getValue("L")));
        objNumber.changeValue("H5",addTwoNumbers(objNumber.getValue("H5"),objNumber.getValue("O")));
    }

}
