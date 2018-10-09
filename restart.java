
//isLetterKey ->says if a char is letter a-z
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
//import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;
//import javafx.animation.Timeline;
//import javafx.util.Duration;
import javafx.scene.text.Text;
import java.io.*;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.*;
import java.util.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class restart extends Application {
    

    @Override
    public void start(Stage stage) throws  IOException {
        boolean spread = true;
        
        
        Rectangle rect= new Rectangle();
        rect.setX(0.0f);
        rect.setY(600.0f);
        rect.setHeight(100.0f);
        rect.setWidth(600.0f);
        rect.setFill(Color.BLUE);
        
        Image image = new Image("minesweeper square.png",20,20, false, false);
        Image uncover = new Image("white square.png",20,20, false, false);
        Image one = new Image("1 square.png",20,20, false, false);
        Image two = new Image("2 square.png",20,20, false, false);
        Image three = new Image("3 square.png",20,20, false, false);
        Image four = new Image("4 square.png",20,20, false, false);
        Image five = new Image("5 square.png",20,20, false, false);
        Image six = new Image("6 square.png",20,20, false, false);
        Image seven = new Image("7 square.png",20,20, false, false);
        Image eight = new Image("8 square.png",20,20, false, false);
        Image bomb = new Image("bomb.png",20,20,false, false);
        

        Button win=new Button();
        win.setText("win");
        win.setTranslateX(100);
        win.setTranslateY(200);
        win.setVisible(false);
        
        Button lose=new Button();
        lose.setText("lose");
        lose.setTranslateX(200);
        lose.setTranslateY(200);
        lose.setVisible(false);
        
        
        Button play=new Button();
        play.setText("play");
        play.setTranslateX(150);
        play.setTranslateY(100);
        play.setVisible(true);
        
        Button playAgain=new Button();
        playAgain.setText("play Again");
        playAgain.setTranslateX(150);
        playAgain.setTranslateY(650);
        playAgain.setVisible(false);
        
        Group root = new Group(rect,win,lose,play,playAgain);
        Scene scene = new Scene(root, 600, 700);
        stage.setTitle("Drawing stuff");
        stage.setScene(scene);
        stage.show();
        ArrayList<Button>box = new ArrayList <Button>();
        for(int i=0; i<16;i++)
        {
             for(int j=0; j<16;j++)
             {
                 box.add(new Button());
                        
             }
        }
        for(int i=0;i<box.size();i++)
        {
            HBox hbox = new HBox();
            box.get(i).setTranslateX(((i%16)*35)+20);
            box.get(i).setTranslateY(((i/16)*30)+50);
            box.get(i).setPrefWidth(25.0);
            box.get(i).setPrefHeight(30.0);
            HBox.setHgrow(box.get(i), Priority.ALWAYS);
            HBox.setMargin(box.get(i),new Insets(1,1,1,1)); 
            box.get(i).setGraphic(new ImageView(image));
            root.getChildren().add(box.get(i));
            box.get(i).setVisible(false);
            
        }
        ArrayList<Integer> uncovered = new ArrayList<Integer>();
        while(uncovered.size()>0)
        {
            uncovered.remove(0);
        }
        play.setOnAction(new EventHandler<ActionEvent>() {
                @Override
            public void handle(ActionEvent event) {
                //win.setVisible(true);
                //lose.setVisible(true);
                while(uncovered.size()>0)
                {
                    uncovered.remove(0);
                }
                for(int i=0;i<box.size();i++)
                {
                    box.get(i).setGraphic(new ImageView(image));
                }
                play.setVisible(false);
                int distribute=0;
                Set<Integer> mine = new HashSet<Integer>(); 
                for(int i=0;i<box.size();i++)
                {
                    box.get(i).setVisible(true);
                    final int buttonInd = i;
                    box.get(i).setOnAction(e -> {
                    System.out.println("Button pressed " + ((Button) e.getSource()).getText()+buttonInd);
                });
                ArrayList<Integer> adj = new ArrayList<Integer>();    
                box.get(buttonInd).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                        public void handle(ActionEvent event) {
                            
                            
                                uncovered.add(buttonInd);
                            
                            boolean distribute=false;
                            int ad=0;
                            
                            for(int i=0;i<uncovered.size();i++)
                            {
                                
                            }
                            if (uncovered.size()==1)
                            {
                                
                                
                                    
                                    while(mine.size()<40)
                                    {
                                        mine.add((int)(Math.random()*255));
                                        if (mine.contains(uncovered.get(0))==true)
                                        {
                                            System.out.print("Crash");
                                            mine.remove(mine.size()-1);
                                        }
                                    }
                                
                                    //System.out.println("a");
                                    
                                
                            }
                            for(int i=0;i<box.size();i++)
                            {   
                                ad=0;
                                if(i>15)
                                {
                                    if(mine.contains(i-16))
                                    {
                                        ad++;
                                    }
                                }
                                if(i<240)
                                {
                                    if(mine.contains(i+16))
                                    {
                                        ad++;
                                    }
                                }
                                if(i%16>0)
                                {
                                    if(mine.contains(i-1))
                                    {
                                        ad++;
                                    }
                                }
                                if(i%16<15)
                                {
                                    if(mine.contains(i+1))
                                    {
                                        ad++;
                                    }
                                }
                                if(i%16>0&&i>15)
                                {
                                    if(mine.contains(i-17))
                                    {
                                        ad++;
                                    }
                                }
                                if(i%16>0&&i<240)
                                {
                                    if(mine.contains(i+15))
                                    {
                                        ad++;
                                    }
                                }
                                if(i%16<15&&i>15)
                                {
                                    if(mine.contains(i-15))
                                    {
                                        ad++;
                                    }
                                }
                                if(i%16<15&&i<240)
                                {
                                    if(mine.contains(i+17))
                                    {
                                        ad++;
                                    }
                                }
                                adj.add(ad);
                            }

                            
                            boolean gameOver = false;
                            int victory = 0;
                            for (int i=0;i<uncovered.size();i++)
                            if (adj.get(uncovered.get(i))==0)
                            {
                                box.get(uncovered.get(i)).setGraphic(new ImageView(uncover));
                                if(i>15)
                                {
                                    uncovered.add(uncovered.get(i-16));
                                }
                                if(i<240)
                                {
                                    uncovered.add(uncovered.get(i+16));
                                }
                                if(i%16>0)
                                {
                                    uncovered.add(uncovered.get(i-1));
                                }
                                if(i%16<15)
                                {
                                    uncovered.add(uncovered.get(i+1));
                                }
                                if(i%16>0&&i>15)
                                {
                                    uncovered.add(uncovered.get(i-17));
                                }
                                if(i%16>0&&i<240)
                                {
                                    uncovered.add(uncovered.get(i+15));
                                }
                                if(i%16<15&&i>15)
                                {
                                    uncovered.add(uncovered.get(i-15));
                                }
                                if(i%16<15&&i<240)
                                {
                                    uncovered.add(uncovered.get(i+17));
                                }
                                    
                                
                            }
                            else if (adj.get(uncovered.get(i)) == 1)
                            {
                                box.get(uncovered.get(i)).setGraphic(new ImageView(one));
                            }
                            else if (adj.get(uncovered.get(i)) == 2)
                            {
                                box.get(uncovered.get(i)).setGraphic(new ImageView(two));
                            }
                            else if (adj.get(uncovered.get(i)) == 3)
                            {
                                box.get(uncovered.get(i)).setGraphic(new ImageView(three));
                            }
                            else if (adj.get(uncovered.get(i)) == 4)
                            {
                                box.get(uncovered.get(i)).setGraphic(new ImageView(four));
                            }
                            else if (adj.get(uncovered.get(i)) == 5)
                            {
                                box.get(uncovered.get(i)).setGraphic(new ImageView(five));
                            }
                            else if (adj.get(uncovered.get(i)) == 6)
                            {
                                box.get(uncovered.get(i)).setGraphic(new ImageView(six));
                            }
                            else if (adj.get(uncovered.get(i)) == 7)
                            {
                                box.get(uncovered.get(i)).setGraphic(new ImageView(seven));
                            }
                            else if (adj.get(uncovered.get(i)) == 8)
                            {
                                box.get(uncovered.get(i)).setGraphic(new ImageView(eight));
                            }
                            else if (mine.contains(uncovered.get(i)))
                            {
                                box.get(uncovered.get(i)).setGraphic(new ImageView(bomb));
                            }
                        
                        
                            System.out.println(mine);
                            System.out.println(buttonInd);
                            for(int i=0;i<uncovered.size();i++)
                            {
                                if(mine.contains(uncovered.get(i))&&i!=0)
                                {
                                    gameOver = true;
                                    victory =1;
                                    
                                }
                            }
                                if (gameOver==true)
                                {
                                    playAgain.setVisible(true);
                                    for (int j=0;j<box.size();j++)
                                    {
                                        if(mine.contains(j))
                                        {
                                            box.get(j).setGraphic(new ImageView(bomb));
                                        }
                                    }
                                    if (victory==1)
                                    {
                                    
                                    }
                                    if (victory==2)
                                    {   
                
                                    }
                                }
                        }
                });
                       
                
            


                }
                
            }
        });
        /*win.setOnAction(new EventHandler<ActionEvent>() {
                @Override
            public void handle(ActionEvent event) {
                playAgain.setVisible(true);
                win.setVisible(false);
                lose.setVisible(false);
                for(int i=0;i<box.size();i++)
                {
                    box.get(i).setVisible(false);
                }
                }
        });*/
        /*lose.setOnAction(new EventHandler<ActionEvent>() {
                @Override
            public void handle(ActionEvent event) {
                playAgain.setVisible(true);
                win.setVisible(false);
                lose.setVisible(false);
                for(int i=0;i<box.size();i++)
                {
                    box.get(i).setVisible(false);
            
                }
                }
        });*/
       
        playAgain.setOnAction(new EventHandler<ActionEvent>() {
                @Override
            public void handle(ActionEvent event) {
                play.setVisible(true);
                win.setVisible(false);
                lose.setVisible(false);
                playAgain.setVisible(false);
                while(uncovered.size()>0)
                {
                    uncovered.remove(0);
                }
                    for (int j=0;j<box.size();j++)
                                    {
                                        
                                            box.get(j).setVisible(false);
                                        
                                    }
                }
        });
        
        

    }
    public static void main(String args[]){
        launch(args);
        
    }
    
   }

