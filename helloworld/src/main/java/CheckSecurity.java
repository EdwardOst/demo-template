
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;

public class CheckSecurity {

    public static void main(final String[] args) {
        try {
            System.out.println(Cipher.getMaxAllowedKeyLength("AES"));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CheckSecurity.class.getName()).log(Level.SEVERE, null, ex);
        }
        final Provider[] providers = Security.getProviders();
        for (int i = 0; i < providers.length; i++) {
            final String name = providers[i].getName();
            final double version = providers[i].getVersion();
            System.out.println("Provider[" + i + "]:: " + name + " " + version);
            if (args.length > 0) {
                final Iterator it = providers[i].keySet().iterator();
                while (it.hasNext()) {
                    final String element = (String) it.next();
                    if (element.toLowerCase().startsWith(args[0].toLowerCase())
                            || args[0].equals("-all")) {
                        System.out.println("\t" + element);
                    }
                }
            }
        }
    }
}
