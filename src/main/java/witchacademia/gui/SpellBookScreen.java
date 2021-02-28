package witchacademia.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import witchacademia.WitchAcademia;
import witchacademia.network.Networking;
import witchacademia.network.PacketUpdateSpellBook;
import witchacademia.spells.Fireball;
import witchacademia.spells.SummonBerries;

public class SpellBookScreen extends Screen {

    private static final int WIDTH = 179;
    private static final int HEIGHT = 151;

    public CompoundNBT tag;

    private ResourceLocation GUI = new ResourceLocation(WitchAcademia.MOD_ID, "textures/gui/spellbook_gui.png");


    protected SpellBookScreen(ITextComponent titleIn) {
        super(titleIn);
    }

    protected SpellBookScreen(CompoundNBT tag) {
        super(new TranslationTextComponent("screen.witchacademia.spellbook"));
        this.tag = tag;
    }

    @Override
    protected void init() {
        int relX = (this.width - WIDTH) / 2;
        int relY = (this.height - HEIGHT) / 2;

        addButton(new Button(relX + 10, relY + 10, 160, 20, new StringTextComponent(Fireball.NAME.getString()), button -> setActiveSpell(Fireball.SPELL_KEY)));
        addButton(new Button(relX + 10, relY + 37, 160, 20, new StringTextComponent(SummonBerries.NAME.getString()), button -> setActiveSpell(SummonBerries.SPELL_KEY)));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    private void setActiveSpell(String spell) {
        System.out.println(spell);
        Networking.sendToServer(new PacketUpdateSpellBook(spell));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - WIDTH) / 2;
        int relY = (this.height - HEIGHT) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, WIDTH, HEIGHT);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    public static void open(CompoundNBT tag) {
        Minecraft.getInstance().displayGuiScreen(new SpellBookScreen(tag));
    }
}
