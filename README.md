# EncryptServiceDemo
https://www.mindrot.org/projects/jBCrypt/ 

jBCrypt是OpenBSD的Blowfish密码哈希代码的Java™实现，如Niels Provos和David的“一个未来可适应的密码方案”Mazières所述。

该系统使用Bruce Schneier的Blowfish分组密码的一个版本哈希密码，其修改旨在提高离线密码破解的成本，并阻碍快速硬件实现。该算法的计算成本是参数化的，因此它可以随着计算机速度的提高而增加。其目的是使密码数据库的妥协不太可能导致攻击者获得明文密码的知识(例如使用John The Ripper)。

原文：
jBCrypt is a Java™ implementation of OpenBSD's Blowfish password hashing code, as described in "A Future-Adaptable Password Scheme" by Niels Provos and David Mazières.

This system hashes passwords using a version of Bruce Schneier's Blowfish block cipher with modifications designed to raise the cost of off-line password cracking and frustrate fast hardware implementation. The computation cost of the algorithm is parametised, so it can be increased as computers get faster. The intent is to make a compromise of a password database less likely to result in an attacker gaining knowledge of the plaintext passwords (e.g. using John the Ripper).

There seems to be a lack of good password hashes for Java - the top two hits in Google (as of 2006/05/24) for "Java password hash" and "Java password encryption" both offer terrible advice: one uses an unsalted hash which allows reverse dictionary lookup of passwords and the other recommends reversible encryption, which is rarely needed and should only be used as a last resort.

jBCrypt is licensed under a ISC/BSD licence (see the LICENSE file for details) and ships with a set of JUnit unit tests to verify correct operation of the library and compatibility with the canonical C implementation of the bcrypt algorithm.

The API is very simple:

// Hash a password for the first time

String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

// gensalt's log_rounds parameter determines the complexity
// the work factor is 2**log_rounds, and the default is 10

String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

// Check that an unencrypted password matches one that has
// previously been hashed

if (BCrypt.checkpw(candidate, hashed))
	System.out.println("It matches");
else
	System.out.println("It does not match");
