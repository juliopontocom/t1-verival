package com.t1;
import java.util.HashMap;
import java.util.Map;

public class Estacionamento {
    
    private static final double VALOR_FIXO = 5.90;
    private static final double VALOR_HORA_EXTRA = 2.50;
    private static final double VALOR_PERNOITE = 50.00;
    private static final double DESCONTO_VIP = 0.50;
    private static final int MINUTOS_CORTESIA = 15;

    private static final Map<String, Integer> mesesMap = new HashMap<>();

    static {
        mesesMap.put("janeiro", 1);
        mesesMap.put("fevereiro", 2);
        mesesMap.put("março", 3);
        mesesMap.put("abril", 4);
        mesesMap.put("maio", 5);
        mesesMap.put("junho", 6);
        mesesMap.put("julho", 7);
        mesesMap.put("agosto", 8);
        mesesMap.put("setembro", 9);
        mesesMap.put("outubro", 10);
        mesesMap.put("novembro", 11);
        mesesMap.put("dezembro", 12);
    }

    public double calcularValor(int anoEntrada, String mesEntrada, int diaEntrada, int horaEntrada, int minutoEntrada,
                                int anoSaida, String mesSaida, int diaSaida, int horaSaida, int minutoSaida,
                                boolean isVip) {
        int mesEntradaNum = mesesMap.get(mesEntrada.toLowerCase());
        int mesSaidaNum = mesesMap.get(mesSaida.toLowerCase());

        long minutosEntrada = converterParaMinutos(anoEntrada, mesEntradaNum, diaEntrada, horaEntrada, minutoEntrada);
        long minutosSaida = converterParaMinutos(anoSaida, mesSaidaNum, diaSaida, horaSaida, minutoSaida);

        long minutosEstacionado = minutosSaida - minutosEntrada;

        if (minutosEstacionado <= MINUTOS_CORTESIA) {
            return 0.0;
        }

        long horasEstacionado = minutosEstacionado / 60;
        boolean pernoite = anoSaida > anoEntrada || 
                           (mesSaidaNum > mesEntradaNum || (mesSaidaNum == mesEntradaNum && diaSaida > diaEntrada)) && 
                           horaSaida >= 8;

        double valor;
        if (pernoite) {
            valor = VALOR_PERNOITE;
        } else if (horasEstacionado <= 1) {
            valor = VALOR_FIXO;
        } else {
            valor = VALOR_FIXO + ((horasEstacionado - 1) * VALOR_HORA_EXTRA);
        }

        if (isVip) {
            valor *= DESCONTO_VIP;
        }

        return valor;
    }

    private long converterParaMinutos(int ano, int mes, int dia, int hora, int minuto) {
        return (((ano * 12L + mes) * 30L + dia) * 24L + hora) * 60L + minuto;
    }
}
