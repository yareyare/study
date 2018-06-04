package exception;

import tool.Code;

/**
 * Created by ivy on 2017/12/11.
 */
public class BaseException extends Throwable{

    private static final long serialVersionUID = 2422549623574293881L;

    public BaseException() {
        super();
    }

    public BaseException(Integer code ) {
        super( code.toString() );
    }

    public BaseException(Code code) {
        super(code.getCode()+"" );
    }

    public BaseException(Integer code, Throwable cause ) {
        super( code.toString(), cause );
    }

    public BaseException(String message, Throwable cause ) {
        super( message, cause );
    }

    public BaseException(String message ) {
        super( message );
    }

    public BaseException(Throwable cause ) {
        super( cause );
    }

    protected BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace ) {
        super( message, cause, enableSuppression, writableStackTrace );
    }

}
