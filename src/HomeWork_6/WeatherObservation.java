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
        String space = "    ";
        String day = String.format("Day: %4.1f, ", this.day);
        String sequence = String.format("Reading: %4.1f ", this.sequence);
        String temp = String.format(" [%-6.2f f]", this.temp);
        String pressure = String.format("[%-6.2f mb]", this.pressure);
        String dewPoint = String.format("[%-6.2f deg]", this.dewPoint);
        String wind = String.format("[%-6.2f mph]", this.wind);
        printMe = day + sequence + temp + space + pressure + space + dewPoint + space + wind;
        return printMe;
    }
}
