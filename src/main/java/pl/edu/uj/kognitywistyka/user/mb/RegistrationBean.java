package pl.edu.uj.kognitywistyka.user.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import pl.edu.uj.kognitywistyka.user.bo.TradeBo;
import pl.edu.uj.kognitywistyka.user.bo.UserBo;
import pl.edu.uj.kognitywistyka.user.model.Trade;
import pl.edu.uj.kognitywistyka.user.model.User;

@ManagedBean
@RequestScoped
public class RegistrationBean {

	
	@ManagedProperty(name = "userBean", value = "#{userBean}")
	private UserBean userBean;
	@ManagedProperty(name = "userBo", value = "#{userBo}")
	private UserBo userBo;
	@ManagedProperty(name = "tradeBo", value = "#{tradeBo}")
	private TradeBo tradeBo;
	private User user = new User();
	
	
	
	public void setTradeBo(TradeBo tradeBo) {
		this.tradeBo = tradeBo;
	}

	private String profession;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String companyName;
	private String positionInCompany;
	private String city;
	private String region;
	private String password;
	private String companyDescription;
	private String[] chosen;
	private List<String> tradeNamessList;
	private List<Trade> trades = null;
	
	
	@PostConstruct
	@SuppressWarnings("unused")
	private void init() {
		trades = tradeBo.getTradeNamesList();
	}
	
	public String register(){
		if(userBo.checkUserExistanceByUserName(userName)){
			sendError("User already exists", "registerButton");
			return "";
		}else{
			Set<Trade> tradesList = new HashSet<Trade>();
			if(trades!= null){
				for(String tradeName : chosen){
				 	for(Trade trade : trades){
				 		if(tradeName.equals(trade.getTradeName())){
				 			tradesList.add(trade);
				 		//	trades.remove(trade);
				 		}
				 	}
				}
			}
			user.setTrades(tradesList);
			if(profession != null)
			{
				user.setBusinessman(profession.equals("businessman"));
				user.setScientist(profession.equals("scientist"));
			}
			else
			{
				user.setBusinessman(false);
				user.setScientist(false);
			}
			
			user.setCity(city);
			user.setCompanyDescription(companyDescription);
			user.setCompanyName(companyName);
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPasswordHash(password);
			user.setPositionInCompany(positionInCompany);
			user.setRegion(region);	
			user.setRegistrationDate(new Date());
			
			user.setUserName(userName);
			userBean.setUser(userBo.createUser(user));
			return "index";
		}
	}

	private void sendError(String error, String buttonName) {
		FacesMessage message = new FacesMessage();
		FacesContext context = FacesContext.getCurrentInstance();
		UIComponent mybutton = findComponent(context.getViewRoot(), buttonName);
		context.addMessage(mybutton.getClientId(context), message);
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private UIComponent findComponent(UIComponent parent, String id) {
		if(id.equals(parent.getId())) {
			return parent;
		}
		Iterator<UIComponent> kids = parent.getFacetsAndChildren();
		while(kids.hasNext()) {
			UIComponent kid = kids.next();
			UIComponent found = findComponent(kid, id);
			if(found != null) {
				return found;
			}
		}
		return null;
	}

	
	public String getProfession(){
		return profession;
	}
	
	public void setProfession(String profession){
		this.profession = profession;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPositionInCompany() {
		return positionInCompany;
	}
	public void setPositionInCompany(String positionInCompany) {
		this.positionInCompany = positionInCompany;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String[] getChosen() {
		return chosen;
	}
	public void setChosen(String[] chosen) {
		this.chosen = chosen;
	}
	public String getCompanyDescription() {
		return companyDescription;
	}
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}
	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}
	
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	public String[] getTradeNamesList(){
		List<String> names = new ArrayList<String>();
		for(Trade t : trades){
			names.add(t.getTradeName());
		}
		String[] a = new String[1];
		return names.toArray(a); 
	}
}