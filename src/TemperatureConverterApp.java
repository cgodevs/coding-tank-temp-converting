
public class TemperatureConverterApp {
    public static void main(String[] args) {
        TemperatureUtilities tempTool = new TemperatureUtilities();

        while(true){
            tempTool.printMenu();
            int nTemps = tempTool.getNumberOfTemps();

            TempUnit inTempsUnit = tempTool.getTempUnit("INPUT");
            TempUnit outTempsUnit = tempTool.getTempUnit("OUTPUT");
            if (inTempsUnit == null || outTempsUnit == null)
                break;

            System.out.println("________________________________________________________");
            double[] tempsToConvert = tempTool.getManyTemps(nTemps);

            System.out.println("\n________________________ CONVERTION ________________________");
            double[] convertedTemps = tempTool.transformMany(tempsToConvert, inTempsUnit, outTempsUnit);

            System.out.println("\n_________________________ AVERAGES _________________________");
            System.out.println(String.format("The average between temperatures to convert is: %.2f %s",tempTool.averageTemp(tempsToConvert), inTempsUnit));
            System.out.println(String.format("The average between temperatures converted is: %.2f %s",tempTool.averageTemp(convertedTemps), outTempsUnit));
            System.out.println("\n____________________________ END ___________________________\n\n\n");

        }
    }
}