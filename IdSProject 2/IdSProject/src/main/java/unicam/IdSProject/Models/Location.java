package unicam.IdSProject.Models;

/**
 * This class represents the Location expressed with coordinates that a Seller can add to its profile
 *
 * @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
 *
 */
public class Location {
    
    private String latitude;
    private String longitude;

    /**
    * This method creates a new Location object
    */
    public Location(String latitude, String longitude){
        this.latitude=latitude;
        this.longitude=longitude;
    }


    
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() { return this.latitude+this.longitude; }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (obj instanceof Location location) {
            return this.getLatitude().equals(location.getLatitude()) && this.getLongitude().equals(location.getLongitude());
        }
        return false;
    }
}
