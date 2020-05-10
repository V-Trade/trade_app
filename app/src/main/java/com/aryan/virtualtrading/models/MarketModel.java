package com.aryan.virtualtrading.models;

public class MarketModel {

    private String companyName, stockSymbol;
    private float maxPrice;

    public MarketModel(String companyName, float maxPrice) {
        this.companyName = companyName;
        this.maxPrice = maxPrice;
    }

    public MarketModel(String companyName, String stockSymbol, float maxPrice) {
        this.companyName = companyName;
        this.stockSymbol = stockSymbol;
        this.maxPrice = maxPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }
}
