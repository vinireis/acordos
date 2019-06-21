package br.com.acordocerto.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acordocerto.domain.Devedor;
import br.com.acordocerto.domain.Usuario;

@RestController
@RequestMapping("/devedor")
public class DevedorController {
	
	@GetMapping
	public List<Devedor> getDevedores(){
		return Arrays.asList(new Devedor("Jhon", new Usuario("usuario@email.com", "senha")));
	}
}
