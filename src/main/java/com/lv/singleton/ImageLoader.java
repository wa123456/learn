package com.lv.singleton;

public class ImageLoader{
    private static ImageLoader instance = new ImageLoader();
    private ImageLoader(){}
    public static ImageLoader getInstance(){
        return instance;
    }
}