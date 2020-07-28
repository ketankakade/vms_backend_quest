package com.quest.vms.common.utils;

public class VmsConstants {
  private VmsConstants() {
  }
  
  // endpoints
  public static final String IDENTITY_URL_PATH = "user-identity";
  public static final String USER_URL_PATH = "user";
  public static final String SIGN_IN = "/sign-in";
  public static final String SIGN_UP = "/sign-up";
  public static final String CREATE_USER = "/create-user";
  public static final String LIST_USERS = "list-user";
  public static final String DELETE_USER = "/delete-user";
  public static final String UPDATE_USER = "update-user";
 
  
  //messages
  public static final String SUCCESS_MESSAGE = "Success";
  public static final String SIGN_IN_FAILED_MESSAGE = "Sign in Failed";

}
