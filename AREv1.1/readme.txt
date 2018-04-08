---------------Air-Ride Editor User Guide------------------

	This program edits certain values inside Kirby Air Ride Air-Ride .dat archives. 

Every vehicle file ingame begins with the prefix "Vc". Extract any one of these files to the same folder as the tool, select the file with the tool, and edit the values. Click "Insert Values" to save your changes to the file. Replace the air-ride files in the ROM with your custom ones using your GC ROM editor of choice (STRONGLY RECOMMEND MAKING A ROM COPY IN CASE YOU BREAK THE GAME). Then, have fun!


			 -NOTES-


-this program convert IEEE-7 floats to hex. Anything around -1.70141e+38 (FF000000) will most definetly either crash the game or underflow to a negative value (i.e. if you set the glide too high, anytime you get in the air you will glide backwards)

-Be careful with the scale parameter. It will crash the game at lower values than some other parameters.

-The boost feature of this game seems to work in this way: when the boost gauge reaches 0, then the actual boost occurs. If the boost strength is set to 0, for the duration of the time that the boost gauge isn't 0, the vehicle will be rapidly accelerated to its max speed. that is why the bulk star and hydra stop on a dime yet move quickly. SO, in order to increase the boost gauge's length (charge release), you need to input small values. For reference, the Bulk Star's charge release value is 0.0036.

-if you click out of the file select window, the program will continue to run indefinitely. this will be fixed soon but doesn't seem to cause slowdown.

Compiled on 3/27/18

Created by DIP

Contact at thisispadding@gmail.com

Contact me if you know java and want to help!
This is unfinished but still functional!
JTatoo looks awesome!


