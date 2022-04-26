/*
 * 참조: Apache Struts2 원격코드 실행 취약점 (CVE-2017-9791)
 */
package sample.cwe20;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.ValidatorForm;

public class ApacheStruts2_RCE_CVE20179791_bad1 extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Some code to save the gangster to the db as necessary
		GangsterForm gform = (GangsterForm) form;
		ActionMessages messages = new ActionMessages();
		
		/* POTENTIAL FLAW */ 
		messages.add("msg", new ActionMessage("Gangster " + gform.getName() + " added successfully"));
		addMessages(request, messages);

		return mapping.findForward("success");
	}
}

