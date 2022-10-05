package org.example;

import java.math.BigDecimal;

public enum Desempenho {

    A{
        @Override
        public BigDecimal percentualReajuste(){
            return new BigDecimal("0.03");
        }
    },
    B {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.15");
        }
    },
    C {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.2");
        }
    };

    public abstract BigDecimal percentualReajuste();



}
