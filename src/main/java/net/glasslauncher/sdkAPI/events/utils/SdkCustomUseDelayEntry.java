package net.glasslauncher.sdkAPI.events.utils;

public class SdkCustomUseDelayEntry {

    public SdkCustomUseDelayEntry(long l, int i)
    {
        lastUse = l;
        lastMinecraftUse = i;
    }

    public long lastUse;
    public int lastMinecraftUse;

}
