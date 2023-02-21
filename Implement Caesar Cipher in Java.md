 Implement Caesae Cipher in Java:-
 
 
The Caesar cipher is estimated to date back to the first century BC in the Roman Empire.
Its name comes from the Roman Emperor Julius Caesar, who used this cipher to encrypt military messages and strategies [1],
and it is estimated to be broken in about the fifth century AD. The Caesar cipher is a substitution cipher, in which each
letter of the alphabet is moved a certain number of characters to the right. For example, if the established number is 5, 
then A will become F, B will become G, C will become H, etc. In this cipher, the key is represented by the number that the
letters are shifted. Note that the key should be secret, known only by the sender (to encrypt the messages) and by the receiver
(to decrypt the messages). The Caesar cipher is important because it is the basis for other classical ciphers, such as Vigenère.
The Caesar cipher with key k = 13 is also known as Rot13.
Let’s consider an example. The key for the cipher is set to k = 6; therefore, all letters
are shifted six characters

Caesar Representation with k = 6
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
A B C D E F G H I J K   L  M  N  O  P Q  R   S  T  U  V  W  X  Y  Z
G H I J K L M N O P Q   R  S  T  U  V W  X   Y  Z  A  B  C  D  E  F

Note that there are 26 letters in the alphabet, and in Table 5-1 the numbering starts
with 0 and ends with 25 because it is related to Ժ26 = {0, 1,…,25}. Sometimes, in other
documentation, the numbering starts with 1 and ends with 26, because it seems more
natural.
Considering the plain message as “CAESAR CIPHER EXAMPLE” and the key as k = 6,
the encrypted message will be “IGKYGX IOVNKX KDGSVRK.” The encrypted message
was obtained by replacing C with the corresponding I, A with the corresponding G, E
with the corresponding K, and so on.

To decrypt the message, the letters from the second row of the table are shifted
to the left for k positions. Therefore, the decryption of “IGKYGX IOVNKX KDGSVRK”
(with the key k = 6) is “CAESAR CIPHER EXAMPLE,” obtained by applying a similar
logic as for encryption: I is replaced with C, G is replaced with A, and so on. Note that
sometimes the space character is removed from the message; therefore, in the example,
the plain text would be “CAESARCIPHEREXAMPLE,” while the encrypted text would be
“IGKYGXIOVNKXKDGSVRK.”
From a mathematical point of view, the operations are addition for encryption and
subtraction for decryption via a modulo operation. The first step is to “convert” the
characters to numbers, as follows: ੝
'A' → 1,
'B' → 2, …, 
'Z' → 26. The encryption function
enck will take as input one parameter, i.e., the number corresponding to the letter that
needs to be encrypted at the current step, and will output the encrypted letter:
enc (c) = (c+k)mod26,
where c is the plain character and k is the key. The decryption function needs to shift
back the letters and, therefore, has the following representation:
dec (c') = (c'-k)mod26,
where c' is the encrypted character that needs to be decrypted and k is the key. 

