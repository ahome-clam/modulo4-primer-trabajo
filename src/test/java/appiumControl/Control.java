package appiumControl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sessionManager.Session;

import java.net.MalformedURLException;
import java.util.List;

public class Control {
    protected WebElement control;
    protected By locator;

    public Control(By locator){
        this.locator=locator;
    }

    public void findControl() throws MalformedURLException {
        this.control= Session.getInstance().getDriver().findElement(this.locator);
    }

    public List<WebElement> findAllControls() throws MalformedURLException {
        List<WebElement> list = Session.getInstance().getDriver().findElements(this.locator);
        return list;
    }

    public void click() throws MalformedURLException {
        this.findControl();
        this.control.click();
    }

    public String getText() throws MalformedURLException {
        this.findControl();
        return this.control.getText();
    }

    public boolean isDisplayed(){
        try{
            this.findControl();
            return this.control.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void sendKeys(String keys) throws MalformedURLException {
        this.findControl();
        this.control.sendKeys(keys);
    }

    public String isChecked() {
        try{
            this.findControl();
            return this.control.getAttribute("checked");
        }catch (Exception e){
            return "NO SÉ";
        }
    }
}
