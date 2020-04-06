package HomeWork_6;
/* Author Name: Cody Bishop
   Date: 04/05/2020
   Program: WeatherObservationClass
   Description: A class Object to work in tandem with the WeatherApp.
*/
public class WeatherObservation {
    public double day;
    public double sequence;
    public double temp;
    public double wind;
    public double pressure;
    public double dewPoint;
    private static WeatherObservation[] obsArray = new WeatherObservation[100];
    public static int obsCount = 0;

    private WeatherObservation(double temp, double pressure, double dewPoint, double wind, double day, double sequence) {
        this.temp = temp;
        this.pressure = pressure;
        this.dewPoint = dewPoint;
        this.wind = wind;
        this.day = day;
        this.sequence = sequence;
    }

    public static void generateObservation(double temp, double pressure,
                                           double dewPoint, double wind, double day, double sequence) {
        obsArray[obsCount] = new WeatherObservation(temp, pressure, dewPoint, wind, day, sequence);
        obsCount++;
    }

    public static WeatherObservation getObservation(int i) {
        return obsArray[i];
    }

    public String printDescription() {
        String printMe;
        printMe = String.format("Day: %3.1d, Reading: %-5.1d [%-5.2d f]%3s[%-4.2d mb]%3s[%-5.2d deg]%3s[%-4.2d mph]"
                , this.day, this.sequence, this.temp, " ", this.pressure, " ", this.dewPoint, " ", this.wind);
        return printMe;
    }
}
