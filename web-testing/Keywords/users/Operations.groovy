package users

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Operations {
	@Keyword
	def Login(String username, String password) {
		WebUI.delay(4)

		WebUI.click(findTestObject('Object Repository/Auth/Page_Advantage Shopping/svgmenuUser'))

		WebUI.setText(findTestObject('Object Repository/Auth/Page_Advantage Shopping/input_username'), username)

		WebUI.setEncryptedText(findTestObject('Object Repository/Auth/Page_Advantage Shopping/input_password'), password)

		WebUI.click(findTestObject('Object Repository/Auth/Page_Advantage Shopping/button_SIGN IN'))

		WebUI.takeScreenshot()

		def userElement = findTestObject('Object Repository/Auth/Page_Advantage Shopping/span_airlangga')

		if (WebUI.verifyElementPresent(userElement, 0)) {
			String username_value = WebUI.getText(findTestObject('Object Repository/Auth/Page_Advantage Shopping/span_airlangga'))

			assert username_value == username
		} else {
			assert false
		}
	}

	@Keyword
	def Logout() {
		WebUI.click(findTestObject('Object Repository/Auth/Page_Advantage Shopping/span_airlangga'))

		WebUI.click(findTestObject('Object Repository/Auth/Page_Advantage Shopping/label_Sign out'))
	}
}
