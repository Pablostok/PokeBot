package pokedex.pokebot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.UpdatesReader;

public class Bot extends TelegramLongPollingBot{

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			String mensaje = update.getMessage().getText();
			System.out.println(mensaje);
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

}
