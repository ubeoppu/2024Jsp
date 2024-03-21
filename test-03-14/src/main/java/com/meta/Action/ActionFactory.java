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
		}else if(command.equals("BulletinList_View")) {
			action = new BulletinListViewFormAction();
		}else if(command.equals("test")) {
			action = new testAction();
		}else if(command.equals("insert_content")) {
			
		}else if(command.equals("bulletinWishList_View")) {
			action = new bulletinWishListFormAction();
		}else if(command.equals("delete_User")) {
			action = new deleteMemberAction();
		}else if(command.equals("contentWishList_View")) {
			action = new contentWishListFormAction();
		}else if(command.equals("bulletin_content_View")) {
			action = new selectBulletinContentViewAction();
		}else if(command.equals("myBulletin_content_View")) {
			action = new selectMyBulletinContentViewAction();
		}else if(command.equals("Bulletin_delete")) {
			action = new deleteBulletinAction();
		}else if(command.equals("comment_Insert")) {
			action = new commentInsertAction();
		}else if(command.equals("comment_Update")) {
			action = new commentUpdateAction();
		}else if(command.equals("comment_Delete")) {
			action = new commentDeleteAction();
		}else if(command.equals("Bulletin_Update_Form")) {
			action = new bulletinUpdateFormAction();
		}else if(command.equals("bulletin_update")) {
			action = new bulletinUpdateAction();
		}
		
		return action;
		
	}
	
	
	
	
}




