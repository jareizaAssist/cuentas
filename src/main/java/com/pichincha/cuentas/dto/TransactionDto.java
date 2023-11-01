package com.pichincha.cuentas.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class TransactionDto {
    private String id;

    private String numeroCuenta;

    private String tipoTransacion;

    private double valor;

    private LocalDate fecha;
}
