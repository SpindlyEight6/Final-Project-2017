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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
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
        
        // Groups For The Stuff
        Group root1 = new Group();
        Group root2 = new Group();
        
        // Setting The Scenes
        final Scene game = new Scene(root1, 500, 500);
        final Scene win = new Scene(root2, 500, 500);
        
        // Add CSS Styling To The Application
        game.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        // Adds the pictures        
        Image pic = new Image("cookie.png");    
        Image clikdpic = new Image("smallcookie.png");                
        ImageView iv = new ImageView(pic);
        iv.setLayoutY(150);
        
        // Adds The Label For Cookies
        Label cookieNum = new Label("");
        cookieNum.setFont(Font.font(20));
        cookieNum.setLayoutX(85);
        cookieNum.setLayoutY(350);
        // Cheat For The Game
        PasswordField cheat = new PasswordField();
        cheat.setPromptText("Enter the Password.");
        
        // Adds The Double Click Stuff 
        Button doubleClickBtn = new Button();
        doubleClickBtn.setText("Buy Double Click (+2 Click)");
        doubleClickBtn.setLayoutX(x);
        doubleClickBtn.setLayoutY(50);
        Label doubleclicklbl = new Label();
        
        
        // Adds The Multi Click Button
        Button multiClickBtn = new Button();
        multiClickBtn.setText("Buy Multi-Click (+3 Click)");
        multiClickBtn.setLayoutX(x);
        multiClickBtn.setLayoutY(75);
       
        
        // Adds The Rapid Click Button
        Button rapidClickBtn = new Button();
        rapidClickBtn.setText("Buy Rapid Click (+16 Click)");
        rapidClickBtn.setLayoutX(x);
        rapidClickBtn.setLayoutY(100);
        
        // Adds The God Click Button
        Button godClickBtn = new Button();
        godClickBtn.setText("Buy God Click (+64 Click)");
        godClickBtn.setLayoutX(x);
        godClickBtn.setLayoutY(125);
        
        // Adds The Master Click Button
        Button masterClickBtn = new Button();
        masterClickBtn.setText("Buy Master Click (+256 Click)");
        masterClickBtn.setLayoutX(x);
        masterClickBtn.setLayoutY(150);
        
        // Adds The Fire Click Button
        Button fireClickBtn = new Button();
        fireClickBtn.setText("Buy Fire Click (+1,024 Click)");
        fireClickBtn.setLayoutX(x);
        fireClickBtn.setLayoutY(175);
        
        // Adds The Baker Button
        Button bakerBtn = new Button();
        bakerBtn.setText("Buy Baker (+1/s)");
        bakerBtn.setLayoutX(x);
        bakerBtn.setLayoutY(200);
        
        // Adds The Chef Button
        Button chefBtn = new Button();
        chefBtn.setText("Buy Chef (+8/s)");
        chefBtn.setLayoutX(x);
        chefBtn.setLayoutY(225);
        
        // Adds The Linguini Button
        Button linguiniBtn = new Button();
        linguiniBtn.setText("Buy Linguini(+32/s)");
        linguiniBtn.setLayoutX(x);
        linguiniBtn.setLayoutY(250);
        
        // Adds The God Button
        Button godBtn = new Button();
        godBtn.setText("Buy God (+128/s)");
        godBtn.setLayoutX(x);
        godBtn.setLayoutY(275);
        
        // Adds The John Cena Button do do do do
        Button johnBtn = new Button();
        johnBtn.setText("Buy John Cena (+1,024/s)");
        johnBtn.setLayoutX(x);
        johnBtn.setLayoutY(300);
        
        // Adds The Guy Fieri Button
        Button guyBtn = new Button();
        guyBtn.setText("Buy Guy Fieri (+8,192/s)");
        guyBtn.setLayoutX(x);
        guyBtn.setLayoutY(325);
        
        // Adds The Gordan Ramsey Button
        Button gordonBtn = new Button();
        gordonBtn.setText("Buy Gordon Ramsey (+32,768/s)");
        gordonBtn.setLayoutX(x);
        gordonBtn.setLayoutY(350);
        
        // Makes Window And Adds Things To It For Game 
        root1.getChildren().addAll(iv,cookieNum,doubleClickBtn,multiClickBtn,
        rapidClickBtn,godClickBtn,masterClickBtn,fireClickBtn,bakerBtn,
        chefBtn,linguiniBtn,godBtn,johnBtn,guyBtn,gordonBtn,cheat);
        
        // All The Stuff For Win Screen
        
        // Misc. Label
        Label winLbl = new Label("You have won!");
        winLbl.setFont(Font.font(20));
        winLbl.setLayoutX(85);
        winLbl.setLayoutY(350);
        
        root2.getChildren().addAll(winLbl);
        // End Win Screen Stuff
        
        // Handles Pressing Of Cookie
        iv.setOnMousePressed((e)->{
            iv.setImage(clikdpic);
            cookies+= cpc;
        });
        
        // Handles Releasing Of Cookie
        iv.setOnMouseReleased((e)->{
            iv.setImage(pic);
            cookieNum.setText(cookies+"");
        });
        
        // Stops Tim After The App Closes
        primaryStage.setOnCloseRequest((e) -> {
            tim.cancel();
            tim.purge();
        });
        
        // Handles Cheating
        cheat.setOnAction((e)-> {
        if (cheat.getText().equals("win")){
            // Do The Stuff to Change To A Win Screen
            System.out.println("You have Won!!!!!!!?!!!");
            primaryStage.setScene(win);
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
            cookieNum.setText(cookies+"");
        });
        
        // Handles Double Clicks
        multiClickBtn.setOnMousePressed((e)->{
            if (cookies >= 256){
                cookies -= 256;
                cpc += 3;
            }            
            cookieNum.setText(cookies+"");
        });
        
        // Handles Rapid Clicks
        rapidClickBtn.setOnMousePressed((e)->{
            if (cookies >= 2048){
                cookies -= 2048;
                cpc += 16;
            }            
            cookieNum.setText(cookies+"");
        });
        
        // Handles God Clicks
        godClickBtn.setOnMousePressed((e)->{
            if (cookies >= 16384){
                cookies -= 16384;
                cpc += 64;
            }            
            cookieNum.setText(cookies+"");
        });
        
        // Handles Master Clicks
        masterClickBtn.setOnMousePressed((e)->{
            if (cookies >= 131072){
                cookies -= 131072;
                cpc += 256;
            }            
            cookieNum.setText(cookies+"");
        });
        
        // Handles Fire Clicks
        fireClickBtn.setOnMousePressed((e)->{
            if (cookies >= 1048576){
                cookies -= 1048576;
                cpc += 1024;
            }            
            cookieNum.setText(cookies+"");
        });
        
        //  Handles Baker Clicks
        bakerBtn.setOnMousePressed((e) ->{
            if (cookies >= 64){
                cookies -= 64;
                cps += 1;
            }
        });        
        
        // Shows Window\
        primaryStage.setTitle("Cookie Clicker");
        primaryStage.setScene(game);
        primaryStage.show();
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
