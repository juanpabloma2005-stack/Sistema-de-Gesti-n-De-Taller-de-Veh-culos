# Sistema de Gestión de Mantenimiento de Vehículos

Este repositorio almacena el **Proyecto II** del Segundo Cuatrimestre. Corresponde a una aplicación de consola avanzada en **Java** diseñada para monitorear y registrar el ciclo de vida de una flota vehicular, el control de gastos de combustible y las reparaciones mecánicas en talleres externos.

## Tecnologías y Características
* **Lenguaje:** Java (JDK 8 o superior)
* **Paradigma:** Programación Orientada a Objetos (POO) estructurada de manera modular
* **Modelo de Datos:** Clases contenedoras e internas que desacoplan las propiedades de cada entidad lógica.

---

## Organización del Código (`src/Logica/`)

El backend del sistema se divide en módulos específicos para resguardar las reglas de negocio y los flujos lógicos:

* **`GestionMantenimientoVehiculos.java`**: El motor del programa. Contiene el bucle principal de ejecución y centraliza la lógica operativa del software.
* **`Control.java`**: Centraliza los métodos de procesamiento para la validación y transformación de datos brutos.
* **`EstrVehiculos.java` (y clase anidada `Vehiculo`)**: Administra las propiedades de la flota (Placas, marca, modelo, kilometraje actual).
* **`EstrMantenimientos.java` (y clase anidada `Mantenimiento`)**: Controla la programación y ejecución de rutinas preventivas sobre las unidades.
* **`EstrBolCombustible.java` (y clase anidada `BolCombustible`)**: Administra los comprobantes y gastos de combustible cargados a los vehículos (Control de litros, precio por litro y rendimiento).
* **`EstrBolTaller.java` (y clase anidada `BolTaller`)**: Gestiona las boletas físicas de los talleres cuando una unidad requiere mantenimiento correctivo o reparaciones.
* **`EstrReportes.java` (y clase anidada `Reporte`)**: Generador interno encargado de consolidar las métricas financieras e historiales consolidados.

---

## Base de Datos en Archivos Planos

El estado de la flota se persiste de manera local en los siguientes archivos de texto alojados en la raíz:
* `vehiculos.txt`
* `Mantenimiento.txt`
* `boletasCombustible.txt`
* `boletasTaller.txt`
* `reportes.txt`

---

##  Compilación y Uso
1. Abre el directorio `GestionMantenimientoVehiculos` en tu IDE (NetBeans, IntelliJ, Eclipse, etc.).
2. El sistema cargará de forma automática el archivo `nbproject/project.xml` configurando las variables de entorno internas del compilador.
3. Compila el código presionando el botón **Build Project**.
4. Ejecuta el archivo principal para desplegar la terminal interactiva de control de mantenimiento.