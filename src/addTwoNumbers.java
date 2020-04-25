public class addTwoNumbers {
    package JavaFX_UI;

    import javafx.application.Application;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.*;
    import javafx.scene.layout.*;
    import javafx.stage.Stage;
    //Always change the top two to bring in ALL * of the Control and Layout tools


    public class AddTwoNumbers extends Application { //This part is CRITICAL. ADDTWONUMBERS EXTENDS APPLICATION
        // controls
        Button btnAdd = new Button("Add The Numbers!"); //Often times these are overloaded.
        //We only expect to do the most common things
        //You can always learn more at the official Java documentation (JavaFX 8)
        TextField txtFirstNum = new TextField();
        TextField txtSecondNum = new TextField();
        Label lblFirstNum = new Label ("First Number: ");
        Label lblSecondNum = new Label("Second Number: ");
        TextField txtOutput = new TextField();
        CheckBox chkDetailed = new CheckBox("Detailed Output?");

        @Override
        public void start(Stage primaryStage) {
//Controls - Moved above so other classes can see them below (Scope rules)


//Pane(s)
            GridPane primaryPane = new GridPane();
            primaryPane.add(lblFirstNum,0, 0);
            primaryPane.add(txtFirstNum, 1, 0);//Check output
            primaryPane.add(lblSecondNum, 0, 1);
            primaryPane.add(txtSecondNum, 1,1);//check output to prototype
            primaryPane.add(chkDetailed,0,2);
            primaryPane.add(btnAdd, 1, 2);
            primaryPane.add(txtOutput, 0, 3, 2, 1);

            primaryPane.setVgap(20);
            primaryPane.setHgap(70);//Play around with these to size things better
            //primaryPane.setRotate(76);
            primaryPane.setAlignment(Pos.CENTER); //Pos. is the set alignmnet method of gridpane to whatever position we wish.
            //Also called a enumerated type - data type consisting of a set of named values called elements, members, enumeral, or enumerators of the type

//Scene
            Scene primaryScene = new Scene(primaryPane, 600, 350);


//Stage - Nest the scene in the Stage
            primaryStage.setTitle("Add Two Numbers v. 1.0");
            primaryStage.setScene(primaryScene);
            primaryStage.show(); //Must have this at the end or it will never show.



//        //      Create an instance object of our EventHandling class
//              AddHandlerClass btnAddHandler = new AddHandlerClass();
//        //
//        //      Regster the instance object with the Button.
//                btnAdd.setOnAction(btnAddHandler);
//                //reference to class that implements the event handler interface


//Three different Methods used to Handle User Events - Use Number 3! (Number 1 found at bottom)

            //METHOD 2: Anonymous Inner Class (Zombie class!)
//        //Implementing the entire class inside the parameter of setOnAction
//        btnAdd.setOnAction(new EventHandler<ActionEvent>(){
//            public void handle(ActionEvent e)
//        {
//            int firstNum = Integer.valueOf(txtFirstNum.getText());
//            int secondNum = Integer.valueOf(txtSecondNum.getText());
//            txtOutput.setText(firstNum + secondNum + "");
//        }
//    });

            //METHOD 3: Lambda Expression
            btnAdd.setOnAction(e -> {
                //Shortcut/simplified method 2 all happening on e
                //Simplified smart compiler way to handle these
                //Adds restrictions to event instance objects
                int firstNum = Integer.valueOf(txtFirstNum.getText());
                int secondNum = Integer.valueOf(txtSecondNum.getText());

                if(chkDetailed.isSelected())
                    txtOutput.setText(txtFirstNum.getText() + txtSecondNum.getText() + "");
            });

        }//End of Stage class - Must be at the end of visual componet code

        //             Method 1 Event handling Class (inner Class)
//            Most Confusing
//            Also, most flexible
//            We want to create an event handling class
//               CLASS MUST IMPLEMENT EVENT HANDLING INTERFACE
        class AddHandlerClass implements EventHandler<ActionEvent> //Handles any button clicker
                //   Error states you must override locally in the class, the handler
        {
            public void handle(ActionEvent e) //Leave out abstract because its a concreate local definition
            //e is industry standard
            {
                //Here is where you write code that should execute when an event occurs (button pressed)
                //txtOutput. Wont work because txtOutput cannot be seen by this code inside a class

                //Wrapper class (Primative data wrapped into class object)
                //int firstNum = Integer.valueOf(txtFirstNum.getText());
                //int secondNum = Integer.valueOf(txtSecondNum.getText());

                txtOutput.setText(txtFirstNum.getText() + txtSecondNum.getText()); //Didn't work b/c they aren't global! So we moved controls to global level. Now works
                //        setText and getText are best for getting and retrieving
            }
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

}
