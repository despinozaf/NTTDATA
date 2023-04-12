package com.client.prueba.controller;

import com.client.prueba.Dao.GeneralDao;
import com.client.prueba.modelo.*;
import com.google.gson.Gson;
import netscape.javascript.JSObject;
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
    GeneralDao service;

    @Autowired
    Movimientos movimientos;

    @GetMapping(value = "/persona")
    public String getPersonas(){
        List<Persona> listPersonas=service.getAllPersona();
        System.out.println(listPersonas.get(0).getIdtpersona());
        return "prueba";
    }

    @GetMapping(value = "/persona/{id}")
    public Persona getPersona(@PathVariable("id") String id){
        System.out.println(id);
        return service.getPersona(id);
    }

    @DeleteMapping(value = "/persona/{id}")
    public String deletePersona(@PathVariable("id") String id){
        Persona per=service.getPersona(id);
        System.out.println(per);
        if(per!=null){
            System.out.println(per);
            service.deleteCliente(per.getIdtpersona());
            service.deletePersona(per.getIdtpersona());
            return "Persona elimina correctamente";
        }
        return null;
    }

    @PutMapping(value="/persona")
    public Persona editarPersona(@RequestBody String bodyReques){
        System.out.println(bodyReques);
        gson = new Gson();
        Persona persona = gson.fromJson(bodyReques, Persona.class);
        System.out.println(persona);
        Persona per=service.getPersona(persona.getIdentificacion());
        System.out.println(per);

        if(per!=null){
            persona.setIdtpersona(per.getIdtpersona());
            System.out.println(persona);
            service.savePersona(persona);

            return persona;
        }
        return null;
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
        ResponseEntity<Object> respuesta=movimientos.crearMovimiento(movimiento);
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



}
