Aquí tienes la estructura en formato Markdown lista para el `README.md` de este código de **Simulación de Sistema de Control de Acceso y Autenticación Multicanal (Interfaces y Polimorfismo en Java)**, manteniendo el enfoque exclusivo de **Programación Orientada a Objetos en memoria** (sin bases de datos):

---

# 🔐 Simulación de Sistema de Control de Acceso y Autenticación (Interfaces y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema de autenticación de usuarios, implementando una arquitectura basada en **interfaces (`interface`)** para desacoplar el controlador de acceso de los diferentes mecanismos de validación de identidad (contraseñas tradicionales, autenticación biométrica por huella y proveedores externos OAuth). Pone en práctica conceptos fundamentales de la **Programación Orientada a Objetos (POO)** como la **implementación obligatoria de contratos de interfaces**, la inyección de dependencias polimórfica, el manejo de credenciales en memoria y la resolución dinámica de flujos de seguridad.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se organiza a través de una interfaz de contrato, sus respectivas clases implementadoras, un componente controlador de acceso y un punto de ejecución:

* **`MecanismoAutenticacion` (Interfaz)**: Define el contrato estándar que cualquier estrategia de validación de identidad del sistema debe cumplir obligatoriamente.
* **Método abstracto**: `boolean validarIdentidad(String identificador, String credencial)`: Obliga a las clases implementadoras a definir su propia lógica de comprobación de credenciales, retornando un indicador booleano de éxito.


* **`AuthPasswordTradicional`**: Implementa la interfaz `MecanismoAutenticacion` para validar usuarios mediante pares clásicos de nombre de usuario y contraseña alfanumérica.
* **Sobrescritura (`@Override`)**:
* `validarIdentidad(String identificador, String credencial)`: Comprueba de forma estricta si el usuario es `"admin"` y la clave es `"1234"`.




* **`AuthBiometrica`**: Implementa `MecanismoAutenticacion` para simular la validación mediante patrones de huella dactilar o datos biométricos.
* **Sobrescritura (`@Override`)**:
* `validarIdentidad(String identificador, String credencial)`: Valida la correspondencia del identificador con la credencial biométrica registrada (por ejemplo, `"HUELLA123"`).




* **`AuthOAuthProveedor`**: Implementa `MecanismoAutenticacion` para autenticar usuarios delegando en tokens de proveedores externos (como Google u OAuth).
* **Sobrescritura (`@Override`)**:
* `validarIdentidad(String identificador, String credencial)`: Verifica la validez del correo electrónico asociado y el token de acceso provisto.




* **`ControladorAcceso`**: Componente controlador encargado de gestionar el flujo de inicio de sesión.
* **Método operativo**: `iniciarSesion(MecanismoAutenticacion mecanismo, String identificador, String credencial)`: Recibe de forma polimórfica cualquier mecanismo de autenticación, invoca su validación y emite por consola el mensaje correspondiente de acceso concedido o denegado.


* **`Main`**: Punto de entrada del programa. Instancia un controlador de acceso y tres mecanismos diferentes de autenticación, ejecutando múltiples escenarios de prueba (inicio exitoso por contraseña, biométrico, OAuth y un intento fallido con credenciales incorrectas) para demostrar el comportamiento del sistema.

---

## ⚙️ Reglas de Negocio y Control de Validación

1. **Desacoplamiento Estricto Mediante Interfaces:** El `ControladorAcceso` desconoce por completo las reglas internas de verificación (`AuthPasswordTradicional`, `AuthBiometrica`, etc.); opera de forma exclusiva con el contrato genérico `MecanismoAutenticacion`, logrando una alta flexibilidad arquitectónica.
2. **Inyección de Dependencias Polimórfica:** El mecanismo de autenticación se pasa como parámetro al controlador en tiempo de ejecución, permitiendo alternar dinámicamente entre distintas estrategias de seguridad sin alterar la lógica central.
3. **Principio Abierto/Cerrado (OCP):** Es posible incorporar nuevos métodos de autenticación al sistema (como autenticación de doble factor 2FA o reconocimiento facial) simplemente creando una clase que implemente la interfaz `MecanismoAutenticacion`, sin modificar el código del controlador de acceso.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
===== AUTENTICACION TRADICIONAL =====
Acceso concedido. Bienvenido admin

===== AUTENTICACION BIOMETRICA =====
Acceso concedido. Bienvenido usuario1

===== AUTENTICACION OAUTH =====
Acceso concedido. Bienvenido usuario@gmail.com

===== INTENTO FALLIDO =====
Acceso denegado. Credenciales incorrectas.

```

---

## 🚀 Conceptos de Programación Aplicados

* **Polimorfismo de Interfaces:** Uso de contratos abstractos (`interface`) para unificar la ejecución de validaciones heterogéneas bajo un mismo tipo de referencia.
* **Principio de Inversión de Dependencias:** El componente de seguridad (`ControladorAcceso`) depende de abstracciones y no de implementaciones concretas.
* **Separación de Responsabilidades:** Clara división entre las reglas de validación de credenciales de cada proveedor, el componente de gestión de sesiones (`ControladorAcceso`) y la ejecución de casos de prueba en el cliente (`Main`).
