package activity.todo;

import appiumControl.*;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;

public class MiListaActivity {
    public Button addButton;
    public TextBox titleTextBox;
    public TextBox noteTextBox;
    public Button saveNote;
    public Button saveAndNewNote;
    public Label firstTitleLabel;
    public Label firstNoteLabel;
    public CheckBox doneCheckBox;
    public Button moreOptionsButton;
    public Button deleteDoneButton;
    public Button confirmDeleteButton;

    public MiListaActivity() throws UnsupportedEncodingException{
        addButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));
        titleTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
        noteTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
        saveNote = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
        saveAndNewNote = new Button(By.id("com.vrproductiveapps.whendo:id/saveAndNew"));
        firstTitleLabel = new Label(By.id("com.vrproductiveapps.whendo:id/home_list_item_text"));
        firstNoteLabel = new Label(By.id("com.vrproductiveapps.whendo:id/home_list_item_text2"));
        doneCheckBox = new CheckBox(By.id("com.vrproductiveapps.whendo:id/home_list_item_marked"));
        moreOptionsButton = new Button(By.xpath(new String(("//android.widget.ImageView[@content-desc=\"Más opciones\"]").getBytes(),"UTF-8")));
        deleteDoneButton = new Button(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
        confirmDeleteButton = new Button(By.id("android:id/button1"));
    }

}
