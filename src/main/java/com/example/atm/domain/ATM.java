package com.example.atm.domain;

import com.sun.xml.internal.ws.server.ServerRtException;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

public class ATM {

    private int id;
    private int kname;
    private String dated;
    private String description;
    private String status;
    private int kilk;


    public ATM(int id, int kname, String dated, String description,String status) {
        this.id = id;
        this.kname = kname;
        this.dated = dated;
        this.description = description;
        this.status = status;
    }


    public ATM(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKname() {
        return kname;
    }

    public void setKname(int kname) {
        this.kname = kname;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getKilk() {
        return kilk;
    }

    public void setKilk(int kilk) {
        this.kilk = kilk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ATM atm = (ATM) o;

        if (id != atm.id) return false;
        if (kname != atm.kname) return false;
        if (dated != null ? !dated.equals(atm.dated) : atm.dated != null) return false;
        return description != null ? description.equals(atm.description) : atm.description == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + kname;
        result = 31 * result + (dated != null ? dated.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "id=" + id +
                ", kname=" + kname +
                ", dated=" + dated +
                ", description='" + description + '\'' +
                '}';
    }

}
