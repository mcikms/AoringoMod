package owah.minecraft.green_apple.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import owah.minecraft.green_apple.GreenApple;
import owah.minecraft.green_apple.init.ItemInit;

public class TileEntityMachine extends TileEntity implements IInventory,ITickable{
    //private ItemStackHandler inventory_old = new ItemStackHandler(1);
    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(14, ItemStack.EMPTY);

    private int totalProgress;
    private int Progress;

    private final int INPUT_SLOT = 0;
    private final int UPGRADE_SLOT = 13;

    public TileEntityMachine(){
        this.totalProgress = 200;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        compound.setInteger("Progress", (short)this.Progress);
        ItemStackHelper.saveAllItems(compound, this.inventory);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventory);
        this.Progress = compound.getInteger("Progress");
    }

    @Override
    public int getSizeInventory() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack itemstack:inventory){
            if(!itemstack.isEmpty()){
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.inventory.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemstack = this.inventory.get(index);
        this.inventory.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }

    }

    @Override
    public int getInventoryStackLimit() {
        return 4096;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        if (this.world.getTileEntity(this.pos) != this)
        {
            return false;
        }
        else
        {
            return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getField(int id) {
        switch (id){
            case 0:
                return this.Progress;
            case 1:
                return this.totalProgress;
        }
        return 0;
    }

    @Override
    public void setField(int id, int value) {
        switch (id){
            case 0:
                this.Progress = value;
                break;
            case 1:
                this.totalProgress = value;
                break;
        }

    }

    @Override
    public int getFieldCount() {
        return 2;
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }

    @Override
    public String getName() {
        return "OK";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public void update() {
        this.updateCost();
        if(!this.getStackInSlot(INPUT_SLOT).isEmpty()){
            Progress++;
            if(Progress >= totalProgress){
                ItemStack itemstack = this.getStackInSlot(INPUT_SLOT).copy();
                itemstack.setCount(1);
                this.OutPut(itemstack);
                Progress = 0;
            }
        }
    }

    protected void OutPut(ItemStack output){
        for(int i = 1;i < inventory.size();i++){
            ItemStack stack = this.getStackInSlot(i);
            if(stack.isEmpty()){
                this.setInventorySlotContents(i,output);
                return;
            }else if(stack.getItem() == output.getItem() && (!output.getHasSubtypes() || output.getMetadata() == output.getMetadata()) && ItemStack.areItemStackTagsEqual(output, stack)){
                stack.grow(output.getCount());
                return;
            }
        }
    }

    protected void updateCost(){
        double newCost = 200;
        if(!this.getStackInSlot(INPUT_SLOT).isEmpty()){
            newCost = Math.ceil(200 / (this.getStackInSlot(INPUT_SLOT).getCount() * 0.05));
        }
        if(!this.getStackInSlot(UPGRADE_SLOT).isEmpty()){
            if(this.getStackInSlot(UPGRADE_SLOT).getItem() == ItemInit.SPEED_UPGRADE){
                newCost = newCost / this.getStackInSlot(UPGRADE_SLOT).getCount();
            }
        }
        this.totalProgress = (int) newCost;
    }

}
