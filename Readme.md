# LABORATORIO 8 - INTEGRACIÓN CONCEPTOS (JSF, Spring Data, Arquitectura por capas)
## Santiago Arévalo Rojas
## Juan Felipe Sánchez Pérez

# PARTE I. INTEGRACIÓN DE SPRING CON EL PROYECTO WEB.   

### Logar desplegar la página que muestran en el tutorial:  
<img src='https://user-images.githubusercontent.com/123812766/231905055-979c37e2-dd56-4859-9233-76bddac52725.png' width=50% height=50%/>

### Lograr desplegar la página del tutorial del laboratorio 5:  
Se clona el repositorio del laboratorio 5:  
<img src='https://user-images.githubusercontent.com/123812766/231905687-4322dbb0-abed-4395-98a9-a30d48cdc4d6.png' width=70% height=70%/>  
 
Se agregan las dependencias al pom.xml indicadas en el tutorial, para la unión entre Spring Boot con Primefaces.  
Además, se añaden la anotación ` @Component ` a la clase BackingBean. También se creó la clase Main con el siguiente contenido:   
```
SpringBootApplication
public class Main {

	public static void main(String[] args) {
	      SpringApplication.run(Main.class, args);

	}

	@Bean
	ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {
		//spring boot only works if this is set
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

		//registration
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setServlet(new FacesServlet());
		srb.setUrlMappings(Arrays.asList("*.xhtml"));
		srb.setLoadOnStartup(1);
		return srb;
	}
}
```   
Se creó el archivo faces-config.xml, para que los beans de JSF se usará como beans de Spring:   
```
<?xml version="1.0" encoding="UTF-8"?>
<faces-config xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee/web-facesconfig_2_2.xsd"
	version="2.2">

	<application>
		<el-resolver>org.springframework.web.jsf.el.SpringBeanFacesELResolver
		</el-resolver>
	</application>

</faces-config>
```   

En el archivo guess.xhtml, las referencias a "guessBean' se cambiaron a "backingBean".   
Por último, en el pom.xml, la versión de primefaces usada fue la 6.0.   
Compilando y ejecutando el comando `mvn spring-boot:run`, se despliega la aplicación web:
<img width=70% height=70% alt="image" src="https://user-images.githubusercontent.com/123812331/232346195-5f4ce53a-dc17-4ac0-b9b2-ac24d838f874.png">

### Crear un página de bienvenida en donde:   
#### Se le pida el nombre del jugador. (Esta información se debe almacenaren un Bean de tipo Aplicación llamado ‘UserBean’).   
Se crea la clase "UserBean", teniendo como atributo userName.

#### Se le dé la bienvenida al juego y tenga un botón “Iniciar”, elcual una vez se presione direccione a la página anteriormente creada en donde el jugador podrá jugar.   
Se creó un archivo welcome.xhtml, resolviendo el requerimiento anterior.   

# PARTE II. INTEGRACIÓN DE SPRING DATA CON EL PROYECTO WEB   


