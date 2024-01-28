package rip.snake.snpcpvelocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import org.slf4j.Logger;

@Plugin(
        id = "snpcp-velocity",
        name = "ServerNPCProxy",
        version = "${VERSION}",
        authors = {"iSnakeBuzz_"},
        url = "https://r.snake.rip/snpc"
)
public class ServerNPC {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
    }
}
