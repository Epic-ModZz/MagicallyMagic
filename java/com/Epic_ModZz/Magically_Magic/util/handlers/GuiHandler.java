package com.Epic_ModZz.Magically_Magic.util.handlers;

import com.Epic_ModZz.Magically_Magic.blocks.gui.GuiCaytalistCreator;
import com.Epic_ModZz.Magically_Magic.blocks.gui.GuiMagicSponge;
import com.Epic_ModZz.Magically_Magic.blocks.properties.ContainerBlockCaytalistCreator;
import com.Epic_ModZz.Magically_Magic.blocks.properties.ContainerMagicSponge;
import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityCayalistCreator;
import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityMagicSponge;
import com.Epic_ModZz.Magically_Magic.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		if(ID == Reference.GUI_MAGIC_SPONGE) return new ContainerMagicSponge(player.inventory, (TileEntityMagicSponge)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_ENERGIES_IMBUER) return new ContainerBlockCaytalistCreator(player.inventory, (TileEntityCayalistCreator)world.getTileEntity(new BlockPos(x,y,z))); 

		return null;
		

	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_MAGIC_SPONGE) return new GuiMagicSponge(player.inventory, (TileEntityMagicSponge)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_ENERGIES_IMBUER) return new GuiCaytalistCreator(player.inventory, (TileEntityCayalistCreator)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
		
	}

	public static void registerGUIs() {
		
	}
}
