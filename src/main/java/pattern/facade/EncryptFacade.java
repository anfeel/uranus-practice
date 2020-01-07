package pattern.facade;

/**
 * file encrypt facade
 * @author anfeel
 * @version $Id: EncryptFacade.java, v 0.1 2020年1月7日 上午10:40:07 anfeel Exp $
 */
public class EncryptFacade extends AbstractEncryptFacade {

    private FileReader    fileReader;
    private FileWriter    fileWriter;
    private CipherMachine cipherMachine;

    /**
     * 
     */
    public EncryptFacade() {
        fileReader = new FileReader();
        fileWriter = new FileWriter();
        cipherMachine = new CipherMachine();
    }

    public void FileEncrypt(String fileNameSrc, String fileNameDes) {
        String plainText = fileReader.read(fileNameSrc);
        String encodedText = cipherMachine.encrypt(plainText);
        fileWriter.write(fileNameDes, encodedText);
    }
}
