package cn.cloverclc.common;


import lombok.Data;

@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public Result() {

    }
    public Result(T data) {
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
    public static Result<Void> error(String code, String msg) {
        Result<Void> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
    public static Result<Void> error(String msg) {
        return error("500", msg); // 约定500=系统异常
    }

}
