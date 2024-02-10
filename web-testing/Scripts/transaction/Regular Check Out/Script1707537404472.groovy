import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

class Users {
	String username
	String password
	
	Users(String username, String password) {
		this.username = username
		this.password = CustomKeywords.'auth.CryptoUtils.encrypt'(password)
	}
}

Users currentUser = new Users(username, password)

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.webURL)

WebUI.waitForElementPresent(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/label_Shop Now'), 20)

WebUI.click(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/label_Shop Now'))

WebUI.click(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/a_Beats Studio 2 Over-Ear Matte Black Headphones'))

WebUI.click(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/button_ADD TO CART'))

CustomKeywords.'users.Operations.Login'(currentUser.username, currentUser.password)

WebUI.click(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/svgmenuCart'))

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/button_CHECKOUT (179.99)'))

WebUI.click(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/button_NEXT'))

WebUI.setText(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/input_safepay_username'), currentUser.username)

WebUI.setEncryptedText(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/input_safepay_password'), 
    currentUser.password)

WebUI.click(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/button_PAY NOW'))

WebUI.takeScreenshot()

String orderNumber = WebUI.getText(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/orderNumberSpan'))

WebUI.click(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/span_airlangga'))

WebUI.click(findTestObject('Object Repository/Transactions/Page_Advantage Shopping/label_My orders'))

WebUI.takeScreenshot()

WebUI.verifyTextPresent(orderNumber, false)

WebUI.closeBrowser()