/* Decompiler 3ms, total 2575ms, lines 26 */
package Model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
   private StringBuilder s;

   public String Hashage(String str) throws NoSuchAlgorithmException {
      MessageDigest msg = MessageDigest.getInstance("MD5");
      byte[] hash = msg.digest(str.getBytes(StandardCharsets.UTF_8));
      this.s = new StringBuilder();
      byte[] var7 = hash;
      int var6 = hash.length;

      for(int var5 = 0; var5 < var6; ++var5) {
         byte b = var7[var5];
         this.s.append(Integer.toString((b & 255) + 256, 16).substring(1));
      }

      String result = this.s.toString();
      return result;
   }
}