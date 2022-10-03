package com.zcyi.rorschachinfrastructure.Base;

public enum ApiResultCode {
    Succeed(200, "请求成功"),
    Failed(400, "请求失败"),
    Error(500, "服务器执行异常");
    private final int _code;
    private final String _msg;

    ApiResultCode(int _code, String _msg) {
        this._code = _code;
        this._msg = _msg;
    }

    public int Value() {
        return _code;
    }

    public String Message() {
        return _msg;
    }
}
