package models.facility;

import java.util.Objects;

public abstract class Facility implements Comparable<Facility>{
    private String serviceCode;
    private double area;
    private double price;
    private int maxPeople;
    private String rentType;

    public Facility() {
    }

    public Facility(String serviceCode, double area, double price, int maxPeople, String rentType) {
        this.serviceCode = serviceCode;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getInfoToCsvFile(){
        return getServiceCode()+","+getArea()+","+getPrice()+","+getMaxPeople()+","+getRentType();
    }

    @Override
    public String toString() {
        return "service name : "+ serviceCode +", Area: "+area+", Price: "+price+", Max people: "+maxPeople+", Rent type: "+rentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility)) return false;
        Facility facility = (Facility) o;
        return Objects.equals(serviceCode, facility.serviceCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceCode);
    }

    @Override
    public int compareTo(Facility o) {
        return this.serviceCode.compareTo(o.serviceCode);
    }
}
