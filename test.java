import java.util.ArrayList;


public class test {

    public static void main(String[] args) {

        ArrayList <Integer> digitList = new ArrayList<>();
        int num = 15704;
        int place = 0;
        while (num > 0){
            place++;
            digitList.add(0,num%10);
            num/=10;
        }
        System.out.println(place);
        System.out.println(num);
        
        for (int s = 0; s < place; s++){
            System.out.print(digitList.get(s) + ", ");
        }
    }
}
//testing
