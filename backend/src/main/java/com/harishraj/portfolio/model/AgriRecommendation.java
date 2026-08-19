package com.harishraj.portfolio.model;

import java.util.List;

public class AgriRecommendation {
    private String recommendedCrop;
    private double confidenceScore;
    private String rationale;
    private String fertilizerAdvice;
    private String irrigationSchedule;
    private String climateSuitability;
    private List<String> localizedTips;
    private String predictedYield;

    public AgriRecommendation() {}

    public AgriRecommendation(String recommendedCrop, double confidenceScore, String rationale,
                              String fertilizerAdvice, String irrigationSchedule, String climateSuitability,
                              List<String> localizedTips, String predictedYield) {
        this.recommendedCrop = recommendedCrop;
        this.confidenceScore = confidenceScore;
        this.rationale = rationale;
        this.fertilizerAdvice = fertilizerAdvice;
        this.irrigationSchedule = irrigationSchedule;
        this.climateSuitability = climateSuitability;
        this.localizedTips = localizedTips;
        this.predictedYield = predictedYield;
    }

    public String getRecommendedCrop() { return recommendedCrop; }
    public void setRecommendedCrop(String recommendedCrop) { this.recommendedCrop = recommendedCrop; }

    public double getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(double confidenceScore) { this.confidenceScore = confidenceScore; }

    public String getRationale() { return rationale; }
    public void setRationale(String rationale) { this.rationale = rationale; }

    public String getFertilizerAdvice() { return fertilizerAdvice; }
    public void setFertilizerAdvice(String fertilizerAdvice) { this.fertilizerAdvice = fertilizerAdvice; }

    public String getIrrigationSchedule() { return irrigationSchedule; }
    public void setIrrigationSchedule(String irrigationSchedule) { this.irrigationSchedule = irrigationSchedule; }

    public String getClimateSuitability() { return climateSuitability; }
    public void setClimateSuitability(String climateSuitability) { this.climateSuitability = climateSuitability; }

    public List<String> getLocalizedTips() { return localizedTips; }
    public void setLocalizedTips(List<String> localizedTips) { this.localizedTips = localizedTips; }

    public String getPredictedYield() { return predictedYield; }
    public void setPredictedYield(String predictedYield) { this.predictedYield = predictedYield; }
}
