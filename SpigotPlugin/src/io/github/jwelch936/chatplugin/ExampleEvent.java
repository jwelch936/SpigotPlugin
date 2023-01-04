package io.github.jwelch936.chatplugin;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ExampleEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final String playerName;

    /**
     * Constructor
     * @param playerName Player name
     */
    public ExampleEvent(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Necessary, unknown why
     * @return handler list
     */
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    /**
     * Necessary, unknown why
     * @return handler list
     */
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    /**
     * Return player name
     * @return player name
     */
    public String getPlayerName() {
        return this.playerName;
    }

}
