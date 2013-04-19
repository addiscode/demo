package com.addiscode.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.addiscode.form.CustomerForm;

public class CustomerAction extends Action {
	/*
	*	THIS METHOD WILL BE EXECUTED BY THE REQUEST PROCESSOR AFTER MAPPING THE ACTION 
	*	AND IT WILL RETURN ACTION FORWARD TO RENDER A JSP
	*/
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(isCancelled(request)) {
			System.out.println("Cancel operation called");
			return mapping.findForward("main");
		}
		
		CustomerForm customerForm = (CustomerForm) form;
		System.out.println("First name: " + customerForm.getFirstName());
		System.out.println("Last name: "+ customerForm.getLastName());
		return mapping.findForward("success");
	}

}
