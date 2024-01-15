package me.twostinkysocks.pingspoof.client;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.Text;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class PingspoofClient implements ClientModInitializer {

    public static long extraPing = 0;

    @Override
    public void onInitializeClient() {
//        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(ClientCommandManager.literal("addping")
//                        .then(ClientCommandManager.argument("value", IntegerArgumentType.integer()))
//                .executes(context -> {
//                    final long value = IntegerArgumentType.getInteger(context, "value");
//                    context.getSource().sendFeedback(Text.literal("Now increasing your ping by " + value +"ms"));
//                    extraPing = value;
//                    return 1;
//                })));
    }
}
