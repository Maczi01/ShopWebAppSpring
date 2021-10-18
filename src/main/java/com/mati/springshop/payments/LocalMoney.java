package com.mati.springshop.payments;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

import javax.money.Monetary;
import java.util.Locale;

public class LocalMoney {
    public static FastMoney of(Number number){
        var locale = Locale.getDefault();
        var currencyUnit = Monetary.getCurrency(locale);
        return FastMoney.of(number, currencyUnit);
    }
}
