package unicam.IdSProject;

/**
 * This class represents the location that a user can add to its profile,
 * expressed through coordinates
 */
public class Location {

    /**
     * The latitude of the location
     */
    private String latitude;

    /**
     * The longitude of the location
     */
    private String longitude;

    public Location(String latitude, String longitude){
        this.latitude=latitude;
        this.longitude=longitude;
    }

    /**
     * @return the latitude of the location
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude of the location
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude of the location
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude of the location
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String toString() { return this.latitude+this.longitude; }
}