package com.tianwen.news.data.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table STOCK.
 */
public class Stock {

    /** Not-null value. */
    private String stockCode;
    /** Not-null value. */
    private String stockName;
    private String pinyin;
    private String mtype;

    public Stock() {
    }

    public Stock(String stockCode) {
        this.stockCode = stockCode;
    }

    public Stock(String stockCode, String stockName, String pinyin, String mtype) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.pinyin = pinyin;
        this.mtype = mtype;
    }

    /** Not-null value. */
    public String getStockCode() {
        return stockCode;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    /** Not-null value. */
    public String getStockName() {
        return stockName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

}