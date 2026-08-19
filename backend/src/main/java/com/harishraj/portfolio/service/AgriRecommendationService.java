package com.harishraj.portfolio.service;

import com.harishraj.portfolio.model.AgriRecommendation;
import com.harishraj.portfolio.model.AgriTelemetry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgriRecommendationService {

    public AgriRecommendation predictOptimalCrop(AgriTelemetry telemetry) {
        double n = telemetry.getNitrogen();
        double p = telemetry.getPhosphorus();
        double k = telemetry.getPotassium();
        double ph = telemetry.getPh();
        double moisture = telemetry.getSoilMoisture();
        double temp = telemetry.getTemperature();
        String lang = telemetry.getLanguage() != null ? telemetry.getLanguage().toLowerCase() : "en";

        String crop = "Paddy / Rice (Oryza sativa)";
        double confidence = 0.94;
        String rationale = "High moisture (" + moisture + "%) and balanced NPK profile (" + n + "-" + p + "-" + k + ") provide optimal vegetative conditions.";
        String fertilizer = "Apply Urea @ 120 kg/ha in 3 split doses; MOP @ 50 kg/ha at basal.";
        String irrigation = "Continuous shallow submergence (2-5 cm) during tillering; drain 10 days before harvest.";
        String climate = "Tropical warm climate (" + temp + "°C) with adequate humidity is ideal.";
        String yield = "4.8 - 5.5 Metric Tonnes / Hectare";

        List<String> tips = new ArrayList<>();

        if (n > 80 && p > 50 && k > 60 && moisture > 65) {
            crop = "Paddy / Rice (Kharif/Rabi)";
            confidence = 0.96;
            tips.add("Optimal water retention detected. Monitor for stem borer.");
            tips.add("Maintain standing water level of 3cm during panicle initiation.");
        } else if (temp > 28 && moisture < 45 && ph >= 6.0 && ph <= 7.5) {
            crop = "Groundnut / Peanut (Arachis hypogaea)";
            confidence = 0.92;
            rationale = "Warm temperature (" + temp + "°C) and moderate moisture (" + moisture + "%) promote peg penetration and pod development.";
            fertilizer = "Single super phosphate (SSP) @ 250 kg/ha + Gypsum @ 400 kg/ha at flowering.";
            irrigation = "Critical watering at flowering and peg formation stages.";
            climate = "Semi-arid to sub-tropical condition is optimal.";
            yield = "2.2 - 2.8 Metric Tonnes / Hectare";
            tips.add("Incorporate gypsum during earthing-up stage to boost calcium for pod filling.");
            tips.add("Avoid waterlogging to protect against root rot.");
        } else if (n >= 60 && p >= 40 && temp >= 22 && temp <= 32) {
            crop = "Maize / Corn (Zea mays)";
            confidence = 0.93;
            rationale = "Nutrient-rich soil with N=" + n + " and P=" + p + " accelerates silking and tassel development.";
            fertilizer = "NPK 120:60:40 kg/ha with micronutrient zinc sulphate @ 25 kg/ha.";
            irrigation = "Irrigate at knee-high, tasseling, and grain filling stages.";
            climate = "Requires plenty of sunlight and moderate humidity.";
            yield = "6.0 - 7.2 Metric Tonnes / Hectare";
            tips.add("Check soil aeration and apply zinc if leaves show interveinal chlorosis.");
        } else if (moisture < 35) {
            crop = "Pearl Millet / Bajra (Pennisetum glaucum)";
            confidence = 0.91;
            rationale = "Low soil moisture (" + moisture + "%) and drought resilience makes Millet the highest return crop.";
            fertilizer = "Basal application of DAP @ 50 kg/ha and Urea @ 40 kg/ha top dress.";
            irrigation = "Drought tolerant; 1-2 supplemental irrigations at flowering stage.";
            climate = "Thrives in dry, warm climatic conditions.";
            yield = "2.5 - 3.2 Metric Tonnes / Hectare";
            tips.add("Excellent crop for low water availability and high thermal tolerance.");
        } else {
            crop = "Cotton / Sugarcane";
            confidence = 0.89;
            tips.add("Soil pH of " + ph + " is suitable for deep root aeration.");
            tips.add("Implement drip fertigation to conserve 40% water.");
        }

        // Multilingual localized recommendations (English, Tamil, Hindi, Telugu)
        if ("ta".equals(lang)) {
            rationale = "[தமிழ்] மண் சத்து அளவுகள் (N: " + n + ", P: " + p + ", K: " + k + ") மற்றும் ஈரப்பதம் (" + moisture + "%) அடிப்படையில் பயிர் தேர்வு செய்யப்பட்டது.";
            fertilizer = "[தமிழ்] யூரியா மற்றும் பொட்டாஷ் சரியான நேரத்தில் இடவும். உயிர் உரங்கள் பயன்படுத்தவும்.";
            irrigation = "[தமிழ்] பயிர் வளர்ச்சி மற்றும் பூக்கும் பருவத்தில் சீரான நீர்ப்பாசனம் உறுதி செய்க.";
            tips.add("உன்னத் பாரத் அபியான் நிதியுதவி பெற்ற விவசாய நுண்ணறிவு வழிகாட்டி.");
        } else if ("hi".equals(lang)) {
            rationale = "[हिंदी] मृदा परीक्षण (N: " + n + ", P: " + p + ", K: " + k + ") और नमी (" + moisture + "%) के अनुसार सर्वोत्तम फसल अनुशंसित।";
            fertilizer = "[हिंदी] समय पर संतुलित उर्वरक (एनपीके) का प्रयोग करें।";
            irrigation = "[हिंदी] क्रांतिकालीन अवस्थाओं में सिंचाई करें।";
            tips.add("उन्नत भारत अभियान द्वारा समर्थित स्मार्ट कृषि सलाहकार प्रणाली।");
        } else if ("te".equals(lang)) {
            rationale = "[తెలుగు] నేల సారాంశం (N: " + n + ", P: " + p + ", K: " + k + ") మరియు తేమ (" + moisture + "%) ఆధారంగా సిఫార్సు.";
            fertilizer = "[తెలుగు] సరైన ఎరువుల నిర్వహణ పాటించండి.";
            irrigation = "[తెలుగు] పంట దశలకు అనుగుణంగా నీటిపారుదల కల్పించండి.";
            tips.add("ఉన్నత్ భారత్ అభియాన్ ప్రోత్సాహక స్మార్ట్ వ్యవసాయ సలహా.");
        } else {
            tips.add("Backed by Unnat Bharat Abhiyan 60k INR Research Grant.");
        }

        return new AgriRecommendation(
                crop,
                confidence,
                rationale,
                fertilizer,
                irrigation,
                climate,
                tips,
                yield
        );
    }
}
