package com.bat.exception;

import lombok.Getter;

/**
 * @author iszengziqiang@163.com
 * @date 2020/9/17 16:20
 * @Version: 1.0
 * @desc //用于手动抛出异常，自定义异常消息
 */
@Getter
public class HandException extends RuntimeException{

    private Integer code;

    private String errorMsg;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public HandException(Integer code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    /**
     * Constructs a new runtime exception with the specified cause and a
     * detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).  This constructor is useful for runtime exceptions
     * that are little more than wrappers for other throwables.
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A <tt>null</tt> value is
     *              permitted, and indicates that the cause is nonexistent or
     *              unknown.)
     * @since 1.4
     */
    public HandException(Throwable cause, Integer code, String errorMsg) {
        super(cause);
        this.code = code;
        this.errorMsg = errorMsg;
    }

    /**
     * Constructs a new runtime exception with the specified cause and a
     * detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).  This constructor is useful for runtime exceptions
     * that are little more than wrappers for other throwables.
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A <tt>null</tt> value is
     *              permitted, and indicates that the cause is nonexistent or
     *              unknown.)
     * @since 1.4
     */
    public HandException(Throwable cause, String errorMsg) {
        super(cause);
        this.errorMsg = errorMsg;
    }
}
