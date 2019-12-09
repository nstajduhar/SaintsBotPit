package naivgationdrawer;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class FXMLDocumentController implements Initializable {
	
	/**
	 * @author Nick Stajduhar
	 * @category Utility
	 * Version 2.0 rev4
	 * 
	 * This program is made for the St. Anne High School robotics team "Saints Bot".
	 *
	 * PitControl is the control panel for their pit in the classroom and at district events
	 * 
	 * Copyright 2018 Nick Stajduhar All Rights Reserved
	 */

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    
    @FXML
    private Label time;
    
    @FXML
    private Label date;
    
    @FXML 
    private Label currentVideo;
    
    @FXML
    private static String current;
    
    @FXML
    private AnchorPane root;

    public static AnchorPane rootP;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootP = root;
        
        rootP.setStyle("-fx-background-color: #ffff00");
        
        
        try {
            VBox box = FXMLLoader.load(getClass().getResource("SidePanelContent.fxml"));
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        
        bindToTime(time);
        date.setText(dtf.format(now));
        
       
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
            
            if(drawer.isShown())
            {
                drawer.close();
            }else
                drawer.open();
        });
    }
    
    private void bindToTime(final Label time) {
        Timeline timeline = new Timeline(new KeyFrame[]{new KeyFrame(Duration.seconds((double)0.0), (EventHandler)new EventHandler<ActionEvent>(){

        	
            public void handle(ActionEvent actionEvent) {
                Calendar timeNow = Calendar.getInstance();
                String hourString = StringUtilities.pad(2, ' ', timeNow.get(10) == 0 ? "12" : String.valueOf(timeNow.get(10)));
                String minuteString = StringUtilities.pad(2, '0', String.valueOf(timeNow.get(12)));
                String secondString = StringUtilities.pad(2, '0', String.valueOf(timeNow.get(13)));
                String ampmString = timeNow.get(9) == 0 ? "AM" : "PM";
                time.setText(String.valueOf(hourString) + ":" + minuteString + ":" + secondString + " " + ampmString);
            }
        }, new KeyValue[0]), new KeyFrame(Duration.seconds((double)1.0), new KeyValue[0])});
        timeline.setCycleCount(-1);
        timeline.play();
    }
    
	public static String getCurrent() {
		return current;
	}

	public static void setCurrent(String current) {
		FXMLDocumentController.current = current;
		System.out.print(getCurrent());
	}
	
	private final Content content1= ContentBuilder.create()
            .color(Content.MatrixColor.RGB)
            .type(Content.Type.IMAGE)
            .origin(0, 1)
            .area(0, 0, 184, 74)
            .bmpName("/jfxtras/labs/samples/matrixpanel/Javafx-logo.bmp")
            .effect(Content.Effect.SCROLL_DOWN).lapse(20)
            .postEffect(Content.PostEffect.PAUSE).pause(3000)
            .build();
	private final Content content2=ContentBuilder.create()
            .color(Content.MatrixColor.BLUE)
            .type(Content.Type.TEXT)
            .origin(0, 1)
            .area(0, 75, 250, 100)
            .txtContent("HELLO JAVAFX SAMPLES!!!   ")
            .font(Content.MatrixFont.FF_10x16)
            .fontGap(Content.Gap.DOUBLE)
            .align(Content.Align.RIGHT)
            .effect(Content.Effect.SCROLL_LEFT).lapse(20)
            .postEffect(Content.PostEffect.PAUSE).pause(1000)
            .order(Content.RotationOrder.FIRST).clear(false)
            .build();
	private final MatrixPanel panel = MatrixPanelBuilder.create()
        .ledWidth(184).ledHeight(100).prefWidth(1050d).prefHeight(1050d)
        .frameVisible(true).frameDesign(MatrixPanel.FrameDesign.SHINY_METAL)
        .frameCustomPath("/jfxtras/labs/samples/matrixpanel/black.jpg")
        .frameBaseColor(Color.ALICEBLUE).contents(new Content[] {content1,content2}).build();
}
