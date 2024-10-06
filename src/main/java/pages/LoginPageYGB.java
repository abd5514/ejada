package pages;
import drivers_initializer.drivers.AppiumMobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPageYGB {
    public LoginPageYGB(AppiumMobileDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver.getDriver()),this);
    }

    @AndroidFindBy(id="com.a2a.ygb:id/iv_profile")
    public   AndroidElement ProfileButton ;
    @AndroidFindBy(xpath="(//android.view.ViewGroup[@resource-id=\"com.a2a.ygb:id/constraint_layout\"])[2]/android.widget.EditText")
    public   AndroidElement EmailFelid ;
    @AndroidFindBy(xpath="(//android.view.ViewGroup[@resource-id=\"com.a2a.ygb:id/constraint_layout\"])[3]/android.widget.EditText")
    public  AndroidElement Password ;
    @AndroidFindBy(id="com.a2a.ygb:id/btn_login")
    public  AndroidElement buttonLogin ;
    @AndroidFindBy( xpath = "//android.widget.EditText\n")
    public AndroidElement sendcode1;

    @AndroidFindBy(xpath = "(//android.widget.FrameLayout[@resource-id=\"com.a2a.ygb:id/otpView\"])[3]")
    public AndroidElement sendcode2;
    @AndroidFindBy(xpath = "(//android.widget.FrameLayout[@resource-id=\"com.a2a.ygb:id/otpView\"])[4]")
    public AndroidElement sendcode3;
    @AndroidFindBy(xpath = "(//android.widget.FrameLayout[@resource-id=\"com.a2a.ygb:id/otpView\"])[5]")
    public AndroidElement sendcode4;
    @AndroidFindBy(id = "com.a2a.ygb:id/btn_next")
    public AndroidElement done;

    @AndroidFindBy(id = "android:id/button1")
    public AndroidElement invalidLoginMessageOkButton;
    @AndroidFindBy(id = "com.belongi.moe.beta:id/buttonGoBack")
    public AndroidElement backToMainScreen;


    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Accounts\"]")
    public AndroidElement DashboardButton;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.a2a.ygb:id/iv_arrow_right\"])[2]\n")
    public AndroidElement ClickOnXAccount;


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.a2a.ygb:id/tv_header\"]")
    public AndroidElement RecentTranaction;

    @AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.a2a.ygb:id/rv_sub_recent_transaction\"])[1]/android.view.ViewGroup/android.widget.ImageView[2]\n")
    public AndroidElement SpesifcTrans;


}
