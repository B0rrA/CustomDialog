# Custom Dialog

Extiende y personaliza de manera rápida un JDialog

### Uso básico:
1. Importa la librería (.jar) a tu proyecto
2. Importa la clase a tu formulario
`import com.B0rrA.Customize.CustomDialog;`
3. Utiliza la clase
    JPanel panel = new JPanel(); // Panel principal
    int opcion = JOptionPane.OK_CANCEL_OPTION; // Opciones para los botones
    String componente = "textField" // Tipo de componente para input
    String título = "Imprimir etiquetas"; // Título de la ventana
    String mensaje = "Ingresar la ubicación:"; // Mensaje a mostrar
    ImageIcon icono= new ImageIcon(getClass().getResource("/Imagenes/logo.png")); //Ícono para la ventana
    Color[] colores = new Color[9];
    colores[0]= 226,241,252; //Color de fondo
    colores[1]= 0,0,0; //Color de las letras
    colores[2]= 0,121,184; //Color de botones principales
    colores[3]= 0,153,210; //Color de botones principales al presionar
    colores[4]= 102,102,102; //Color del botón cancelar
    colores[5]= 153,153,153; //Color del botón cancelar al presionar
    colores[6]= 0,0,0); //Color de las letras
    colores[7]= 204,204,204; //Color de borde al enfocar a un componente
    colores[8]= 255,255,255; //Color de letras en contraste
    CustomDialog cd = new CustomDialog(panel,opcion,componente,título,mensaje,colores,icono);
    cd.setLocationRelativeTo(null);
    cd.setSize(295,175);
    cd.setVisible(true);
    if (cd.getEstado()==true) {
        System.out.println("Confirmado");
        System.out.println("Resultado: "+ch.getResultado());
    } else if (cd.estaCancelado()) {
        System.out.println("Cancelado");
    }

### Opciones
Se utiliza las opciones de `JOptionPane` para asignar los botones
| Opción  | Botón Positivo | Botón Negativo | Botón Cancelar |
| ------------- | ------------- |
| YES_NO_OPTION  | `Sí`  | `No` | No se muestra |
| YES_NO_CANCEL_OPTION  | `Sí`  | `No` | `Cancelar` |
| QUESTION_MESSAGE  | `Buscar` | No se muestra | `Cancelar` |
| *Cualquier otro* | `Aceptar` | No se muestra | No se muestra |

### Componentes utilizables
| Nombre  | Descripción |
| ------------- | ------------- |
| textField  | Utiliza un JTextField como método de entrada de datos  |
| calendar  | Utiliza un JCalendar para seleccionar fechas  |
| textArea  | Utiliza un JTextArea para ingresar textos largos  |
| `null` | No muestra ningun componente para ingreso de datos |

### Métodos principales
| Método  | Descripción |
| ------------- | ------------- |
| `setSoloNúmeros(boolean)`  |  Cuando se utiliza textField, asigna si aceptará solo números. Falso por defecto |
| `setTamaño(Dimension)`  | Asigna el tamaño del formulario  |
| `getEstado()`  | (Boolean) Devuelve Verdadero si el diálogo fué confirmado por el usuario |
| `estaCancelado()` | (Boolean) Devuelve Verdadero si el diálogo fué cancelado |
| `getResultado()` | (Object) Devuelve el valor ingresado o seleccionado por el usuario |
