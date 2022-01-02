package com.example.demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Group root =new Group();
        Scene scene = new Scene(root, 600, 600,Color.rgb(229,255,204));
        //Text
        Text txt =new Text(120,30,"Welcom to Open Source Project");
        root.getChildren().add(txt);
        Font myfont=new Font("century gothic",25);
        txt.setFont(myfont);
        txt.setFill(Color.DARKBLUE);
        DropShadow shadow= new DropShadow(5,4,4,Color.BLACK);
        txt.setEffect(shadow);
        //label
        Label lbl0 =new Label(" enter 1 to insert data in database file " +
                "\n enter 2 to delete data from database file" +
                "\n enter 3 to update data in database file" +
                "\n enter 4 to search in  database file\n" +
                " enter 0 to break");
        lbl0.setLayoutX(50);
        lbl0.setLayoutY(60);
        root.getChildren().add(lbl0);
        //label
        Label lbl1 =new Label("Enter The Number : ");
        lbl1.setLayoutX(50);
        lbl1.setLayoutY(200);
        root.getChildren().add(lbl1);
        //TextField
        TextField in =new TextField();
        in.setLayoutX(180);
        in.setLayoutY(200);
        root.getChildren().add(in);
        //Button
        Button btn= new Button();
        btn.setLayoutX(180);
        btn.setLayoutY(240);
        btn.setText("Click Enter");
        root.getChildren().add(btn);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArrayList<String>arrayList=new ArrayList<String>();
                String filename = "database.csv";
                int x= Integer.parseInt(in.getText());
                if(x==1){
                    try {
                        Group root =new Group();
                        Scene scene = new Scene(root, 600, 600, Color.rgb(229,255,204));
                        Stage stage2 = new Stage();
                        stage2.setTitle("Insert Window");
                        stage2.setScene(scene);
                        stage2.show();
                        //
                        Label lbl =new Label("Enter your id : ");
                        lbl.setLayoutX(50);
                        lbl.setLayoutY(10);
                        root.getChildren().add(lbl);
                        TextField in =new TextField();
                        in.setLayoutX(180);
                        in.setLayoutY(10);
                        root.getChildren().add(in);
                        //
                        Label lbl1 =new Label("Enter your Name : ");
                        lbl1.setLayoutX(50);
                        lbl1.setLayoutY(60);
                        root.getChildren().add(lbl1);
                        TextField in0 =new TextField();
                        in0.setLayoutX(180);
                        in0.setLayoutY(60);
                        root.getChildren().add(in0);
                        //
                        Label lbl2 =new Label("Enter your gpa : ");
                        lbl2.setLayoutX(50);
                        lbl2.setLayoutY(110);
                        root.getChildren().add(lbl2);
                        TextField in1 =new TextField();
                        in1.setLayoutX(180);
                        in1.setLayoutY(110);
                        root.getChildren().add(in1);
                        //
                        Label lbl3 =new Label("Enter your Department : ");
                        lbl3.setLayoutX(50);
                        lbl3.setLayoutY(160);
                        root.getChildren().add(lbl3);
                        TextField in2 =new TextField();
                        in2.setLayoutX(180);
                        in2.setLayoutY(160);
                        root.getChildren().add(in2);
                        //
                        Label lbl4 =new Label("Enter your Address : ");
                        lbl4.setLayoutX(50);
                        lbl4.setLayoutY(210);
                        root.getChildren().add(lbl4);
                        TextField in3 =new TextField();
                        in3.setLayoutX(180);
                        in3.setLayoutY(210);
                        root.getChildren().add(in3);
                        //
                        Button btn=new Button();
                        btn.setLayoutY(250);
                        btn.setLayoutX(200);
                        btn.setText("insert data");
                        root.getChildren().add(btn);

                        btn.setOnAction((ActionEvent e)->{
                                    Student student = new Student(Integer.parseInt(in.getText()), in0.getText(),Double.parseDouble(in1.getText()), in2.getText(), in3.getText());
                                    int studet_id = student.getId();
                                    String student_name = student.getName();
                                    Double student_gpa = student.getGpa();
                                    String student_dpt = student.getDpt();
                                    String student_address = student.getAddress();
                                    try {
                                        FileWriter database = new FileWriter( filename, true);
                                        database.append(studet_id + "," + student_name + "," + student_gpa + "," + student_dpt + "," + student_address);
                                        database.append("\n");
                                        database.close();

                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                    stage2.close();
                                }
                        );



                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else if(x==2){
                    Group root =new Group();
                    Scene scene = new Scene(root, 600, 600, Color.rgb(229,255,204));
                    Stage stage3 = new Stage();
                    stage3.setTitle("Delete Window");
                    stage3.setScene(scene);
                    stage3.show();
                    Label lbl =new Label("Enter your Search Key : ");
                    lbl.setLayoutX(50);
                    lbl.setLayoutY(10);
                    root.getChildren().add(lbl);
                    TextField in =new TextField();
                    in.setLayoutX(180);
                    in.setLayoutY(10);
                    root.getChildren().add(in);
                    //
                    Button Btn =new Button();
                    Btn.setText("Delete");
                    Btn.setLayoutX(350);
                    Btn.setLayoutY(10);
                    root.getChildren().add(Btn);
                    Btn.setOnAction((ActionEvent e)->{
                        String searchkey =in.getText();
                        String line;
                        try {
                            BufferedReader reader=new BufferedReader(new FileReader(filename));
                            while ((line=reader.readLine())!=null){
                                if (line.contains(searchkey)){
                                    System.out.println(line);
                                    continue;
                                }else {
                                    arrayList.add(line);
                                }

                            }
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                        try {
                            FileWriter writer=new FileWriter(filename);
                            for (int i=0;i<arrayList.size();i++){
                                writer.append(arrayList.get(i));
                                writer.append("\n");

                            }
                            writer.close();
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }finally {
                            System.out.println("done!");
                        }
                 stage3.close();


                    });

                }
                else if(x==3){
                    Group root =new Group();
                    Scene scene = new Scene(root, 600, 600, Color.rgb(229,255,204));
                    Stage stage4 = new Stage();
                    stage4.setTitle("Update Window");
                    stage4.setScene(scene);
                    stage4.show();
                    Label lbl =new Label("Enter your Search Key : ");
                    lbl.setLayoutX(50);
                    lbl.setLayoutY(10);
                    root.getChildren().add(lbl);
                    TextField in =new TextField();
                    in.setLayoutX(180);
                    in.setLayoutY(10);
                    root.getChildren().add(in);
                    Label lbl1 =new Label("Enter Old Value : ");
                    lbl1.setLayoutX(50);
                    lbl1.setLayoutY(50);
                    root.getChildren().add(lbl1);
                    TextField in1 =new TextField();
                    in1.setLayoutX(180);
                    in1.setLayoutY(50);
                    root.getChildren().add(in1);
                    Label lbl2 =new Label("Enter new Value : ");
                    lbl2.setLayoutX(50);
                    lbl2.setLayoutY(90);
                    root.getChildren().add(lbl2);
                    TextField in2 =new TextField();
                    in2.setLayoutX(180);
                    in2.setLayoutY(90);
                    root.getChildren().add(in2);
                    Button Btn =new Button();
                    Btn.setText("Update");
                    Btn.setLayoutX(200);
                    Btn.setLayoutY(150);
                    root.getChildren().add(Btn);
                    Btn.setOnAction((ActionEvent e)->{
                        try {
                            BufferedReader reader =new BufferedReader(new FileReader(filename));
                        String searchKey=in.getText();
                        String line ;
                        while ((line =reader.readLine())!=null){
                            if( line.contains(searchKey)){
                                System.out.println("Enter the text you want to change");
                                String oldValue =in1.getText();

                                System.out.println("Enter the new value you want to change");
                                String newValue =in2.getText();
                                arrayList.add( line.replace(oldValue, newValue));


                            }else{
                                arrayList.add(line);
                            }

                        }
                    }catch (Exception exm){
                        System.out.println(exm);
                    }

                    try{
                        FileWriter writer=new FileWriter(filename);
                        for(int i=0;i<arrayList.size();i++){
                            writer.append(arrayList.get(i));
                            writer.append("\n");

                        }
                        writer.close();
                    }catch (Exception exm){
                        System.out.println(exm);
                    }



stage4.close();
                    });

                }
                else if(x==4){
                    Group root =new Group();
                    Scene scene = new Scene(root, 600, 600, Color.rgb(229,255,204));
                    Stage stage4 = new Stage();
                    stage4.setTitle("Search Window");
                    stage4.setScene(scene);
                    stage4.show();
                    Label lbl =new Label("Enter your Search Key : ");
                    lbl.setLayoutX(50);
                    lbl.setLayoutY(10);
                    root.getChildren().add(lbl);
                    TextField in =new TextField();
                    in.setLayoutX(180);
                    in.setLayoutY(10);
                    root.getChildren().add(in);
                    Button Btn =new Button();
                    Btn.setText("Search");
                    Btn.setLayoutX(200);
                    Btn.setLayoutY(50);
                    root.getChildren().add(Btn);
                    Btn.setOnAction((ActionEvent e)->{
                        try {
                            BufferedReader reader =new BufferedReader(new FileReader(filename));
                            System.out.println("Please Enter any key to get the record");
                            String searchKey= in.getText();
                            String line ;

                            while ((line =reader.readLine())!=null){
                                if( line.contains(searchKey)){
                                   Text txt = new Text(150,150,line);
                                   root.getChildren().add(txt);

                                }

                            }
                        }catch (Exception exp){
                            System.out.println(exp);
                        }

                    });
                }
               else{
                    Text txt = new Text(50,300,"Please Enter number from 1 To 4");
                    txt.setFill(Color.RED);
                    Font myfont=new Font("century gothic",25);
                    txt.setFont(myfont);
                    root.getChildren().add(txt);
                }

                }

        });

        stage.setTitle("Open Source Project");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) throws IOException {

        FileWriter file =new FileWriter("database.csv");
        file.append("id"+","+"Name"+","+"gpa"+","+"dept"+","+"address");
        file.append("\n");
        file.close();
        launch();

    }
}