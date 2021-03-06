package jp.ac.titech.c.cl.chatannotator.logger.server.json;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class GimmickLogJson
{
	public final String interactTime;
	public final String interactorId;

	public final String name;

	public final int x;
	public final int y;
	public final int z;

	public final boolean activated;

	public GimmickLogJson(BlockPos gimmickPos, ResourceLocation gimmickName, boolean isActivated, EntityPlayer interactPlayer, Date interactTime)
	{
		this.interactTime = new SimpleDateFormat("HH:mm:ss").format(interactTime);
		interactorId = (Objects.nonNull(interactPlayer))? interactPlayer.getUniqueID().toString() : "null";

		name = gimmickName.toString();

		x = gimmickPos.getX();
		y = gimmickPos.getY();
		z = gimmickPos.getZ();

		activated = isActivated;
	}
}
