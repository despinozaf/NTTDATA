package com.client.prueba.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.json.JSONObject;

public interface MethodsResponse {

    default ResponseEntity<Object> HttpBad(String error, String code) {
        JSONObject json = new JSONObject();
        json.put("status", HttpStatus.UNAUTHORIZED.value());
        json.put("code", code);
        json.put("message", error);
        return ResponseEntity.status(HttpStatus.OK).body(json.toString());
    }

    default ResponseEntity<Object> HttpOut(String error) {
        JSONObject json = new JSONObject();
        json.put("status", HttpStatus.REQUEST_TIMEOUT.value());
        json.put("code", 2);
        json.put("message", error);
        return ResponseEntity.status(HttpStatus.OK).body(json.toString());
    }

    default ResponseEntity<Object> HttpOk(String mensaje, Object data) {
        JSONObject json = new JSONObject();
        json.put("status", HttpStatus.OK.value());
        json.put("code", 0);
        json.put("message", mensaje);
        json.put("data", data);
        return ResponseEntity.status(HttpStatus.OK).body(json.toString());
    }


}
