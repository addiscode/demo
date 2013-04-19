package com.addiscode.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

public class CustomerForm extends ActionForm {
	private String firstName;
	private String lastName;
	
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
	
	/*
	*	THIS METHOD WILL BE CALLED IF THE VALIDATION PROPERTY SET TRUE ON FORM BEAN DECLARATION FROM struts-config.xml
	*/
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if(firstName == null || firstName.trim().equals("")) {
			String[] strArray = {"First name"};
			MessageResources msgRes = (MessageResources) request.getAttribute(Globals.MESSAGES_KEY);
			
			errors.add("firstName",new ActionError("error.required",msgRes.getMessage("prompt.customer.firstname")));
			System.out.println(msgRes.getMessage("prompt.customer.firstname") + " is required");
		}
		return errors;
	}
}
