package owah.minecraft.green_apple.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import owah.minecraft.green_apple.Item.IItemUpgrade;
import owah.minecraft.green_apple.tile.TileEntityMachine;

public class GreenAppleMachineContainer extends Container {
    //-----------------------------PART 1---------------------------------------
    public GreenAppleMachineContainer(IInventory playerInv, final TileEntityMachine te)
    {
        addSlotToContainer(new Slot(te, 0, 26, 20)
        {
            @Override
            public void onSlotChanged() {
                te.markDirty();
            }
        });
        addSlotToContainer(new Slot(te, 13, 26, 56)
        {
            @Override
            public void onSlotChanged() {
                te.markDirty();
            }
            public boolean isItemValid(ItemStack stack)
            {
                if(stack.getItem() instanceof IItemUpgrade){
                    return true;
                }
                return false;
            }
        });
        for(int i=0; i<4;i++)
        {
            for(int j=0; j<3; j++)
            {
                addSlotToContainer(new Slot(te, i*3+j + 1, 80+i*18, 20+j*18)
                {
                    @Override
                    public void onSlotChanged() {
                        te.markDirty();
                    }
                });
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(playerInv,  i * 9+j + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int k = 0; k < 9; k++) {
            addSlotToContainer(new Slot(playerInv, k, 8 + k * 18, 142));
        }
    }
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return !playerIn.isSpectator();
    }
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();
            if (index < containerSlots) {
                if (!this.mergeItemStack(itemstack1, containerSlots, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, itemstack1);
        }
        return itemstack;
    }
}
