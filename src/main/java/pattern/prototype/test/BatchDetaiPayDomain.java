package pattern.prototype.test;

/**
 * 明细clone测试类
 * @author anfeel
 * @version $ Id:BatchDetaiPayDomain, v 0.1 2020年08月27日 14:53 anfeel Exp $
 */
public class BatchDetaiPayDomain implements Cloneable {
    private String msgid;
    private String instgacpty;
    private String instgregid;
    private String cnapsmsgid;
    private String detailno;
    private String cnapsdetailno;
    private String amount;
    private String paybankno;
    private String payaccno;
    private String payaccname;
    private String payaddress;
    private String payerbankno;
    private String paysettbankno;
    private String custmorid;
    private String contractid;
    private String remark;
    private String status;
    private String prcdesc;
    private String checkflag;
    private String recvtime;

    public BatchDetaiPayDomain clone() {
        BatchDetaiPayDomain d = null;
        try {
            d = (BatchDetaiPayDomain) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return d;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getInstgacpty() {
        return instgacpty;
    }

    public void setInstgacpty(String instgacpty) {
        this.instgacpty = instgacpty;
    }

    public String getInstgregid() {
        return instgregid;
    }

    public void setInstgregid(String instgregid) {
        this.instgregid = instgregid;
    }

    public String getCnapsmsgid() {
        return cnapsmsgid;
    }

    public void setCnapsmsgid(String cnapsmsgid) {
        this.cnapsmsgid = cnapsmsgid;
    }

    public String getDetailno() {
        return detailno;
    }

    public void setDetailno(String detailno) {
        this.detailno = detailno;
    }

    public String getCnapsdetailno() {
        return cnapsdetailno;
    }

    public void setCnapsdetailno(String cnapsdetailno) {
        this.cnapsdetailno = cnapsdetailno;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaybankno() {
        return paybankno;
    }

    public void setPaybankno(String paybankno) {
        this.paybankno = paybankno;
    }

    public String getPayaccno() {
        return payaccno;
    }

    public void setPayaccno(String payaccno) {
        this.payaccno = payaccno;
    }

    public String getPayaccname() {
        return payaccname;
    }

    public void setPayaccname(String payaccname) {
        this.payaccname = payaccname;
    }

    public String getPayaddress() {
        return payaddress;
    }

    public void setPayaddress(String payaddress) {
        this.payaddress = payaddress;
    }

    public String getPayerbankno() {
        return payerbankno;
    }

    public void setPayerbankno(String payerbankno) {
        this.payerbankno = payerbankno;
    }

    public String getPaysettbankno() {
        return paysettbankno;
    }

    public void setPaysettbankno(String paysettbankno) {
        this.paysettbankno = paysettbankno;
    }

    public String getCustmorid() {
        return custmorid;
    }

    public void setCustmorid(String custmorid) {
        this.custmorid = custmorid;
    }

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrcdesc() {
        return prcdesc;
    }

    public void setPrcdesc(String prcdesc) {
        this.prcdesc = prcdesc;
    }

    public String getCheckflag() {
        return checkflag;
    }

    public void setCheckflag(String checkflag) {
        this.checkflag = checkflag;
    }

    public String getRecvtime() {
        return recvtime;
    }

    public void setRecvtime(String recvtime) {
        this.recvtime = recvtime;
    }
}
