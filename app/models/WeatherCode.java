package models;


//A class to take the code parameter and set the description based on what code is entered.

public class WeatherCode {
    private int code;
    private String description;

    //constructor to use the code to set the description using a getter
    public WeatherCode(int code){
        this.code = code;
        this.description = getDescription(code);
    }

    //getters
    public int getCode(){
        return code;
    }
    public String getDescription(){
        return this.description;
    }
    private String getDescription(int code){
        switch(code){
            case 100:
                return "Clear";
            case 200:
                return "Partial Clouds";
            case 300:
                return "Cloudy";
            case 400:
                return "Light Showers";
            case 500:
                return "Heavy Showers";
            case 600:
                return "Rain";
            case 700:
                return "Snow";
            case 800:
                return "Thunder";
            default:
                return "Unknown";

        }
    }
}
