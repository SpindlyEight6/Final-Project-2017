/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    // X-Cord For All the Labels
    public int x2 = 330;
    
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
        final Scene game = new Scene(root1, 520, 400);
        final Scene win = new Scene(root2, 400, 400);
        
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
        doubleClickBtn.setText("Buy Double Click");
        doubleClickBtn.setLayoutX(x);
        doubleClickBtn.setLayoutY(50);
        Label doubleClickLbl = new Label("Cost: 64 Gives: +2 clicks");
        doubleClickLbl.setLayoutX(x2);
        doubleClickLbl.setLayoutY(50);
        
        // Adds The Multi Click Stuff
        Button multiClickBtn = new Button();
        multiClickBtn.setText("Buy Multi-Click");
        multiClickBtn.setLayoutX(x);
        multiClickBtn.setLayoutY(75);
        Label multiClickLbl = new Label("Cost: 256 Gives: +3 clicks");
        multiClickLbl.setLayoutX(x2);
        multiClickLbl.setLayoutY(75);
        
        // Adds The Rapid Click Stuff
        Button rapidClickBtn = new Button();
        rapidClickBtn.setText("Buy Rapid Click");
        rapidClickBtn.setLayoutX(x);
        rapidClickBtn.setLayoutY(100);
        Label rapidClickLbl = new Label("Cost: 2,048 Gives: +16 clicks");
        rapidClickLbl.setLayoutX(x2);
        rapidClickLbl.setLayoutY(100);
        
        // Adds The God Click Stuff
        Button godClickBtn = new Button();
        godClickBtn.setText("Buy God Click");
        godClickBtn.setLayoutX(x);
        godClickBtn.setLayoutY(125);
        Label godClickLbl = new Label("Cost: 16,384 Gives: +64 clicks");
        godClickLbl.setLayoutX(x2);
        godClickLbl.setLayoutY(125);        
        
        // Adds The Master Click Stuff
        Button masterClickBtn = new Button();
        masterClickBtn.setText("Buy Master Click");
        masterClickBtn.setLayoutX(x);
        masterClickBtn.setLayoutY(150);
        Label masterClickLbl = new Label("Cost: 131,072 Gives: +256 clicks");
        masterClickLbl.setLayoutX(x2);
        masterClickLbl.setLayoutY(150);
        
        // Adds The Fire Click Stuff
        Button fireClickBtn = new Button();
        fireClickBtn.setText("Buy Fire Click");
        fireClickBtn.setLayoutX(x);
        fireClickBtn.setLayoutY(175);
        Label fireClickLbl = new Label("Cost: 1,048,576 Gives: +1,024 clicks");
        fireClickLbl.setLayoutX(x2);
        fireClickLbl.setLayoutY(175);
        
        // Adds The Baker Stuff
        Button bakerBtn = new Button();
        bakerBtn.setText("Buy Baker");
        bakerBtn.setLayoutX(x);
        bakerBtn.setLayoutY(200);
        Label bakerLbl = new Label("Cost: 64 Gives: +1/s");
        bakerLbl.setLayoutX(x2);
        bakerLbl.setLayoutY(200);
        
        // Adds The Chef Stuff
        Button chefBtn = new Button();
        chefBtn.setText("Buy Chef");
        chefBtn.setLayoutX(x);
        chefBtn.setLayoutY(225);
        Label chefLbl = new Label("Cost: 500 Gives: +8/s");
        chefLbl.setLayoutX(x2);
        chefLbl.setLayoutY(225);
        
        // Adds The Linguini Stuff
        Button linguiniBtn = new Button();
        linguiniBtn.setText("Buy Linguini");
        linguiniBtn.setLayoutX(x);
        linguiniBtn.setLayoutY(250);
        Label linguiniLbl = new Label("Cost: 4,000 Gives: +32/s");
        linguiniLbl.setLayoutX(x2);
        linguiniLbl.setLayoutY(250);
        
        // Adds The God Stuff
        Button godBtn = new Button();
        godBtn.setText("Buy God");
        godBtn.setLayoutX(x);
        godBtn.setLayoutY(275);
        Label godLbl = new Label("Cost: 32,000 Gives: +128/s");
        godLbl.setLayoutX(x2);
        godLbl.setLayoutY(275);
        
        // Adds The John Cena Stuff do do do do
        Button johnBtn = new Button();
        johnBtn.setText("Buy John Cena");
        johnBtn.setLayoutX(x);
        johnBtn.setLayoutY(300);
        Label johnLbl = new Label("Cost: 1,048,576 Gives: +1,024/s");
        johnLbl.setLayoutX(x2);
        johnLbl.setLayoutY(300);
        
        // Adds The Guy Fieri Stuff
        Button guyBtn = new Button();
        guyBtn.setText("Buy Guy Fieri");
        guyBtn.setLayoutX(x);
        guyBtn.setLayoutY(325);
        Label guyLbl = new Label("Cost: 8,388,608 Gives: +8,192/s");
        guyLbl.setLayoutX(x2);
        guyLbl.setLayoutY(325);
        
        // Adds The Gordan Ramsey Stuff
        Button gordonBtn = new Button();
        gordonBtn.setText("Buy Gordon Ramsey");
        gordonBtn.setLayoutX(x);
        gordonBtn.setLayoutY(350);
        Label gordonLbl = new Label("Cost: 67,108,864 Gives: +32,768/s");
        gordonLbl.setLayoutX(x2);
        gordonLbl.setLayoutY(350);
        
        // Makes Window And Adds Things To It For Game 
        root1.getChildren().addAll(iv,cookieNum,doubleClickBtn,multiClickBtn,
        rapidClickBtn,godClickBtn,masterClickBtn,fireClickBtn,bakerBtn,
        chefBtn,linguiniBtn,godBtn,johnBtn,guyBtn,gordonBtn,cheat,doubleClickLbl,
        multiClickLbl,rapidClickLbl,godClickLbl,masterClickLbl,fireClickLbl,
        bakerLbl,chefLbl,linguiniLbl,godLbl,johnLbl,guyLbl,gordonLbl);
        
        // All The Stuff For Win Screen
        
        // Misc. Label
        Label winLbl = new Label("You have won!");
        winLbl.setFont(Font.font(20));
        winLbl.setLayoutX(win.getWidth()/2);
        winLbl.setLayoutY(win.getHeight()/2);
        
        
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
