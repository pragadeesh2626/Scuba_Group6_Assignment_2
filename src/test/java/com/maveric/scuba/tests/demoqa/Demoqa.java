package com.maveric.scuba.tests.demoqa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.maveric.scuba.pageobjects.demoqa.Demoqa_Objects;
import com.maveric.scuba.utils.*;

public class Demoqa {
	@Test
	public static void ProfileForm() throws InterruptedException {
		Scubautils.driverinit("ff");
		Scubautils.urllaunch("https://demoqa.com/");
		Scubautils.Btnclick(Demoqa_Objects.form);
		Scubautils.Btnclick(Demoqa_Objects.Practice_Form);
		Scubautils.send(Demoqa_Objects.FirstName, "John Pragadeesh");
		Scubautils.send(Demoqa_Objects.LastName, "Kiru Prathachala");
		Scubautils.send(Demoqa_Objects.UserEmail, "johnpraga@gmail.com");
		Scubautils.Btnclick(Demoqa_Objects.Male_Gender);
		Scubautils.send(Demoqa_Objects.UserNumber, "9600091763");
		Scubautils.datePicker(Demoqa_Objects.DOB, 3, Demoqa_Objects.Date, "1994");
		Scubautils.send(Demoqa_Objects.Subject_Search,"English");
		Scubautils.tabkey();		
		Scubautils.Btnclick(Demoqa_Objects.Music_Hobby);
		Scubautils.Btnclick(Demoqa_Objects.Reading_Hobby);
		Scubautils.Btnclick(Demoqa_Objects.Sports_Hobby);
		Scubautils.UploadFile(Demoqa_Objects.ChooseFile);
		Scubautils.send(Demoqa_Objects.TextBox_CurrentAddress, "ABC");
		Scubautils.send(Demoqa_Objects.Select_State,"Rajasthan");
		Scubautils.tabkey();
		Scubautils.send(Demoqa_Objects.Select_City,"Jaipur");
		Scubautils.tabkey();
		Scubautils.pgdwn();
		Thread.sleep(5000);
		Scubautils.Btnclick(Demoqa_Objects.ProfileForm_Submit);
		Thread.sleep(5000);
		Scubautils.Btnclick(Demoqa_Objects.ProfileForm_Close);
	}
	
@Test
public static void BookStore() throws InterruptedException
{
	Scubautils.driverinit("ff");
	Scubautils.urllaunch("https://demoqa.com/");
	Scubautils.pgdwn();
	Scubautils.Btnclick(Demoqa_Objects.BookStoreApplications);
	Scubautils.Btnclick(Demoqa_Objects.Login_Form);
	Scubautils.Btnclick(Demoqa_Objects.Login_Button);
	Scubautils.send(Demoqa_Objects.UserName, "JohnPragadeesh");
	Scubautils.send(Demoqa_Objects.Password, "Maveric@456");
	Scubautils.Btnclick(Demoqa_Objects.Login_Submit);
	Thread.sleep(5000);
	Scubautils.pgdwn();
	Scubautils.Btnclick(Demoqa_Objects.Goto_BookStore);
	Scubautils.Btnclick(Demoqa_Objects.BookName);
	Scubautils.Btnclick(Demoqa_Objects.AddCollection);
	Thread.sleep(5000);
	Scubautils.alertok();
	Scubautils.pgdwn();
	Scubautils.Btnclick(Demoqa_Objects.Profile);
	Scubautils.Btnclick(Demoqa_Objects.Delete_Allbooks);
	Thread.sleep(2000);
	Scubautils.alertok();
	Thread.sleep(2000);
	Scubautils.alertok();
	Scubautils.Btnclick(Demoqa_Objects.Logout);
}
}