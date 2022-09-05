public class ToFahrenheitConverter {
    private TempUnit inputUnit;

    public ToFahrenheitConverter(TempUnit inputUnit){
        this.inputUnit = inputUnit;
    }

    public double transform(TempUnit inputUnit, double temp){
        switch (inputUnit){
            case CELSIUS:
                return fromCelsius(temp);
            case KELVIN:
                return fromKelvin(temp);
            case FAHRENHEIT: default:
                return temp;
        }
    }

    public static double fromCelsius(double celsius) {
        final double fator1 = 9.0 / 5.0;
        final int fator2 = 32;
        double fahrenheit = (celsius * fator1) + fator2;
        return fahrenheit;
    }

    public static double fromKelvin(double kelvin){
        double celsius = kelvin - 273.15;
        return fromCelsius(celsius);
    }

}
