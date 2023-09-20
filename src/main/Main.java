package main;


import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	
	ArrayList<User> registeredUser = new ArrayList<>();
	User currUser = null;
	Alert alert = new Alert(Alert.AlertType.ERROR);
	Alert info = new Alert(Alert.AlertType.INFORMATION);
	
//	ArrayList<Item> availableItem = new ArrayList<>();
//	Item 1
	File file1 = new File("src/lego5.png");
	Image img1 = new Image(file1.toURI().toString());
	ImageView iv1 = new ImageView(img1);
	Item item1 = new Item("Ironman Hulkbuster", "2330000", "100", "Capture the scale and power of the Hulkbuster MK44 with this 4,049-piece, authentically detailed movable model, standing over 52 cm (20.5 in.) tall"
			, file1, img1, iv1, 0);
	
	TextField nameTxt1 = new TextField();
	TextField priceTxt1 = new TextField();
	TextField stockTxt1 = new TextField();
	TextField descTxt1 = new TextField();

//	Item 2
	File file2 = new File("src/lego2.png");
	Image img2 = new Image(file2.toURI().toString());
	ImageView iv2 = new ImageView(img2);
	Item item2 = new Item("Hogwarts Icons - Collectors' Edition", "4550000", "80", "Bring the magical personality and elegant movement of Hedwig, the celebrated snowy owl from the Harry Potter™ movies, to life"
			, file2, img2, iv2, 0);
	
	TextField nameTxt2 = new TextField();
	TextField priceTxt2 = new TextField();
	TextField stockTxt2 = new TextField();
	TextField descTxt2 = new TextField();

//	Item 3
	File file3 = new File("src/lego3.png");
	Image img3 = new Image(file3.toURI().toString());
	ImageView iv3 = new ImageView(img3);
	Item item3 = new Item("Mickey Mouse", "1520000", "500", "LEGHO feature the iconic Mickey Mouse", file3, img3, iv3, 0);
	TextField nameTxt3 = new TextField("");
	TextField priceTxt3 = new TextField("");
	TextField stockTxt3 = new TextField("");
	TextField descTxt3 = new TextField("");

