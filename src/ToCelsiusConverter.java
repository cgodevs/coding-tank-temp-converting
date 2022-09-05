public class ToCelsiusConverter {

    private TempUnit inputUnit;

    public ToCelsiusConverter(TempUnit inputUnit){
        this.inputUnit = inputUnit;
    }

    public double transform(TempUnit inputUnit, double temp){
        switch (inputUnit){
            case FAHRENHEIT:
                return fromFahrenheit(temp);
            case KELVIN:
                return fromKelvin(temp);
            case CELSIUS: default:
                return temp;
        }
    }

    public double fromFahrenheit(double fahrenheit) {
        final double fator1 = 5.0 / 9.0;
        final int fator2 = 32;
        return (fahrenheit - fator2) * fator1;
    }

    public double fromKelvin(double kelvin){
        return kelvin - 273.15;
    }

}
