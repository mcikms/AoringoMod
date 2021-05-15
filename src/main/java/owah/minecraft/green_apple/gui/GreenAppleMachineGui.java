package owah.minecraft.green_apple.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import owah.minecraft.green_apple.tile.TileEntityMachine;

public class GreenAppleMachineGui extends GuiContainer {
    private final IInventory tileEntity;
    public GreenAppleMachineGui(IInventory playerinv, TileEntityMachine te) {
        super(new GreenAppleMachineContainer(playerinv, te));
        this.xSize = 176;
        this.ySize = 166;
        this.tileEntity = te;
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1,1);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("green_apple","textures/gui/green_apple_machine_gui.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize,this.ySize);
        this.drawTexturedModalRect(this.guiLeft + 48,this.guiTop + 20,176,0,this.getProgressScaled(24),16);
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
    private int getProgressScaled(int pixels)
    {
        int i = this.tileEntity.getField(0);
        int j = this.tileEntity.getField(1);
        if(i == 0){
            return 0;
        }
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}
