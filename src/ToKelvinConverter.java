public class ToKelvinConverter {

    private TempUnit inputUnit;

    public ToKelvinConverter(TempUnit inputUnit){
        this.inputUnit = inputUnit;
    }

    public double transform(TempUnit inputUnit, double temp){
        switch (inputUnit){
            case FAHRENHEIT:
                return fromFahrenheit(temp);
            case CELSIUS:
                return fromCelsius(temp);
            case KELVIN: default:
                return temp;
        }
    }

    public double fromFahrenheit(double fahrenheit) {
        double celsius = (fahrenheit - 32.0) * 5.0 / 9.0;
        return fromCelsius(celsius);
    }

    public double fromCelsius(double celsius) {
        return celsius + 273.15;
    }
}
