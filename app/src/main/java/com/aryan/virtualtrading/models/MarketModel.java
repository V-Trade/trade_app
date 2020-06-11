package com.aryan.virtualtrading.models;

public class MarketModel {

    private String name, symbol;
    private float sharePrice, eps, peRatio;
    private double capital,outShares;


    public MarketModel(String name, String symbol, float sharePrice) {
        this.name = name;
        this.symbol = symbol;
        this.sharePrice = sharePrice;
    }

    public MarketModel(String name, String symbol, float sharePrice, float eps, float peRatio, double capital, double outShares) {
        this.name = name;
        this.symbol = symbol;
        this.sharePrice = sharePrice;
        this.eps = eps;
        this.peRatio = peRatio;
        this.capital = capital;
        this.outShares = outShares;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(float sharePrice) {
        this.sharePrice = sharePrice;
    }

    public float getEps() {
        return eps;
    }

    public void setEps(float eps) {
        this.eps = eps;
    }

    public float getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(float peRatio) {
        this.peRatio = peRatio;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getOutShares() {
        return outShares;
    }

    public void setOutShares(double outShares) {
        this.outShares = outShares;
    }
}
