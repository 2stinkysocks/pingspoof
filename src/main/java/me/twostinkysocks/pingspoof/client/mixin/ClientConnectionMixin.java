package me.twostinkysocks.pingspoof.client.mixin;

import me.twostinkysocks.pingspoof.client.PingspoofClient;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.PacketCallbacks;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.common.KeepAliveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {
    @Inject(method = "sendInternal", at = @At("HEAD"))
    private void sendInternal(Packet<?> packet, PacketCallbacks callbacks, boolean flush, CallbackInfo ci) {
        try {
            if(packet instanceof KeepAliveC2SPacket) {
                if(PingspoofClient.extraPing > 0) {
                    Thread.sleep(PingspoofClient.extraPing);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
