package testClean;

import activity.todo.MiListaActivity;
import appiumControl.CheckBox;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sessionManager.Session;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

public class ToDoTest {
    MiListaActivity miListaActivity = new MiListaActivity();

    public ToDoTest() throws UnsupportedEncodingException{
    }

    @Test
    public void addNoteTest() throws MalformedURLException {
        String titulo = "Tarea Uno";
        String nota = "Nota de prueba.";
        miListaActivity.addButton.click();
        miListaActivity.titleTextBox.sendKeys(titulo);
        miListaActivity.noteTextBox.sendKeys(nota);
        miListaActivity.saveNote.click();

        String actualTitle = miListaActivity.firstTitleLabel.getText();
        String actualNote = miListaActivity.firstNoteLabel.getText();

        Assert.assertEquals("¡ERROR! El título no coincide", titulo, actualTitle);
        Assert.assertEquals("¡ERROR! La nota no coincide", nota, actualNote);
    }

    @Test
    public void deleteOneTaskDoneFromTwoTest() throws MalformedURLException {
        String titulo = "Tarea hecha";
        String nota = "Nota de prueba para eliminar.";
        List<WebElement> listTasksAfter, listTasksBefore;
        miListaActivity.addButton.click();
        miListaActivity.titleTextBox.sendKeys(titulo);
        miListaActivity.noteTextBox.sendKeys(nota);
        miListaActivity.saveNote.click();

        miListaActivity.addButton.click();
        miListaActivity.titleTextBox.sendKeys(titulo);
        miListaActivity.noteTextBox.sendKeys(nota);
        miListaActivity.saveNote.click();

        miListaActivity.doneCheckBox.click();
        listTasksBefore = new CheckBox(By.xpath("//android.widget.ImageButton[@content-desc=\"Marcar como Hecha\"]")).findAllControls();

        int sizeBefore = listTasksBefore.size();

        miListaActivity.moreOptionsButton.click();
        miListaActivity.deleteDoneButton.click();
        miListaActivity.confirmDeleteButton.click();

        listTasksAfter = new CheckBox(By.xpath("//android.widget.ImageButton[@content-desc=\"Marcar como Hecha\"]")).findAllControls();

        int sizeAfter = listTasksAfter.size();

        Assert.assertEquals("¡ERROR! Problemas al eliminar un elemento de la lista de dos elementos", sizeBefore-1, sizeAfter);

    }

    @After
    public void after() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
