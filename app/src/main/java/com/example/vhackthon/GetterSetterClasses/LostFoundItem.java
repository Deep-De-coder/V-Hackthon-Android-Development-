package com.example.vhackthon.GetterSetterClasses;

public class LostFoundItem {

    String name,imageUrl,location,type;

    public LostFoundItem() {
    }

    public LostFoundItem(String name, String imageUrl, String location,String type) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.location = location;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
