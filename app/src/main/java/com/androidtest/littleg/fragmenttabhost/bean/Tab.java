package com.androidtest.littleg.fragmenttabhost.bean;

/**
 * Created by MrLittleG on 2017-03-25.
 */

public class Tab {
    private int image;
    private int tittle;
    private Class fragment;

    public Tab(int image, int tittle,Class fragment) {
        this.image = image;
        this.fragment = fragment;
        this.tittle = tittle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTittle() {
        return tittle;
    }

    public void setTittle(int tittle) {
        this.tittle = tittle;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
