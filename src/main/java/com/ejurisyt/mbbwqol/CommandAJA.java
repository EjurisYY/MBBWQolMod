/**
 * Copyright © 2023 EjurisYT
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.ejurisyt.mbbwqol;

import java.util.Arrays;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CommandAJA extends CommandBase {

    @Override
    public String getCommandName() {
        return "aja";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/aja <on/off>";
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("autojoinassist", "aja");
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (sender instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) sender;
    
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("on")) {
                    AutoGG.cmsg = "/categories";
                    player.addChatMessage(new ChatComponentText("Auto Join Assitant is now enabled."));
                } else if (args[0].equalsIgnoreCase("off")) {
                    AutoGG.cmsg = "";
                    player.addChatMessage(new ChatComponentText("Auto Join Assitant is now disabled."));
                } else {
                    player.addChatMessage(new ChatComponentText(getCommandUsage(sender)));
                }
            } else {
                player.addChatMessage(new ChatComponentText(getCommandUsage(sender)));
            }
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
