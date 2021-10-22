package com.mati.springshop.payments;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.util.Locale;

public class LocalMoney {
    public static FastMoney of(Number number) {
        return FastMoney.of(number, getCurrencyUnit());
    }

    public static FastMoney zero () {
        return FastMoney.zero(getCurrencyUnit());
    }

    private static CurrencyUnit getCurrencyUnit() {
        var locale = Locale.getDefault();
        var currencyUnit = Monetary.getCurrency(locale);
        return currencyUnit;
    }
}
