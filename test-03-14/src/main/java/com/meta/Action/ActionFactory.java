package com.meta.Action;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory(){}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("command값 >>" + command);
		
		if(command.equals("login_Form")) {
			action = new loginFormAction()
					;
		}else if(command.equals("login_Check")) {
			action = new loginCheckAction();
			
		}else if(command.equals("changeUser_InformationForm")) {
			action = new changeUserInformationFormAction();
		}else if(command.equals("update_member")) {
			action = new updateMemberAction();
		}
		
		return action;
		
	}
	
	
	
	
}




