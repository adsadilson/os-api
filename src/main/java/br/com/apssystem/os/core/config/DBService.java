package br.com.apssystem.os.core.config;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.com.apssystem.os.domain.entity.Cliente;
import br.com.apssystem.os.domain.entity.OS;
import br.com.apssystem.os.domain.entity.Tecnico;
import br.com.apssystem.os.domain.enums.Prioridade;
import br.com.apssystem.os.domain.enums.Status;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DBService {

	

	// @formatter:off

	public void instanciaBaseDado() {
		popularTecnico();
		popularCliente();
		popularOS();
				
	}

	private void popularTecnico() {
		Tecnico tec = new Tecnico();
		tec.setNome("ADILSON P S. SANTOS");
		tec.setCpf("339.241.570-73");
		tec.setTelefone("77 3431-1011");
	}
	
	private void popularCliente() {
		Cliente cli = new Cliente();
		cli.setNome("BETINA GONÇALVES");
		cli.setCpf("338.034.520-23");
		cli.setTelefone("77 3421-1001");
	}
	
	private void popularOS() {
		OS os = new OS();
		os.setDataAbertura(LocalDate.now());
		os.setDataFechamento(LocalDate.of(2021, 12, 30));
		os.setStatus(Status.ATIVO);
		os.setPrioridade(Prioridade.MEDIA);
		os.setObservacoes("REPARO NA PLACA MAE DO NOTEBOOK");
	}

	
	// @formatter:on
}
