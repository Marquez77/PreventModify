package me.marquez.preventmodify;


import com.pixelmonmod.pixelmon.client.gui.override.multiplayer.CustomAddServerScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.AddServerScreen;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(PreventModifyMod.MODID)
public class PreventModifyMod
{
    public static final String MODID = "preventmodify";
    private static final Logger LOGGER = LogManager.getLogger();

    public PreventModifyMod()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onGuiOpen(GuiScreenEvent.DrawScreenEvent.Pre e) {
        // Pixelmon
        if (e.getGui() instanceof CustomAddServerScreen) {
            e.setCanceled(true);
            Minecraft.getInstance().setScreen(new MainMenuScreen());
        }
        // Vanilla
//        if (e.getGui() instanceof AddServerScreen) {
//            e.setCanceled(true);
//        }

    }
}
