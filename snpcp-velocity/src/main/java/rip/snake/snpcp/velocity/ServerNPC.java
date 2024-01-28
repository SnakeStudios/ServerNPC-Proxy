package rip.snake.snpcp.velocity;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import lombok.Getter;
import org.slf4j.Logger;
import rip.snake.snpcp.velocity.listener.MessagesListener;

@Plugin(
        id = "snpcp-velocity",
        name = "servernpc-velocity",
        version = "${VERSION}",
        authors = {"iSnakeBuzz_"},
        url = "https://r.snake.rip/snpc"
)
@Getter
public class ServerNPC {

    private final ProxyServer proxyServer;
    private final Logger logger;

    public ServerNPC(ProxyServer server, Logger logger) {
        this.proxyServer = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        proxyServer.getEventManager().register(this, new MessagesListener(this));
    }

}
