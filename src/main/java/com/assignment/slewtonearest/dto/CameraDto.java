package com.assignment.slewtonearest.dto;

public class CameraDto {

    private String id;
    private String cameraName;
    private String cameraType;
    private String latitude;
    private String longitude;
    private String azimuth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getCameraType() {
        return cameraType;
    }

    public void setCameraType(String cameraType) {
        this.cameraType = cameraType;
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

    public String getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(String azimuth) {
        this.azimuth = azimuth;
    }

    @Override
    public String toString() {
        return "CameraDto{" +
                "id='" + id + '\'' +
                ", cameraName='" + cameraName + '\'' +
                ", cameraType='" + cameraType + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", azimuth='" + azimuth + '\'' +
                '}';
    }
}
