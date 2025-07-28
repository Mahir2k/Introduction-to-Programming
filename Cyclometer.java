//The bike records datas of time elapsed in seconds and the number of rotation of the front wheel. We create variables in seconds and number of rotations. We use constants for conversion of units and get the required value.
// Mahir Ashab Enan, 09/05
// CSE7 Lab 02

public class Cyclometer {
    public static void main(String[] args){
        int secsTrip1=480; // Amount of seconds in Trip 1
        int secsTrip2=3220; //Amount of seconds in Trip 2
        int countsTrip1=1561; //Amount of rotation in Trip 1
        int countsTrip2=9037; //Amount of rotation in Trip 2

        double wheelDiameter=27.0, //diameter of wheel
        PI=3.14159, //value of pi
        feetPerMile=5280, //how many feet per mile
        inchesPerFoot=12, //how many inch per foot
        secondsPerMinute=60; //how many seconds in a minute
        double distanceTrip1, distanceTrip2, totalDistance; //The calculation of distance of Trip 1 & 2 as well as the total distance

        System.out.println("Trip 1 took "+ (secsTrip1/secondsPerMinute) + " minutes and had "+ countsTrip1 + "counts.");
        System.out.println("Trip 2 took "+ (secsTrip2/secondsPerMinute) + " minutes and had "+ countsTrip2 + " counts.");

        distanceTrip1 = countsTrip1*wheelDiameter*PI; //Distance of Trip 1 in inches
        distanceTrip1 /= inchesPerFoot*feetPerMile; //Distance of Trip 1 in miles
        distanceTrip2 = countsTrip2*wheelDiameter*PI/inchesPerFoot/feetPerMile; //Distance of Trip 2 in miles after converting from inches
        totalDistance = distanceTrip1+distanceTrip2; //Sum of Trip 1 and Trip 2

        System.out.println("Trip 1 was " + distanceTrip1 + " miles.");
        System.out.println("Trip 2 was " + distanceTrip2 + " miles.");
        System.out.println("The total distance was "+totalDistance+" miles.");
    }
}
