package ba.unsa.etf.rs.tut5;

import javafx.beans.property.SimpleStringProperty;

public class Korisnik {

    private SimpleStringProperty ime;
    private SimpleStringProperty prezime;
    private SimpleStringProperty email;
    private SimpleStringProperty korisnickoIme;
    private SimpleStringProperty lozinka;

    public Korisnik() {
        ime=new SimpleStringProperty("");
        prezime=new SimpleStringProperty("");
        email=new SimpleStringProperty("");
        korisnickoIme=new SimpleStringProperty("");
        lozinka=new SimpleStringProperty("");
    }

    public Korisnik(String ime, String prezime, String email, String korisnickoIme, String lozinka) {
        this.ime=new SimpleStringProperty(ime);
        this.prezime=new SimpleStringProperty(prezime);
        this.email=new SimpleStringProperty(email);
        this.korisnickoIme=new SimpleStringProperty(korisnickoIme);
        this.lozinka=new SimpleStringProperty(lozinka);
    }

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme.get();
    }

    public SimpleStringProperty korisnickoImeProperty() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka.get();
    }

    public SimpleStringProperty lozinkaProperty() {
        return lozinka;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme.set(korisnickoIme);
    }

    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }

    public String toString() {
        return prezime.get()+ " " +ime.get();
    }
}
