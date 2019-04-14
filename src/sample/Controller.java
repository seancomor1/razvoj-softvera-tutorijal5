package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controller {
    public ListView<Korisnik> listaKorisnika;
    public PasswordField fldLozinka;
    public TextField fldKorisnickoIme;
    public TextField fldEmail;
    public TextField fldPrezime;
    public TextField fldIme;
    public Button dodaj;
    public Button kraj;

    private KorisnikModel model;

    public Controller(KorisnikModel m) {
        model=m;
    }

    private void odvezivanje() {
        fldIme.textProperty().unbindBidirectional(model.getTrenutniKorisnik().imeProperty());
        fldPrezime.textProperty().unbindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        fldEmail.textProperty().unbindBidirectional(model.getTrenutniKorisnik().emailProperty());
        fldKorisnickoIme.textProperty().unbindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        fldLozinka.textProperty().unbindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
    }

    private void povezivanje() {
        fldIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        fldPrezime.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        fldEmail.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        fldKorisnickoIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnickoImeProperty());
        fldLozinka.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
    }

    public void initialize() {
        model.setTrenutniKorisnik(model.getKorisnici().get(0));
        povezivanje();
        listaKorisnika.setItems(model.getKorisnici());
        listaKorisnika.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik stariKorisnik, Korisnik noviKorisnik) {
                if(stariKorisnik!=null) {
                    odvezivanje();
                }
                if (noviKorisnik == null) {
                    fldIme.setText("");
                    fldPrezime.setText("");
                    fldEmail.setText("");
                    fldKorisnickoIme.setText("");
                    fldLozinka.setText("");
                }
                else {
                    Korisnik korisnik =  (Korisnik) listaKorisnika.getSelectionModel().getSelectedItem();
                    odvezivanje();
                    model.setTrenutniKorisnik(korisnik);
                    povezivanje();
                    listaKorisnika.refresh();
                }
                listaKorisnika.refresh();
            }
        });
    }

    public void dodajNovogkorisnika(ActionEvent actionEvent) {
        model.dodajKorisnika();
        odvezivanje();
        model.setTrenutniKorisnik(model.getKorisnici().get(model.getKorisnici().size()-1));
        povezivanje();
        listaKorisnika.refresh();
    }

    public void zatvoriProzor(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }
}
