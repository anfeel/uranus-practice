package pattern.facade;

/**
 * encrypt file
 * @author anfeel
 * @version $Id: CipherMachine.java, v 0.1 2020年1月7日 上午10:39:51 anfeel Exp $
 */
public class CipherMachine {

    public String encrypt(String plainText) {
        return "*****" + plainText + "*****";
    }
}
