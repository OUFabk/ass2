/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Account;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author WAFAco
 */
public class UpaccController implements Initializable {
    private Account oldAccount;

    @FXML
    private TextField accountNumber;
    @FXML
    private TextField username;
    @FXML
    private TextField balance;
    @FXML
    private RadioButton usdRadio;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private RadioButton nisRadio;
    @FXML
    private Button updateaccBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField creationDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //get selected user data from UsersManagmentController updatedUser var
       
        this.oldAccount = Controller.Admin.AccountsManagmentController.selectedAccountToUpdate;
        //set text field's data the same as updatedUser data
        username.setText(oldAccount.getUsername());
        accountNumber.setText(oldAccount.getAccountNumber());
        String x = Double.toString(oldAccount.getBalance());
        balance.setText(x);
        creationDate.setText(oldAccount.getCreationDate());
        oldAccount.setCurrency(x);
        
        if (oldAccount.getCurrency().equals("usd")) {
            genderGroup.selectToggle(usdRadio);
        }
        
        if (oldAccount.getCurrency().equals("nis")) {
            genderGroup.selectToggle(nisRadio);
        }
    }    

    @FXML
    private void updateacc(ActionEvent event)  throws SQLException, ClassNotFoundException {
        //get the new data from text field's and store it in new user object
        String username1 = username.getText();
        String accountNumber1 = accountNumber.getText();
        String balance1 = balance.getText();
        String creationDate1 = creationDate.getText();
        String genderGroup1 = ((RadioButton)genderGroup.getSelectedToggle()).getText();
        
        //make an new user object having this data
       // Account newAccount = new Account(username1,accountNumber1,balance1,creationDate1,genderGroup1);
                Account newAccount = new Account();

        //set the new user id the same as the old user
        newAccount.setId(oldAccount.getId());
        
        // update the user in database by update method
        newAccount.update();
        
        //close the update stage using our global stage var in UsersManagmentController and show an alert
        Controller.Admin.UsersManagmentController.updateStage.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User updated");
        alert.setContentText("User updated");
        alert.showAndWait();
        
    }

    @FXML
    private void cancelCreationacc(ActionEvent event) {
               Controller.Admin.AccountsManagmentController.updateStage.close(); 

    }
    
}
