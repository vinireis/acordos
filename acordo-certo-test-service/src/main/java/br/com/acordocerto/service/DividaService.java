package br.com.acordocerto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.acordocerto.domain.Credor;
import br.com.acordocerto.domain.Devedor;
import br.com.acordocerto.domain.Divida;
import br.com.acordocerto.repository.DividaRepository;
import javassist.NotFoundException;

@Service
public class DividaService {
	private DividaRepository dividaRepository;
	private CredorService credorService;
	private DevedorService devedorService;
	
	public DividaService(DividaRepository dividaRepository, CredorService credorService,
			DevedorService devedorService) {
		this.dividaRepository = dividaRepository;
		this.credorService = credorService;
		this.devedorService = devedorService;
	}

	public List<Divida> getDividas() {
		return dividaRepository.findAll();
	}

	public void cadastrar(Divida divida) throws NotFoundException {
		verificaSeExisteCredor(divida);
		verificaSeExisteDevedor(divida);
		
		dividaRepository.saveAndFlush(divida);
	}


	public void atualizar(Divida divida) {
		dividaRepository.save(divida);
	}

	public Optional<Divida> getDivida(Long id) {
		return dividaRepository.findById(id);
	}

	public void remove(Long id) {
		dividaRepository.deleteById(id);
	}

	private void verificaSeExisteDevedor(Divida divida) throws NotFoundException {
		Optional<Devedor> optionalDevedor = devedorService.getDevedor(divida.getDevedor().getId());
		if (optionalDevedor.isPresent()) {
			divida.setDevedor(optionalDevedor.get());
		}else {
			throw new NotFoundException("Não existe devedor com id = " + divida.getCredor().getId());
		}
	}
	
	private void verificaSeExisteCredor(Divida divida) throws NotFoundException {
		Optional<Credor> optionalCredor = credorService.getCredor(divida.getCredor().getId());
		if (optionalCredor.isPresent()) {
			divida.setCredor(optionalCredor.get());
		}else {
			throw new NotFoundException("Não existe credor com id = " + divida.getCredor().getId());
		}
	}
}
