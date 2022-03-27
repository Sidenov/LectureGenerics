package ru.netology.domain;

import java.util.Objects;

public class AirTicket implements Comparable<AirTicket>{
    private int id;
    private int price;
    private String aiportFrom;
    private String aiportTo;

    public AirTicket() {
    }

    public AirTicket(int id, int price, String aiportFrom, String aiportTo) {
        this.id = id;
        this.price = price;
        this.aiportFrom = aiportFrom;
        this.aiportTo = aiportTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAiportFrom() {
        return aiportFrom;
    }

    public void setAiportFrom(String aiportFrom) {
        this.aiportFrom = aiportFrom;
    }

    public String getAiportTo() {
        return aiportTo;
    }

    public void setAiportTo(String aiportTo) {
        this.aiportTo = aiportTo;
    }

    @Override
    public int compareTo(AirTicket o) {
        return this.price - o.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirTicket ticket = (AirTicket) o;
        return id == ticket.id && price == ticket.price && Objects.equals(aiportFrom, ticket.aiportFrom) && Objects.equals(aiportTo, ticket.aiportTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, aiportFrom, aiportTo);
    }

    @Override
    public String toString() {
        return "AirTicket{" +
                "id=" + id +
                ", price=" + price +
                ", aiportFrom='" + aiportFrom + '\'' +
                ", aiportTo='" + aiportTo + '\'' +
                '}';
    }
}
