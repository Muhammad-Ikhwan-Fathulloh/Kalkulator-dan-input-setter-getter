package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class HomeView extends View{

    public HomeView(){
        Label label = new Label("Data Diri");
        
        ObservableList<String> names = FXCollections.observableArrayList(
                "NPM : "+entity.getNpmk(),
                "Nama : "+entity.getNamak(),
                "Jurusan : "+entity.getJurusank());
        ListView<String> listView = new ListView<String>(names);
        
        Button button = new Button("Kembali");
        button.setGraphic(new Icon(MaterialDesignIcon.LANGUAGE));
        button.setOnAction(e-> MobileApplication.getInstance().switchView(GluonApplication.HOME_VIEW));
        
        VBox controls = new VBox(15.0, label, listView, button);
        controls.setAlignment(Pos.CENTER);
        
        setCenter(controls);
    }
    
    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu Home")));
        appBar.setTitleText("Data Diri View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search Home")));
    }
}
