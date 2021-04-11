package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import static com.gluonhq.charm.glisten.application.MobileApplication.HOME_VIEW;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GluonApplication extends MobileApplication {
    public static final String DATA_VIEW = "data view";
    public static final String BASIC_VIEW = "basic view";

    @Override
    public void init() {
        addViewFactory(DATA_VIEW, HomeView::new);
        
        addViewFactory(HOME_VIEW, Kalkulator::new);
        
        addViewFactory(BASIC_VIEW, BasicView::new);
        
    }
    
    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        ((Stage) scene.getWindow()).getIcons().add(new Image(GluonApplication.class.getResourceAsStream("/icon.png")));
    }
    
}
