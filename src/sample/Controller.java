package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller {
    public Label fldIme;
    public Label fldPrezime;
    public Label fldEmail;
    public Label fldKorisnickoIme;
    public Label fldLozinka;
    public ListView listaKorisnika;

    private KorisnikModel model=new KorisnikModel();

    public Controller() {
        model.napuni();
    }

    public void initialize() {

        /*fldIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        fldPrezime.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        fldEmail.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        fldKorisnickoIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        fldLozinka.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());*/

        listaKorisnika.setItems(model.getKorisnici());
    }

    public void dodajNovogkorisnika(ActionEvent actionEvent) {
    }

    public void zatvoriProzor(ActionEvent actionEvent) {
    }
}
