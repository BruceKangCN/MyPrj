package com.bk.prj.entity;

import java.util.Date;

public class Project {
    private Integer no;
    private String name;
    private String language;
    private Date last_update;
    private String status;
    private String url;

    public void setNo(Integer no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Project{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", last_update=" + last_update +
                ", status='" + status + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public Date getLast_update() {
        return last_update;
    }

    public String getStatus() {
        return status;
    }

    public String getUrl() {
        return url;
    }
}
