package cn.cloverclc.common;


import lombok.Data;

@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    private Result() {

    }

    private Result(T data) {
        this.data = data;
    }
    public static Result<Void> success() {
        Result<Void> result = new Result<>();
        result.setCode("0");
        result.setMsg("success");
        return result;
    }
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode("0");
        result.setMsg("success");
        return result;
    }

    public static <T> Result<T> error(String code, String msg, T data) {
        Result<T> result = new Result<>(data);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static Result<Void> error(String msg) {
        return error("500", msg);
    }
    public static <T> Result<T> error(String code, String msg) {
        // 异常场景下 data 传 null，适配任意泛型类型
        return error(code, msg, null);
    }

}
