
import java.util.Scanner;
public class Main
{
    //Contantes
    private static final double APPROVED = 3.0; //Aprobacion
    public static final int SUBJECT = 3; // Asignaturas
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAXLIMITIDENTIFICATION = 999999;
        
        //Declara la cantidad de estudiantes y la digita
        int numStudents;
        System.out.println("Digite la cantidad de alumnos ");
        numStudents = scanner.nextInt();
        System.printLn(numStudents);
        //Salto de Linea
        scanner.nextLine();
        // Declara las variables que contendrán los arrays
        String[] names = new String[numStudents];
        int[] identification = new int[numStudents];
        double[][] notes = new double[numStudents][SUBJECT];
        String subject[] = {"Cálculo", "Programación", "Algebra"};
        // Asignamos manualmente los nombres de las tres asignaturas

        // Recorre tantas veces los alumnos que se les digito
        int i = 0;
        for(i = 0; i < names.length; i++) 
        { //for para ingresar los datos y llenar cada array

            System.out.println();

            System.out.print("Ingrese el nombre del estudiante " + (i+1) + ": ");
            names[i] = scanner.nextLine();  //llenar array de nombres

            do{
                System.out.print("Ingrese la identificación del estudiante: ");
                identification[i] = scanner.nextInt(); //llenar array de codigos
            }while(identification[i] > MAXLIMITIDENTIFICATION);
            // Consumir la nueva línea sobrante después de nextInt
            scanner.nextLine();

            double sumNotes = 0;
            for (int j = 0; j < SUBJECT; j++) { //for anidado para llenar la matriz de notas
                do { //uso de do while para verificar que la nota ingresada este entre 0.0 y 5.0
                    System.out.print("Ingrese la nota " + subject[j] + " de " + names[i] + " entre 0.0 y 5.0: ");
                    notes[i][j] = scanner.nextDouble();
                    if (notes[i][j]<0.0 || notes[i][j]>5.0 ) {
                        System.out.println("Nota invalida, debe ingresar una nota entre 0.0 y 5.0");
                    }
                    
                } while (notes[i][j]<0.0 || notes[i][j]>5.0);

                sumNotes += notes[i][j]; //contador que almacena la suma de las notas
            }
            scanner.nextLine();

        }
        // Consumir la nueva línea sobrante después de la última entrada de nota
        
        //Calcular y hacer reporte
        System.out.println("REPORTE FINAL:");
        
        for (i = 0; i < numStudents; i++) {
            double average = calculateAverage(notes[i]);
            //Hace una especie de if para saber si aprobó o no
            String state = average >= APPROVED ? "Aprobado" : "Reprobado";
            System.out.println(names[i] + "(ID: " + identification[i] + ") - " + "Promedio: " + average + " - " + state);
        }
    }
    // Método para calcular el promedio de las notas
    public static double calculateAverage(double[] notes) {
        double sum = 0;
        for (double note : notes) {
            sum += note;
        }
        return sum / notes.length;
    }
}