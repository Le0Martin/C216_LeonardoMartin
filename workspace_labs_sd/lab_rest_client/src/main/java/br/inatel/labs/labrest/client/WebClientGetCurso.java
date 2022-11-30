package br.inatel.labs.labrest.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.labs.labrest.client.model.Curso;
import reactor.core.publisher.Flux;

public class WebClientGetCurso {

	public static void main(String[] args) {
		List<Curso> listaCurso = new ArrayList<>();
		
		Flux<Curso> FluxCurso = WebClient.create("http://localhost:8080")
			.get()
			.uri("/curso")
			.retrieve()
			.bodyToFlux(Curso.class);
		
		FluxCurso.subscribe(c -> listaCurso.add(c));
		
		System.out.println("Lista de curso: ");
		System.out.println(listaCurso);
	}
}