//	Item 4
	File file4 = new File("src/lego4.png");
	Image img4 = new Image(file4.toURI().toString());
	ImageView iv4 = new ImageView(img4);
	Item item4 = new Item("Eiffel Tower", "8200000", "70", "Captivate fans of travel, history or architecture with the new LEGHO Eiffel tower", file4, img4, iv4, 0);
	
	TextField nameTxt4 = new TextField("");
	TextField priceTxt4 = new TextField("");
	TextField stockTxt4 = new TextField("");
	TextField descTxt4 = new TextField("");
	
	File file = new File("src/legovid.mp4");
	Media media = new Media(file.toURI().toString());
	MediaPlayer mp = new MediaPlayer(media);
	MediaView mv = new MediaView(mp);
	
	File audioFile = new File("src/lofi2.mp3");
	Media audioMedia = new Media(audioFile.toURI().toString());
	MediaPlayer audioPlayer = new MediaPlayer(audioMedia);
	
	VBox menuContainer = new VBox();
	public void menu(Stage arg0) {
		Menu m = new Menu("Menu");
		MenuItem m1 = new MenuItem("Logout");
		MenuBar mb = new MenuBar();	
		//	Menu
		m.getItems().addAll(m1);
		mb.getMenus().add(m);
		menuContainer.getChildren().add(mb);
	
		m1.setOnAction(e->{
			loginPage(arg0);
		});
		
	}
	
	VBox menuContainer2 = new VBox();
	public void menu2(Stage arg0) {
		Menu m = new Menu("Menu");
		MenuItem m1 = new MenuItem("Logout");
		MenuItem m2 = new MenuItem("View Lego");
		MenuBar mb = new MenuBar();	
		//	Menu
		m.getItems().addAll(m2, m1);
		mb.getMenus().add(m);
		menuContainer2.getChildren().add(mb);
	
		m1.setOnAction(e->{
			loginPage(arg0);
			mp.stop();
			audioPlayer.stop();
		});
		
		m2.setOnAction(e->{
			catalogueAndCart(arg0);
			mp.stop();
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
	
	public void loginPage(Stage arg0) {
		arg0.setTitle("Login");
		Label leghoLbl = new Label("Legho");
		Label emailLbl = new Label("Email");
		Label passLbl = new Label("Password");
		TextField emailTxt = new TextField();
		PasswordField passTxt = new PasswordField();
		Button registerBtn = new Button("Register");
		Button loginBtn = new Button("Login");
		GridPane gridLogin = new GridPane();		
		
		registerBtn.setStyle("-fx-background-color:#3a3a3a;-fx-text-fill:white;-fx-padding: 5 30 5 30;");
		loginBtn.setStyle("-fx-background-color:#3a3a3a;-fx-text-fill:white;-fx-padding: 5 30 5 30;");
		gridLogin.setAlignment(Pos.CENTER);
		gridLogin.add(leghoLbl, 1, 0, 2, 1);
		gridLogin.add(emailLbl, 0, 1);
		gridLogin.add(emailTxt, 1, 1, 3, 1);
		gridLogin.add(passLbl, 0, 2);
		gridLogin.add(passTxt, 1, 2, 3, 1);
		gridLogin.add(registerBtn, 1, 3);
		gridLogin.add(loginBtn, 3, 3);
		gridLogin.setAlignment(Pos.CENTER);
		leghoLbl.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		GridPane.setHalignment(leghoLbl, HPos.RIGHT);
		GridPane.setHalignment(loginBtn, HPos.CENTER);
		GridPane.setHalignment(registerBtn, HPos.CENTER);
		gridLogin.setPadding(new Insets(40, 40, 40, 40));
		gridLogin.setHgap(10);
		gridLogin.setVgap(10);
		
		Scene loginPage = new Scene(gridLogin, 600, 600);
		arg0.setScene(loginPage);
		
		
		loginBtn.setOnMouseClicked(e->{

			if(emailTxt.getText().isEmpty()) {
				alert.setTitle("Login Failed");
				alert.setContentText("Email must be filled.");
				alert.showAndWait();
			} else
				if(passTxt.getText().isEmpty()) {
				alert.setTitle("Login Failed");
				alert.setContentText("Password must be filled.");
				alert.showAndWait();
			}else
				if(emailTxt.getText().equals("admin") && emailTxt.getText().equals("admin")) {
				adminWindow(arg0);
			} else {
				int check = 1;
				for (User user : registeredUser) {
					if(user.getEmail().equals(emailTxt.getText()) && user.getPassword().equals(passTxt.getText())) {
						currUser = user;
						welcomePage(arg0);
//						System.out.println("welcome guest");
						check = 0;
						break;
					}
				}
				if(check == 1) {
					alert.setContentText("Wrong credentials.");
					alert.showAndWait();
				}
			}
		});
		
		registerBtn.setOnMouseClicked(e->{
			registerPage(arg0);
		});
	}
	
	public void registerPage(Stage arg0) {
		arg0.setTitle("Register");
		GridPane gridRegist = new GridPane();
		Label registTitle = new Label("Register");
		registTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Label emailLbl = new Label("Email");
		TextField emailTxt = new TextField();
		Label passLbl = new Label("Password");
		PasswordField passTxt = new PasswordField();
		Label passConfirmLbl = new Label("Confirm Password");
		PasswordField passConfirmTxt = new PasswordField();
		Button loginBtn = new Button("Login");
		Button registerBtn = new Button("Register");
		Button resetBtn = new Button("Reset");
		
		registerBtn.setStyle("-fx-background-color:#3a3a3a;-fx-text-fill:white;-fx-padding: 5 15 5 15;");
		loginBtn.setStyle("-fx-background-color:#3a3a3a;-fx-text-fill:white;-fx-padding: 5 15 5 15;");
		resetBtn.setStyle("-fx-background-color:#3a3a3a;-fx-text-fill:white;-fx-padding: 5 15 5 15;");
		
		gridRegist.setAlignment(Pos.CENTER);
		gridRegist.add(registTitle, 1, 0, 2, 1);
		gridRegist.add(emailLbl, 0, 1);
		gridRegist.add(emailTxt, 1, 1, 4, 1);
		gridRegist.add(passLbl, 0, 2);
		gridRegist.add(passTxt, 1, 2, 4, 1);
		gridRegist.add(passConfirmLbl, 0, 3);
		gridRegist.add(passConfirmTxt, 1, 3, 4, 1);
		gridRegist.add(loginBtn, 1, 4);
		gridRegist.add(registerBtn, 2, 4);
		gridRegist.add(resetBtn, 3, 4);
		GridPane.setHalignment(registTitle, HPos.CENTER);
		GridPane.setMargin(passConfirmLbl, new Insets(0, 10, 0, 0));
		GridPane.setMargin(registerBtn, new Insets(0, 20, 0, 20));
		gridRegist.setVgap(10);
		
		Scene registerPage = new Scene(gridRegist, 600, 600);
		arg0.setScene(registerPage);
		
		loginBtn.setOnMouseClicked(e->{
			loginPage(arg0);
		});
		
		registerBtn.setOnMouseClicked(e->{
			int check = 1;
            String emailInput = emailTxt.getText();
            String passwordInput = passTxt.getText();
            String confirmPasswordInput = passConfirmTxt.getText();
            
            if(emailInput.isEmpty()) {
                alert.setContentText("Email must be filled");
                alert.showAndWait();
                check = 0;
                } else// Email must be end with @email.com
                	if(!emailInput.endsWith("@email.com")) {
                		alert.setContentText("Email must be end with @email.com");
                		alert.showAndWait();
                		check = 0;
                } else
                	if(passwordInput.isEmpty()) {
                		alert.setContentText("Password must be filled");
                		alert.showAndWait();
                		check = 0;
                } else
                	if(confirmPasswordInput.isEmpty()) {
                		alert.setContentText("Confirm password must be filled");
                		alert.showAndWait();
                		check = 0;
                } else
                	if(!passwordInput.equals(confirmPasswordInput)) {
                		alert.setContentText("Confirm Password must be matched with the password");
                		alert.showAndWait();
                		check = 0;
                } else
                	if(emailInput.isEmpty() && passwordInput.isEmpty() && confirmPasswordInput.isEmpty()) {
                		alert.setContentText("Please fill email, password, or confirm password");
                		alert.showAndWait();
                		check = 0;
                } else
                    // Email must not starts with @
                    if(emailInput.startsWith("@")) {
                    	alert.setContentText("Email must not starts with @");
                		alert.showAndWait();
                		check = 0;
                } else 
                	if(check == 0){
                	// Email must have only one @
                    int count = 0;
                    for(char c : emailInput.toCharArray()) {
                    	if(c == '@') {
                    		count++;
                    		if(count > 1) {
                            	alert.setContentText("Email must have only one '@'");
                                alert.showAndWait();
                    		}
                    	}
                    }
                    
                        // Email must not have space
                    for(char c : emailInput.toCharArray()) {
                    	if(c == ' ') {
                    		alert.setContentText("Email must not have space");
                    		alert.showAndWait();
                    	}
                    }
                    
                        // Email must be unique, have not used for any registration before
        			for (User user : registeredUser) {
        				if(emailInput.equals(user.getEmail())) {
        	            	alert.setContentText("Email already registered");
        	        		alert.showAndWait();
        				}
        			}
        			check = 0;
                } else {
                	check = 1;
                	// After validation succeed, the application will save the data in the systems, close
                	// the Register Window, and open the Login Window
                	registeredUser.add(new User(emailInput, passwordInput, null));
                	info.setTitle("Success");
                	info.setContentText("Registration Success");
                	info.showAndWait();
                	loginPage(arg0);
                }               
        });
		
		resetBtn.setOnMouseClicked(e->{
			emailTxt.clear();
			passTxt.clear();
			passConfirmTxt.clear();
		});
	}
	
	public void adminWindow(Stage arg0) {
		GridPane gridAdmin = new GridPane();
		BorderPane bpAdmin = new BorderPane();
		Label name1, name2, name3, name4, price1, price2, price3, price4, stock1, stock2, stock3, stock4, desc1, desc2, desc3, desc4;
		
		bpAdmin.setTop(menuContainer);
		bpAdmin.setCenter(gridAdmin);
		gridAdmin.setAlignment(Pos.CENTER);
		arg0.setTitle("ADMIN");
		
//		Item 1
		name1 = new Label("Name: ");
		price1 = new Label("Price: ");
		stock1 = new Label("Stock: ");
		desc1 = new Label("Description: ");
		
		nameTxt1.setEditable(false);
		nameTxt1.setMouseTransparent(true);
		nameTxt1.setFocusTraversable(false);
		nameTxt1.setStyle("-fx-opacity: 0.5;");
	
		nameTxt1.setText(item1.getName());
		priceTxt1.setText(item1.getPrice());
		stockTxt1.setText(item1.getStock());
		descTxt1.setText(item1.getDesc());
		Button updateBtn1 = new Button("Update");
		
		GridPane.setMargin(updateBtn1, new Insets(0, 0, 20, 0));
		
		iv1.setFitHeight(100);
		iv1.setFitWidth(100);

		gridAdmin.add(iv1, 0, 0, 1, 1);
		gridAdmin.add(name1, 1, 0, 1, 1);
		gridAdmin.add(nameTxt1, 2, 0, 1, 1);
		gridAdmin.add(price1, 3, 0, 1, 1);
		gridAdmin.add(priceTxt1, 4, 0, 1, 1);
		gridAdmin.add(stock1, 5, 0, 1, 1);
		gridAdmin.add(stockTxt1, 6, 0, 1, 1);
		gridAdmin.add(desc1, 1, 1, 1, 1);
		gridAdmin.add(descTxt1, 2, 1, 4, 1);
		gridAdmin.add(updateBtn1, 2, 2, 1, 1);
		
		updateBtn1.setOnMouseClicked(e->{
			if(stockTxt1.getText().isEmpty()) {
				alert.setTitle("Update Failed");
				alert.setContentText("Item 1 stock must not empty.");
				alert.showAndWait();
			} else
				if(priceTxt1.getText().isEmpty()) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 1 price must not empty.");
					alert.showAndWait();
			} else
				if(!stockTxt1.getText().matches("-?\\d+(\\.\\d+)?")) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 1 stock must be a number.");
					alert.showAndWait();
			} else
				if(!priceTxt1.getText().matches("-?\\d+(\\.\\d+)?")) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 1 price must be a number.");
					alert.showAndWait();
			} else
				if(Integer.parseInt(stockTxt1.getText()) < 0) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 1 stock must be equal or more than 0.");
					alert.showAndWait();
			} else
				if(Integer.parseInt(priceTxt1.getText()) <= 0) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 1 price must be more than 0.");
					alert.showAndWait();
			} else
				if(descTxt1.getText().isEmpty()) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 1 description must not empty.");
					alert.showAndWait();
			} else {
				item1.setPrice(priceTxt1.getText());
				item1.setStock(stockTxt1.getText());
				item1.setDesc(descTxt1.getText());
			}
		});
		
		iv1.setOnMouseClicked(e->{
			viewImageWindow(arg0, img1, nameTxt1.toString());
		});
		
