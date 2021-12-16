package com.code.mvcapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.code.mvcapp.model.AutoAcquire;

public class validation {

		public String validateParameters(AutoAcquire autoAcquireBean) {

			String validateMSISDN    = validateMSISDN(autoAcquireBean.getMsisdn().toString());

			String validateSIM_TYPE  = validateSIM_TYPE(autoAcquireBean.getSimType());

			String validateName      = validateName(autoAcquireBean.getName());

			String validateDOB       = validateDOB(autoAcquireBean.getDateOfBirth());

			String validateGender    = validateGender(autoAcquireBean.getGender());

			String validateAddress   = validateAddress(autoAcquireBean.getAddress());

			String validateID_Number = validateID_Number(autoAcquireBean.getIdNumber());
	    
			if (validateMSISDN.equals("") && 
					validateSIM_TYPE.equals("") && 
					validateName.equals("") &&
					validateDOB.equals("")&& 
					validateGender.equals("") && 
					validateAddress.equals("") &&
					validateID_Number.equals("")) {
				
				return "SUCCESS";
			
			} else {
				return "  Validation failed because of the following reasons \r\n " 
						+ validateMSISDN +"\r\n"
						+ validateSIM_TYPE+"\r\n"
						+ validateName+"\r\n"
						+ validateDOB +"\r\n"
						+ validateGender +"\r\n"
						+ validateAddress+"\r\n"
						+ validateID_Number;
			}
		
	 }

		public static String validateMSISDN(String long1) {

			String msg = "";
			if ((!long1.equals("")) && (long1 != null)) {
				String CC = "66";
				String numberLength = "8";
				String finalMSISDN = null;

				Pattern msisdnWithCC = Pattern.compile("^(" + CC + ")([0-9]{" + numberLength + "})$");
				Pattern msisdnWithoutCC = Pattern.compile("^(0)([0-9]{" + numberLength + "})$");
				Pattern msisdnWithoutZero = Pattern.compile("^([0-9]{" + numberLength + "})$");

				Matcher teststring = msisdnWithCC.matcher(long1);

				if (teststring.matches()) {
					finalMSISDN = long1;
				} else {
					teststring = msisdnWithoutCC.matcher(long1);
					if (teststring.matches()) {
						finalMSISDN = CC + teststring.group(2);
					} else {
						teststring = msisdnWithoutZero.matcher(long1);
						if (teststring.matches()) {
							finalMSISDN = CC + teststring.group(1);
						}
					}
				}

				if (finalMSISDN == null) {
					msg = "MSISDN is INVALID, Please enter a valid MSISDN";
				}
			} else {
				msg = "MSISDN should not be empty, Please enter a MSISDN";
			}
			return msg;
		}

		public static String validateSIM_TYPE(String SIM_Type) {
			
			String msg="";
			
			if ((!SIM_Type.equals("")) && (SIM_Type != null)) {

				if (!SIM_Type.equalsIgnoreCase("PREPAID") && !SIM_Type.equalsIgnoreCase("POSTPAID")) {
	               msg="Selected SIM type is not valid," + " Please Specify POSTPAID or PREPAID only";
				}
			} else {
				  msg="Please enter a SIM type (POSTPAID or PREPAID)";
			}
	       return msg;
		}

		public static String validateName(String name) {
			String msg="";
			if ((!name.equals("")) && (name != null)) {
				
				  Pattern p = Pattern.compile("[^A-Za-z0-9]");
				  Matcher m = p.matcher(name);
				  boolean b = m.find();
				  if (b)
				    msg ="Name coontains a special character ,Please enter valid Name";
				 
			} else {
				  
				msg="Please enter your Name, Name cannot be empty";
			}
			 return msg;
		}

		public static String validateDOB(String date) {
			
			String msg="";
			if ((!date.equals("")) && (date != null)) {

				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

				Date inputDate = null;
				try {
					inputDate = (Date) formatter.parse(date);
				} catch (ParseException e) {
					System.out.println("parse exception arised");
					e.printStackTrace();
				}
				System.out.println("inputDate = " + inputDate);

				Date dateNow = new Date();
				// System.out.println("dateNow = "+dateNow);

				String currentdate1 = formatter.format(dateNow);
				// System.out.println("string currentdate ="+currentdate1);

				Date currentdate = null;
				try {
					currentdate = (Date) formatter.parse(currentdate1);
				} catch (ParseException e) {
					System.out.println("parse exception arised");
					e.printStackTrace();
				}
				System.out.println("currentdate = " + currentdate);

				if (!inputDate.before(currentdate)) {
					
					msg="Date Of Birth is not valid, Please Enter a date before today";
				}

			} else {
				
				msg="Date of Birth should not be empty, Please enter your Date of Birth";
			}
			 return msg;
		}

		public static String validateGender(String gender) {
			String msg="";
			if ((!gender.equals("")) && (gender != null)) {
				if (!gender.equalsIgnoreCase("F") && !gender.equalsIgnoreCase("M")) {
					 
					msg="Please enter your gender in 'F' or 'M' format";
				}
			} else {
				msg="Gender should not be empty, " + "Please enter your Gender";
			}
			return msg;
		}

		public static String validateAddress(String address) {
			String msg="";
			if ((!address.equals("")) && (address != null)) {
				if (address.length()<20) {
					 
					msg="Please enter your full address" + " (Address must be more than 20 characters)";
				}
			} else {
				
	               msg="Address should not be empty, " + "Please enter your Address";
			}
			return msg;
		}

		public static String validateID_Number(String id_number) {
			String msg="";
			if ((!id_number.equals("")) && (id_number != null)) {
				if (!id_number.matches("^[a-zA-Z0-9]*$")) {
					msg="ID_Number is not valid, ID_Number should be a " + "combination of characters and numbers";
				}
			} else {
				 
				msg="Please enter an ID_Number, ID_Number cannot be empty";
			}
			return msg;
		}

	/*	public static Boolean validateMSISDN1(String id_number) {
			Boolean msg=true;
			return msg;
		}
	*/

	}


