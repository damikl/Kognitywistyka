package pl.edu.uj.kognitywistyka.contact.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.contact.bo.ContactBo;

@ManagedBean
@RequestScoped
public class ContactBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String senderName;
	private String senderEmail;
	private String message;

	private String successResponse;

	@ManagedProperty(name = "contactBo", value = "#{contactBo}")
	private ContactBo contactBo;


	public void setContactBo(ContactBo contactBo) {
		this.contactBo = contactBo;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSuccessResponse(String successResponse) {
		this.successResponse = successResponse;
	}
	public String getSuccessResponse() {
		String successResponse = this.successResponse;
		this.successResponse = "";
		return successResponse;
	}

	public String sendMessage() {
		String from = senderName + " <" + senderEmail + ">";
		contactBo.sendMessage(from, "Wiadomość z formularza kontaktowego", message);

		resetView();
		setSuccessResponse("Wiadomość wysłana poprawnie.");
		return "success";
	}

	private void resetView() {
		setSenderName("");
		setSenderEmail("");
		setMessage("");
		setSuccessResponse("");
	}
}
