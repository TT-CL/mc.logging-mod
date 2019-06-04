package com.harunabot.chatannotator.proxy;

import com.harunabot.chatannotator.Main;
import com.harunabot.chatannotator.util.handlers.GuiHandler;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Load resources and do some stuffs on the client side
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	@Override
    public void preInit(FMLPreInitializationEvent event) {
    	super.preInit(event);

    	System.out.println("ClientProxy.preInit");
    }

	@Override
    public void init(FMLInitializationEvent event) {
		super.init(event);

        System.out.println("ClientProxy.init");
    }

	@Override
    public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);

    	System.out.println("ClientProxy.postInit");
    }
}
