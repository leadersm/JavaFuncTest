package com.tianwen.news.data.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table NEWS_TYPE.
 */
public class NewsType {

    /** Not-null value. */
    private String id;
    /** Not-null value. */
    private String name;
    private String desc;
    private String mode;
    private String boss;
    private String market;
    private String color;
    private Integer sort;

    public NewsType() {
    }

    public NewsType(String id) {
        this.id = id;
    }

    public NewsType(String id, String name, String desc, String mode, String boss, String market, String color, Integer sort) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.mode = mode;
        this.boss = boss;
        this.market = market;
        this.color = color;
        this.sort = sort;
    }

    /** Not-null value. */
    public String getId() {
        return id;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setId(String id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}
