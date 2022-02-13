package tests1;

import org.testng.annotations.DataProvider;

public class DataProvider1 {
	
	@DataProvider(name="data-provider1")
	public Object[][] getData() {
		Object[][] data =new Object[2][3];
		//row 1
		data[0][0]="userName1";
		data[0][1]="password1";
		data[0][2]="resticted";
		//row 2
		data[1][0]="userName2";
		data[1][1]="password2";
		data[1][2]="non-resticted";
		
		return data;
	}

}
