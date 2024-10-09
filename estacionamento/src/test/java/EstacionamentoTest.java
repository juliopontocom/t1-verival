import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.t1.Estacionamento;

public class EstacionamentoTest {
   
    private Estacionamento estacionamento = null;

    @Test
    void testeCortesiaOnPoint() {
        estacionamento = new Estacionamento();
        double resultado = estacionamento.calcularValor(2024, "outubro", 8, 8, 0, 2024, "outubro", 8, 8, 15, false);
        Assertions.assertEquals(0.0, resultado);
    }

    @Test
    void testeCortesiaOffPoint() {
        estacionamento = new Estacionamento();
        double resultado = estacionamento.calcularValor(2024, "outubro", 8, 8, 0, 2024, "outubro", 8, 8, 16, false);
        Assertions.assertEquals(5.90, resultado);
    }

    @Test
    void testeValorFixoUmaHoraOnPoint() {
        estacionamento = new Estacionamento();
        double resultado = estacionamento.calcularValor(2024, "outubro", 8, 8, 0, 2024, "outubro", 8, 9, 0, false);
        Assertions.assertEquals(5.90, resultado);
    }

    @Test
    void testeValorFixoUmaHoraOffPoint() {
        estacionamento = new Estacionamento();
        double resultado = estacionamento.calcularValor(2024, "outubro", 8, 8, 0, 2024, "outubro", 8, 9, 1, false);
        Assertions.assertEquals(8.40, resultado);
    }

    @Test
    void testeValorAposDuasHorasOnPoint() {
        estacionamento = new Estacionamento();
        double resultado = estacionamento.calcularValor(2024, "outubro", 8, 8, 0, 2024, "outubro", 8, 10, 0, false);
        Assertions.assertEquals(8.40, resultado);
    }

    @Test
    void testeValorAposDuasHorasOffPoint() {
        estacionamento = new Estacionamento();
        double resultado = estacionamento.calcularValor(2024, "outubro", 8, 8, 0, 2024, "outubro", 8, 10, 1, false);
        Assertions.assertEquals(10.90, resultado);
    }

    @Test
    void testePernoiteOnPoint() {
        estacionamento = new Estacionamento();
        double resultado = estacionamento.calcularValor(2024, "outubro", 8, 22, 0, 2024, "outubro", 9, 8, 0, false);
        Assertions.assertEquals(50.00, resultado);
    }

    @Test
    void testePernoiteOffPoint() {
        estacionamento = new Estacionamento();
        double resultado = estacionamento.calcularValor(2024, "outubro", 8, 22, 0, 2024, "outubro", 9, 7, 59, false);
        Assertions.assertEquals(10.90, resultado);
    }

    @Test
    void testeVIPComDescontoUmaHora() {
        estacionamento = new Estacionamento();
        double resultado = estacionamento.calcularValor(2024, "outubro", 8, 8, 0, 2024, "outubro", 8, 9, 0, true);
        Assertions.assertEquals(2.95, resultado);
    }

    @Test
    void testeVIPComDescontoPernoite() {
        estacionamento = new Estacionamento();
        double resultado = estacionamento.calcularValor(2024, "outubro", 8, 22, 0, 2024, "outubro", 9, 8, 0, true);
        Assertions.assertEquals(25.00, resultado);
    }
}
