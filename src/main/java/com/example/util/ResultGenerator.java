package com.example.util;

/**
 * @author: ming
 * @date: 2021/10/24 15:50
 */

/**
 * 生成响应结果
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";
    private static final Integer RESULT_CODE_SUCCESS = 200;
    private static final Integer RESULT_CODE_SERVER_ERROR = 500;

    public static Result<Object> genSuccessResult(){
        return new Result<>(RESULT_CODE_SUCCESS,DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result<Object> genSuccessResult(String message){
        Result<Object> result = new Result<>();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> genSuccessResult(T data){
        Result<T> result = new Result<>();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static Result<Object> genFailResult(){
        return new Result<>(RESULT_CODE_SERVER_ERROR,DEFAULT_FAIL_MESSAGE);
    }

    public static Result<Object> genFailResult(String message){
        Result<Object> result = new Result<>();
        result.setResultCode(RESULT_CODE_SERVER_ERROR);
        result.setMessage(message);
        return result;
    }

    public static Result<Object> genErrorResult(int code, String message){
        Result<Object> result = new Result<>();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }
}
