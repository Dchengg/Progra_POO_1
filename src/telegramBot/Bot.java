package telegramBot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
	
	public void SendRandomCode() {
		String message_text = "it works";
		SendMessage message = new SendMessage();
		long number = 86564739;
		message.setChatId(number);
		message.setText(message_text);
		try {
			execute(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onUpdateReceived(Update update) {
		if(update.hasMessage() && update.getMessage().hasText()) {
			String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();
			SendMessage message = new SendMessage();
			message.setChatId(chat_id);
			message.setText(message_text);
			try {
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public String getBotUsername() {
		return "PackageNotifierBot";
	}
	
	@Override
	public String getBotToken() {
		return "508395264:AAHNrhDNzWCf4qHT8uO15_AYb9sHWqnZixw";
	}
}
