package com.epam.lab.buyit.controller.email;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.email.textlines.TextLineConteiner;
import com.epam.lab.buyit.controller.email.textlines.TextLineItem;
import com.epam.lab.buyit.controller.email.textlines.impl.AuctionPriceLine;
import com.epam.lab.buyit.controller.email.textlines.impl.BuyItNowPrice;
import com.epam.lab.buyit.controller.email.textlines.impl.BuyerGreatingLine;
import com.epam.lab.buyit.controller.email.textlines.impl.BuyerLine;
import com.epam.lab.buyit.controller.email.textlines.impl.BuyerLink;
import com.epam.lab.buyit.controller.email.textlines.impl.CountLine;
import com.epam.lab.buyit.controller.email.textlines.impl.PasswordLine;
import com.epam.lab.buyit.controller.email.textlines.impl.ProductLink;
import com.epam.lab.buyit.controller.email.textlines.impl.ProductNameLine;
import com.epam.lab.buyit.controller.email.textlines.impl.SellerGreatingLine;
import com.epam.lab.buyit.controller.email.textlines.impl.SellerLine;
import com.epam.lab.buyit.controller.email.textlines.impl.SellerLink;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.User;

public class EmailMessageBuilder {
	private static final Logger LOGGER = Logger
			.getLogger(EmailMessageBuilder.class);
	private String registrationHtmlPath = getPath("/html/registrationForm.html");
	private String passwordRecoveryHtmlPath = getPath("/html/passwordRecoveryForm.html");
	private String placeABidHtmlPath = getPath("/html/placeABidForm.html");
	private String yourBidKillHtmlPath = getPath("/html/yourBidKilledForm.html");
	private String winLotHtmlPath = getPath("/html/winLotForm.html");
	private String productSoldOnAuctionHtml = getPath("/html/productSoldOnAuction.html");
	private String productSoldOnBuyItNowHtml = getPath("/html/productSoldOnBuyItNow.html");
	private String noBodyBuyProductHtml = getPath("/html/noBodyByYouProductForm.html");
	private String buyItNowHtml = getPath("/html/buyItNowForm.html");

	private ArrayList<TextLineItem> lineList = new ArrayList<TextLineItem>();

	{
		lineList.add(new BuyerGreatingLine());
		lineList.add(new BuyerLine());
		lineList.add(new BuyerLink());

		lineList.add(new SellerGreatingLine());
		lineList.add(new SellerLine());
		lineList.add(new SellerLink());

		lineList.add(new PasswordLine());
		lineList.add(new ProductLink());
		lineList.add(new ProductNameLine());

		lineList.add(new BuyItNowPrice());
		lineList.add(new AuctionPriceLine());
		lineList.add(new CountLine());
	}

