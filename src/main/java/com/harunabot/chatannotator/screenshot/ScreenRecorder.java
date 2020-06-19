package com.harunabot.chatannotator.screenshot;

import java.awt.image.BufferedImage;

import org.apache.logging.log4j.Level;

import com.harunabot.chatannotator.ChatAnnotator;
import com.harunabot.chatannotator.screenshot.client.StandbyScreenshots;
import com.harunabot.chatannotator.screenshot.network.NotifyArrivalMessage;
import com.harunabot.chatannotator.screenshot.server.ScreenshotLog;
import com.harunabot.chatannotator.util.handlers.ChatAnnotatorPacketHandler;
import com.sun.jna.platform.unix.X11.Screen;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ScreenShotHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import paulscode.sound.SoundSystem;

public class ScreenRecorder
{
	public static ScreenshotLog SCREENSHOT_LOG;
	public static StandbyScreenshots SCREENSHOT_HOLDER;


	@SideOnly(Side.CLIENT)
	public static void createScreenShot()
	{
		BufferedImage bufferedImage;
		NotifyArrivalMessage message;
		Minecraft minecraft = Minecraft.getMinecraft();

		bufferedImage = ScreenShotHelper.createScreenshot(minecraft.displayWidth, minecraft.displayHeight, minecraft.getFramebuffer());
		message = SCREENSHOT_HOLDER.registerImage(bufferedImage);

		ChatAnnotatorPacketHandler.sendToServer(message);
	}

	public static void init()
	{
		SCREENSHOT_LOG = new ScreenshotLog();
		SCREENSHOT_HOLDER = new StandbyScreenshots();
	}
}
