package fi.dy.masa.minihud.gui;

import javax.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.gui.GuiScreen;
import fi.dy.masa.malilib.config.option.ConfigInfo;
import fi.dy.masa.malilib.gui.BaseScreenTab;
import fi.dy.masa.malilib.gui.ScreenTab;
import fi.dy.masa.malilib.gui.config.BaseConfigScreen;
import fi.dy.masa.malilib.gui.config.BaseConfigTab;
import fi.dy.masa.malilib.gui.config.ConfigTab;
import fi.dy.masa.malilib.util.data.ModInfo;
import fi.dy.masa.minihud.Reference;
import fi.dy.masa.minihud.config.Configs;
import fi.dy.masa.minihud.config.InfoLine;
import fi.dy.masa.minihud.config.RendererToggle;
import fi.dy.masa.minihud.config.StructureToggle;

public class ConfigScreen
{
    public static final ModInfo MOD_INFO = Reference.MOD_INFO;

    private static final BaseConfigTab GENERIC              = new BaseConfigTab(MOD_INFO, "generic",    160, Configs.Generic.OPTIONS, ConfigScreen::create);
    private static final BaseConfigTab COLORS               = new BaseConfigTab(MOD_INFO, "colors",     100, Configs.Colors.OPTIONS,  ConfigScreen::create);
    private static final BaseConfigTab INFO_LINES           = new BaseConfigTab(MOD_INFO, "info_lines", 200, InfoLine.VALUES,         ConfigScreen::create);
    private static final BaseConfigTab OVERLAY_RENDERERS    = new BaseConfigTab(MOD_INFO, "renderers",  200, getRendererOptions(),    ConfigScreen::create);
    private static final BaseConfigTab STRUCTURES           = new BaseConfigTab(MOD_INFO, "structures", 200, getStructureOptions(),   ConfigScreen::create);
    public  static final BaseScreenTab SHAPES               = new BaseScreenTab(MOD_INFO, "shapes", GuiShapeManager::screenValidator, GuiShapeManager::openShapeManager);

    public static final ImmutableList<ConfigTab> CONFIG_TABS = ImmutableList.of(
            GENERIC,
            COLORS,
            INFO_LINES,
            OVERLAY_RENDERERS,
            STRUCTURES
    );

    public static final ImmutableList<ScreenTab> ALL_TABS = ImmutableList.of(
            GENERIC,
            COLORS,
            INFO_LINES,
            OVERLAY_RENDERERS,
            STRUCTURES,
            SHAPES
    );

    public static BaseConfigScreen create(@Nullable GuiScreen currentScreen)
    {
        return new BaseConfigScreen(MOD_INFO, null, ALL_TABS, INFO_LINES, "minihud.gui.title.configs");
    }

    public static ImmutableList<ConfigTab> getConfigTabs()
    {
        return CONFIG_TABS;
    }

    private static ImmutableList<ConfigInfo> getRendererOptions()
    {
        ImmutableList.Builder<ConfigInfo> builder = ImmutableList.builder();

        builder.add(Configs.Generic.MAIN_RENDERING_TOGGLE);
        builder.addAll(RendererToggle.VALUES);

        return builder.build();
    }

    private static ImmutableList<ConfigInfo> getStructureOptions()
    {
        ImmutableList.Builder<ConfigInfo> builder = ImmutableList.builder();

        builder.add(Configs.Generic.MAIN_RENDERING_TOGGLE);
        builder.add(RendererToggle.OVERLAY_STRUCTURE_MAIN_TOGGLE);
        builder.addAll(StructureToggle.VALUES);

        return builder.build();
    }
}
