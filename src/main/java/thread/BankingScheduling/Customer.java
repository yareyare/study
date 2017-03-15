package thread.BankingScheduling;

/**
 * Created by ivy on 2017/3/14.
 * 用户
 */
public class Customer {

    private String type;
    private Long seq;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Customer() {
    }

    public Customer(Long seq, String type) {
        this.seq = seq;
        this.type = type;
        System.out.println(type+"用户排队等候：========="+seq);
    }
}
