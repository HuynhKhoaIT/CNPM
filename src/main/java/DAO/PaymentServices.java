package DAO;

import java.util.*;
import Model.*;
import Model.Item;

import com.paypal.api.payments.*;
import com.paypal.base.rest.*;

public class PaymentServices {
	private static final String CLIENT_ID = "ARx6yqggvEcdgcf7kjhd60w8EYRobPbkjtRA6vPMEy1A983G1Zd9NzbPf6o5JZTexdFMX80la7leRbag";
	private static final String CLIENT_SECRET = "EMnkLS6R_RM3VdCIymqPPxvO_8odJ43lD1ZaSrNkp-QdyXKkPRRCKwXbdL7LjS5M429Nygsz6URbiItL";
	private static final String MODE = "sandbox";

	public String authorizePayment(String total, List<Item> items) throws PayPalRESTException {

		Payer payer = getPayerInformation();
		RedirectUrls redirectUrls = getRedirectURLs();
		List<Transaction> listTransaction = getTransactionInformation(total, items);

		Payment requestPayment = new Payment();
		requestPayment.setTransactions(listTransaction);
		requestPayment.setRedirectUrls(redirectUrls);
		requestPayment.setPayer(payer);
		requestPayment.setIntent("authorize");

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		Payment approvedPayment = requestPayment.create(apiContext);



		return getApprovalLink(approvedPayment);

	}

	private Payer getPayerInformation() {
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		PayerInfo payerInfo = new PayerInfo();
		payerInfo.setFirstName("Quân").setLastName("Nguyễn").setEmail("sb-47vhts22009362_api1.business.example.com");

		payer.setPayerInfo(payerInfo);

		return payer;
	}

	private RedirectUrls getRedirectURLs() {
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://localhost:8080/Apple_store/show");
		redirectUrls.setReturnUrl("http://localhost:8080/Apple_store/review_payment");


		return redirectUrls;
	}

	private String getApprovalLink(Payment approvedPayment) {
		List<Links> links = approvedPayment.getLinks();
		String approvalLink = null;

		for (Links link : links) {
			if (link.getRel().equalsIgnoreCase("approval_url")) {
				approvalLink = link.getHref();
				break;
			}
		}

		return approvalLink;
	}

	private List<Transaction> getTransactionInformation(String Total, List<Item> items) {

		/*
		 * for (Item o : items) {
		 */
		/*
		 * Details details = new Details();
		 * details.setSubtotal(Integer.toString(o.getPrice()));
		 */

		Details details = new Details();
		details.setShipping("0");
		details.setSubtotal(Total);
		details.setTax("0");


		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal(Total);
		amount.setDetails(details);

		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription("");


		ItemList itemList = new ItemList();
		List<com.paypal.api.payments.Item> Items = new ArrayList<com.paypal.api.payments.Item>();

		for (Item o : items) {
			com.paypal.api.payments.Item item = new com.paypal.api.payments.Item();
			item.setCurrency("USD");
			item.setName(o.getNameSP());
			item.setPrice(Integer.toString(o.getPrice()));
			item.setTax("0");
			item.setQuantity(Integer.toString(o.getQuantity()));

			Items.add(item);
		}
		itemList.setItems(Items);
		transaction.setItemList(itemList);

		List<Transaction> listTransaction = new ArrayList<Transaction>();
		listTransaction.add(transaction);

		return listTransaction;


	}

	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
		return Payment.get(apiContext, paymentId);
	}

	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(payerId);

		Payment payment = new Payment().setId(paymentId);

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		return payment.execute(apiContext, paymentExecution);
	}
}
