package tool;

/**
 * Created by James on 16/8/12.
 */
public enum Code {
    // 10000 成功
    SUCCESS(10200, "成功"),

    PARAM_NULL(10400, "必填参数为空"), 
    DB_ERROR(10401, "数据库操作失败"),
    DB_NOT_FIND(10402, "没有更新任何记录"),
    PARAM_ILLEGAL_NULL(10403, "参数不在可选值范围内"),
    PARAM_TOO_LARGER(10404, "参数内容太长"),
    SERVER_PROCESS_ERROR(10405, "服务器操作失败，请稍后再试!"),
    
    MOBILE_FORMAT_ERROR(10406, "手机号格式错误"),
    IDCARD_FORMAT_ERROR(10407,"身份证格式错误"),
    PHONE_MATCH_CODE_ERROR(10408,"手机号码归属地获取失败"),
    PHONE_RULE_ERROR(10409,"判断手机号是否在信用卡公司限制范围内失败"),
    USER_EXIST_ERROR(10410,"用户已经推送过"),
    PARAM_CODED(10411,"有打码字段"),

    
    // 20000 参数方法返回值错误
    PARAMTER_INCORRECT(200100, "参数不正确"),
    GENERATER_RETURN_ERROR(200101, "处理返回值错误"),

    SERVICE_NOT_FIND(402, "没有这个服务"),

    // 30000 不支持的方法协议,服务不可用
    METHOD_NOT_SUPPORT(300100, "不支持的请求方法"), protocol_notsupport(300200, "不支持的协议"), node_unavailable(300300, "没有可用的服务节点"),

    // 40000 异常
    ERROR(400100, "执行错误"),

    // 50000 流程控制错误
    OVER_LIMIT(500100, "接口调用次数超过限制"),

    // 90000 业务错误
    // 90100 用户联系人业务错误
    CONTACTS_ISEXIST(90100, "该联系人已经存在");

    public String note;
    public Integer code;

    private Code(Integer code, String note) {
        this.note = note;
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
