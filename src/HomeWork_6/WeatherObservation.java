package HomeWork_6;
/* Author Name: Cody Bishop
   Date: 04/05/2020
   Program: WeatherObservationClass
   Description: A class Object to work in tandem with the WeatherApp. This class Object will contain the data involved
   in a weather observation.
*/
public class WeatherObservation {
    //Creation of all variables
    public double day;
    public double sequence;
    public double temp;
    public double wind;
    public double pressure;
    public double dewPoint;
    private static WeatherObservation[] obsArray = new WeatherObservation[100];
    public static int obsCount = 0;

    // Constructor
    private WeatherObservation(double temp, double pressure, double dewPoint, double wind, double day, double sequence) {
        this.temp = temp;
        this.pressure = pressure;
        this.dewPoint = dewPoint;
        this.wind = wind;
        this.day = day;
        this.sequence = sequence;
    }

    //Method used to create an object of the class WeatherObservation
    public static void generateObservation(double temp, double pressure,
                                           double dewPoint, double wind, double day, double sequence) {
        obsArray[obsCount] = new WeatherObservation(temp, pressure, dewPoint, wind, day, sequence);
        obsCount++;
    }

    //Method used to access the Array of Observation
    public static WeatherObservation getObservation(int i) {
        return obsArray[i];
    }

    // A method used to format and return a string to print for the observation readout
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
