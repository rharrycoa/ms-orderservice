package com.pe.appventas.msorderservice.util;

import com.pe.appventas.msorderservice.dto.AddressDto;

import java.text.DecimalFormat;

public class OrderUtils {
    public static String obtainFullAddress(AddressDto address) {
        if (address == null) {
            return "";
        }
        return address.getStreet() + ", " + address.getCity() + ", "
                + address.getState() + " " + address.getZipCode();
    }

    public static String formatDecimal(double number) {
        DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
        return dFormat.format(number);
    }
}
