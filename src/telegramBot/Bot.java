package telegramBot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import aplicacion.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bot extends TelegramLongPollingBot {
	
	public final static String BOT_TOKEN = "508395264:AAHNrhDNzWCf4qHT8uO15_AYb9sHWqnZixw";
	public final static String BOT_USERNAME = "PackageNotifierBot";
	private ArrayList<Cliente> clientes;
	
	public Bot(ArrayList<Cliente> pClientes) {
		super();
		setClientes(pClientes);
	}
	
	@Override
    public void onUpdateReceived(Update update) {
	  if (update.hasMessage() && update.getMessage().hasText()) {
		  if(update.getMessage().getText().equals("/start")) {
			  SendMessage message = new SendMessage();
			  message.setChatId(update.getMessage().getChatId());
			  message.setText("Para poder cambiar tu contrase�a necesitamos saber tu n�mero telefonico, por favor haz click en 'Compartir tu n�mero'. Nunca compartiremos tu n�mero telefonico");
			  ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
			  message.setReplyMarkup(replyKeyboardMarkup);
			  replyKeyboardMarkup.setSelective(true);
			  replyKeyboardMarkup.setResizeKeyboard(true);
			  replyKeyboardMarkup.setOneTimeKeyboard(true);
			  List<KeyboardRow> keyboard = new ArrayList<>();

			  KeyboardRow keyboardFirstRow = new KeyboardRow();
			  KeyboardButton keyboardButton = new KeyboardButton();
			  keyboardButton.setText("Compartir tu n�mero >").setRequestContact(true);
			  keyboardFirstRow.add(keyboardButton);
			
			  // add array to list
			  keyboard.add(keyboardFirstRow);
			 
			  // add list to our keyboard
			  replyKeyboardMarkup.setOneTimeKeyboard(true);
			  replyKeyboardMarkup.setKeyboard(keyboard);
			  
			  try {
				  execute(message);
			  } catch (TelegramApiException e) {
				  e.printStackTrace();
			  }
			  System.out.println(update.getMessage().getContact());
		  }else {
			  SendMessage message = new SendMessage();
			  message.setChatId(update.getMessage().getChatId());
			  message.setText("Para solicitar el c�digo de verificaci�n para el cambio de contrase�a"
					  + "porfavor utilice el commando '/sendcode' ");
			  try {
		           	execute(message); // Call method to send the message
		      } catch (TelegramApiException e) {
		            e.printStackTrace();
		      }
		  }
	  }else if(update.hasMessage()){
		  String number = update.getMessage().getContact().getPhoneNumber();
		  if(!number.equals(null)) {
			  number = number.substring(3);
			  System.out.println(number);
			  SendMessage message = new SendMessage();
			  message.setChatId(update.getMessage().getChatId());
			  String codigo = generarCodigo();
			  Cliente cliente = buscarCliente(number,codigo);
			  if(!cliente.equals(null)) {
				  message.setText(codigo);
				  try {
			           	execute(message); // Call method to send the message
			      } catch (TelegramApiException e) {
			            e.printStackTrace();
			      }
				  cliente.cambiarContrasena(codigo);
			  }else {
				  message.setText("No hay ningun usuario valido con ese n�mero telefonico");
				  try {
			           	execute(message); // Call method to send the message
			      } catch (TelegramApiException e) {
			            e.printStackTrace();
			      }
			  }
			  
			  	
		  }
		   
	  }
    }
	
	public Cliente buscarCliente(String numero,String codigo) {
		for(Cliente cliente:clientes) {
			if(cliente.getNumTel().equals(numero)) {
				return cliente;
			}
		}
		return null;
	}
	
	public String generarCodigo() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder builder = new StringBuilder();
		Random rand = new Random();
		while(builder.length() < 4) {
			int index = (int) (rand.nextFloat() * chars.length());
			builder.append(chars.charAt(index));
		}
		String codigo = builder.toString();
		return codigo;
	}
	
	@Override
	public String getBotUsername() {
		return BOT_USERNAME;
	}
	
	@Override
	public String getBotToken() {
		return BOT_TOKEN;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
