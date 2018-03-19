# -Dorothy-Sayer-s-Carcass-Encryption
A Java-based project required for CS 211, Object-Oriented Programming

In Dorothy Sayers' novel "Have His Carcass", Lord Peter Wimsey describes a cryptography technique that is simple for encoding and decoding, yet relatively hard to crack. 

Here's how it works, in Sayers' (edited) words:

You choose a key-word of six letters or more, none of which recurs. Such as, for example, SQUANDER. Then you make a diagram of five squares each way and write the key-word in the squares like this:https://drive.google.com/open?id=16cLBArS9Sgg1dtfpnVBvy3id_ZxHrGoH

doro1

Then you fill up the remaining spaces with the rest of the alphabet in order, leaving out the ones you've already got.

You can't put twenty-six letters in twenty-five spaces, so you pretend you're an ancient Roman or a medieval monk and treat I and J as one letter. So you get this: https://drive.google.com/open?id=1-ybcpXgR30OrjAPJLtodLq6LNfsa1IFR

doro2

Now let's take a message -- What shall we say? 'All is known, fly at once' -- that classic hardy perennial. We write it down all of a piece and break it into groups of two letters, reading from left to right. It won't do to have two of the same letters coming together in a pair, so where that happens, we shove in a Q, which won't confuse the reader. Now our message runs:

AL QL IS KN OW NF LY AT ON CE

If there is an odd letter at the end, we'd add on another Q to square it up. Now we take our first group, AL. We see that they come at the corners of a rectangle in which the other corners are SP. So we put down SP for the first two letters of the coded message. In the same way, QL becomes SM and IS becomes FA.

Ah, but here's KN. They both come on the same vertical line. In this case you take the letter next below each -- TC. Next comes OW, which translates to MX. Going on, SK, PV, NP, TU... If your first diagonal went from bottom to top, you must take it the same way again. ON = TU, NO would be UT.

CE comes on the same horizontal line. In that case, you take the letter to the right of each. Since there isn't a letter to the right of C, you start again at the beginning of the line, producing DR. Your coded message stands now:

SP SM FA TC MX SK PV NP TU DR

The input for your program will be a series of keywords and messages to encode, alternating line-by-line, until the end-of-file flag of 999. Using the above technique, you are to encode the message, using the word.

Example Input

SQUANDER
ALL IS KNOWN FLY AT ONCE
JUXTAPOSITION
THE ROOSTER CROWED AT MIDNIGHT
999

Input will be in upper case and will contain no punctuation. Letters may occur more than once in the keywords, in which case you must ignore all but the first occurrence of the letter.

Sample Output (1st line only)

Print each message, encrypted, using two letter groups and no punctuation, separated by a single white space.

SP SM FA TC MX SK PV NP TU DR

Print an I for IJ.

Notes:
If the last letter is both odd and repeated, treat it as repeated and put the 'Q' before it, not afterward. That is, ALL becomes ALQL for encoding purposes.

In the unlikely case of two Qs in a row, insert a Z between them. Also, augment oddlength messages ending with a Q by using a Z. Thus, FAQQAD becomes FAQZQADQ and HUQ becomes HUQZ for encoding.
