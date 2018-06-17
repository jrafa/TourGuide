package com.jrafa.tourguide.place;

/**
 * Created by jrafa on 13.04.2018.
 */

public class Place {
    private String name;
    private String address;
    private int imageId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Place(String name, String address, int imageId) {
        this.name = name;
        this.address = address;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean hasImage() {
        return imageId != NO_IMAGE_PROVIDED;
    }

}
