package jp.ac.titech.c.cl.chatannotator.logger.network;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

/*
 * A Message from Client side to tell the player status on chat.
 */
public class PlayerStateMessage implements IMessage
{
	private String serialId;

	// The block player is looking at
	private BlockPos lookingAtPos;
	private String lookingAtName;

	// inventory
	// inhand

	public PlayerStateMessage()
	{
	}

	public PlayerStateMessage(String serialId, EntityPlayer player, World world, float partialTicks)
	{
		this.serialId = serialId;

		lookingAtPos = player.rayTrace(100, partialTicks).getBlockPos();
		IBlockState lookingBlockState = world.getBlockState(lookingAtPos);
		lookingAtName = lookingBlockState.getBlock().getRegistryName().toString();
	}

	public String getSerialId()
	{
		return serialId;
	}


	public BlockPos getLookingAtPos()
	{
		return lookingAtPos;
	}

	public String getLookingAtName()
	{
		return lookingAtName;
	}


	@Override
	public void fromBytes(ByteBuf buf)
	{
		serialId = ByteBufUtils.readUTF8String(buf);
		lookingAtPos = bytesToPos(buf);
		lookingAtName = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, serialId);

		buf.writeInt(lookingAtPos.getX());
		buf.writeInt(lookingAtPos.getY());
		buf.writeInt(lookingAtPos.getZ());

		ByteBufUtils.writeUTF8String(buf, lookingAtName);
	}

	private static BlockPos bytesToPos(ByteBuf buf)
	{
		int x,y,z;
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();

		return new BlockPos(x, y, z);
	}
}