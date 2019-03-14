package model;

import java.io.Serializable;

public class Client implements Serializable {

    private int cl_number;
    private int trans_type;
    private int nb_km;

    public Client() {

    }

    public Client(int cl_number, int trans_type, int nb_km) {
        this.cl_number = cl_number;
        this.trans_type = trans_type;
        this.nb_km = nb_km;
    }

    public int getCl_number() {
        return cl_number;
    }

    public void setCl_number(int cl_number) {
        this.cl_number = cl_number;
    }

    public int getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(int trans_type) {
        this.trans_type = trans_type;
    }

    public int getNb_km() {
        return nb_km;
    }

    public void setNb_km(int nb_km) {
        this.nb_km = nb_km;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cl_number=" + cl_number +
                ", trans_type=" + trans_type +
                ", nb_km=" + nb_km +
                '}';
    }
}
