package testers;

import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;

public class CallGraphs {

    static String algorithm = "DESede";

    public static void main(String[] args) throws Exception {

  Key symKey = KeyGenerator.getInstance(algorithm).generateKey();
Integer a=new Integer(10);

  Cipher c = Cipher.getInstance(algorithm);

  byte[] encryptionBytes = encryptF("texttoencrypt",symKey,c,a);

  //System.out.println("Decrypted: " + decryptF(encryptionBytes,symKey,c));
    }

    private static byte[] encryptF(String input,Key pkey,Cipher c,Integer a) throws InvalidKeyException, BadPaddingException,

IllegalBlockSizeException {

  c.init(Cipher.ENCRYPT_MODE, pkey);

  byte[] inputBytes = input.getBytes();

  return c.doFinal(inputBytes);
    }

    private static String decryptF(byte[] encryptionBytes,Key pkey,Cipher c) throws InvalidKeyException,

BadPaddingException, IllegalBlockSizeException {

  c.init(Cipher.DECRYPT_MODE, pkey);

  byte[] decrypt = c.doFinal(encryptionBytes);

  String decrypted = new String(decrypt);

  return decrypted;
    }
}
