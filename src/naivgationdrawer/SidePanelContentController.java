package naivgationdrawer;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;



public class SidePanelContentController implements Initializable {
	
	
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

	  public ProcessBuilder pb;
	  public ProcessBuilder pbStop;
	  public Process process;
	  public Process processStop;
	  public static Boolean promoBool = Boolean.valueOf(false);
	  public static Boolean miuBool = Boolean.valueOf(false);
	  public static Boolean staticBool = Boolean.valueOf(false);
	  public static Boolean doNotBool = Boolean.valueOf(false);
	  public static Boolean hiddenBool = Boolean.valueOf(false);
	  public static Boolean promoLoopBool = Boolean.valueOf(false);
	  public static Boolean safetyBypassBool = Boolean.valueOf(false);
	
    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton b4;
    @FXML
    private JFXButton b5;
    @FXML
    private Label currentVideo;
    @FXML
    private JFXButton exit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    }    

    @FXML
    private void changeColor(ActionEvent event) {
    
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        switch(btn.getText())
        {
            case "Promo Loop":
            if (!promoLoopBool.booleanValue()) {
                promoLoopBool = Boolean.valueOf(true);
                try {
                	//Setting all bools to false allowing videos to start with one tap rather than multiple
                	 miuBool = Boolean.valueOf(false);
                     staticBool = Boolean.valueOf(false);
                     doNotBool = Boolean.valueOf(false);
                     hiddenBool = Boolean.valueOf(false);
                     safetyBypassBool = Boolean.valueOf(false);
                     promoBool = Boolean.valueOf(false);
                	
                  currentVideo.setText("Current Video: Promo Loop");
                  pbStop = new ProcessBuilder(new String[] { "bash", "-c", "sudo killall omxplayer.bin" });
                  processStop = pbStop.start();
                  pb = new ProcessBuilder(new String[] { "bash", "-c", "omxplayer --win \"0 0 1900 1050\" --display=5 --no-osd --loop /home/pi/Videos/promoLoopVideo.mov" });
                  process = pb.start();
                }
                catch (IOException e1)
                {
                  e1.printStackTrace();
                }
                
              }
              else if (promoLoopBool.booleanValue()) {
                try {
                  pb = new ProcessBuilder(new String[] { "bash", "-c", "sudo killall omxplayer.bin" });
                  process = pb.start();
                  currentVideo.setText("Current Video: ");
                  promoLoopBool = Boolean.valueOf(false);
                  
                }
                catch (IOException e1)
                {
                  e1.printStackTrace();
                }
                
              }
                break;
            case "Machine In Use":
            if (!miuBool.booleanValue()) {
                miuBool = Boolean.valueOf(true);
                try {
                	//Setting all bools to false allowing videos to start with one tap rather than multiple
                    staticBool = Boolean.valueOf(false);
                    doNotBool = Boolean.valueOf(false);
                    hiddenBool = Boolean.valueOf(false);
                    safetyBypassBool = Boolean.valueOf(false);
                    promoBool = Boolean.valueOf(false);
                    promoLoopBool = Boolean.valueOf(false);
                  currentVideo.setText("Current Video: Machine In Use");
                  pbStop = new ProcessBuilder(new String[] { "bash", "-c", "sudo killall omxplayer.bin" });
                  processStop = pbStop.start();
                  pb = new ProcessBuilder(new String[] { "bash", "-c", "omxplayer --win \"0 0 1900 1050\" --display=5 --no-osd --loop /home/pi/Videos/miuVideo.mov" });
                  process = pb.start();
                }
                catch (IOException e1)
                {
                  e1.printStackTrace();
                }
                
              }
              else if (miuBool.booleanValue()) {
                try {
                  pb = new ProcessBuilder(new String[] { "bash", "-c", "sudo killall omxplayer.bin" });
                  process = pb.start();
                  currentVideo.setText("Current Video: ");
                  miuBool = Boolean.valueOf(false);
                }
                catch (IOException e1)
                {
                  e1.printStackTrace();
                }
                
              }
                break;
            case "Static":
            if (!staticBool.booleanValue()) {
                staticBool = Boolean.valueOf(true);
                try {
                	//Setting all bools to false allowing videos to start with one tap rather than multiple
               	 miuBool = Boolean.valueOf(false);
                    promoLoopBool = Boolean.valueOf(false);
                    doNotBool = Boolean.valueOf(false);
                    hiddenBool = Boolean.valueOf(false);
                    safetyBypassBool = Boolean.valueOf(false);
                    promoBool = Boolean.valueOf(false);
                  currentVideo.setText("Current Video: Static Intro");
                  pbStop = new ProcessBuilder(new String[] { "bash", "-c", "sudo killall omxplayer.bin" });
                  processStop = pbStop.start();
                  pb = new ProcessBuilder(new String[] { "bash", "-c", "omxplayer --win \"0 0 1900 1050\" --display=5 --no-osd --loop /home/pi/Videos/staticVideo.mov" });
                  process = pb.start();
                }
                catch (IOException e1)
                {
                  e1.printStackTrace();
                }
                
              }
              else if (staticBool.booleanValue()) {
                try {
                  pb = new ProcessBuilder(new String[] { "bash", "-c", "sudo killall omxplayer.bin" });
                  process = pb.start();
                  currentVideo.setText("Current Video: ");
                  staticBool = Boolean.valueOf(false);
                }
                catch (IOException e1)
                {
                  e1.printStackTrace();
                }
                
              }
                break;
                
            case "Promo":
            if (!promoBool.booleanValue()) {
                promoBool = Boolean.valueOf(true);
                try {
                	//Setting all bools to false allowing videos to start with one tap rather than multiple
               	 miuBool = Boolean.valueOf(false);
                    staticBool = Boolean.valueOf(false);
                    doNotBool = Boolean.valueOf(false);
                    hiddenBool = Boolean.valueOf(false);
                    safetyBypassBool = Boolean.valueOf(false);
                    promoLoopBool = Boolean.valueOf(false);
                  currentVideo.setText("Current Video: Girls in STEM");
                  pbStop = new ProcessBuilder(new String[] { "bash", "-c", "sudo killall omxplayer.bin" });
                  processStop = pbStop.start();
                  pb = new ProcessBuilder(new String[] { "bash", "-c", "omxplayer --win \"0 0 1900 1050\" --display=5 --no-osd --loop /home/pi/Videos/promoVideo.mov" });
                  process = pb.start();
                }
                catch (IOException e1)
                {
                  e1.printStackTrace();
                }
                
              }
              else if (promoBool.booleanValue()) {
                try {
                  pb = new ProcessBuilder(new String[] { "bash", "-c", "sudo killall omxplayer.bin" });
                  process = pb.start();
                  currentVideo.setText("Current Video: ");
                  promoBool = Boolean.valueOf(false);
                }
                catch (IOException e1)
                {
                  e1.printStackTrace();
                }
              }
                break;
                
                case "Safety":
                	if (!safetyBypassBool.booleanValue()) {
                        safetyBypassBool = Boolean.valueOf(true);
                        try {
                        	//Setting all bools to false allowing videos to start with one tap rather than multiple
                       	 miuBool = Boolean.valueOf(false);
                            staticBool = Boolean.valueOf(false);
                            doNotBool = Boolean.valueOf(false);
                            hiddenBool = Boolean.valueOf(false);
                            promoLoopBool = Boolean.valueOf(false);
                            promoBool = Boolean.valueOf(false);
                          currentVideo.setText("Current Video: Safety Video");
                          pbStop = new ProcessBuilder(new String[] { "bash", "-c", "sudo killall omxplayer.bin" });
                          processStop = pbStop.start();
                          pb = new ProcessBuilder(new String[] { "bash", "-c", "omxplayer --win \"0 0 1900 1050\" --display=5 --no-osd --loop /home/pi/Videos/safetyBypass.mov" });
                          process = pb.start();
                        }
                        catch (IOException e1)
                        {
                          e1.printStackTrace();
                        }
                        
                      }
                      else if (safetyBypassBool.booleanValue()) {
                        try {
                          pb = new ProcessBuilder(new String[] { "bash", "-c", "sudo killall omxplayer.bin" });
                          process = pb.start();
                          currentVideo.setText("Current Video: ");
                          safetyBypassBool = Boolean.valueOf(false);
                        }
                        catch (IOException e1)
                        {
                          e1.printStackTrace();
                        }
                        
                      }
                	break;
                
              }
        }
    
    @FXML
    private void exit(ActionEvent event) {
        try {
    			pb = new ProcessBuilder(new String[] { "bash", "-c", "sudo killall omxplayer.bin" });
			process = pb.start();
	        System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
