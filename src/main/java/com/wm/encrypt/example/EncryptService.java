package com.wm.encrypt.example;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptService {

  public static  String encrypt(String content){
    //content abc1234234234
    //salt $2a$10$fHCUFTep1eMSLegmFuMRZ.
    return  BCrypt.hashpw(content, BCrypt.gensalt());
  }

  public static String encryptBySalt(String content){
    return  BCrypt.hashpw(content, BCrypt.gensalt(12));

  }

  public static boolean check(String input, String hashContent){
    //input "abc1234234234"
    //hashContent "$2a$10$yEG9bFE5GIN3VteFzJUpKOhg8I.w7BtTE40iwrcfyP40B7VkDW9Ea"
    return  BCrypt.checkpw(input, hashContent);
  }

}
