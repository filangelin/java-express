package org.example.practice11;

import java.math.BigDecimal;

public class DebugTask8 {
    public static void main(String[] args) {
        BigDecimal a = BigDecimal.valueOf(0.1).multiply(BigDecimal.valueOf(3));  // не Double из-за погрешностей при представлении дробей
        BigDecimal b = BigDecimal.valueOf(0.3);
        if (a.compareTo(b) == 0) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
