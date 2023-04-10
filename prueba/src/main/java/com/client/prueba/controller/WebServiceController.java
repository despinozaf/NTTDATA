package com.client.prueba.controller;

import com.client.prueba.Dao.GeneralDao;
import com.client.prueba.modelo.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.client.prueba.Services.Movimientos;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.client.prueba.Response.MethodsResponse;

@Slf4j
@RestController
@RequestMapping(path = "/api")
public class WebServiceController  implements MethodsResponse {

    @Autowired
    private MessageSource mensajes;
    @Autowired
    GeneralDao service;

    Movimientos movimientos;

    @GetMapping(value = "/persona/{id}")
    public String persona(@PathVariable("id") String id){
        List<Persona> listPersonas=service.getAllPersona();
        System.out.println(listPersonas.get(0).getIdtpersona());
        return "prueba";
    }

    private Gson gson;

    @PostMapping("/clientes")
    public ResponseEntity<Object> createPersona(@RequestBody String bodyReques){
        String msgOk = "Cliente creado correctamente";
        String msgError = "Error al crear el cliente";
        String codeMsgError = "111";
        System.out.println(bodyReques);
        log.info("Ingreso crear cliente");
        InformacionCliente informacionCliente;
        gson = new Gson();
        //informacionCliente = gson.fromJson(bodyReques, InformacionCliente.class);
        // Creacion de persona
        Persona persona = gson.fromJson(bodyReques, Persona.class);
        Long idPersona=service.savePersona(persona);
        if(idPersona>0){
            Cliente cliente = gson.fromJson(bodyReques, Cliente.class);
            cliente.setIdtpersona(idPersona);
            Long idCliente=service.saveCliente(cliente);

            if(idCliente==0){
                return HttpBad(msgError, codeMsgError);
            }

        }else{
            return HttpBad(msgError, codeMsgError);
        }

        return HttpOk(msgOk,new Gson().toJson(persona));


    }

    @PostMapping("/cuentas")
    public ResponseEntity<Object> createCuenta(@RequestBody Cuenta cuenta){
        String msgOk = "Cuenta creado correctamente";
        String msgError = "Error al crear la cuenta";
        String codeMsgError = "222";
        System.out.println(cuenta);
        log.info("Ingreso crear cuentas");
        gson = new Gson();
        //Cuenta cuenta = gson.fromJson(bodyReques, Cuenta.class);
        Long idCuenta=service.saveCuenta(cuenta);
        if(idCuenta>0){
            return HttpOk(msgOk,new Gson().toJson(cuenta));
        }else{
            return HttpBad(msgError, codeMsgError);
        }

    }

    @PostMapping("/movimientos")
    public ResponseEntity<Object> createMovimiento(@RequestBody Movimiento movimiento){
        ResponseEntity<Object> respuesta=crearMovimiento(movimiento);
        return respuesta;

    }

    @GetMapping(value = "/movimientos")
    public List<Movimiento> getMovimientos(@RequestBody String bodyRequest) throws ParseException {
        ConsultaMovimientos fechas;
        System.out.println(bodyRequest);
        gson = new Gson();
        fechas = gson.fromJson(bodyRequest, ConsultaMovimientos.class);
        System.out.println(fechas);
        Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechas.getFinicio());
        Date date2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechas.getFfin());
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(fechas.getCuenta());
        return service.findAllByFecha(date1, date2, fechas.getCuenta());
    }

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
