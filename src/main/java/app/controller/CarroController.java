package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Carro;
import app.service.CarroService;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody Carro carro) {
		try {
			String mensagem = this.carroService.salvar(carro);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<String> atualizar(@RequestBody Carro carro, @PathVariable long id) {
		try {
			String mensagem = this.carroService.atualizar(carro, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.carroService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/buscarTodos")
	public ResponseEntity<List<Carro>> buscarTodos() {
		try {
			List<Carro> lista = this.carroService.buscarTodos();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<Carro> buscarPorId(@PathVariable long id) {
		try {
			Carro carro = this.carroService.buscarPorId(id);
			return new ResponseEntity<>(carro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/buscarPorNome")
	public ResponseEntity<List<Carro>> buscarPorNome(@RequestParam String nome) {
		try {
			List<Carro> lista = this.carroService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/buscarPorMarca")
	public ResponseEntity<List<Carro>> buscarPorMarca(@RequestParam long idMarca) {
		try {
			List<Carro> lista = this.carroService.findByMarca(idMarca);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/buscarAcimaAno")
	public ResponseEntity<List<Carro>> buscarAcimaAno(@RequestParam int ano) {
		try {
			List<Carro> lista = this.carroService.findAcimaAno(ano);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
