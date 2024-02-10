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

import com.kms.katalon.util.CryptoUtil

def encryptedText = CustomKeywords.'auth.CryptoUtils.encrypt'(password)

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.webURL + 'register')

WebUI.setText(findTestObject('Object Repository/Page_Advantage Shopping/input_usernameRegisterPage'), username)

WebUI.click(findTestObject('Object Repository/Page_Advantage Shopping/label_Email'))

WebUI.setText(findTestObject('Object Repository/Page_Advantage Shopping/input_emailRegisterPage'), email)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Advantage Shopping/input_passwordRegisterPage'), encryptedText)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Advantage Shopping/input_confirm_passwordRegisterPage'), encryptedText)

WebUI.setText(findTestObject('Object Repository/Page_Advantage Shopping/input_first_nameRegisterPage'), first_name)

WebUI.setText(findTestObject('Object Repository/Page_Advantage Shopping/input_last_nameRegisterPage'), last_name)

WebUI.setText(findTestObject('Object Repository/Page_Advantage Shopping/input_phone_numberRegisterPage'), phone_number)

Integer countryCode = 0

switch(country) {
    case "Indonesia":
        countryCode = 170;
        break;
    case "UK":
        countryCode = 297;
        break;
    case "USA":
        countryCode = 298;
        break;
}

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Advantage Shopping/select_AfganistanAlbaniaAlgeriaAmerican Sam_3cef8a'),
		'object:' + countryCode, true)

WebUI.setText(findTestObject('Object Repository/Page_Advantage Shopping/input_cityRegisterPage'), city)

WebUI.setText(findTestObject('Object Repository/Page_Advantage Shopping/input_addressRegisterPage'), address)

WebUI.setText(findTestObject('Object Repository/Page_Advantage Shopping/input_state__province__regionRegisterPage'), province)

WebUI.setText(findTestObject('Object Repository/Page_Advantage Shopping/input_postal_codeRegisterPage'), postal_code)

WebUI.click(findTestObject('Object Repository/Page_Advantage Shopping/input_i_agree'))

WebUI.click(findTestObject('Object Repository/Page_Advantage Shopping/button_REGISTER'))

WebUI.takeScreenshot()

WebUI.closeBrowser()