import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class Bot extends TelegramLongPollingBot{

    @Override
    public String getBotUsername() {
        return "@testms1925_bot";
    }

    @Override
    public String getBotToken() {
        return "5794427832:AAHILpmCqKXnL09l0P-OqX_XbnlXRUs9lZU";
    }

    @Override
    public void onUpdateReceived(Update update) {

        long UserChatId = update.getMessage().getChatId();
        String u = update.getMessage().getText();
        String Text = "\uD83D\uDD17 Izlayapsiz, ammo topolmayapsiz\n" +
                "\n" +
                "@newlink_uz (https://t.me/+8EAg1KAVK1llNDFi) kanali - barcha foydalanuvchilar uchun cheksiz imkoniyatlar manzili. Kanal Sizga quyidagi afzalliklarni beradi:\n" +
                "\n" +
                "✔\uFE0FEng foydali linklar;\n" +
                "✔\uFE0FEng foydali Web saytlar;\n" +
                "✔\uFE0FEng foydali telegram botlar manzili.\n" +
                "\n" +
                "Vaqtingizni behuda izlashga sarflamang, yaxshisi, kanalga tashrif buyuring va qulayliklar ichida \" suzing\".\n" +
                "\n" +
                "⚡\uFE0F@newlink_uz (https://t.me/+8EAg1KAVK1llNDFi) - hammasi faqat Siz uchun!";

        String PhotoParse = "D:\\Users\\HP\\IdeaProjects\\MathGame\\src\\IMG\\img.png";

        if (u.equals("/start") ) {
            sendPhotoWithText(UserChatId, PhotoParse, Text);
        }
    }

    private void sendPhotoWithText(long chatId, String photoPath, String captionText) {

        SendPhoto sendPhoto = new SendPhoto();

        sendPhoto.setChatId(chatId);

        sendPhoto.setPhoto(new InputFile(new File(photoPath)));

        sendPhoto.setCaption(captionText);

        sendPhoto.setParseMode("HTML");

        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}