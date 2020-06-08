package com.harinder.hippie_backpacker;

public class Itinerary {
    String locationName, locationType, locationHours, locationItems, locationExperience;

    public Itinerary()
    {}

    //Constructor
    public Itinerary(String locationName, String locationType, String locationHours, String locationItems, String locationExperience) {
        this.locationName = locationName;
        this.locationType = locationType;
        this.locationHours = locationHours;
        this.locationItems = locationItems;
        this.locationExperience = locationExperience;
    }

    //Getters and setters
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getLocationHours() {
        return locationHours;
    }

    public void setLocationHours(String locationHours) {
        this.locationHours = locationHours;
    }

    public String getLocationItems() {
        return locationItems;
    }

    public void setLocationItems(String locationItems) {
        this.locationItems = locationItems;
    }

    public String getLocationExperience() {
        return locationExperience;
    }

    public void setLocationExperience(String locationExperience) {
        this.locationExperience = locationExperience;
    }
}
