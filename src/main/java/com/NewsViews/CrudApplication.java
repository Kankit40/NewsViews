package com.NewsViews;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;

@SpringBootApplication
public class CrudApplication {


	public static void main(String[] args) {

		ClassLoader classLoader = CrudApplication.class.getClassLoader();
		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountkey.json")).getFile());

		try {
			FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
			FirebaseOptions options = FirebaseOptions.builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://newsviews-41403-default-rtdb.firebaseio.com")
					.build();
			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			System.out.println("Um erro ocorreu ao buscar a chave do serviço.");
			System.out.println(e.getMessage());
		}


		SpringApplication.run(CrudApplication.class, args);
	}

}
