package br.com.felipesantos.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {
	
	public static String getMensagemErro(Exception e) {
		while (e.getCause() != null) {
			e = (Exception) e.getCause();
		}
		String retorno = e.getMessage();
		if (retorno.contains("viola restrição de chave estrangeira")) {
			retorno = "Registro não pode ser removido por possuir referências "
					+ "em outras partes do sistema";
		}
		return retorno;
	}
	
	public static void mensagemInformacao(String textoMensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, textoMensagem, "");
		context.addMessage(null, msg);
	}
	
	public static void mensagemErro(String textoMensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, textoMensagem, "");
		context.addMessage(null, msg);
	}
}
