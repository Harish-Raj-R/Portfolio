package com.harishraj.portfolio.model;

public class AgriTelemetry {
    private double nitrogen;    // mg/kg (0 - 140)
    private double phosphorus;  // mg/kg (0 - 140)
    private double potassium;   // mg/kg (0 - 200)
    private double soilMoisture;// % (0 - 100)
    private double ph;          // (0 - 14)
    private double temperature; // °C (10 - 45)
    private double humidity;    // % (10 - 100)
    private String soilType;    // "Clay", "Sandy", "Loamy", "Black", "Red"
    private String language;    // "en", "ta", "hi", "te"

    public AgriTelemetry() {}

    public AgriTelemetry(double nitrogen, double phosphorus, double potassium, double soilMoisture,
                         double ph, double temperature, double humidity, String soilType, String language) {
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
        this.soilMoisture = soilMoisture;
        this.ph = ph;
        this.temperature = temperature;
        this.humidity = humidity;
        this.soilType = soilType;
        this.language = language;
    }

    public double getNitrogen() { return nitrogen; }
    public void setNitrogen(double nitrogen) { this.nitrogen = nitrogen; }

    public double getPhosphorus() { return phosphorus; }
    public void setPhosphorus(double phosphorus) { this.phosphorus = phosphorus; }

    public double getPotassium() { return potassium; }
    public void setPotassium(double potassium) { this.potassium = potassium; }

    public double getSoilMoisture() { return soilMoisture; }
    public void setSoilMoisture(double soilMoisture) { this.soilMoisture = soilMoisture; }

    public double getPh() { return ph; }
    public void setPh(double ph) { this.ph = ph; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public double getHumidity() { return humidity; }
    public void setHumidity(double humidity) { this.humidity = humidity; }

    public String getSoilType() { return soilType; }
    public void setSoilType(String soilType) { this.soilType = soilType; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
}
