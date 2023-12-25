package br.com.felipesantos.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.felipesantos.model.Cidade;
import br.com.felipesantos.model.Pessoa;
import br.com.felipesantos.model.Time;
import br.com.felipesantos.model.Usuario;

public class FabricaObjetos {
	
	public static List<Time> carregaTimes() {
		List<Time> times = new ArrayList<>();
		Time time = new Time();
		time.setId(1);
		time.setNome("Corinthians");
		time.setDataFundacao(Calendar.getInstance());
		time.setHistoria("Fundado em 1910, na cidade de São Paulo");
		Cidade cidade = new Cidade();
		cidade.setNome("São Paulo");
		time.setCidade(cidade);
		
		Pessoa tecnico = new Pessoa();
		tecnico.setNome("Mano Menezes");
		time.setTecnico(tecnico);
		
		Usuario usuario = new Usuario();
		usuario.setNome("Felipe");
		time.setUsuario(usuario);
		times.add(time);
		return times;
	}

}