	public void sendSuccessRegistrationForm(User user) {

		String text = "";
		BufferedReader br = null;
		TextLineConteiner conteiner = new TextLineConteiner();
		conteiner.setBuyer(user);
		try {
			String currentLine = null;
			br = new BufferedReader(new FileReader(registrationHtmlPath));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				for (TextLineItem textLine : lineList) {
					if (currentLine.contains(textLine.getId())) {
						textLine.setTextLineContainer(conteiner);
						text += textLine.execute() + "\n";
						break;
					}
				}
			}

		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				LOGGER.warn(e);
			}
		}
		EmailSender.sendHtml("You have successfully registered", text, user
				.getContact().getEmail());

	}

	public void sendPasswordRecoveryForm(User user, String password) {
		String text = "";
		TextLineConteiner conteiner = new TextLineConteiner();
		conteiner.setBuyer(user).setPassword(password);
		BufferedReader br = null;
		try {
			String currentLine = null;
			br = new BufferedReader(new FileReader(passwordRecoveryHtmlPath));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				for (TextLineItem textLine : lineList) {
					if (currentLine.contains(textLine.getId())) {
						textLine.setTextLineContainer(conteiner);
						text += textLine.execute() + "\n";
						break;
					}
				}
			}

		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				LOGGER.warn(e);
			}
		}
		EmailSender.sendHtml("Password recovery...", text, user.getContact()
				.getEmail());

	}

	public void sendPlaceABidForm(User buyer, Product product) {
		String text = "";
		TextLineConteiner conteiner = new TextLineConteiner();
		conteiner.setBuyer(buyer).setProduct(product);
		BufferedReader br = null;
		try {
			String currentLine = null;
			br = new BufferedReader(new FileReader(placeABidHtmlPath));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				for (TextLineItem textLine : lineList) {
					if (currentLine.contains(textLine.getId())) {
						textLine.setTextLineContainer(conteiner);
						text += textLine.execute() + "\n";
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				LOGGER.warn(e);
			}
		}
		EmailSender.sendHtml("Place a bid...", text, buyer.getContact()
				.getEmail());

	}

	public void sendYourBidKilldForm(User buyer, Product product) {
		String text = "";
		TextLineConteiner conteiner = new TextLineConteiner();
		conteiner.setBuyer(buyer).setProduct(product);
		BufferedReader br = null;
		try {
			String currentLine = null;
			br = new BufferedReader(new FileReader(yourBidKillHtmlPath));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				for (TextLineItem textLine : lineList) {
					if (currentLine.contains(textLine.getId())) {
						textLine.setTextLineContainer(conteiner);
						text += textLine.execute() + "\n";
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				LOGGER.warn(e);
			}
		}
		EmailSender.sendHtml("Your lot was killd", text, buyer.getContact()
				.getEmail());
	}

	public void sendWinLotForm(User buyer, Product product, User seller) {
		String text = "";
		TextLineConteiner conteiner = new TextLineConteiner();
		conteiner.setBuyer(buyer).setProduct(product).setSeller(seller);
		BufferedReader br = null;
		try {
			String currentLine = null;
			br = new BufferedReader(new FileReader(winLotHtmlPath));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				for (TextLineItem textLine : lineList) {
					if (currentLine.contains(textLine.getId())) {
						textLine.setTextLineContainer(conteiner);
						text += textLine.execute() + "\n";
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				LOGGER.warn(e);
			}
		}
		EmailSender.sendHtml("You win a lot...", text, buyer.getContact()
				.getEmail());
	}

	public void sendProductSoldOnAuctionForm(User seller, Product product,
			User buyer) {
		String text = "";
		TextLineConteiner conteiner = new TextLineConteiner();
		conteiner.setBuyer(buyer).setSeller(seller).setProduct(product);
		BufferedReader br = null;
		try {
			String currentLine = null;
			br = new BufferedReader(new FileReader(productSoldOnAuctionHtml));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				for (TextLineItem textLine : lineList) {
					if (currentLine.contains(textLine.getId())) {
						textLine.setTextLineContainer(conteiner);
						text += textLine.execute() + "\n";
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				LOGGER.warn(e);
			}
		}
		EmailSender.sendHtml("Your product sold...", text, seller.getContact()
				.getEmail());
	}

	public void sendProductSoldOnBuyItNowForm(User seller, Product product,
			User buyer, int count) {
		String text = "";
		TextLineConteiner conteiner = new TextLineConteiner();
		conteiner.setBuyer(buyer).setSeller(seller).setProduct(product)
				.setCount(count);
		BufferedReader br = null;
		try {
			String currentLine = null;
			br = new BufferedReader(new FileReader(productSoldOnBuyItNowHtml));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				for (TextLineItem textLine : lineList) {
					if (currentLine.contains(textLine.getId())) {
						textLine.setTextLineContainer(conteiner);
						text += textLine.execute() + "\n";
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				LOGGER.warn(e);
			}
		}
		EmailSender.sendHtml("Your product sold...", text, seller.getContact()
				.getEmail());
	}

	public void sendNoBodyBuyYourProductForm(User seller, Product product) {
		String text = "";
		TextLineConteiner conteiner = new TextLineConteiner();
		conteiner.setSeller(seller).setProduct(product);
		BufferedReader br = null;
		try {
			String currentLine = null;
			br = new BufferedReader(new FileReader(noBodyBuyProductHtml));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				for (TextLineItem textLine : lineList) {
					if (currentLine.contains(textLine.getId())) {
						textLine.setTextLineContainer(conteiner);
						text += textLine.execute() + "\n";
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				LOGGER.warn(e);
			}
		}
		EmailSender.sendHtml("Sorry nobody buy your product", text, seller
				.getContact().getEmail());
	}

	public void sendBuyItNowForm(User seller, Product product, User buyer,
			int count) {
		String text = "";
		TextLineConteiner conteiner = new TextLineConteiner();
		conteiner.setSeller(seller).setProduct(product).setBuyer(buyer)
				.setCount(count);
		BufferedReader br = null;
		try {
			String currentLine = null;
			br = new BufferedReader(new FileReader(buyItNowHtml));
			while ((currentLine = br.readLine()) != null) {
				text += currentLine;
				text += "\n";
				for (TextLineItem textLine : lineList) {
					if (currentLine.contains(textLine.getId())) {
						textLine.setTextLineContainer(conteiner);
						text += textLine.execute() + "\n";
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				LOGGER.warn(e);
			}
		}
		EmailSender.sendHtml("You buy product", text, buyer.getContact()
				.getEmail());
	}

	private static String getPath(String relativePath) {
		String oldPath = EmailMessageBuilder.class.getProtectionDomain()
				.getCodeSource().getLocation().getPath();
		String newPath = oldPath.replaceAll("%5Bepam%5D", "[epam]");
		newPath = newPath
				.replaceAll(
						"/WEB-INF/classes/com/epam/lab/buyit/controller/email/EmailMessageBuilder.class",
						relativePath);
		return newPath;
	}
}
