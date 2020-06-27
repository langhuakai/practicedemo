package com.wei.practicedemo.handler;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;

public class Result {
    // https://www.cnblogs.com/l-y-h/p/12781586.html

    /**
     * 响应是否成功，true 为成功，false 为失败
     */
    private Boolean success;

    /**
     * 响应状态码， 200 成功，500 系统异常
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private Map<String, Object> data = new HashMap<>();

    /**
     * 默认私有构造器
     */
    private Result(){}

    /**
     * 私有自定义构造器
     * @param success 响应是否成功
     * @param code 响应状态码
     * @param message 响应消息
     */
    private Result(Boolean success, Integer code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    /**
     * 返回一个默认的 成功操作 的结果，默认响应状态码 200
     * @return 成功操作的实例对象
     */
    public static Result ok() {
        return new Result(true, HttpStatus.SC_OK, "success");
    }

    /**
     * 返回一个自定义 成功操作 的结果
     * @param success 响应是否成功
     * @param code 响应状态码
     * @param message 响应消息
     * @return 成功操作的实例对象
     */
    public static Result ok(Boolean success, Integer code, String message) {
        return new Result(success, code, message);
    }

    /**
     * 返回一个默认的 失败操作 的结果，默认响应状态码为 500
     * @return 失败操作的实例对象
     */
    public static Result error() {
        return new Result(false, HttpStatus.SC_INTERNAL_SERVER_ERROR, "error");
    }

    /**
     * 返回一个自定义 失败操作 的结果
     * @param success 响应是否成功
     * @param code 响应状态码
     * @param message 相应消息
     * @return 失败操作的实例对象
     */
    public static Result error(Boolean success, Integer code, String message) {
        return new Result(success, code, message);
    }

    /**
     * 自定义响应是否成功
     * @param success 响应是否成功
     * @return 当前实例对象
     */
    public Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    /**
     * 自定义响应状态码
     * @param code 响应状态码
     * @return 当前实例对象
     */
    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 自定义响应消息
     * @param message 响应消息
     * @return 当前实例对象
     */
    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 自定义响应数据，一次设置一个 map 集合
     * @param map 响应数据
     * @return 当前实例对象
     */
    public Result data(Map<String, Object> map) {
        this.data.putAll(map);
        return this;
    }

    /**
     * 通用设置响应数据，一次设置一个 key - value 键值对
     * @param key 键
     * @param value 数据
     * @return 当前实例对象
     */
    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
