package sample;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisnikModel {

    private ObservableList<Korisnik> korisnici=FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik=new SimpleObjectProperty<>();

    public KorisnikModel() {
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici=korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    public void napuni() {
        korisnici.add(new Korisnik("Vedran", "Ljubović", "vljubovic@etf.unsa.na", "vljubovic", "1234"));
        korisnici.add(new Korisnik("Amra", "Delić", "adelic@etf.unsa.na", "adelic", "5467"));
        korisnici.add(new Korisnik("Tarik", "Sijerčić", "tsijercic@etf.unsa.na", "tsijercic", "8912"));
        korisnici.add(new Korisnik("Rijad", "Fejzić", "rfejzic@etf.unsa.na", "rfejzic", "5468"));
        trenutniKorisnik.set(null);
    }

}
