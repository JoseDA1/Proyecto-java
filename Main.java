
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/
import java.util.Scanner;
public class Main
{
    //Contantes
    private static final double APPROVED = 3.0; //Aprobacion
    public static final int SUBJECT = 3; // Asignaturas
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        //Declara la cantidad de estudiantes y la digita
        int numStudents;
        System.out.println("Digite la cantidad de alumnos ");
        numStudents = scanner.nextInt();
        //Salto de Linea
        scanner.nextLine();
        // Declara las variables que contendrán los arrays
        String[] names = new String[numStudents];
        String[] identification = new String[numStudents];
        double[][] notes = new double[numStudents][SUBJECT];

        // Recorre tantas veces los alumnos que se les digito
        for(int i=0; i<numStudents; i++){
            //Pide la identificacion
            System.out.println("Nombre del estudiante " + (i + 1));
            names[i] = scanner.nextLine();
             //Pide la identificacion
            System.out.println("Identificación del estudiante " + (i + 1));
            identification[i] = scanner.nextLine();
            //Pide las notas de las asignaturas
            System.out.println("Ingrese la nota de cada Asignatura del estudiante " + (i + 1) + " (Son " + SUBJECT + " Asignaturas)");
            System.out.println("De 0.0 a 5.0");
            // Recorre tantas veces la cantidad de asignaturas
            for(int j=0; j<SUBJECT; j++){
                notes[i][j] = scanner.nextDouble();
            }
            //Salto de Linea
            scanner.nextLine();
        }
        
        //Calcular y hacer reporte
        System.out.println("REPORTE FINAL:");
        for (int i = 0; i < numStudents; i++) {
            double average = calculateAverage(notes[i]);
            //Hace una especie de if para saber si aprobó o no
            String state = average >= APPROVED ? "Aprobado" : "Reprobado";
            System.out.println(names[i] + "(ID: " + identification[i] + ") - " + "Promedio: " + average + " - " + state);
        }
        
        
    }
    
    // Método para calcular el promedio de las notas
    private static double calculateAverage(double[] notes) {
        double sum = 0;
        for (double note : notes) {
            sum += note;
        }
        return sum / notes.length;
    }
}
