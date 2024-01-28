package rip.snake.servernpc.proxy.core;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import lombok.experimental.UtilityClass;
import rip.snake.servernpc.proxy.core.enums.SubChannel;

@UtilityClass
public class MessageHelper {

    public String replace(String message, String playerName) {
        return message.replace("%player_name%", playerName).replace("%player%", playerName);
    }

    public NPCRequest decrypt(byte[] data) {
        ByteArrayDataInput in = ByteStreams.newDataInput(data);
        boolean isConsole = in.readBoolean();

        String subChannel = in.readUTF();
        String playerName = in.readUTF();
        String message = in.readUTF();

        return new NPCRequest(SubChannel.getByName(subChannel), isConsole, playerName, message);
    }

    private boolean isBool(String s) {
        boolean bool;

        try {
            bool = Boolean.parseBoolean(s);
        } catch (Exception ignored) {
            bool = false;
        }

        return bool;
    }

}
