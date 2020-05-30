package com.teste.marsweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MarsPhoto {

    private List<Photo> photos = new ArrayList<>();

    public MarsPhoto() {
    }

    public MarsPhoto(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public static class Photo{
        private int id;
        private String img_src;

        public Photo(int id, String img_src) {
            this.id = id;
            this.img_src = img_src;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg_src() {
            return img_src;
        }

        public void setImg_src(String img_src) {
            this.img_src = img_src;
        }
    }
}
