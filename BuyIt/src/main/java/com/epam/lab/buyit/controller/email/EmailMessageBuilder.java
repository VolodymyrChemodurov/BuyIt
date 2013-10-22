package com.epam.lab.buyit.controller.email;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.User;

public class EmailMessageBuilder {
	private static final Logger LOGGER = Logger
			.getLogger(EmailMessageBuilder.class);
	String registrationHtmlPath = getPath("/html/registrationForm.html");
	String passwordRecoveryHtmlPath = getPath("/html/passwordRecoveryForm.html");
	String placeABidHtmlPath = getPath("/html/placeABidForm.html");
	String yourBidKillHtmlPath = getPath("/html/yourBidKilledForm.html");
	String winLotHtmlPath = getPath("/html/winLotForm.html");
	String productSoldHtml = getPath("/html/productSold.html");

	public void sendSuccessRegistrationForm(String userName, String email) {
		String text = "";
		String greatingLine = "Hello " + userName + " !!!";
		BufferedReader br = null;
		try {
			String currentLine = null;
			br = new BufferedReader(new FileReader(
					registrationHtmlPath));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				if (currentLine.contains("greatingLine")) {
					text += greatingLine + "\n";

				}

			}

		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		} finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					LOGGER.error(e);
				}
		}
		// System.out.println(text);
		EmailSender.sendHtml("You have successfully registered", text, email);

	}

	public void sendPasswordRecoveryForm(String userName, String password,
			String email) {
		String text = "";
		String greatingLine = "Hello " + userName + " !!!";

		try {
			String currentLine = null;
			BufferedReader br = new BufferedReader(new FileReader(
					passwordRecoveryHtmlPath));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				if (currentLine.contains("greatingLine")) {
					text += greatingLine + "\n";

				}
				if (currentLine.contains("password")) {
					text += password + "\n";

				}
			}

		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		EmailSender.sendHtml("Password recovery...", text, email);

	}

	public void sendPlaceABidForm(String userName, Product product, String email) {
		String text = "";
		String greatingLine = "Hello " + userName + " !!!";
		String productLink = "http://localhost:8080/BuyIt/productDetails?id="
				+ product.getIdProduct();
		try {
			String currentLine = null;
			BufferedReader br = new BufferedReader(new FileReader(
					placeABidHtmlPath));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				if (currentLine.contains("greatingLine")) {
					text += greatingLine + "\n";
					continue;
				}
				if (currentLine.contains("productName")) {
					text += product.getName() + "\n";
					continue;
				}
				if (currentLine.contains("productLink")) {
					text += productLink + "\n";
					continue;
				}
				if (currentLine.contains("endTime")) {
					text += product.getAuction().getEndTime() + "\n";
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		EmailSender.sendHtml("Place a bid...", text, email);

	}

	public void sendYourBidKilldForm(String userName, Product product,
			String email) {
		String text = "";
		String greatingLine = "Hello " + userName + " !!!";
		String productLink = "http://localhost:8080/BuyIt/productDetails?id="
				+ product.getIdProduct();
		try {
			String currentLine = null;
			BufferedReader br = new BufferedReader(new FileReader(
					yourBidKillHtmlPath));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				if (currentLine.contains("greatingLine")) {
					text += greatingLine + "\n";

				}
				if (currentLine.contains("productName")) {
					text += product.getName() + "\n";
				}
				if (currentLine.contains("productLink")) {
					text += productLink + "\n";
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		EmailSender.sendHtml("Your lot was killd", text, email);
	}

	public void sendWinLotForm(String userName, Product product, User seller,
			String email) {
		String text = "";
		String greatingLine = "Hello " + userName + " !!!";
		String productLink = "http://localhost:8080/BuyIt/productDetails?id="
				+ product.getIdProduct();
		String sellerLine = "Name: " + seller.getFirstName() + ";<br>  Email: "
				+ seller.getContact().getEmail()+";<br> ";
		if(!seller.getContact().getPhone().equals("") ){
			sellerLine+="Phone: "+ seller.getContact().getPhone()+"<br>"; 
		}
		try {
			String currentLine = null;
			BufferedReader br = new BufferedReader(new FileReader(
					winLotHtmlPath));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				if (currentLine.contains("greatingLine")) {
					text += greatingLine + "\n";
					continue;
				}
				if (currentLine.contains("productName")) {
					text += product.getName() + "\n";
					continue;
				}
				if (currentLine.contains("productLink")) {
					text += productLink + "\n";
					continue;
				}
				if (currentLine.contains("SellerLine")) {
					text += sellerLine + "\n";
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		EmailSender.sendHtml("You win a lot...", text, email);
	}
	public void sendProductSoldForm(String userName, Product product, User buyer,
			String email) {
		String text = "";
		String greatingLine = "Hello " + userName + " !!!";
		String productLink = "http://localhost:8080/BuyIt/productDetails?id="
				+ product.getIdProduct();
		String sellerLine = "Name: " + buyer.getFirstName() + ";<br>  Email: "
				+ buyer.getContact().getEmail()+";<br> ";
		if(!buyer.getContact().getPhone().equals("") ){
			sellerLine+="Phone: "+ buyer.getContact().getPhone()+"<br>"; 
		}
		try {
			String currentLine = null;
			BufferedReader br = new BufferedReader(new FileReader(
					productSoldHtml));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				if (currentLine.contains("greatingLine")) {
					text += greatingLine + "\n";
					continue;
				}
				if (currentLine.contains("productName")) {
					text += product.getName() + "\n";
					continue;
				}
				if (currentLine.contains("productLink")) {
					text += productLink + "\n";
					continue;
				}
				if (currentLine.contains("BuyerLine")) {
					text += sellerLine + "\n";
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		EmailSender.sendHtml("Your product sold...", text, email);
	}

	private static String getPath(String relativePath) {
		String oldPath = EmailMessageBuilder.class.getProtectionDomain()
				.getCodeSource().getLocation().getPath();
		// System.out.println(oldPath);
		String newPath = oldPath.replaceAll("%5Bepam%5D", "[epam]");
		newPath = newPath
				.replaceAll(
						"/WEB-INF/classes/com/epam/lab/buyit/controller/email/EmailMessageBuilder.class",
						relativePath);
		return newPath;
	}
}