//		Item 2
		name2 = new Label("Name: ");
		price2 = new Label("Price: ");
		stock2 = new Label("Stock: ");
		desc2 = new Label("Description: ");
		
		nameTxt2.setEditable(false);
		nameTxt2.setMouseTransparent(true);
		nameTxt2.setFocusTraversable(false);
		nameTxt2.setStyle("-fx-opacity: 0.5;");
		
		nameTxt2.setText(item2.getName());
		priceTxt2.setText(item2.getPrice());
		stockTxt2.setText(item2.getStock());
		descTxt2.setText(item2.getDesc());
		Button updateBtn2 = new Button("Update");
		
		GridPane.setMargin(updateBtn2, new Insets(0, 0, 20, 0));
		
		iv2.setFitHeight(100);
		iv2.setFitWidth(100);

		gridAdmin.add(iv2, 0, 4, 1, 1);
		gridAdmin.add(name2, 1, 4, 1, 1);
		gridAdmin.add(nameTxt2, 2, 4, 1, 1);
		gridAdmin.add(price2, 3, 4, 1, 1);
		gridAdmin.add(priceTxt2, 4, 4, 1, 1);
		gridAdmin.add(stock2, 5, 4, 1, 1);
		gridAdmin.add(stockTxt2, 6, 4, 1, 1);
		gridAdmin.add(desc2, 1, 5, 1, 1);
		gridAdmin.add(descTxt2, 2, 5, 4, 1);
		gridAdmin.add(updateBtn2, 2, 6, 1, 1);
		
		updateBtn2.setOnMouseClicked(e->{
			if(stockTxt2.getText().isEmpty()) {
				alert.setTitle("Update Failed");
				alert.setContentText("Item 2 stock must not empty.");
				alert.showAndWait();
			} else
				if(priceTxt2.getText().isEmpty()) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 2 price must not empty.");
					alert.showAndWait();
			} else
				if(!stockTxt2.getText().matches("-?\\d+(\\.\\d+)?")) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 2 stock must be a number.");
					alert.showAndWait();
			} else
				if(!priceTxt2.getText().matches("-?\\d+(\\.\\d+)?")) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 2 price must be a number.");
					alert.showAndWait();
			} else
				if(Integer.parseInt(stockTxt2.getText()) < 0) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 2 stock must be equal or more than 0.");
					alert.showAndWait();
			} else
				if(Integer.parseInt(priceTxt2.getText()) <= 0) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 2 price must be more than 0.");
					alert.showAndWait();
			} else
				if(descTxt2.getText().isEmpty()) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 2 description must not empty.");
					alert.showAndWait();
			} else {
				item2.setPrice(priceTxt2.getText());
				item2.setStock(stockTxt2.getText());
				item2.setDesc(descTxt2.getText());
			}
		});
		
		iv2.setOnMouseClicked(e->{
			viewImageWindow(arg0, img2, nameTxt2.toString());
		});
		
