package ru.kodanev.aleksey.RERT_API_Invite_PAY;
//А также класс, обрабатывающий базовый ответ, возвращаемый нашим сервисом:
public class BaseResponse {

    private final String status;
    private final int code;

    public BaseResponse(String status, int code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }
}
