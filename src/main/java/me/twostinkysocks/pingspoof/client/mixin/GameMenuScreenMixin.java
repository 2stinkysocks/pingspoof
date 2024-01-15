package me.twostinkysocks.pingspoof.client.mixin;

import me.twostinkysocks.pingspoof.client.PingspoofClient;
import me.twostinkysocks.pingspoof.client.Util;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {

    private TextFieldWidget pingField;

    protected GameMenuScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("RETURN"))
    public void init(CallbackInfo ci) {
        pingField = new TextFieldWidget(this.textRenderer, 5, this.height-30, 100, 20, Text.of("Add Ping"));
        pingField.setText(String.valueOf(PingspoofClient.extraPing));
        this.addSelectableChild(pingField);
        this.addDrawableChild(ButtonWidget.builder(Text.of("Confirm"), button -> {
            if(Util.isInt(pingField.getText())) {
                PingspoofClient.extraPing = Integer.parseInt(pingField.getText());
                MinecraftClient.getInstance().player.sendMessage(Text.of("Set your ping increase to " + pingField.getText() + "ms"));
            }
        }).size(100, 20).position(5, this.height-55).build());
    }

    @Inject(method = "render", at = @At("RETURN"))
    public void render(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        this.pingField.render(context, mouseX, mouseY, delta);
    }


}