//		Item 3
		name3 = new Label("Name: ");
		price3 = new Label("Price: ");
		stock3 = new Label("Stock: ");
		desc3 = new Label("Description: ");

		
		nameTxt3.setEditable(false);
		nameTxt3.setMouseTransparent(true);
		nameTxt3.setFocusTraversable(false);
		nameTxt3.setStyle("-fx-opacity: 0.5;");
		
		nameTxt3.setText(item3.getName());
		priceTxt3.setText(item3.getPrice());
		stockTxt3.setText(item3.getStock());
		descTxt3.setText(item3.getDesc());
		Button updateBtn3 = new Button("Update");
		
		GridPane.setMargin(updateBtn3, new Insets(0, 0, 20, 0));
		
		iv3.setFitHeight(100);
		iv3.setFitWidth(100);
		
		gridAdmin.add(iv3, 0, 8, 1, 1);
		gridAdmin.add(name3, 1, 8, 1, 1);
		gridAdmin.add(nameTxt3, 2, 8, 1, 1);
		gridAdmin.add(price3, 3, 8, 1, 1);
		gridAdmin.add(priceTxt3, 4, 8, 1, 1);
		gridAdmin.add(stock3, 5, 8, 1, 1);
		gridAdmin.add(stockTxt3, 6, 8, 1, 1);
		gridAdmin.add(desc3, 1, 9, 1, 1);
		gridAdmin.add(descTxt3, 2, 9, 4, 1);
		gridAdmin.add(updateBtn3, 2,10, 1, 1);
		
		updateBtn3.setOnMouseClicked(e->{
			if(stockTxt3.getText().isEmpty()) {
				alert.setTitle("Update Failed");
				alert.setContentText("Item 3 stock must not empty.");
				alert.showAndWait();
			} else
				if(priceTxt3.getText().isEmpty()) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 3 price must not empty.");
					alert.showAndWait();
			} else
				if(!stockTxt3.getText().matches("-?\\d+(\\.\\d+)?")) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 3 stock must be a number.");
					alert.showAndWait();
			} else
				if(!priceTxt3.getText().matches("-?\\d+(\\.\\d+)?")) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 3 price must be a number.");
					alert.showAndWait();
			} else
				if(Integer.parseInt(stockTxt3.getText()) < 0) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 3 stock must be equal or more than 0.");
					alert.showAndWait();
			} else
				if(Integer.parseInt(priceTxt3.getText()) <= 0) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 3 price must be more than 0.");
					alert.showAndWait();
			} else
				if(descTxt3.getText().isEmpty()) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 3 description must not empty.");
					alert.showAndWait();
			} else {
				item3.setPrice(priceTxt3.getText());
				item3.setStock(stockTxt3.getText());
				item3.setDesc(descTxt3.getText());
			}
		});
		
		iv3.setOnMouseClicked(e->{
			viewImageWindow(arg0, img3, nameTxt3.toString());
		});
		
