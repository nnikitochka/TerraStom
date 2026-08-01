package net.minestom.server.event.player;

import net.minestom.server.entity.Player;
import net.minestom.server.event.trait.CancellableEvent;
import net.minestom.server.event.trait.PlayerEvent;
import net.minestom.server.network.packet.server.ServerPacket;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Listen to outgoing packets asynchronously.
 * <p>
 * Currently, do not support viewable packets.
 */
@ApiStatus.Experimental
public class PlayerPacketOutEvent implements PlayerEvent, CancellableEvent {
    private final Player player;
    private final ServerPacket originalPacket;
    private ServerPacket packet;
    private boolean cancelled;

    public PlayerPacketOutEvent(Player player, ServerPacket packet) {
        this.player = player;
        this.originalPacket = packet;
        this.packet = packet;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    public ServerPacket getPacket() {
        return packet;
    }

    public void setPacket(ServerPacket packet) {
        this.packet = packet;
    }

    public boolean isPacketReplaced() {
        return packet != originalPacket;
    }

    public ServerPacket getOriginalPacket() {
        return originalPacket;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
