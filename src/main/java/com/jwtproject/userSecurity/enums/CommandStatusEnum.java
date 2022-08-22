package com.jwtproject.userSecurity.enums;


public enum  CommandStatusEnum implements CodeEnum  {
    NEW(0, "New OrderMain"),
    FINISHED(1, "Finished"),

    CANCELED(2, "Canceled")
            ;

    private  int code;
    private String msg;

    CommandStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
