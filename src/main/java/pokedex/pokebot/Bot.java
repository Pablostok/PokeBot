package pokedex.pokebot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.UpdatesReader;

import pokedex.pokebot.Constants;

public class Bot extends TelegramLongPollingBot{
	
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
				respuesta.setText(Constants.MENU_INICIAL);
				break;
			case "1":
				//TO-DO
				break;
			case "2":
				respuesta.setText(Constants.LISTADO_COMANDO_SERVICIOS);
				break;
			case "3":
				respuesta.setText(Constants.SERVICIOS_PRECIOS);
				break;
			case "SERVICIO 1":
				respuesta.setText(Constants.SERVICIO1_PASO1);
				break;
			case "":
				break;
			default:
				respuesta.setText(Constants.MENSAJE_POR_DEFECTO);
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
