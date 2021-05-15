package owah.minecraft.green_apple.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import owah.minecraft.green_apple.GreenApple;
import owah.minecraft.green_apple.core.GuiHandler;
import owah.minecraft.green_apple.core.IGreenAppleBlocks;
import owah.minecraft.green_apple.core.IGreenAppleItems;
import owah.minecraft.green_apple.init.BlockInit;
import owah.minecraft.green_apple.init.ItemInit;
import owah.minecraft.green_apple.tile.TileEntityMachine;

import javax.annotation.Nullable;

public class GreenAppleMachine extends BlockContainer implements IGreenAppleBlocks , IGreenAppleItems {
    protected final String DEFAULT_NAME = "block_green_apple_machine";

    public GreenAppleMachine() {
        super(Material.IRON);
        this.setCreativeTab(GreenApple.creativeTabs);
        this.setUnlocalizedName(this.DEFAULT_NAME);
        this.setRegistryName(GreenApple.MODID, this.DEFAULT_NAME);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityMachine();
    }
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityMachine te = (TileEntityMachine) world.getTileEntity(pos);
            if (!player.isSneaking()) {
                player.openGui(GreenApple.instance, GuiHandler.GreenAppleMachine, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityMachine te = (TileEntityMachine) world.getTileEntity(pos);
        for(int slot = 0; slot < te.getSizeInventory();slot++)
        {
            ItemStack stack = te.getStackInSlot(slot);
            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(),pos.getZ(), stack);
        }
        super.breakBlock(world, pos, state);
    }


    @Override
    public void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(this);
    }

    @Override
    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(new ResourceLocation(GreenApple.MODID, this.DEFAULT_NAME), "inventory"));
    }

    @Override
    public void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(this).setRegistryName(this.DEFAULT_NAME));
    }
}
