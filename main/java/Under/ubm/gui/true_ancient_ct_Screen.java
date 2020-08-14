package Under.ubm.gui;

import Under.ubm.Lib.UbmLib;
import Under.ubm.init.UbmBlockContainer;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class true_ancient_ct_Screen extends ContainerScreen<true_ancient_ct_Screen>
{
    private mousePosx;
    private mousePosY;

    public static final ResourceLocation guiTextures1 = new ResourceLocation(UbmLib.MODID, "textures/gui/true_ancient_ct");

    public true_ancient_ct_Screen(UbmBlockContainer screenContainer, PlayerInventory inv, ITextComponent titleIn)
    {
        super(screenContainer, inv, titleIn);
        this.xSize = 256;
        this.ySize = 256;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground();
        this.mouseposx = (float)mouseX;
        this.mouseposY = (float)mouseY;
        super render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }



    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color3f(1.0F, 1.0F, 1.0F);
        getMinecraft().getTextureManager().bindTexture(guiTextures1);
        this.blit(guiLeft, guiTop, 0, 0, xSize, ySize);
        ClientPlayerEntity player = Minecraft.getInstance().player;
        InventoryScreen.drawEntityOnScreen(300, 80, 30, mouseX, mouseY, player);
    }
}
