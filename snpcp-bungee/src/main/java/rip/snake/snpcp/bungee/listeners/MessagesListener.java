package rip.snake.snpcp.bungee.listeners;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import rip.snake.servernpc.proxy.core.MessageHelper;
import rip.snake.servernpc.proxy.core.NPCRequest;
import rip.snake.snpcp.bungee.ServerNPC;

public class MessagesListener implements Listener {

    private final ServerNPC plugin;
    private final String channelName = "servernpc:main";

    public MessagesListener(ServerNPC plugin) {
        this.plugin = plugin;
        ProxyServer.getInstance().registerChannel(channelName);
    }

    @EventHandler
    public void onPluginMessage(PluginMessageEvent event) {
        if (!(event.getSender() instanceof Server)) return;
        if (!event.getTag().equalsIgnoreCase(channelName)) return;

        NPCRequest request = NPCRequest.fromBytes(event.getData());

        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(request.getSender());
        if (player == null) return;

        String message = MessageHelper.replace(request.getMessage(), player.getName());


        if (request.isConsole()) {
            ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), message);
        } else {
            ProxyServer.getInstance().getPluginManager().dispatchCommand(player, message);
        }
    }


}