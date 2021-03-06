package controller;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;

import javafx.scene.text.Text;
import model.PictureNode;
import service.ChangeService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.ws.Holder;

import action.PPTAction;
import action.BeautyAction;
import action.Enlarge_Small_Action;
import action.MainAction;
import action.OpenAction;
import action.Previous_next_Action;
import action.ResetAction;
import action.RotateAction;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.control.Menu;
import javafx.scene.control.ToolBar;

public class ViewUIController implements Initializable{
	@FXML
	private HBox hbox;
	@FXML
	private ImageView imageView;
	@FXML
	private Button enlargeBtn;
	@FXML
	private Button smallBtn;
	@FXML
	private Button resetBtn;
	@FXML
	private Button rotateBtn;
	@FXML
	private Button beautyBtn;
	@FXML
	private Menu MenuMore;
	@FXML
	private Menu MenuHelp;
//	@FXML
//	private Text text;
	@FXML
	private Button previousImageBtn;
	@FXML
	private Button nextImageBtn;
	@FXML
	private ToolBar toolbar;
	private ViewUIController viewUIController;
	private Image image;
	private File[] file;
	private int changenumber = 0;
	private int page = 0;

    public ViewUIController() {
		viewUIController = this;

	}
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		initData();
	}
    private void initData() {
    	
		image = new Image(PictureNode.getSelectedPictures().get(0).getURL());
		
		ChangeService.origin=new ImageView(image);
		ChangeService.change=new ImageView(image);
//		this.file = PictureNode.getSelectedPictures().get(0).getImageFile().listFiles();
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
    	imageView.setImage(image);
    	toolbar.setVisible(true);
    }
    
    public ImageView getImageView() {
		return imageView;
	}
//    public Text getText() {
//		return text;
//	}
//    public void setText(Text text) {
//		this.text = text;
//	}
    @FXML
    private void Back(ActionEvent e) {
    	new  MainAction();
    }
    @FXML
    private void Press() {
    	if(toolbar.isVisible()) {
    		toolbar.setVisible(false);
    	}
    	else {
    		toolbar.setVisible(true);
    	}
    }
    @FXML
    private void PPTAction(ActionEvent e) {
    	new PPTAction();
    }
    @FXML
    private void Daozhi(ActionEvent e) {
    	if (imageView.getNodeOrientation().name().equals("RIGHT_TO_LEFT")) {
			imageView.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
		} else {
			imageView.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		}
    }
	// Event Listener on Button[#enlargeBtn].onAction
	@FXML
	public void enlargeAction(ActionEvent event) {
		Enlarge_Small_Action.enlarge(imageView);
		
	}
	// Event Listener on Button[#smallBtn].onAction
	@FXML
	public void smallAction(ActionEvent event) {
		Enlarge_Small_Action.small(imageView);
	}
	// Event Listener on Button[#resetBtn].onAction
	@FXML
	public void resetAction(ActionEvent event) {
//		new Enlarge_Small_Action(imageView);
	}
	// Event Listener on Button[#rotateBtn].onAction
	@FXML
	public void rotateAction(ActionEvent event) {
		new RotateAction(imageView);
	}
	// Event Listener on Button[#beautyBtn].onAction
	@FXML
	public void beautyAction(ActionEvent event) {
		ChangeService.change=this.imageView;
		new BeautyAction();
		
	}
	// Event Listener on Button[#previousImageBtn].onAction
	@FXML
	public void previousAction(ActionEvent event) {
		Previous_next_Action.changePicture(imageView, false);
	}
	// Event Listener on Button[#nextImageBtn].onAction
	@FXML
	public void nextAction(ActionEvent event) {
	   Previous_next_Action.changePicture(imageView, true);
	}
}
