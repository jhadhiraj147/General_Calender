import java.util.Scanner;
public class Calender {


    // Creating some useful data sets //
    static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static int[] days_in_months_normal_year = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] days_in_months_leap_year = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] weekdays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};




    // To check if or not a year is leap year //
    static boolean is_leap_year(long year) {
        if (year % 4 == 0) {

            if (year % 100 != 0 || (year % 400 == 0)) {
                return true;
            }
        }
    return false;}




    // To get the starting day of any month of any year starting 1800 AD //
    static int first_day_of_the_month(int year, int month) {
        int total_days = 0;
        for(int i = 1800; i < year; i++) {
            if (is_leap_year(i)) {
                total_days += 366;
            }
            else { total_days += 365; }
        }
        for (int j = 1; j < month; j++) {
            if (is_leap_year(year)) {
                total_days += days_in_months_leap_year[j - 1];
            }
            else {
                total_days += days_in_months_normal_year[j - 1];
            }
        }
        return ((total_days + 3) % 7);
    }




    // To get the number of days in any month of any year //
    static int no_of_days_in_the_selected_month(int year, int month) {
        if (is_leap_year(year)) {
            return days_in_months_leap_year[month - 1];
        }

        else { return days_in_months_normal_year[month - 1];}
    }



    // Our Main Method to handle all methods //
    public static void main(String[] args) {

        // Fetching user inputs //
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the year below: ");
        int year = input.nextInt();
        System.out.println("Now, Enter below the month (1 - 12) of the year");
        System.out.println("or Enter 13 to print Calender for the whole year: ");
        int month = input.nextInt();
        



        
       // To print all months of the selected year //
       if (month > 12 || month < 1) {
        for (int k = 1; k <= 12; k++) {
            // Formatting the output //
        int start_day = first_day_of_the_month(year, k);
        int total_days_in_month = no_of_days_in_the_selected_month(year, k);
        System.out.printf("--------------%-9s%5d-----------------",months[k - 1], year);
        System.out.println();
        for (int j = 0; j < weekdays.length; j++) {
            System.out.printf("%-7s", weekdays[j]);
        }
        System.out.println();
        for (int i = 0; i < start_day; i++){
            System.out.print("       ");
        }
        for (int i = 1; i <= total_days_in_month; i++){
            System.out.printf("%-7d", i);
            if ((start_day + i) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();

        }
       }






       // To print only specific month of the year entered //
       else {
        // Formatting the output //
        int start_day = first_day_of_the_month(year, month);
        int total_days_in_month = no_of_days_in_the_selected_month(year, month);
        System.out.printf("---------------%s   %d---------------",months[month - 1], year);
        System.out.println();
        for (int j = 0; j < weekdays.length; j++) {
            System.out.printf("%-7s", weekdays[j]);
        }
        System.out.println();
        for (int i = 0; i < start_day; i++){
            System.out.print("       ");
        }
        for (int i = 1; i <= total_days_in_month; i++){
            System.out.printf("%-7d", i);
            if ((start_day + i) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }
    }    
}
