package owah.minecraft.green_apple.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import owah.minecraft.green_apple.gui.GreenAppleMachineContainer;
import owah.minecraft.green_apple.gui.GreenAppleMachineGui;
import owah.minecraft.green_apple.tile.TileEntityMachine;

public class GuiHandler implements IGuiHandler {
    public static final int GreenAppleMachine = 1;
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GreenAppleMachine) {
            return new GreenAppleMachineContainer(player.inventory,(TileEntityMachine) world.getTileEntity(new BlockPos(x,y,z)));
        }
        return null;
    }
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GreenAppleMachine){
            return new GreenAppleMachineGui(player.inventory,(TileEntityMachine) world.getTileEntity(new BlockPos(x,y,z)));
        }
        return null;
    }
}
