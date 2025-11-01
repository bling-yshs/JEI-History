package ciallo.mikun.jeihistory.jei;

import ciallo.mikun.jeihistory.JeiHistory;
import ciallo.mikun.jeihistory.gui.history.HistoryIngredientListGrid;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/**
 * 注册成JEI插件
 */
@JeiPlugin
public class JeiHistoryPlugin implements IModPlugin {

    public static HistoryIngredientListGrid historyIngredientListGrid;

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(JeiHistory.MODID, "jei");
    }

}
