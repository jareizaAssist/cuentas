package com.pichincha.cuentas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AccountDto {
    private String id;

    private String numeroCuenta;

    private String tipoCuenta;

    private String estado;

    private String idCliente;

    private double total;

}
