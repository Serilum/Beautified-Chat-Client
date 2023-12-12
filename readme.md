<h2>Beautified Chat Client</h2>
<p><a href="https://github.com/Serilum/Beautified-Chat-Client"><img src="https://serilum.com/assets/data/logo/beautified-chat-client.png"></a></p><h2>Download</h2>
<p>You can download Beautified Chat Client on CurseForge and Modrinth:</p><p>&nbsp;&nbsp;CurseForge: &nbsp;&nbsp;<a href="https://curseforge.com/minecraft/mc-mods/beautified-chat-client">https://curseforge.com/minecraft/mc-mods/beautified-chat-client</a><br>&nbsp;&nbsp;Modrinth: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://modrinth.com/mod/beautified-chat-client">https://modrinth.com/mod/beautified-chat-client</a></p>
<h2>Issue Tracker</h2>
<p>To keep a better overview of all mods, the issue tracker is located in a separate repository.<br>&nbsp;&nbsp;For issues, ideas, suggestions or anything else, please follow this link:</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;-> <a href="https://serilum.com/url/issue-tracker">Issue Tracker</a></p>
<h2>Pull Requests</h2>
<p>Because of the way mod loader files are bundled into one jar, some extra information is needed to do a PR.<br>&nbsp;&nbsp;A wiki page entry about it is available here:</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;-> <a href="https://serilum.com/url/pull-requests">Pull Request Information</a></p>
<h2>Mod Description</h2>
<p><a href="https://serilum.com/" rel="nofollow"><img src="https://github.com/Serilum/.cdn/blob/main/description/header/header.png" alt="" width="838" height="400"></a><br><br><a href="https://legacy.curseforge.com/minecraft/mc-mods/beautified-chat-client/files"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/header.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/beautified-chat-client/files/all?filter-status=1&filter-game-version=1738749986:75125" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_20.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/beautified-chat-client/files/all?filter-status=1&filter-game-version=1738749986:73407" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_19.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/beautified-chat-client/files/all?filter-status=1&filter-game-version=1738749986:73250" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_18.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/beautified-chat-client/files/all?filter-status=1&filter-game-version=1738749986:73242" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_17.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/beautified-chat-client/files/all?filter-status=1&filter-game-version=1738749986:70886" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_16.png"></a><a href="https://legacy.curseforge.com/minecraft/mc-mods/beautified-chat-client/files/all?filter-status=1&filter-game-version=1738749986:628" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/versions/1_12.png"></a><br><br><strong><span style="font-size:24px">Requires the library mod&nbsp;<a style="font-size:24px" href="https://www.curseforge.com/minecraft/mc-mods/collective" rel="nofollow">Collective</a>.<br></span></strong><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/beautified-chat-client/a.jpg" width="288" height="50"></picture><br><br></p>
<p><span style="font-size:18px">This is the <strong>client variant</strong> of the Beautified Chat mod. It is highly configurable and allows users to change the chat input on their client. The mod variant you're currently looking at just needs the mod the client. It will make changes to the chat on all connected servers, without the need to have the mod on the server's mod list. There is also a timestamp feature to know when messages were sent.<br><br><strong><span style="color:#396;font-size:18px">The server version is also available and is called <a style="font-size:18px;color:#396" href="https://www.curseforge.com/minecraft/mc-mods/beautified-chat-server" rel="nofollow">Beautified Chat [Server]</a>.&nbsp;</span></strong><br>Both the client and server mod are compatible with each other, server-side takes priority.<br><br><strong><span style="color:#f60;font-size:18px">In default Minecraft, all chat is in the format:</span></strong><br><span style="font-size:14px"><strong>&lt;Username&gt; Message</strong></span><br><br><strong><span style="color:#f60;font-size:18px">The mod by default changes this to:</span></strong><br><span style="font-size:14px"><strong>Timestamp | Username: Message</strong></span><br><br>The default colours can be seen below in the example image. Both the format and the colour codes can be changed with ease via the config. If you don't want the timestamp, just remove it in the&nbsp;<em>chatMessageFormat</em> config option.<br><br>The default timestamp format is 24-hours. If you want AM/PM, just input in the <em>timestampFormat</em> config option "<strong>hh:mm a</strong>" instead of the default "<strong>HH:mm</strong>".<br><br></span><br><br><strong><span style="font-size:20px">Configurable:</span> <span style="color:#008000;font-size:14px"><a style="color:#008000" href="https://serilum.com/url/issue-trackerwiki/how-to-configure-mods" rel="nofollow">(&nbsp;how do I configure?&nbsp;)</a></span><br></strong><span style="font-size:12px"><strong>chatMessageFormat</strong>&nbsp;(default = "%timestamp% | %username%: %chatmessage%"): Variables: %timestamp% = timestamp set in timestampFormat. %username% = the username of the player who sent the message.</span><br><span style="font-size:12px"><strong>timestampFormat</strong>&nbsp;(default = "HH:mm"): Example time in formats: 5 seconds past 9 o' clock in the evening. *=Default. *(HH:mm) = 21:00, (HH:mm:ss) = 21:00:05, (hh:mm a) = 9:00 PM</span><br><br><span style="font-size:14px"><strong>The possible colour code values for the next 4 configs are:</strong></span><br><span style="font-size:14px">0: black, 1: dark_blue, 2: dark_green, 3: dark_aqua, 4: dark_red, 5: dark_purple, 6: gold, 7: gray, 8: dark_gray, 9: blue, 10: green, 11: aqua, 12: red, 13: light_purple, 14: yellow, 15: white.</span><br><span style="font-size:12px"><strong><br>chatTimestampColour</strong>&nbsp;(default = 8, min 0, max 15): The colour of the timestamp in the chat message.&nbsp;</span><br><span style="font-size:12px"><strong>chatUsernameColour</strong>&nbsp;(default = 2, min 0, max 15): The colour of the username in the chat messsage.</span><br><span style="font-size:12px"><strong>chatMessageColour</strong>&nbsp;(default = 15, min 0, max 15): The colour of the chat message.</span><br><span style="font-size:12px"><strong>chatOtherSymbolsColour</strong>&nbsp;(default = 7, min 0, max 15): The colour of the other symbols from chatMessageFormat. So everything except the variables.</span><br><br><br><span style="font-size:18px"><strong>The default format ("%timestamp% | %username%: %chatmessage%"):</strong></span><br><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/beautified-chat-client/b.jpg" width="779" height="147"></picture></p>
<p><br>------------------<br><br><span style="font-size:24px"><strong>You may freely use this mod in any modpack, as long as the download remains hosted within the CurseForge or Modrinth ecosystem.</strong></span><br><br><span style="font-size:18px"><a style="font-size:18px;color:#008000" href="https://serilum.com/" rel="nofollow">Serilum.com</a> contains an overview and more information on all mods available.</span><br><br><span style="font-size:14px">Comments are disabled as I'm unable to keep track of all the separate pages on each mod.</span><span style="font-size:14px"><br>For issues, ideas, suggestions or anything else there is the&nbsp;<a style="font-size:14px;color:#008000" href="https://serilum.com/url/issue-tracker" rel="nofollow">Github repo</a>. Thanks!</span><span style="font-size:6px"><br><br></span><a href="https://ricksouth.com/donate" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/shields/donation_rounded.svg" alt="" width="306" height="50"></a></p>