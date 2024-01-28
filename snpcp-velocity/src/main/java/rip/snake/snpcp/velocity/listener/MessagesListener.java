package rip.snake.snpcp.velocity.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PluginMessageEvent;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ServerConnection;
import com.velocitypowered.api.proxy.messages.MinecraftChannelIdentifier;
import org.jetbrains.annotations.NotNull;
import rip.snake.servernpc.proxy.core.MessageHelper;
import rip.snake.servernpc.proxy.core.NPCRequest;
import rip.snake.snpcp.velocity.ServerNPC;

public class MessagesListener {

    public static final MinecraftChannelIdentifier IDENTIFIER = MinecraftChannelIdentifier.from("servernpc:main");
    private final ServerNPC plugin;

    public MessagesListener(@NotNull ServerNPC plugin) {
        this.plugin = plugin;

        plugin.getLogger().info("Registering plugin message listener...");
        plugin.getProxyServer().getChannelRegistrar().register(IDENTIFIER);
    }

    @Subscribe
    public void onPluginMessage(@NotNull PluginMessageEvent event) {
        // Ensure the identifier is what you expect before trying to handle the data
        if (!(event.getSource() instanceof ServerConnection)) return;
        if (event.getIdentifier() != IDENTIFIER) return;

        NPCRequest request = NPCRequest.fromBytes(event.getData());
        Player player = plugin.getProxyServer().getPlayer(request.getSender()).orElse(null);
        if (player == null) return;

        String message = MessageHelper.replace(request.getMessage(), player.getUsername());

        if (request.isConsole()) {
            plugin.getProxyServer().getCommandManager().executeAsync(plugin.getProxyServer().getConsoleCommandSource(), message);
        } else {
            plugin.getProxyServer().getCommandManager().executeAsync(player, message);
        }
    }

}
