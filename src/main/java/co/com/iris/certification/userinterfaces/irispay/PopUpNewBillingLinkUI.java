package co.com.iris.certification.userinterfaces.irispay;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PopUpNewBillingLinkUI {

    public static final Target LABEL_POP_UP_TITLE = Target.the("").located(By.xpath("//p[contains(.,'Comparte tu link')]"));

    // Estos Target no estan en uso ya que contenido de la ventana emergente al finalizar la creacion de un nuevo link aun no esta definido
    public static final Target BTN_SHARE_LINK_EMAIL = Target.the("button to share billing link by email")
            .located(By.xpath("//button[@class='btn btn-primary btn-block btn-sm text-modal-share'][contains(.,'Correo Electrónico')]"));
    public static final Target TEXT_LINK_QR = Target.the("field with the QR of the billing link to copy")
            .located(By.xpath("//div[@class='col content-qr w-auto']"));
    public static final Target BTN_COPY_LINK = Target.the("button to copy billing link")
            .located(By.xpath("//button[@class='btn btn-primary btn-block btn-sm text-modal-share'][contains(.,'Copiar')]"));
    //
    public static final Target BTN_CLOSE_POP_UP = Target.the("button to close pop up")
            .located(By.xpath("//div[@class='row']/a[@class='close-modal']"));


    public PopUpNewBillingLinkUI() {
    }

}
