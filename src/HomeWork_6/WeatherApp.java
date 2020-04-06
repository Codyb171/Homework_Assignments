package HomeWork_6;/* Author Name: Cody Bishop
   Date: 04/05/2020
   Program: WeatherApp
   Description:
*/

public class WeatherApp {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                WeatherObservation.generateObservation(genRan(120),
                        genRan(35.0), genRan(100.0), genRan(70), i, j);
            }
        }
        for (int i = 0; i < WeatherObservation.obsCount; i++) {
            System.out.println(WeatherObservation.getObservation(i).printDescription());
        }
    }

    public static double genRan(double upperRange) {
        return (Math.random() * (upperRange + 1.0));
    }
}
