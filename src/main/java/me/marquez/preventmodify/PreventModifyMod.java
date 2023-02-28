package me.marquez.preventmodify;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.EditServerScreen;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(PreventModifyMod.MODID)
public class PreventModifyMod
{
    public static final String MODID = "preventmodify";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PreventModifyMod()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onGuiOpen(ScreenEvent e) {
        if (e.getScreen() instanceof EditServerScreen) {
            e.setCanceled(true);
        }

    }
}
