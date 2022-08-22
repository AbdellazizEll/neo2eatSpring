package com.jwtproject.userSecurity.enums;
import lombok.Getter;

@Getter
public enum PlatStatusEnum implements CodeEnum{


    UP(0, "Available"),
    DOWN(1, "Unavailable")
    ;


    private Integer code;
    private String message;

    PlatStatusEnum(Integer code , String message)
    {
        this.code = code;
        this.message = message;

    }

    public String getStatus(Integer code )
    {
        for(PlatStatusEnum statusEnum : PlatStatusEnum.values()){
            if(statusEnum.getCode() == code ) return statusEnum.getMessage();
        }
        return "";

    }

    public Integer getCode()
    {
        return code ;
    }

}
