package pl.edu.uj.kognitywistyka.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@FacesValidator("pl.edu.uj.kognitywistyka.email")
public class EmailValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		try {
			String tmp = (String)value;
			InternetAddress address = new InternetAddress(tmp);
			String adr = address.getAddress();
			if(adr == null || adr.length() < 4)
			{
				throw new ValidatorException(getErrorMessage(context,"InvalidEmailAddress"));
			}	
			String[] parts = tmp.split("@");
			if(parts.length != 2)
			{
				throw new ValidatorException(getErrorMessage(context,"InvalidEmailAddress"));
			}
			parts[0] = parts[0].trim();
			parts[1] = parts[1].trim();
			if(parts[0].length() < 1 || parts[1].length() < 1)
			{
				throw new ValidatorException(getErrorMessage(context,"InvalidEmailAddress"));
			}
			parts = parts[1].split("\\.");
			if(parts.length < 2)
			{
				throw new ValidatorException(getErrorMessage(context,"InvalidEmailAddress"));
			}
			for(int i = 0; i < parts.length; ++i)
			{
				parts[i] = parts[i].trim();
				if( parts[i].length() < 1)
				{
					throw new ValidatorException(getErrorMessage(context,"InvalidEmailAddress"));
				}
			}
		} catch (AddressException e) {
			throw new ValidatorException(getErrorMessage(context,"InvalidEmailAddress"), e);
		}
	}
	
	private FacesMessage getErrorMessage(FacesContext context, String resourceid)
    {
    	UIViewRoot viewRoot = context.getViewRoot();
    	Locale locale = viewRoot.getLocale();
    	ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	ResourceBundle bundle = ResourceBundle.getBundle("messages", locale, loader);
    	String resource = bundle.getString(resourceid);
    	return new FacesMessage(resource);
    }
}