package com.gluonapplication;

import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Kalkulator extends View {
   
    public Kalkulator() {
        Label label = new Label("Kalkulator");
        label.setGraphic(new Icon(MaterialDesignIcon.ANDROID));
        
        AppBar ab = new AppBar();
        ab.getActionItems().add(MaterialDesignIcon.HOME.button(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) { 
                     
            }
        }));
        
        ab.getActionItems().add(MaterialDesignIcon.BUILD.button(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) { 
                     
            }
        }));
        
        ab.getActionItems().add(MaterialDesignIcon.BOOK.button(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) { 
                     
            }
        }));
        
        
        
        TextField angka1 = new TextField();
        angka1.setId("angka1");
        angka1.setPromptText("Masukkan Angka 1");
     
        TextField angka2 = new TextField();
        angka2.setId("angka2");
        angka2.setPromptText("Masukkan Angka 2");
        
        TextField hasil = new TextField(); 
        hasil.setId("hasil");
        hasil.setPromptText("Hasil");
        hasil.setDisable(true);
        
        Button button1 = new Button("+");
        
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) { 
                if (angka(angka1.getText()) && angka(angka2.getText())) {
                    int hasilk = Integer.valueOf(angka1.getText()) + Integer.valueOf(angka2.getText());
                    hasil.setText(""+hasilk);
                }else{
                    angka1.clear();
                    angka2.clear();
                    hasil.clear();
                }     
            }
        });
        
        Button button2 = new Button("-");
        
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) { 
               if (angka(angka1.getText()) && angka(angka1.getText())) {
                    int hasilk = Integer.valueOf(angka1.getText()) - Integer.valueOf(angka2.getText());
                    hasil.setText(""+hasilk);
                }else{
                    angka1.clear();
                    angka2.clear();
                    hasil.clear();
                }           
            }
        });
        
        Button button3 = new Button("*");
        
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) { 
                if (angka(angka1.getText()) && angka(angka1.getText())) {
                    int hasilk = Integer.valueOf(angka1.getText()) * Integer.valueOf(angka2.getText());
                    hasil.setText(""+hasilk);
                }else{
                    angka1.clear();
                    angka2.clear();
                    hasil.clear();
                }        
            }
        });
        
        Button button4 = new Button("/");
        
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) { 
              if (angka(angka1.getText()) && angka(angka1.getText())) {
                    int hasilk = Integer.valueOf(angka1.getText()) / Integer.valueOf(angka2.getText());
                    hasil.setText(""+hasilk);
                }else{
                    angka1.clear();
                    angka2.clear();
                    hasil.clear();
                }         
            }
        });
        
        Button button5 = new Button("%");
        
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) { 
                if (angka(angka1.getText()) && angka(angka1.getText())) {
                    int hasilk = Integer.valueOf(angka1.getText()) % Integer.valueOf(angka2.getText());
                    hasil.setText(""+hasilk);
                }else{
                    angka1.clear();
                    angka2.clear();
                    hasil.clear();
                }            
            }
        });
        
        Button buttonc = new Button("C");
        
        buttonc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {               
               angka1.clear();
               angka2.clear();
               hasil.clear();                       
            }
        });
       
        VBox controls = new VBox(15.0, label, angka1, angka2, hasil, buttonc);  
        controls.setAlignment(Pos.CENTER);       
        VBox menu = new VBox(ab);
        controls.setAlignment(Pos.CENTER);
        menu.setAlignment(Pos.CENTER);
        setTop(controls);
        setBottom(menu); 
        HBox btn = new HBox(5.0, button1, button2, button3, button4, button5);
        btn.setAlignment(Pos.CENTER);
        setCenter(btn);
    }
    
    public static boolean angka(String in){
        try{
            Integer.parseInt(in);
            return true;
        }catch(Exception e){
            return false;
        }  
    }
    
    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("Kalkulator View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }
    
}
