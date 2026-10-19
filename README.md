# Formulario de contacto - Android

Proyecto independiente para la actividad de Coursera: **Desarrollo de aplicaciones con Android** (UNAM).

## Funcionalidades
- Formulario con nombre completo, fecha de nacimiento, teléfono, correo y descripción.
- Campos con `TextInputLayout` de Material Design.
- Selector de fecha (`DatePickerDialog`) que no permite fechas futuras.
- Validación de campos obligatorios y formato de correo.
- Segunda Activity de confirmación con todos los datos.
- Botón **Editar datos** que abre el formulario con los datos precargados.

## Tecnologías
- Java
- Android Studio
- Material Components for Android
- AndroidX AppCompat

## Cómo ejecutar
1. Descomprime el proyecto.
2. Abre la carpeta `ContactoApp` desde Android Studio.
3. Espera a que Gradle sincronice las dependencias.
4. Ejecuta la aplicación en un emulador o dispositivo Android.

## Publicar en GitHub
1. Crea un repositorio nuevo en GitHub, por ejemplo `FormularioContactoAndroid`.
2. No agregues un README desde GitHub si vas a subir este proyecto, porque ya incluye uno.
3. En la carpeta del proyecto ejecuta:

```bash
git init
git add .
git commit -m "Crear formulario de contacto Android"
git branch -M main
git remote add origin https://github.com/TU-USUARIO/FormularioContactoAndroid.git
git push -u origin main
```

Reemplaza `TU-USUARIO` por tu nombre de usuario real de GitHub. El enlace solo funcionará después de crear el repositorio y subir los archivos.
