/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author gavin1706s
 */

public class Test extends Application {    
    // Number Of Cookies You Have
    private int cookies;    
    // Number Of Cookies You Get Per Click
    private int cpc;    
    // Number Of Cookies Per Second
    private int cps;
    // X-Cord For All The Buttons
    public int x = 200;
    
    @Override
    public void start(Stage primaryStage) {
        // Money
        cookies = 0;
        
        // Cookies Per Click
        cpc = 1;
        
        // Cookies Per Second
        cps = 0;
        
        // Condition For the Timer To Run
        boolean run = true;
        
        // Makes A Timer Named Tim
        Timer tim = new Timer();
        
        // TimerTask To Make cps To cookies
        class cps2Cookies extends TimerTask {
            @Override
            public void run() {
                if (run)  {
                    cookies += cps;  
                }else{
                    tim.cancel();
                    tim.purge();
                }
                
            }
        }        
        // Makes Tim Run cps2Cookies
        tim.schedule(new cps2Cookies(), 0, 1000);
        
        // Add CSS Styling To The Application
        Application.setUserAgentStylesheet(getClass().getResource("stylesheet.css").toExternalForm());
        
        // Adds the pictures        
        Image pic = new Image("cookie.png");    
        Image clikdpic = new Image("smallcookie.png");                
        ImageView iv = new ImageView(pic);
        iv.setLayoutY(150);
        
        // Adds The Label For Points
        Label lbl = new Label("");
        lbl.setFont(Font.font(20));
        lbl.setLayoutX(85);
        lbl.setLayoutY(350);
        
        // Cheat For The Game
        PasswordField cheat = new PasswordField();
        cheat.setPromptText("Enter the Password.");
        
        // Adds The Double Click Stuff 
        Button doubleClickBtn = new Button();
        doubleClickBtn.setText("Buy Double Click");
        doubleClickBtn.setLayoutX(x);
        doubleClickBtn.setLayoutY(50);
        Label doubleclicklbl = new Label();
        
        // Adds The Multi Click Button
        Button multiClickBtn = new Button();
        multiClickBtn.setText("Buy Multi-Click");
        multiClickBtn.setLayoutX(x);
        multiClickBtn.setLayoutY(75);
        
        // Adds The Rapid Click Button
        Button rapidClickBtn = new Button();
        rapidClickBtn.setText("Buy Rapid Click");
        rapidClickBtn.setLayoutX(x);
        rapidClickBtn.setLayoutY(100);
        
        // Adds The God Click Button
        Button godClickBtn = new Button();
        godClickBtn.setText("Buy God Click");
        godClickBtn.setLayoutX(x);
        godClickBtn.setLayoutY(125);
        
        // Adds The Master Click Button
        Button masterClickBtn = new Button();
        masterClickBtn.setText("Buy Master Click");
        masterClickBtn.setLayoutX(x);
        masterClickBtn.setLayoutY(150);
        
        // Adds The Fire Click Button
        Button fireClickBtn = new Button();
        fireClickBtn.setText("Buy Fire Click");
        fireClickBtn.setLayoutX(x);
        fireClickBtn.setLayoutY(175);
        
        // Adds The Baker Button
        Button bakerBtn = new Button();
        bakerBtn.setText("Buy Baker");
        bakerBtn.setLayoutX(x);
        bakerBtn.setLayoutY(200);
        
        // Adds The Chef Button
        Button chefBtn = new Button();
        chefBtn.setText("Buy Chef");
        chefBtn.setLayoutX(x);
        chefBtn.setLayoutY(225);
        
        // Adds The Linguini Button
        Button linguiniBtn = new Button();
        linguiniBtn.setText("Buy Linguini");
        linguiniBtn.setLayoutX(x);
        linguiniBtn.setLayoutY(250);
        
        // Adds The God Button
        Button godBtn = new Button();
        godBtn.setText("Buy God");
        godBtn.setLayoutX(x);
        godBtn.setLayoutY(275);
        
        // Adds The John Cena Button do do do do
        Button johnBtn = new Button();
        johnBtn.setText("Buy John Cena");
        johnBtn.setLayoutX(x);
        johnBtn.setLayoutY(300);
        
        // Adds The Guy Fieri Button
        Button guyBtn = new Button();
        guyBtn.setText("Buy Guy Fieri");
        guyBtn.setLayoutX(x);
        guyBtn.setLayoutY(325);
        
        // Adds The Gordan Ramsey Button
        Button gordonBtn = new Button();
        gordonBtn.setText("Buy Gordon Ramsey");
        gordonBtn.setLayoutX(x);
        gordonBtn.setLayoutY(350);
        
        // Makes Window And Adds Things To It
        Pane root = new Pane();
        root.getChildren().addAll(iv,lbl,doubleClickBtn,multiClickBtn,
        rapidClickBtn,godClickBtn,masterClickBtn,fireClickBtn,bakerBtn,
        chefBtn,linguiniBtn,godBtn,johnBtn,guyBtn,gordonBtn,cheat);
        
        // Handles Pressing Of Cookie
        iv.setOnMousePressed((e)->{
            iv.setImage(clikdpic);
            cookies+= cpc;
        });
        
        // Handles Releasing Of Cookie
        iv.setOnMouseReleased((e)->{
            iv.setImage(pic);
            lbl.setText(cookies+"");
        });
        
        // Handles Cheating
        cheat.setOnAction((e)-> {
        if (cheat.getText().equals("win")){
            // Do The Stuff to Change To A Win Screen
            System.out.println("You have Won!!!!!!!?!!!");
            tim.cancel();
            tim.purge();
        }else{
            cheat.clear();
        }        
        }); 
        
        // Handles double Clicks
        doubleClickBtn.setOnMousePressed((e)->{
            if (cookies >= 64){
                cookies -= 64;
                cpc += 2;
            }            
            lbl.setText(cookies+"");
        });
        
        // Handles Double Clicks
        multiClickBtn.setOnMousePressed((e)->{
            if (cookies >= 256){
                cookies -= 256;
                cpc += 3;
            }            
            lbl.setText(cookies+"");
        });
        
        // Handles Rapid Clicks
        rapidClickBtn.setOnMousePressed((e)->{
            if (cookies >= 2048){
                cookies -= 2048;
                cpc += 16;
            }            
            lbl.setText(cookies+"");
        });
        
        // Handles God Clicks
        godClickBtn.setOnMousePressed((e)->{
            if (cookies >= 16384){
                cookies -= 16384;
                cpc += 64;
            }            
            lbl.setText(cookies+"");
        });
        
        // Handles Master Clicks
        masterClickBtn.setOnMousePressed((e)->{
            if (cookies >= 131072){
                cookies -= 131072;
                cpc += 256;
            }            
            lbl.setText(cookies+"");
        });
        
        // Handles Fire Clicks
        fireClickBtn.setOnMousePressed((e)->{
            if (cookies >= 1048576){
                cookies -= 1048576;
                cpc += 1024;
            }            
            lbl.setText(cookies+"");
        });
        
        //  Handles Baker Clicks
        bakerBtn.setOnMousePressed((e) ->{
            if (cookies >= 64){
                cookies -= 64;
                cps += 1;
            }
        });
        
        // Shows Window
        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        primaryStage.setTitle("Cookie Clicker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // The Second Screen
    public void start2(Stage secondaryStage) {
        
        Label lbl = new Label("You have won!");
        lbl.setFont(Font.font(20));
        lbl.setLayoutX(85);
        lbl.setLayoutY(350);
        
        Pane root = new Pane();
        root.getChildren().addAll(lbl);
        
        Scene scene = new Scene(root, 500, 500);
        secondaryStage.setTitle("Cookie Clicker");
        secondaryStage.setScene(scene);
        secondaryStage.hide();
    }
    
    // Adds cookies
    public void addPoints(){
        cookies++;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
