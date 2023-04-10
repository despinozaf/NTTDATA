package com.client.prueba.Services;

import com.client.prueba.Dao.GeneralDao;
import com.client.prueba.Response.MethodsResponse;
import com.client.prueba.modelo.Cuenta;
import com.client.prueba.modelo.Movimiento;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Calendar;

public class Movimientos implements MethodsResponse {

    @Autowired
    GeneralDao service;

    MethodsResponse methodsResponse;

    public  ResponseEntity<Object> crearMovimiento(Movimiento movimiento){
        System.out.println(movimiento);
        String msgOk = "Movimiento creado correctamente";
        String msgError = "Error al crear el movimiento";
        String codeMsgError = "333";
        String msgErrorS = "Saldo no disponible";
        String codeMsgErrorS = "444";
        String msgErrorC = "Cuenta no existe";
        String codeMsgErrorC = "555";
        Calendar calendar = Calendar.getInstance();
        movimiento.setFecha(calendar.getTime());
        System.out.println(movimiento);
        BigDecimal saldoActual;
        saldoActual = service.findSaldoActual(movimiento.getNumerocuenta());
        System.out.println(saldoActual);
        if(saldoActual == null){
            saldoActual = service.findSaldoInicial(movimiento.getNumerocuenta());
            if(saldoActual == null){
                return HttpBad(msgErrorC, codeMsgErrorC);
            }
        }
        if(saldoActual.signum() >= 0) {
            movimiento.setSaldo(saldoActual.add(movimiento.getValor()));
        } else {
            return HttpBad(msgErrorS, codeMsgErrorS);
        }
         Long idMovimiento=service.saveMovimiento(movimiento);
        if(idMovimiento>0){
            return HttpOk(msgOk,new Gson().toJson(movimiento));
        }else{
            return HttpBad(msgError, codeMsgError);
        }



    }




}
