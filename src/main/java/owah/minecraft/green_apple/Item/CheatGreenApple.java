package owah.minecraft.green_apple.Item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import owah.minecraft.green_apple.GreenApple;
import owah.minecraft.green_apple.core.IGreenAppleItems;
import owah.minecraft.green_apple.init.ItemInit;
import owah.minecraft.green_apple.tab.GreenAppleTab;

public class CheatGreenApple extends ItemFood implements IGreenAppleItems {
    private final String DEFAULT_NAME = "cheat_green_apple";
    //コンストラクタ
    public CheatGreenApple() {
        super(100, false);
        this.setUnlocalizedName(this.DEFAULT_NAME);
        this.setRegistryName(GreenApple.MODID, this.DEFAULT_NAME);
        this.setCreativeTab(GreenApple.creativeTabs);
        this.setAlwaysEdible();

        ItemInit.ITEMS.add(this);
    }
    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        super.onFoodEaten(stack, worldIn, player);
        player.addExperienceLevel(666);
        stack.setCount(stack.getCount()+1);
        if(player.isSneaking()) {
            AxisAlignedBB a = new AxisAlignedBB(player.chasingPosX-32,player.chasingPosY-64,player.chasingPosZ-32,player.chasingPosX+32,player.chasingPosY+64,player.chasingPosZ+32);
            for(Entity e:worldIn.getEntitiesWithinAABBExcludingEntity(player,a)) {
                if(e instanceof EntityLivingBase) {
                    EntityLivingBase Entity =(EntityLivingBase) e;
                    if(Entity instanceof EntityPlayer ) {
                    }else {
                        DamageSource d = DamageSource.causePlayerDamage(player);
                        Entity.setHealth(0);
                        Entity.onDeath(d);
                        if(!(Entity instanceof EntityDragon)) {
                            Entity.isDead = true;
                        }

                    }
                }
                if(e instanceof EntityItem) {
                    EntityItem Entity =(EntityItem) e;
                    ItemStack s = Entity.getItem();
                    player.addItemStackToInventory(s);
                }
            }
        }


    }

    //食べる速度
    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 2;
    }
    //どのブロックが壊せるか
    @Override
    public boolean canHarvestBlock(IBlockState blockIn)
    {
        return true;
    }
    //壊す速度
    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        return 	Integer.MAX_VALUE;
    }
    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(entityIn instanceof EntityPlayer ) {
            EntityPlayer player =(EntityPlayer) entityIn;
            player.setHealth(20);
            player.capabilities.allowFlying = true;
            player.capabilities.disableDamage = true;
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(11),99999,275));
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(6),99999,275));
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(1),99999,1));
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(16),99999,1));
            player.isDead = false;
            player.setEntityInvulnerable(true);
        }
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

    @Override
    public void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(this);
    }

    @Override
    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(new ResourceLocation(GreenApple.MODID, this.DEFAULT_NAME), "inventory"));
    }
}
