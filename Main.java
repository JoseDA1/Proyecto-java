import java.util.Scanner;
import java.util.Locale;
public class Main
{
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        //Contantes
        final double APPROVED = 3.0; //Aprobacion
        final int SUBJECT = 3; // Asignaturas
        // Declarando el limite para el codigo del estudiante
        final int MAXLIMITIDENTIFICATION = 999999;
        final int MINLIMITIDENTIFICATION_AND_STUDENTS = 0;
        
        //Declara la cantidad de estudiantes y la digita
        int numStudents;
        do { // Se crea do while para asegurar que se ingrese un numero correcto de estudiantes
            System.out.println("Digite la cantidad de alumnos ");
            numStudents = scanner.nextInt();
                if (numStudents<=MINLIMITIDENTIFICATION_AND_STUDENTS){
                    System.out.println("Ingrese un número valido en la cantidad de estudiantes");
                }
        } while (numStudents<=MINLIMITIDENTIFICATION_AND_STUDENTS);
        
        //Salto de Linea
        scanner.nextLine();
        // Declara las variables que contendrán los arrays
        String[] names = new String[numStudents];
        int[] identification = new int[numStudents];
        // Matriz con los estudiantes y las materias
        double[][] notes = new double[numStudents][SUBJECT];
        String subject[] = {"Cálculo", "Programación", "Algebra"};
        // Asignamos manualmente los nombres de las tres asignaturas
        // Recorre tantas veces los alumnos que se les digito
        
        int total_students=names.length; //Se pone el names.leght por fuera del for para evitar consumo de memoria
        for(int i = 0; i < total_students; i++) 
        { 
            // Consumir la nueva línea sobrante
            System.out.println();
            //for para ingresar los datos y llenar cada array
            System.out.print("Ingrese el nombre del estudiante " + (i+1) + ": ");
            names[i] = scanner.nextLine();  //llenar array de nombres

            // do while para repetir en caso de que ingresen valores no deseados
            do{
                System.out.print("Ingrese la identificación del estudiante: ");
                identification[i] = scanner.nextInt(); //llenar array de codigos
                if(identification[i]  > MAXLIMITIDENTIFICATION || identification[i] <= MINLIMITIDENTIFICATION_AND_STUDENTS){
                    System.out.println("Codigo invalido, por favor digite otra vez");
                }
            }while(identification[i] > MAXLIMITIDENTIFICATION || identification[i] <= MINLIMITIDENTIFICATION_AND_STUDENTS);
            // Consumir la nueva línea sobrante después de nextInt
            scanner.nextLine();

            for (int j = 0; j < SUBJECT; j++) { //for anidado para llenar la matriz de notas
                System.out.print("Ingrese la nota " + subject[j] + " de " + names[i] + " entre 0.0 y 5.0: ");
                do { //uso de do while para verificar que la nota ingresada esté entre 0.0 y 5.0
                    notes[i][j] = scanner.nextDouble();
                    if (notes[i][j]<0.0 || notes[i][j]>5.0 ) {
                        System.out.println("Nota invalida, debe ingresar una nota entre 0.0 y 5.0");
                    }
                    
                } while (notes[i][j]<0.0 || notes[i][j]>5.0);
                
            }
            // Consumir la nueva línea sobrante después de la última entrada de nota
            scanner.nextLine();
        }
        //Calcular y hacer reporte
        System.out.println();
        System.out.println("REPORTE FINAL:");
        
        for (int i = 0; i < numStudents; i++) {
            // Invoca el metodo calcular y almacena en una variable el resultado
            double average = calculateAverage(notes[i]);
            //If para saber si aprobó o no
                           //Condicion            //true       //false                     
            String state = average >= APPROVED ? "Aprobado" : "Reprobado";
            System.out.println(names[i] + " (ID: " + identification[i] + ") - " + "Promedio: " + average + " - " + state);
        }
        scanner.close();
    }
    // Método para calcular el promedio de las notas
    public static double calculateAverage(double[] notes) {
        double sum = 0; //se crea un acumulador
        double resultAverage = 0;
        // For each donde almacenará los valores de la array notes
        for (double note : notes) {
            sum += note;
        }
        // variable que almacene el promedio
        //Se redondea el promedio a dos cifras
        resultAverage = Math.round((sum /(double)notes.length)*100.0) / 100.0; //Se hace casting para obetener más precisión en los datos
        // Devuelve el resultado
        return resultAverage; 
    }
    
}