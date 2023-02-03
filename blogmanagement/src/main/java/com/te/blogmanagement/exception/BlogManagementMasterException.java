package com.te.blogmanagement.exception;

@SuppressWarnings("serial")
public class BlogManagementMasterException {

	private BlogManagementMasterException() {

	}

	public static final String USER_ID_NOT_FOUND = "user not found";

	public static final String POST_ID_NOT_FOUND = "post not found";
	
	public static final String TAG_ID_NOT_FOUND = "Tag Id not found";
	
	public static final String CATEGORY_ID_NOT_FOUND = "Category Id not found";

}
