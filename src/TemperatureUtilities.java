import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperatureUtilities {

    public void printMenu(){
        System.out.println("________________________________________________________");
        System.out.println("|_______________________ Menu __________________________|");
        System.out.println("| Option 1 - CELSIUS                                    |");
        System.out.println("| Option 2 - FAHRENHEIT                                 |");
        System.out.println("| Option 3 - KELVIN                                     |");
        System.out.println("| Option 0 - Exit                                       |");
        System.out.println("|_______________________________________________________|");
    }

    public TempUnit getTempUnit(String io){
        System.out.print("Choose an option number or type in a temperature unit for " + io + ": ");
        Scanner sc = new Scanner(System.in);
        TempUnit unit;

        if(sc.hasNextInt()){
            int optionNumber = sc.nextInt();
            switch (optionNumber) {
                case 1:
                    unit = TempUnit.CELSIUS;
                    break;
                case 2:
                    unit = TempUnit.FAHRENHEIT;
                    break;
                case 3:
                    unit = TempUnit.KELVIN;
                    break;
                default:
                    System.out.println("Invalid option");
                    unit = null;
            }
        } else {
            try{
                unit = TempUnit.valueOf(sc.nextLine());
            } catch (IllegalArgumentException b){
                System.out.println("\n(!) Type in either an option number, CELSIUS, KELVIN or FAHRENHEIT.");
                return getTempUnit(io);
            }
        }
        return unit;
    }

    public int getNumberOfTemps(){
        int nTemps = 0;
        while(nTemps <= 0){
            System.out.print("\nEnter number of temperatures to transform: ");
            Scanner sc = new Scanner(System.in);
            try {
                nTemps = sc.nextInt();
                if(nTemps < 0)
                    System.out.println("(!) Enter a non-zero positive integer.");
            } catch(InputMismatchException e){
                System.out.println("(!) Enter a non-zero positive integer.");
            }
        }
        return nTemps;
    }

    public double getTemp() {
        double temp = 0;
        System.out.print("Enter temperature: ");
        Scanner sc = new Scanner(System.in);
        try {
            temp = sc.nextDouble();
        } catch(InputMismatchException e){
            System.out.println("\n(!) You must inform a number.");
            return getTemp();
        }
        return temp;
    }

    public double[] getManyTemps(int nTemps){
        double[] tempsToConvert = new double[nTemps];
        for(int i = 0; i < nTemps; i++){
            System.out.print(String.format("(#%d of %d) ", (i+1), nTemps)); //track current temp to inform
            tempsToConvert[i] = getTemp();
        }
        return tempsToConvert;
    }

    public double transform(TempUnit inputUnit, TempUnit outputUnit, double temp){
        double result = 0;
        switch (outputUnit){
            case CELSIUS:
                result = new ToCelsiusConverter(inputUnit).transform(inputUnit, temp);
                System.out.println(String.format("%s: %.2f -> CELSIUS: %.2f", inputUnit, temp, result));
                break;
            case KELVIN:
                result = new ToKelvinConverter(inputUnit).transform(inputUnit, temp);
                System.out.println(String.format("%s: %.2f -> KELVIN: %.2f", inputUnit, temp, result));
                break;
            case FAHRENHEIT:
                result = new ToFahrenheitConverter(inputUnit).transform(inputUnit, temp);
                System.out.println(String.format("%s: %.2f -> FAHRENHEIT: %.2f", inputUnit, temp, result));
                break;
        }
        return result;
    }

    public double[] transformMany(double[] tempsToConvert, TempUnit inTempsUnit, TempUnit outTempsUnit){
        int nTemps = tempsToConvert.length;
        double[] convertedTemps = new double[nTemps];
        for(int i = 0; i < nTemps; i++){
            convertedTemps[i] = transform(inTempsUnit, outTempsUnit, tempsToConvert[i]);
        }
        return convertedTemps;
    }

    public double averageTemp(double[] temps){
        double sum = 0;
        for (double temp: temps){
            sum += temp;
        }
        return sum/temps.length;
    }

}
