package com.company.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Guest {

    private Long Id;
    private String name;
    private Integer daysOfStay;
    private LocalDate dateCheckIn;
    private LocalDate dateCheckOut;
    private List<String> listServices = new ArrayList<>();
    private Long roomId;

    public Guest() {
    }

    public Guest(String name, Integer daysOfStay) {
        this.name = name;
        this.daysOfStay = daysOfStay;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDate getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(LocalDate dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public List<String> getListServices() {
        return listServices;
    }

    public void setListServices(List<String> listServices) {
        this.listServices = listServices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(LocalDate dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public Integer getDaysOfStay() {
        return daysOfStay;
    }

    public void setDaysOfStay(Integer daysOfStay) {
        this.daysOfStay = daysOfStay;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return Objects.equals(name, guest.name) &&
                Objects.equals(daysOfStay, guest.daysOfStay) &&
                Objects.equals(dateCheckIn, guest.dateCheckIn) &&
                Objects.equals(dateCheckOut, guest.dateCheckOut) &&
                Objects.equals(listServices, guest.listServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, daysOfStay, dateCheckIn, dateCheckOut, listServices);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", id=" + Id +
                ", daysOfStay=" + daysOfStay +
                ", dateCheckIn=" + dateCheckIn +
                ", dateCheckOut=" + dateCheckOut +
                ", listServices=" + listServices +
                '}';
    }
}

