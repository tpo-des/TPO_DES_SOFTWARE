# 🏟️ Trabajo Práctico Obligatorio - "Uno Más"
**Análisis y Diseño Orientado a Objetos - 1C 2025**

## 📌 Objetivo del sistema

El sistema desarrollado permite gestionar encuentros deportivos (fútbol, básquet, vóley u otros), donde los usuarios pueden crear partidos, buscar jugadores para completarlos y participar activamente en los mismos.

---

## 🧱 Arquitectura y Diseño

- Se implementó el patrón arquitectónico **MVC (Modelo-Vista-Controlador)**.
- Se aplicó el patrón de diseño **Strategy** para el emparejamiento de jugadores (actualmente implementado por **localidad**).
- La estructura está preparada para incorporar fácilmente más estrategias (nivel, historial, etc.) sin modificar la lógica del sistema.

---

## ✅ Funcionalidades implementadas

1. **Registro de usuarios** con nombre, correo, contraseña, deporte favorito, nivel y localidad.
2. **Inicio de sesión**.
3. **Creación de partidos** definiendo:
   - Tipo de deporte
   - Cantidad de jugadores
   - Ubicación (usada como localidad)
   - Fecha y hora
4. **Estados del partido**:
   - `Necesitamos jugadores` (inicial)
   - `Partido armado` (cuando se completa)
   - `Confirmado` (todos los jugadores aceptan)
5. **Búsqueda de partidos abiertos** filtrando por deporte y ubicación.
6. **Unirse a partidos** si hay cupos disponibles.
7. **Confirmación de participación** por parte de los jugadores.
8. Emparejamiento automático por localidad (Strategy).
9. Estructura modular y abierta para futuros patrones (State, Observer, Factory...).

---

## 🖼️ UML

El sistema incluye un diagrama UML donde se identifican:

- Las clases principales del dominio (`Usuario`, `Partido`, `RepositorioUsuarios`, etc.)
- Aplicación del patrón Strategy.
- Separación clara entre capas MVC.

🔗 *[Adjuntar UML aquí si es un PDF o imagen]*

---

## 💡 Patrones de diseño aplicados

| Patrón    | Aplicación                                                                 |
|-----------|----------------------------------------------------------------------------|
| MVC       | Separación clara entre Modelo, Vista y Controlador                         |
| Strategy  | Emparejamiento flexible de jugadores según criterios (localidad por ahora) |
| (Listo para más) | La estructura permite fácilmente incorporar State, Observer, etc.   |

---

## 📁 Estructura del código

