package ciallo.mikun.jeihistory.mixin;

import ciallo.mikun.jeihistory.JeiHistoryConfig;
import ciallo.mikun.jeihistory.jei.JeiHistoryPlugin;
import mezz.jei.api.ingredients.ITypedIngredient;
import mezz.jei.api.recipe.IFocus;
import mezz.jei.gui.recipes.RecipesGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = RecipesGui.class, remap = false)
public class RecipesGuiMixin {
    @Inject(method = "show", at = @At("HEAD"))
    private void onShow(List<IFocus<?>> focuses, CallbackInfo ci) {
        if (JeiHistoryConfig.open_history && JeiHistoryPlugin.historyIngredientListGrid != null) {
            for (IFocus<?> focus : focuses) {
                try {
                    ITypedIngredient<?> ingredient = focus.getTypedValue();
                    JeiHistoryPlugin.historyIngredientListGrid.addHistory(ingredient);
                } catch (Exception e) {
                    // Ignore any errors in getting typed ingredient
                }
            }
        }
    }
}
