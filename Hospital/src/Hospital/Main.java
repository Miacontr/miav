package Hospital;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Paciente {
    private String nombre;
    private int dni;
    private void dirección; 
    private int peso; 
    private int temperatura;
	private Object dirección; 

    public Paciente(String nombre, int dni, int dirección, void peso, int temperatura) {
        this.nombre = nombre;
        this.dni = dni;
        this.setDirección(dirección); 
        this.peso = peso; 
        this.temperatura = temperatura; 
       
    }

    public Paciente(String string, int i, int j, int k, int l, int m) {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }
    
    public void getDirección1() {
    	return dirección1;
    }
    
    public int getTemperatura1() { 
    	return getTemperatura1() 
    }
    
    public int getPeso1() {
    	
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", dni: " + dni;
    }

	public int getDirección() {
		return dirección1;
	}

	public void setDirección(int dirección) {
		this.dirección1 = dirección;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
}

class Medico {
    private String nombre;
    private String especialidad;

    public Medico(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", especialidad: " + especialidad;
    }
}

class SistemaGestionPacientes {
    private Map<Medico, List<Paciente>> pacientesPorMedico;

    public SistemaGestionPacientes() {
        pacientesPorMedico = new HashMap<>();
    }

    public void asignarPaciente(Medico medico, Paciente paciente) {
        if (pacientesPorMedico.containsKey(medico)) {
            pacientesPorMedico.get(medico).add(paciente);
        } else {
            List<Paciente> pacientes = new ArrayList<>();
            pacientes.add(paciente);
            pacientesPorMedico.put(medico, pacientes);
        }
    }

    public List<Paciente> getPacientesPorMedico(Medico medico) {
        return pacientesPorMedico.getOrDefault(medico, new ArrayList<>());
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaGestionPacientes sistema = new SistemaGestionPacientes();

        Medico medico1 = new Medico("Dr. Juan Perez", "Cardiología");
        Medico medico2 = new Medico("Dra. Maria Gomez", "Pediatría");

        Paciente paciente1 = new Paciente("Carlos", 35, 72473826,37,14,7);
        Paciente paciente2 = new Paciente("Ana", 28, 0);
        Paciente paciente3 = new Paciente("Luis", 42, 0);
        Paciente paciente4 = new Paciente("Sophia", 5, 0);

        sistema.asignarPaciente(medico1, paciente1);
        sistema.asignarPaciente(medico1, paciente2);
        sistema.asignarPaciente(medico2, paciente3);
        sistema.asignarPaciente(medico2, paciente4);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del médico: ");
        String nombreMedico = scanner.nextLine();

        List<Paciente> pacientesDelMedico = sistema.getPacientesPorMedico(new Medico(nombreMedico, ""));

        if (pacientesDelMedico.isEmpty()) {
            System.out.println("No se encontraron pacientes para el médico especificado.");
        } else {
            System.out.println("Pacientes del médico " + nombreMedico + ":");
            for (Paciente paciente : pacientesDelMedico) {
                System.out.println(paciente);
            }
        }
    }
}