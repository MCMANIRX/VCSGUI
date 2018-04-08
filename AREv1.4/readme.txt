---------------Air-Ride Editor User Guide------------------

	This program edits certain values inside Kirby Air Ride Air-Ride .dat archives. 

Every vehicle file ingame begins with the prefix "Vc". 
Extract any one of these files anywhere. 
Click "Insert Values" to save your changes to the file. 

(The other button is borked because CMD GCRebuilder is noncompliant :( 
If anyone knows how to use GCR in CMD, contact me.)

Replace the air-ride files in the ROM with your custom ones using your GC ROM editor of choice 
(STRONGLY RECOMMEND MAKING A ROM COPY IN CASE YOU BREAK THE GAME). 

Then, have fun!


			 -NOTES-

-REQUIRES AT LEAST JAVA 8 https://java.com/en/download/

-this program convert IEEE-7 floats to hex. Anything around -1.70141e+38 (FF000000) will most definetly either crash the game or 
underflow to a negative value (i.e. if you set the glide too high, anytime you get in the air you will glide backwards)

-Be careful with the scale parameter. It will crash the game at lower values than some other parameters.

-The boost feature of this game seems to work in this way: when the boost gauge reaches 0, then the actual boost occurs. 
For the duration of the time that the boost gauge isn't 0, the vehicle will be rapidly accelerated to its max speed. 
SO, in order to increase the boost gauge's length (charge release), you need to input small values. 
For reference, the Bulk Star's charge release value is 0.0036. (it's boost strength is 0, so it stops on a dime).




Compiled on 4/1/18

Created by DIP

Contact at thisispadding@gmail.com

Contact me if you know java and want to help!
This is unfinished but still functional!
JTatoo looks awesome!


