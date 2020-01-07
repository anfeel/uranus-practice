package pattern.facade;

/**
 * 
 * @author anfeel
 * @version $Id: FacadeSample.java, v 0.1 2020年1月7日 上午11:20:08 anfeel Exp $
 */
public class FacadeSample {

    public static void main(String[] args) {
        AbstractEncryptFacade encryptFacade = new NewEncryptFacade();
        encryptFacade.FileEncrypt("111", "333");
        AbstractEncryptFacade encryptFacade2 = new EncryptFacade();
        encryptFacade2.FileEncrypt("111", "333");
    }
}
