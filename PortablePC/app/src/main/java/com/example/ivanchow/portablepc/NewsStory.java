package com.example.ivanchow.portablepc;
import android.graphics.Bitmap;


public class NewsStory{
    private String title;
    private Bitmap titleImage;
    private String article;
    private String author;
    private String category;

    public NewsStory(String title, Bitmap titleImage, String article, String author, String category) {
        this.title = title;
        this.titleImage = titleImage;
        this.article = article;
        this.author = author;
        this.category = category;
    }

    public NewsStory(String title) {
        this.title = title;
    }




    //getters

    public String getTitle() {
        return title;
    }

    public Bitmap getTitleImage() {
        return titleImage;
    }

    public String getArticle() {
        return article;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }
}
