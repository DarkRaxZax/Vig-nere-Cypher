import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Vigenere extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getScene(), 300, 140);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Vigenère Cipher");
        primaryStage.getIcons().add(new Image("Lock.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Parent getScene(){
        TextField message = new TextField();
        message.setPrefColumnCount(20);
        message.setPromptText("Insert the message");
        TextField key = new TextField();
        key.setPrefColumnCount(20);
        key.setPromptText("Insert the key");
        Button encrypt = new Button();
        encrypt.setText("Encrypt!");
        Button decrypt = new Button();
        decrypt.setText("Decrypt!");
        TextField result = new TextField();
        result.setEditable(false);
        result.setPrefColumnCount(20);

        encrypt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.setText(cypher((message.getText()), (key.getText()).toLowerCase(), true));
            }
        }
        );
        
        decrypt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.setText(cypher((message.getText()), (key.getText()).toLowerCase(), false));
            }
        }
        );
        
        VBox root = new VBox(10);
        HBox groupButtons = new HBox(20);
        root.setPadding(new Insets(10));
        groupButtons.setAlignment(Pos.CENTER);
        groupButtons.getChildren().addAll(encrypt, decrypt);
        root.getChildren().addAll(message, key, groupButtons, result);
        return root;
    }
    
    private String cypher(String text, String key, Boolean encrypt){
        String result = "";
        int b;
        int k = 0;
        boolean uppercase;
        for (int i = 0; i < text.length(); i++) {
            if(Character.isLetter(text.charAt(i))) {
                uppercase = (text.charAt(i) == Character.toUpperCase(text.charAt(i)));
                if(encrypt){
                    b = toInt(text.charAt(i)) + toInt(key.charAt(k));
                    if (b > 25) {
                        b -= 26;
                    }
                } else {
                    b = toInt(text.charAt(i)) - toInt(key.charAt(k));
                    if (b < 0) {
                        b += 26;
                    }
                }
                    k = (k+1)%key.length();
                    if(uppercase){
                        result += Character.toUpperCase(toChar(b));
                    }else{
                       result += toChar(b); 
                    }
            } else result += text.charAt(i);
        }
        return result;
    }

    public int toInt(char a){
        int b;
        switch(a){
            case 'A':
            case 'a': b = 0;    break;
            case 'B':
            case 'b': b = 1;    break;
            case 'C':
            case 'c': b = 2;    break;
            case 'D':
            case 'd': b = 3;    break;
            case 'E':
            case 'e': b = 4;    break;
            case 'F':
            case 'f': b = 5;    break;
            case 'G':
            case 'g': b = 6;    break;
            case 'H':
            case 'h': b = 7;    break;
            case 'I':
            case 'i': b = 8;    break;
            case 'J':
            case 'j': b = 9;    break;
            case 'K':
            case 'k': b = 10;   break;
            case 'L':
            case 'l': b = 11;   break;
            case 'M':
            case 'm': b = 12;   break;
            case 'N':
            case 'n': b = 13;   break;
            case 'O':
            case 'o': b = 14;   break;
            case 'P':
            case 'p': b = 15;   break;
            case 'Q':
            case 'q': b = 16;   break;
            case 'R':
            case 'r': b = 17;   break;
            case 'S':
            case 's': b = 18;   break;
            case 'T':
            case 't': b = 19;   break;
            case 'U':
            case 'u': b = 20;   break;
            case 'V':
            case 'v': b = 21;   break;
            case 'W':
            case 'w': b = 22;   break;
            case 'X':
            case 'x': b = 23;   break;
            case 'Y':
            case 'y': b = 24;   break;
            default: b = 25;    break;
        }
        return b;
    }
    
    public char toChar(int a){
        char b;
        switch(a){
            case 0: b = 'a';    break;
            case 1: b = 'b';    break;
            case 2: b = 'c';    break;
            case 3: b = 'd';    break;
            case 4: b = 'e';    break;
            case 5: b = 'f';    break;
            case 6: b = 'g';    break;
            case 7: b = 'h';    break;
            case 8: b = 'i';    break;
            case 9: b = 'j';    break;
            case 10: b = 'k';   break;
            case 11: b = 'l';   break;
            case 12: b = 'm';   break;
            case 13: b = 'n';   break;
            case 14: b = 'o';   break;
            case 15: b = 'p';   break;
            case 16: b = 'q';   break;
            case 17: b = 'r';   break;
            case 18: b = 's';   break;
            case 19: b = 't';   break;
            case 20: b = 'u';   break;
            case 21: b = 'v';   break;
            case 22: b = 'w';   break;
            case 23: b = 'x';   break;
            case 24: b = 'y';   break;
            default: b = 'z';   break;
        }
        return b;
    }
    
}
