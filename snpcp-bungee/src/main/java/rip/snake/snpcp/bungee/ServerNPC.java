package rip.snake.snpcp.bungee;

import net.md_5.bungee.api.plugin.Plugin;
import rip.snake.snpcp.bungee.listeners.MessagesListener;

public final class ServerNPC extends Plugin {

    @Override
    public void onEnable() {
        this.getProxy().getPluginManager().registerListener(this, new MessagesListener(this));
    }

}
