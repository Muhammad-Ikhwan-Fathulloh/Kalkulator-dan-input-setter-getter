package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BasicView extends View {
    
    public BasicView() {
        Label label = new Label("Biodata");
        label.setGraphic(new Icon(MaterialDesignIcon.HOME));
        
        AppBar ab = new AppBar();
        ab.getActionItems().add(MaterialDesignIcon.HOME.button(e -> System.out.println("Menu Home")));
        ab.getActionItems().add(MaterialDesignIcon.BUILD.button(e -> System.out.println("Menu Build")));
        
        
        TextField npm = new TextField();
        npm.setId("npm");
        npm.setPromptText("Masukkan NPM Anda");
     
        TextField nama = new TextField();
        nama.setId("nama");
        nama.setPromptText("Masukkan Nama Anda");
        
        TextField jurusan = new TextField(); 
        jurusan.setId("jurusan");
        jurusan.setPromptText("Masukkan Jurusan Anda");
        
        ObservableList<String> names = FXCollections.observableArrayList(
          npm.getText(),nama.getText(),jurusan.getText());
        ListView<String> listView = new ListView<String>(names);
        
        Button button = new Button("Kirim");
        button.setGraphic(new Icon(MaterialDesignIcon.CODE));
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) { 
                entity.setNpmk(npm.getText());
                entity.setNamak(nama.getText());
                entity.setJurusank(jurusan.getText());
                
                MobileApplication.getInstance().switchView(GluonApplication.DATA_VIEW);
                
                npm.clear();
                nama.clear();
                jurusan.clear();           
            }
        });
       
        
        VBox controls = new VBox(15.0, label, npm, nama, jurusan, button);
        VBox menu = new VBox(ab);
        controls.setAlignment(Pos.CENTER);
        menu.setAlignment(Pos.CENTER);
        setCenter(controls);
        setBottom(menu);
        
    }
    
    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("Biodata View");
        appBar.getActionItems().add(MaterialDesignIcon.HOME.button(e -> System.out.println("Home")));
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }
    
}
