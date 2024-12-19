// Clases del programa
// Clase Amount
package model;

public class Amount {
    private double value;
    private String currency = "$"; // Moneda fija

    public Amount(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, currency);
    }
}
