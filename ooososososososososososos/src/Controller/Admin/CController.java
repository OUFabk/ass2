/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Account;
import View.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author WAFAco
 */
public class CController implements Initializable {

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button saveNewUserBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Label accountNumber;
    @FXML
    private TextField username;
    @FXML
    private TextField balance;
    @FXML
    private RadioButton usd;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private RadioButton nis;
    @FXML
    private TextField creationDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
         ViewManager.adminPage.changeSceneToUsersManagment();
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
         ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    @FXML
    private void saveNewacc(ActionEvent event)throws SQLException, ClassNotFoundException  {
        // get data from all text fields 
        String accountNumber0 = accountNumber.getText();
      //  accountNumber0 = (int)accountNumber0;
        String username0 = username.getText();
        String balance0 = balance.getText();
          String creationDate0 = creationDate.getText();
        String usdORnis = ((RadioButton)genderGroup.getSelectedToggle()).getText();
        
       Account account = new Account();
       
       account.save();
         ViewManager.adminPage.changeSceneToAccountsManagment();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account inserted");
        alert.setContentText("Account inserted");
        alert.showAndWait();
    }

    @FXML
    private void cancelaccCreation(ActionEvent event) {
        
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void accountNumberh(MouseEvent event) {
    }
    
}
