package rip.snake.servernpc.proxy.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubChannel {

    COMMAND("command");

    private final String name;

    public static SubChannel getByName(String name) {
        for (SubChannel subChannel : values()) {
            if (subChannel.getName().equalsIgnoreCase(name)) {
                return subChannel;
            }
        }
        return null;
    }
}