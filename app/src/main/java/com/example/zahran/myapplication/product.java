package com.example.zahran.myapplication;

/**
 * Created by zahran on 1/30/2020.
 */

public class product {
    private int profilrimage;
    private int deleteimage;
    private int mainimage;
    private int likimage;
    private int commentimage;
    private int smileyimage;
    private int shareimage;
    private String name;

    public product(int profilrimage, int deleteimage, int mainimage, int likimage, int commentimage, int smileyimage,
                   int shareimage, String name) {
        this.profilrimage = profilrimage;
        this.deleteimage = deleteimage;
        this.mainimage = mainimage;
        this.likimage = likimage;
        this.commentimage = commentimage;
        this.smileyimage = smileyimage;
        this.shareimage = shareimage;
        this.name = name;
    }

    public int getProfilrimage() {
        return profilrimage;
    }

    public void setProfilrimage(int profilrimage) {
        this.profilrimage = profilrimage;
    }

    public int getDeleteimage() {
        return deleteimage;
    }

    public void setDeleteimage(int deleteimage) {
        this.deleteimage = deleteimage;
    }

    public int getMainimage() {
        return mainimage;
    }

    public void setMainimage(int mainimage) {
        this.mainimage = mainimage;
    }

    public int getLikimage() {
        return likimage;
    }

    public void setLikimage(int likimage) {
        this.likimage = likimage;
    }

    public int getCommentimage() {
        return commentimage;
    }

    public void setCommentimage(int commentimage) {
        this.commentimage = commentimage;
    }

    public int getSmileyimage() {
        return smileyimage;
    }

    public void setSmileyimage(int smileyimage) {
        this.smileyimage = smileyimage;
    }

    public int getShareimage() {
        return shareimage;
    }

    public void setShareimage(int shareimage) {
        this.shareimage = shareimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
