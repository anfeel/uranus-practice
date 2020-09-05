package pattern.prototype.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anfeel
 * @version $ Id:BatchTest, v 0.1 2020年08月27日 14:57 anfeel Exp $
 */
public class BatchTest {
    @Test
    public void test1() {
        List<BatchDetailDomain> list = new ArrayList<>();
        for (int i = 0; i < 4000000; i++) {
            BatchDetailDomain d = new BatchDetailDomain();
            d.setAmount("123123123");
            d.setCheckflag("123123123");
            d.setCnapsdetailno("123123123");
            d.setCnapsmsgid("123123123");
            d.setContractid("123123123");
            d.setCustmorid("123123123");
            d.setDetailno("123123123");
            d.setInstgacpty("123123123");
            d.setInstgregid("123123123");
            d.setMsgid("123123123");
            d.setPayaccname("测试大批量报文");
            d.setPayaccno("123123123");
            d.setPayaddress("地址吱吱吱栀子黄栀子花吱吱吱吱资质和");
            d.setPaybankno("123123123");
            d.setPayerbankno("123123123");
            d.setPaysettbankno("123123123");
            d.setPrcdesc("123123123");
            d.setRecvtime("123123123");
            d.setRemark("备注备注备注备注备注备注备注备注备注备注备注备注备注备注");
            d.setStatus("123123123");
            list.add(d);
        }
        System.out.println("构造完成");
    }

    @Test
    public void test2() {
        List<BatchDetaiPayDomain> list = new ArrayList<>();
        BatchDetaiPayDomain domain = new BatchDetaiPayDomain();
        for (int i = 0; i < 4000000; i++) {
            BatchDetaiPayDomain d = domain.clone();
            d.setAmount("123123123");
            d.setCheckflag("123123123");
            d.setCnapsdetailno("123123123");
            d.setCnapsmsgid("123123123");
            d.setContractid("123123123");
            d.setCustmorid("123123123");
            d.setDetailno("123123123");
            d.setInstgacpty("123123123");
            d.setInstgregid("123123123");
            d.setMsgid("123123123");
            d.setPayaccname("测试大批量报文");
            d.setPayaccno("123123123");
            d.setPayaddress("地址吱吱吱栀子黄栀子花吱吱吱吱资质和");
            d.setPaybankno("123123123");
            d.setPayerbankno("123123123");
            d.setPaysettbankno("123123123");
            d.setPrcdesc("123123123");
            d.setRecvtime("123123123");
            d.setRemark("备注备注备注备注备注备注备注备注备注备注备注备注备注备注");
            d.setStatus("123123123");
            list.add(d);
        }
        System.out.println("构造完成");
    }
}
