package pokedex.pokebot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.UpdatesReader;

public class Bot extends TelegramLongPollingBot{
	
	public static String MENU_INICIAL = "Bienvenid@ al menu:\n"
			+ "\n"
			+ "a) Consultar mi cita\n"
			+ "	a.1) Consultar cita por identificador\n"
			+ "	\n"
			+ "b) agendar nueva cita\n"
			+ "	b.0) elegir un servicio de los disponibles\n"
			+ "	b.1) elegir un dia de los disponibles\n"
			+ "	b.2) elegir una hora de las disponibles\n"
			+ "	b.3) resumen y confirmación\n"
			+ "\n"
			+ "c) listar servicios y precios";
	
	public static String MENSAJE_POR_DEFECTO = "Comando no encontrado";
	
	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			String mensaje = update.getMessage().getText();
			Long id_chat = update.getMessage().getChatId();
			SendMessage respuesta = analizarMensaje(mensaje, id_chat.toString());
			enviarMensaje(respuesta);
		}
		
	}

	@Override
	public String getBotUsername() {
		return "PokeRobotPabloBot";
	}

	@Override
	public String getBotToken() {
		return "1662086772:AAGvgwxaV-Da4YbMShr2sxxQ_eiZbD4n09I";
	}
	
	public SendMessage analizarMensaje(String mensaje, String id_chat) {
		SendMessage respuesta = new SendMessage();
		respuesta.setChatId(id_chat);
		mensaje = mensaje.trim().toUpperCase();
		
		switch(mensaje) {
			case "MENU":
				respuesta.setText(MENU_INICIAL);
				break;
			
			default:
				respuesta.setText(MENSAJE_POR_DEFECTO);
		}
		return respuesta;
	}

	public void enviarMensaje(SendMessage mensaje) {
		try {
			execute(mensaje);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
