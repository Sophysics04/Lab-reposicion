import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Antes de iniciar, por favor ingrese su nombre");
        String currentEstudianteName = scanner.nextLine();
        Estudiante currentEstudiante = new Estudiante(currentEstudianteName);
        System.out.println("Para iniciar debe de ingresar 5 asignaturas que esta cursando y su promedio en cada una");
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Por favor ingrese el nombre de la asignatura");
                String currentMateriaName = scanner.nextLine();
                System.out.println("Por favor ingrese su promedio actual de la asignatura (unicamente valores enteros");
                int currentMateriaGrade = scanner.nextInt();
                scanner.nextLine();
                Materia currentMateria = new Materia(currentMateriaGrade, currentMateriaName);
                currentEstudiante.addMateria(currentMateria);
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida, debe ingresar un valor entero para el promedio");
                scanner.nextLine();
                i--;
            }
        }

        while (true) {
            System.out.println("Hola! te ayudamos con tu curso, selecciona una opcion :D :");
            System.out.println("1. ver promedio general");
            System.out.println("2. ver materia con la nota mas alta");
            System.out.println("3. ver todas las materias");
            System.out.println("4. Salir");

            if (currentEstudiante.getAverage() > 90) {
                System.out.println("tu promedio general se encuentra por encima de 90, Excelente!");
            }
            ArrayList<Materia> MateriasUnder10 = currentEstudiante.getAlerts();
            if (MateriasUnder10.size() <= 0) {
                System.out.println("No tienes alertas");
            } else {
                System.out.println("Tienes " + MateriasUnder10.size() + " cursos con un promedio menor a 10 :c");
                for (int i = 0; i < MateriasUnder10.size(); i++) {
                    Materia currentMateria = MateriasUnder10.get(i);
                    System.out.println(currentMateria.getName());
                }
            }

            int mainSelect = 0;
            try {
                mainSelect = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalido");
                scanner.nextLine();
                continue;
            }

            switch (mainSelect) {

                case 1:
                    System.out.println("Su promedio es de " + currentEstudiante.getAverage());
                    break;

                case 2:
                    System.out.println(currentEstudiante.getHighestGrade());
                    break;

                case 3:
                    ArrayList<Materia> currentMateriaList = currentEstudiante.getMateriaList();
                    for (int i = 0; i < currentMateriaList.size(); i++) {
                        Materia currentMateria = currentMateriaList.get(i);
                        System.out.println(currentMateria.getDetails());
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa");
                    System.exit(0);
                    break;

                default:
                    System.out.println("error");
                    break;
            }
        }

    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }
}

public class Estudiante {
    private String name;
    private ArrayList<Materia> MateriaList;

    public Estudiante(String name) {
        this.name = name;
        this.MateriaList = new ArrayList<Materia>();
    }

    public int getAverage() {
        int currentSum = 0;
        for (int i = 0; i < MateriaList.size(); i++) {
            Materia currentMateria = MateriaList.get(i);
            currentSum = currentSum + currentMateria.getGrade();
        }
        return currentSum / (MateriaList.size());
    }

    public String getHighestGrade() {
        int highestGrade = 0;
        int highestGradeIndex = 0;
        for (int i = 0; i < MateriaList.size(); i++) {
            Materia currentMateria = MateriaList.get(i);
            int currentGrade = currentMateria.getGrade();
            if (currentGrade > highestGrade) {
                highestGrade = currentGrade;
                highestGradeIndex = i;
            }
        }
        return "Tu mejor clase es " + MateriaList.get(highestGradeIndex).getName() + " con una nota de " + highestGrade;
    }

    public ArrayList getMateriaList() {
        return MateriaList;
    }

    public void addMateria(Materia materiaToAdd) {
        MateriaList.add(materiaToAdd);
    }

    public ArrayList getAlerts() {
        ArrayList<Materia> MateriasUnder10 = new ArrayList<Materia>();
        for (int i = 0; i < MateriaList.size(); i++) {
            Materia currentMateria = MateriaList.get(i);
            if (currentMateria.getGrade() < 10) {
                MateriasUnder10.add(currentMateria);
            }
        }
        return MateriasUnder10;
    }
}

public class Materia {
    private int grade;
    private String name;

    public Materia(int grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return name + " - " + grade;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }
}
