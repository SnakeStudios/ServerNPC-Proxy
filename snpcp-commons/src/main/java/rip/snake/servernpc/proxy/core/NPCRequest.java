package rip.snake.servernpc.proxy.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import rip.snake.servernpc.proxy.core.enums.SubChannel;

@Data
@AllArgsConstructor
public class NPCRequest {

    private final SubChannel subChannel;
    private final boolean isConsole;
    private final String sender;
    private final String message;

    public static NPCRequest fromBytes(byte[] data) {
        return MessageHelper.decrypt(data);
    }
}
