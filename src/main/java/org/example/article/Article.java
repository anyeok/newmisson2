package org.example.article;

import java.util.Map;

public class Article {
    private int id;
    private String subject;
    private String content;

    Article(Map<String, Object> row) {
        this.id = (int) row.get("id");
        this.subject = (String) row.get("subject");
        this.content = (String) row.get("content");
    }

    public int getId() {
        return this.id;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}