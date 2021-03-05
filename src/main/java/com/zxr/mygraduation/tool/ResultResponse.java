package com.zxr.mygraduation.tool;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author
 * @create 2019/10/6 18:21
 * @since 1.0.0
 */
@Data
public class ResultResponse {
    /**
     * 状态码:默认为0,
     */
    private int code;
    /**
     * 状态
     */
    private boolean status=false;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object obje;

    public void setCode(int code) {
        if (code == 0) {
            this.status = true;
        }
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObje() {
        return obje;
    }

    public void setObje(Object obje) {
        this.obje = obje;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "code=" + code +
//                ",status=" + status +
//                ",msg=" + msg  +
//                ",obje=" + obje +
//                "}";
//    }

//    @Override
//    public String toString() {
//        return "ResultResponse{" +
//                "code=" + code +
//                ", status=" + status +
//                ", msg='" + msg + '\'' +
//                ", obje=" + obje +
//                '}';
//    }
}