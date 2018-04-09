package cucumberleanft;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.RegExpProperty;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.CSSDescription;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import com.hp.lft.sdk.web.WebElement;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LeanFtStepDefinitions {
	
	Browser browser;

    public LeanFtStepDefinitions() {}

    @Before
	public void setUp() throws GeneralLeanFtException {
		browser = BrowserFactory.launch(BrowserType.CHROME);
		browser.deleteCookies();
	}

	@After
	public void cleanUp() throws GeneralLeanFtException {
		browser.close();
	}

	
	//Implementation of the feature’s steps - Passos da Automação
	
    @Given("^User entra no portal de compras online$")
    public void user_entra_no_portal_de_compras_online() throws Throwable {

    	browser.navigate("http://www.advantageonlineshopping.com");
    }
    
    @When("^Seleciona link de Itens Populares$")
    public void seleciona_link_itens_populares() throws GeneralLeanFtException{
		Link POPULARITEMSLink = browser.describe(Link.class, new LinkDescription.Builder()
				.innerText("POPULAR ITEMS")
				.tagName("A").build());
		POPULARITEMSLink.click();
    }
    
    @When("^Adiciona o primeiro item ao carrinho$")
    public void adiciona_primeiro_item_carrinho() throws GeneralLeanFtException{
		Link viewDetailsLink = browser.describe(Link.class, new LinkDescription.Builder()
				.accessibilityName("")
				.innerText("View Details ")
				.role("link")
				.tagName("A")
				.index(0).build());
		viewDetailsLink.click();
		
		Button saveToCartButton = browser.describe(Button.class, new ButtonDescription.Builder()
				.buttonType("submit")
				.name("ADD TO CART")
				.tagName("BUTTON").build());
		saveToCartButton.click();
    }
    
    @When("^Navega para o carrinho$")
    public void navega_para_o_carrinho() throws GeneralLeanFtException{
		WebElement cart = browser.describe(WebElement.class, new CSSDescription("svg#menuCart > path"));
		cart.click();
    }
    
    @Then("^O carrinho atualizado com o item$")
    public void o_carrinho_atualizado_item() throws GeneralLeanFtException{
		Button checkOutBtnButton = browser.describe(Button.class, new ButtonDescription.Builder()
				.buttonType("submit")
				.name(new RegExpProperty("CHECKOUT  (.*)"))
				.tagName("BUTTON").build());
		checkOutBtnButton.click();
		
    }

}