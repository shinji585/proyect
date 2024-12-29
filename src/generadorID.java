import java.util.*;

public class generadorID {
    static Random r = new Random();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("bienvenido esta listo para generar su ID");
        boolean estado = Boolean.parseBoolean(capturador());
        if (estado == true) {
            while (estado) {
                System.out.print("ingrese su nombre: ");
                String name = capturador();
                // se solicita el apellido
                System.out.print("ingrese su apellido: ");
                String lastName = capturador();
                // se solicita el año de nacimiento
                System.out.println("ingrese el año de nacimiento de usted");
                int año = Integer.parseInt(capturador());
                // ahora realizamos los calculos
                try {
                    String mostrador = generador(name, lastName, año);
                    System.out.println("Felicitaciones el ID generado para usted es: " + mostrador);
                    estado = false;
                } catch (Exception e) {
                    System.out.println("error de " + e.getLocalizedMessage());
                }
            }
        } else {
            System.out.println("gracias por utilizar nuestro programa");
        }
    }

    public static String capturador() {
        System.out.print("Desea ingresar un valor booleano (true/false) o una cadena de texto? Ingrese 1 para booleano, 2 para cadena: ");
        
        // capturamos la entrada manejandola como ingresos por el teclado 
        String numero = s.nextLine().trim();
        
        // Validamos que la entrada sea 1 o 2
        while (!numero.equals("1") && !numero.equals("2")) {
            System.out.println("Entrada inválida. Ingrese 1 para booleano o 2 para cadena.");
            numero = s.nextLine().trim();
        }
        
        String valor = null; // la variable se inicializa vacia
        
        // Si elige 1, capturamos un valor booleano
        if (numero.equals("1")) {
            System.out.print("Ingrese un valor booleano (true/false): ");
            valor = s.nextLine().trim();
            
            // validacion por si la entrada no es booleana 
            while (!valor.equals("true") && !valor.equals("false")) {
                System.out.println("Valor inválido. Ingrese true o false.");
                valor = s.nextLine().trim();
            }
        } 
        // validamos si elige ingresar texto
        else if (numero.equals("2")) {
            System.out.print("Ingrese una cadena de texto: ");
            valor = s.nextLine().trim();
            
            // Validamos que la cadena no esté vacía
            while (valor.isEmpty()) {
                System.out.println("La cadena no puede estar vacía. Ingrese un valor.");
                valor = s.nextLine().trim();
            }
        }

        return valor;
    }

    // ahora tendriamos que crear el metodo que generara los valores ingresados
    public static String generador(String name, String apellido, int añoNacimiento) {
        String id = "";
        // tengo que concatenar los dos primeros valores
        for (int i = 0; i < name.length() && i < 2; i++) {
            id += name.charAt(i);
        }
        // reiniciamos la variable
        for (int j = 0; j < 2 && j < apellido.length(); j++) {
            id += apellido.charAt(j);
        }
        // volvemos a reiniciar la variable
        String pasador = Integer.toString(añoNacimiento);
        for (int j = 0; j < 2 && j < pasador.length(); j++) {
            id += pasador.charAt(j);
        }
        // ahora que tenemos todo el valor hasta el momento concatenado de id pasemos a
        // este un nuevo valor ramdo que tiene que ir desde 0 hasta el 9999
        id += String.format("%04d", r.nextInt(0, 9999));
        return id;
    }
}
