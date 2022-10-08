package com.wm.encrypt.example;

import junit.framework.TestCase;
import org.junit.Test;

public class EncryptServiceTest extends TestCase {

  @Test
  public void test_encrypt_hash(){
    String hashResult =  EncryptService.encrypt("abc1234234234");
    System.out.println(hashResult);
  }

  @Test
  public void test_encrypt_hash_with_salt(){
    String hashResult =  EncryptService.encryptBySalt("abc1234234234" );
    System.out.println(hashResult);
  }

  @Test
  public void test_encrypt_check_hash(){
    System.out.println(EncryptService.check("abc1234234234", "$2a$10$yEG9bFE5GIN3VteFzJUpKOhg8I.w7BtTE40iwrcfyP40B7VkDW9Ea"));
    System.out.println(EncryptService.check("abc1234234234", "$2a$12$u3kfcIdfzCFZnUc5CtAJW.dPsETH/EyIGHNCwZpey6PYUA9tETGqe"));
    System.out.println(EncryptService.check("abc1234234234", "$2a$12$u3kfcIdfzCFZnUc5CtAJW.dPsETH/EyIGHwZpey6PYUA9tEsss"));

  }
}