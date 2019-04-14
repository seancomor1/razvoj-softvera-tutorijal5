package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    public ListView<Korisnik> listaKorisnika;
    public PasswordField fldLozinka;
    public TextField fldKorisnickoIme;
    public TextField fldEmail;
    public TextField fldPrezime;
    public TextField fldIme;

    private KorisnikModel model=new KorisnikModel();

    public Controller() {
        model.napuni();
    }

    public void initialize() {

        listaKorisnika.setItems(model.getKorisnici());
        model.trenutniKorisnikProperty().addListener(
                (obs, oldKorisnik, newKorisnik) -> {
                    if(oldKorisnik != null) {
                        fldIme.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                        fldPrezime.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                        fldEmail.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                        fldKorisnickoIme.textProperty().unbindBidirectional(oldKorisnik.korisnickoImeProperty());
                        fldLozinka.textProperty().unbindBidirectional(oldKorisnik.lozinkaProperty());
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
        listaKorisnika.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik korisnik, Korisnik t1) {
                model.setTrenutniKorisnik(t1);
            }
        });
    }

    public void dodajNovogkorisnika(ActionEvent actionEvent) {

        //listaKorisnika.getSelectionModel().getSelectedItem();
        //model.setTrenutniKorisnik(listaKorisnika.getSelectionModel().getSelectedItem());
    }

    public void zatvoriProzor(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }
}
