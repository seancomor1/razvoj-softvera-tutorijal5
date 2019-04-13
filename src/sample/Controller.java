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
    public ListView<Korisnik> listaKorisnika;

    private KorisnikModel model=new KorisnikModel();

    public Controller() {
        model.napuni();
    }

    public void initialize() {

        listaKorisnika.setItems(model.getKorisnici());
        model.trenutniKorisnikProperty().addListener(
                (obs, oldKorisnik, newKorisnik) -> {
                    if(oldKorisnik != null) {
                        fldIme.textProperty().bindBidirectional(oldKorisnik.imeProperty());
                        fldPrezime.textProperty().bindBidirectional(oldKorisnik.prezimeProperty());
                        fldEmail.textProperty().bindBidirectional(oldKorisnik.emailProperty());
                        fldKorisnickoIme.textProperty().bindBidirectional(oldKorisnik.korisnickoImeProperty());
                        fldLozinka.textProperty().bindBidirectional(oldKorisnik.lozinkaProperty());
                    }
                    if(newKorisnik==null) {
                        fldIme.setText("");
                        fldPrezime.setText("");
                        fldEmail.setText("");
                        fldKorisnickoIme.setText("");
                        fldLozinka.setText("");
                    }
                    else {
                        fldIme.textProperty().bindBidirectional(newKorisnik.imeProperty());
                        fldPrezime.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                        fldEmail.textProperty().bindBidirectional(newKorisnik.emailProperty());
                        fldKorisnickoIme.textProperty().bindBidirectional(newKorisnik.korisnickoImeProperty());
                        fldLozinka.textProperty().bindBidirectional(newKorisnik.lozinkaProperty());
                    }
                }
        );
    }

    public void dodajNovogkorisnika(ActionEvent actionEvent) {

        listaKorisnika.getSelectionModel().getSelectedItem();
        //model.setTrenutniKorisnik(listaKorisnika.getSelectionModel());
    }

    public void zatvoriProzor(ActionEvent actionEvent) {
    }
}