//		Item 4
		name4 = new Label("Name: ");
		price4 = new Label("Price :");
		stock4 = new Label("Stock :");
		desc4 = new Label("Description: ");
		
		nameTxt4.setEditable(false);
		nameTxt4.setMouseTransparent(true);
		nameTxt4.setFocusTraversable(false);
		nameTxt4.setStyle("-fx-opacity: 0.5;");
		
		nameTxt4.setText(item4.getName());
		priceTxt4.setText(item4.getPrice());
		stockTxt4.setText(item4.getStock());
		descTxt4.setText(item4.getDesc());
		Button updateBtn4 = new Button("Update");
		
		GridPane.setMargin(updateBtn1, new Insets(0, 0, 20, 0));
		
		iv4.setFitHeight(100);
		iv4.setFitWidth(100);
		
		gridAdmin.add(iv4, 0, 12, 1, 1);
		gridAdmin.add(name4, 1, 12, 1, 1);
		gridAdmin.add(nameTxt4, 2, 12, 1, 1);
		gridAdmin.add(price4, 3, 12, 1, 1);
		gridAdmin.add(priceTxt4, 4, 12, 1, 1);
		gridAdmin.add(stock4, 5, 12, 1, 1);
		gridAdmin.add(stockTxt4, 6, 12, 1, 1);
		gridAdmin.add(desc4, 1, 13, 1, 1);
		gridAdmin.add(descTxt4, 2, 13, 4, 1);
		gridAdmin.add(updateBtn4, 2,14, 1, 1);
		
		updateBtn4.setOnMouseClicked(e->{
			if(stockTxt4.getText().isEmpty()) {
				alert.setTitle("Update Failed");
				alert.setContentText("Item 4 stock must not empty.");
				alert.showAndWait();
			} else
				if(priceTxt4.getText().isEmpty()) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 4 price must not empty.");
					alert.showAndWait();
			} else
				if(!stockTxt4.getText().matches("-?\\d+(\\.\\d+)?")) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 4 stock must be a number.");
					alert.showAndWait();
			} else
				if(!priceTxt4.getText().matches("-?\\d+(\\.\\d+)?")) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 4 price must be a number.");
					alert.showAndWait();
			} else
				if(Integer.parseInt(stockTxt4.getText()) < 0) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 4 stock must be equal or more than 0.");
					alert.showAndWait();
			} else
				if(Integer.parseInt(priceTxt4.getText()) <= 0) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 4 price must be more than 0.");
					alert.showAndWait();
			} else
				if(descTxt4.getText().isEmpty()) {
					alert.setTitle("Update Failed");
					alert.setContentText("Item 4 description must not empty.");
					alert.showAndWait();
			} else {
				item4.setPrice(priceTxt4.getText());
				item4.setStock(stockTxt4.getText());
				item4.setDesc(descTxt4.getText());
			}
		});
		
		iv4.setOnMouseClicked(e->{
			viewImageWindow(arg0, img4, nameTxt4.toString());
		});
		
		Scene adminPage = new Scene(bpAdmin, 800, 800);
		arg0.setScene(adminPage);
		
	}

	public void viewImageWindow(Stage arg0, Image img, String prod) {
		ImageView iv = new ImageView(img);
		String fullText = "LEGHO feature the iconic " + prod;
		Label prodDesc = new Label();
		prodDesc.setText(fullText);
		Button rotateR = new Button("Rotate Right");
		Button rotateL = new Button("Rotate Left");
		Button zoomIn = new Button("Zoom In");
		Button zoomOut = new Button("Zoom Out");
		Stage popUp = new Stage();
		GridPane gp = new GridPane();
		
		iv.setFitHeight(100);
		iv.setFitWidth(100);
		
		gp.setAlignment(Pos.CENTER);
		gp.add(iv, 0, 0, 2, 1);
		gp.add(prodDesc, 0, 1, 2, 1);
		gp.add(rotateR, 0, 2);
		gp.add(rotateL, 0, 3);
		gp.add(zoomIn, 1, 2);
		gp.add(zoomOut, 1, 3);
		
		popUp.setTitle("View Image");
		GridPane.setHalignment(iv, HPos.CENTER);
		GridPane.setValignment(iv, VPos.TOP);
		GridPane.setHalignment(rotateR, HPos.CENTER);
		GridPane.setHalignment(rotateL, HPos.CENTER);
		GridPane.setHalignment(zoomIn, HPos.CENTER);
		GridPane.setHalignment(zoomOut, HPos.CENTER);
		GridPane.setMargin(iv, new Insets(0, 0, 100, 0));
		GridPane.setMargin(rotateR, new Insets(15, 15, 0, 0));
		GridPane.setMargin(rotateL, new Insets(15, 15, 0, 0));
		GridPane.setMargin(zoomIn, new Insets(15, 15, 0, 0));
		GridPane.setMargin(zoomOut, new Insets(15, 15, 0, 0));
		
		rotateR.setPrefWidth(100);
		rotateL.setPrefWidth(100);
		zoomIn.setPrefWidth(100);
		zoomOut.setPrefWidth(100);
		
		rotateR.setOnMouseClicked(e->{ 
			iv.setRotate(iv.getRotate() + 90);
		});
		
		rotateL.setOnMouseClicked(e->{ 
			iv.setRotate(iv.getRotate() - 90);
		});
		
		zoomIn.setOnMouseClicked(e->{
			if(iv.getScaleX()*1.2 < 2.5) {
				iv.setScaleX(1.2*iv.getScaleX());
				iv.setScaleY(1.2*iv.getScaleY());
			}
		});
		
		zoomOut.setOnMouseClicked(e->{
			if(iv.getScaleX()*0.8 > 0.4) {
				iv.setScaleX(0.8*iv.getScaleX());
				iv.setScaleY(0.8*iv.getScaleY());
			}
		});
		
		Scene secondScene = new Scene(gp, 450, 450);
		
		popUp.setX(arg0.getX() + 100);
		popUp.setY(arg0.getY() + 200);
		popUp.setScene(secondScene);
		popUp.show();
	}
	
	public void welcomePage(Stage arg0) {
		arg0.setTitle("USER");
		
		mv.setFitHeight(300);
		mv.setFitWidth(300);
		
		BorderPane bpWelcome = new BorderPane();
		VBox vbox = new VBox();
		Label welcomeTitle = new Label("Welcome To LEGHO!");
		Button continueBtn = new Button("CONTINUE >>");
		
		welcomeTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 30px;");
		continueBtn.setStyle("-fx-background-color:#3a3a3a;-fx-text-fill:white;-fx-padding: 5 15 5 15;");
		VBox.setMargin(continueBtn, new Insets(20, 0, 0, 0));
		
		vbox.getChildren().addAll(welcomeTitle, mv, continueBtn);
		
		bpWelcome.setTop(menuContainer2);
		bpWelcome.setCenter(vbox);
		vbox.setAlignment(Pos.CENTER);
		
		mp.play();
		mp.setCycleCount(mp.INDEFINITE);
		Scene welcomePage = new Scene(bpWelcome, 600, 600);
		arg0.setScene(welcomePage);
		
		continueBtn.setOnMouseClicked(e->{
			mp.stop();
			catalogueAndCart(arg0);
		});
		
	}

	public void catalogueAndCart(Stage arg0) {
		arg0.setTitle("USER");
		BorderPane bpCatalogue = new BorderPane();
		BorderPane contain = new BorderPane();
		VBox containLeft = new VBox();
		Pane containRight = new Pane();
		VBox elementRight = new VBox();
		Pane cart = new Pane();
		VBox prod1 = new VBox();
		VBox prod2 = new VBox();
		VBox prod3 = new VBox();
		VBox prod4 = new VBox();
		HBox prodRow1 = new HBox();
		HBox prodRow2 = new HBox();
		HBox btnRow = new HBox();
		HBox titleContain = new HBox();
		Label catalogueTitle = new Label("Happy shopping");
		Label cartTitle = new Label("Your Cart");
		Button buyBtn = new Button("Buy");
		Button clearBtn = new Button("Clear Cart");
		
		ScrollPane scroll = new ScrollPane();
		scroll.setContent(containLeft);
		scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		iv1.setFitHeight(100);
		iv1.setFitWidth(100);
		iv2.setFitHeight(100);
		iv2.setFitWidth(100);
		iv3.setFitHeight(100);
		iv3.setFitWidth(100);
		iv4.setFitHeight(100);
		iv4.setFitWidth(100);
		
		
		Label name1 = new Label("Name: " + item1.getName());
		Label price1 = new Label("Price: " + item1.getPrice());
		Label stock1 = new Label("Stock: " + item1.getStock());
		Label desc1 = new Label("Description: " + item1.getDesc());
		
		Label name2 = new Label("Name: " + item2.getName());
		Label price2 = new Label("Price: " + item2.getPrice());
		Label stock2 = new Label("Stock: " + item2.getStock());
		Label desc2 = new Label("Description: " + item2.getDesc());
		
		Label name3 = new Label("Name: " + item3.getName());
		Label price3 = new Label("Price: " + item3.getPrice());
		Label stock3 = new Label("Stock: " + item3.getStock());
		Label desc3 = new Label("Description: " + item3.getDesc());
		
		Label name4 = new Label("Name: " + item4.getName());
		Label price4 = new Label("Price: " + item4.getPrice());
		Label stock4 = new Label("Stock: " + item4.getStock());
		Label desc4 = new Label("Description: " + item4.getDesc());
		
		audioPlayer.play();
		audioPlayer.setCycleCount(audioPlayer.INDEFINITE);
		bpCatalogue.setTop(menuContainer2);
		bpCatalogue.setCenter(contain);
		contain.setTop(catalogueTitle);
		contain.setAlignment(catalogueTitle, Pos.CENTER);
		contain.setLeft(scroll);
//		contain.setLeft(containLeft);
		contain.setCenter(containRight);
		btnRow.getChildren().addAll(buyBtn, clearBtn);
		containLeft.setMargin(prodRow1, new Insets(20));
		
		containLeft.getChildren().addAll(prodRow1, prodRow2);
		containLeft.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		containLeft.setStyle("-fx-border-color: #e5e5e5;");
		containLeft.setSpacing(40);
		containLeft.setAlignment(Pos.CENTER);
		
		titleContain.getChildren().addAll(cartTitle);
		elementRight.getChildren().addAll(titleContain, btnRow, cart);
		
		cart.setPrefSize(1000, 1000);
		
		containRight.getChildren().addAll(elementRight);
		cart.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		cart.setStyle("-fx-border-color: #00ff00;");
		btnRow.setSpacing(20);
		
		prodRow1.setSpacing(40);
		prodRow2.setSpacing(40);
		prodRow1.getChildren().addAll(prod1, prod2);
		prodRow1.setAlignment(Pos.CENTER);
		prod1.getChildren().addAll(iv1, name1, price1, stock1, desc1);
		prod1.setMaxWidth(100);
		prod2.getChildren().addAll(iv2, name2, price2, stock2, desc2);
		prod2.setMaxWidth(100);
		
		prodRow2.getChildren().addAll(prod3, prod4);
		prodRow2.setAlignment(Pos.CENTER);
		prod3.getChildren().addAll(iv3, name3, price3, stock3, desc3);
		prod3.setMaxWidth(100);
		prod4.getChildren().addAll(iv4, name4, price4, stock4, desc4);
		prod4.setMaxWidth(100);
		
		iv1.setOnMouseClicked(e->{
			viewImageWindow(arg0, img1, item1.getName());
		});
		
		iv2.setOnMouseClicked(e->{
			viewImageWindow(arg0, img2, item2.getName());
		});
		
		iv3.setOnMouseClicked(e->{
			viewImageWindow(arg0, img3, item3.getName());
		});
		
		iv4.setOnMouseClicked(e->{
			viewImageWindow(arg0, img4, item4.getName());
		});
		
		cart.setOnDragOver(e->{
			e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		});
		
		iv1.setOnDragDetected(e->{
			Dragboard dragboard = iv1.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			ClipboardContent item1 = new ClipboardContent();
			item1.putString("Item 1");
			dragboard.setContent(item1);
		});
		
		iv2.setOnDragDetected(e->{
			Dragboard dragboard = iv2.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			ClipboardContent item2 = new ClipboardContent();
			item2.putString("Item 2");
			dragboard.setContent(item2);
		});
		
		iv3.setOnDragDetected(e->{
			Dragboard dragboard = iv3.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			ClipboardContent item3 = new ClipboardContent();
			item3.putString("Item 3");
			dragboard.setContent(item3);
		});
		
		iv4.setOnDragDetected(e->{
			Dragboard dragboard = iv4.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			ClipboardContent item4 = new ClipboardContent();
			item4.putString("Item 4");
			dragboard.setContent(item4);
		});
		
		cart.setOnDragDropped(e->{
			Dragboard dragboard = e.getDragboard();
			if(e.getX() > 100 && e.getY() > 100) {
				if(dragboard.hasString()) {
					if(dragboard.getString().equals("Item 1")) {
						ImageView iv = new ImageView(img1);
						iv.setScaleX(0.2);
						iv.setScaleY(0.2);
						iv.setX(e.getX()-500);
						iv.setY(e.getY()-500);
						cart.getChildren().add(iv);
						item1.setCount(item1.getCount()+1);
						currUser.addCartItem(item1);
						e.consume();
					} else
						if(dragboard.getString().equals("Item 2")) {
							ImageView iv = new ImageView(img2);
							iv.setScaleX(0.2);
							iv.setScaleY(0.2);
							iv.setX(e.getX()-300);
							iv.setY(e.getY()-300);
							cart.getChildren().add(iv);
							item2.setCount(item2.getCount()+1);
							currUser.addCartItem(item2);
							e.consume();
					} else
						if(dragboard.getString().equals("Item 3")) {
							ImageView iv = new ImageView(img3);
							iv.setScaleX(0.06);
							iv.setScaleY(0.06);
							iv.setX(e.getX()-1500);
							iv.setY(e.getY()-2300);
							cart.getChildren().add(iv);
							item3.setCount(item3.getCount()+1);
							currUser.addCartItem(item3);
							e.consume();
					} else
						if(dragboard.getString().equals("Item 4")) {
							ImageView iv = new ImageView(img4);
							iv.setScaleX(0.2);
							iv.setScaleY(0.2);
							iv.setX(e.getX()-400);
							iv.setY(e.getY()-450);
							cart.getChildren().add(iv);
							item4.setCount(item4.getCount()+1);
							currUser.addCartItem(item4);
							e.consume();
					}
				}
			}
		});
		
		clearBtn.setOnMouseClicked(e->{
			cart.getChildren().clear();
			currUser.setCartItem(null);
		});
		
		buyBtn.setOnMouseClicked(e->{
			Integer item1Stock = Integer.parseInt(item1.getStock());
			Integer item2Stock = Integer.parseInt(item2.getStock());
			Integer item3Stock = Integer.parseInt(item3.getStock());
			Integer item4Stock = Integer.parseInt(item4.getStock());
			

			if((item1Stock - item1.getCount()) < 0) {
				alert.setTitle("Purchase Failed");
				alert.setContentText("Item 1 Exceed Stock.");
				alert.showAndWait();
			} 
			else if(item2Stock - item2.getCount() < 0) {
				alert.setTitle("Purchase Failed");
				alert.setContentText("Item 2 Exceed Stock.");
				alert.showAndWait();
			}
			else if(item3Stock - item3.getCount() < 0) {
				alert.setTitle("Purchase Failed");
				alert.setContentText("Item 3 Exceed Stock.");
				alert.showAndWait();
			}
			else if(item4Stock - item4.getCount() < 0) {
				alert.setTitle("Purchase Failed");
				alert.setContentText("Item 4 Exceed Stock.");
				alert.showAndWait();
			}
			else {
				int stockNew1 = item1Stock-item1.getCount();
				int stockNew2 = item2Stock-item2.getCount();
				int stockNew3 = item3Stock-item3.getCount();
				int stockNew4 = item4Stock-item4.getCount();
				
				item1.setStock(Integer.toString(stockNew1));
				item2.setStock(Integer.toString(stockNew2));
				item3.setStock(Integer.toString(stockNew3));
				item4.setStock(Integer.toString(stockNew4));
				
				info.setTitle("Purchase Success");
				info.setContentText("Thank you for shopping");
				info.showAndWait();
				
				cart.getChildren().clear();
				currUser.setCartItem(null);
				catalogueAndCart(arg0);
			}
			
		});
		
		Scene catalogue = new Scene(bpCatalogue, 900, 600);
		arg0.setScene(catalogue);
		arg0.show();
		
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
//		menu(arg0);
//		menu2(arg0);
		registerPage(arg0);
		arg0.show();
	}

}
