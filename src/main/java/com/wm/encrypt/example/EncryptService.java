package com.wm.encrypt.example;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptService {

  public static  String encrypt(String content){
    return  BCrypt.hashpw(content, BCrypt.gensalt());
  }

  public static String encryptBySalt(String content){
    return  BCrypt.hashpw(content, BCrypt.gensalt(12));

  }

  public static boolean check(String input, String hashContent){
    return  BCrypt.checkpw(input, hashContent);
  }

}
