package pattern.facade;

/**
 * 
 * @author anfeel
 * @version $Id: NewEncryptFacade.java, v 0.1 2020年1月7日 上午11:31:54 anfeel Exp $
 */
public class NewEncryptFacade extends AbstractEncryptFacade {
    private FileReader       fileReader;
    private FileWriter       fileWriter;
    private NewCipherMachine newCipherMachine;

    /**
     * 
     */
    public NewEncryptFacade() {
        fileReader = new FileReader();
        fileWriter = new FileWriter();
        newCipherMachine = new NewCipherMachine();
    }

    public void FileEncrypt(String fileNameSrc, String fileNameDes) {
        String plainText = fileReader.read(fileNameSrc);
        String encodedText = newCipherMachine.encrypt(plainText);
        fileWriter.write(fileNameDes, encodedText);
    }
}
