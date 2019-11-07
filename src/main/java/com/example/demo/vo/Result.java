package com.example.demo.vo;

/**
 * @Auther: ahu_w
 * @Date: 2019/11/7 16:54
 * @Description:
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;
    /**
     *成功时设置消息
     */
    public Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }
    /**
     *成功时调用
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }
    /**
     *失败时调用
     */
    public static <T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }

    /**
     * 将返回消息CodeMsg封装到本类中
     * */
    private Result(CodeMsg cm) {
        if(cm == null) {
            return;
        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
