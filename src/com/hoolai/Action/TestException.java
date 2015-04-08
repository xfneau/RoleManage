package com.hoolai.Action;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

//import org.apache.commons.codec.binary.Hex;

public class TestException {  
    public TestException() {  
    }  
  
    boolean testEx()  {  
        boolean ret = true;  
        try {  
            ret = testEx1();  
        } catch (Exception e) {  
            System.out.println("testEx, catch exception");  
            ret = false;  
            throw e;  
        } finally {  
            System.out.println("testEx, finally; return value=" + ret);  
            return ret;  
        }  
    }  
  
    boolean testEx1() {  
        boolean ret = true;  
        try {  
            ret = testEx2();  
            if (!ret) {  
                return false;  
            }  
            System.out.println("testEx1, at the end of try");  
            return ret;  
        } catch (Exception e) {
            System.out.println("testEx1, catch exception");  
            ret = false;  
            throw e;  
        } finally {  
            System.out.println("testEx1, finally; return value=" + ret);  
            return ret;  
        }  
    }  
  
    boolean testEx2() throws Exception{  
        boolean ret = true;  
            int b = 12;  
            int c;  
            for (int i = 2; i >= -2; i--) {  
                c = b / i;  
                System.out.println("i=" + i);  
            }  
            return true;  
    }  
    public static byte[] getSignature(String d, String k) throws InvalidKeyException, NoSuchAlgorithmException  {
    	byte[] data = d.getBytes();
    	byte[] key = k.getBytes();
    	SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        return mac.doFinal(data);
    }

    
    public static void main(String[] args) {
    	
    	
    }
}  