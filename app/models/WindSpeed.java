package models;

//class to describe the wind speed based on the beaufort scale
public class WindSpeed {
    private float speed;

    //constructor to set the value of the wind speed
    public WindSpeed(float speed) {
        this.speed = speed;
    }

    //getter
    public float getSpeed() {
        return speed;
    }

    //return string based value using if else statements
    public static String convertToBeaufortScale(float windSpeed) {
       int beaufortNum = 0;

        if (windSpeed < 1) {
            return "Calm (0 bft)";
        } else if (windSpeed >= 1 && windSpeed <= 5) {
            return "Light Air (1 bft)";
        } else if (windSpeed >= 6 && windSpeed <= 11) {
            return "Light Breeze (2 bft)";
        } else if (windSpeed >= 12 && windSpeed <= 19) {
            return "Gentle Breeze (3 bft)";
        } else if (windSpeed >= 20 && windSpeed <= 28) {
            return "Moderate Breeze (4 bft)";
        } else if (windSpeed >= 29 && windSpeed <= 38) {
            return "Fresh Breeze (5 bft)";
        } else if (windSpeed >= 39 && windSpeed <= 49) {
            return "Strong Breeze (6 bft)";
        } else if (windSpeed >= 50 && windSpeed <= 61) {
            return "Near Gale (7 bft)";
        } else if (windSpeed >= 62 && windSpeed <= 74) {
            return "Gale (8 bft)";
        } else if (windSpeed >= 75 && windSpeed <= 88) {
            return "Severe Gale (9 bft)";
        } else if (windSpeed >= 89 && windSpeed <= 102) {
            return "Strong Storm (10 bft)";
        } else if (windSpeed >= 103 && windSpeed <= 117) {
            return "Violent Storm (11 bft)";
        } else {
            return "Hurricane";
        }
    }

}
