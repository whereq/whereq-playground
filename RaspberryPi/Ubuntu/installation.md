# MySQL Installation and Management

### Install MySQL
```bash
sudo apt -y install mysql-server
```

### Verify MySQL is running
```bash
sudo ss -tap | grep mysql
```

### Uninstall MySQL
```bash
sudo apt uninstall mysql-server
sudo apt purge mysql-server
```

### Start and Stop MySQL Service
```bash
sudo service mysql start
sudo service mysql stop
```

---

# Java Installation and Information

### Install OpenJDK 21 JRE
```bash
sudo apt install openjdk-21-jre-headless
```

### Verify Java Version
```bash
someone@somewhere:~$ java -version
openjdk version "21.0.3" 2024-04-16
OpenJDK Runtime Environment (build 21.0.3+9-Ubuntu-1ubuntu123.10.1)
OpenJDK 64-Bit Server VM (build 21.0.3+9-Ubuntu-1ubuntu123.10.1, mixed mode, sharing)
```

### Locate Java Installation
```bash
someone@somewhere:~$ whereis java
java: /usr/bin/java /usr/share/java /usr/share/man/man1/java.1.gz
```

### Locate Keytool
```bash
someone@somewhere:~$ whereis keytool
keytool: /usr/bin/keytool /usr/share/man/man1/keytool.1.gz
```

**Note**: The JRE is installed under **`/usr/lib/jvm`** by default.

### Check Installed JREs in `/usr/lib/jvm`
```bash
someone@somewhere:/usr/lib/jvm$ ls /usr/lib/jvm
java-1.21.0-openjdk-arm64  java-21-openjdk-arm64
```

### Navigate to the Installed JDK Directory
```bash
someone@somewhere:/usr/lib/jvm$ cd java-1.21.0-openjdk-arm64
someone@somewhere:/usr/lib/jvm/java-1.21.0-openjdk-arm64$ ls -l
```

### Sample Output
```bash
total 24
drwxr-xr-x  2 root root 4096 Sep 24 18:56 bin
drwxr-xr-x  4 root root 4096 Sep 24 18:56 conf
lrwxrwxrwx  1 root root   42 May 29 08:14 docs -> ../../../share/doc/openjdk-21-jre-headless
drwxr-xr-x 71 root root 4096 Sep 24 18:56 legal
drwxr-xr-x  5 root root 4096 Sep 24 18:56 lib
drwxr-xr-x  3 root root 4096 Sep 24 18:56 man
-rw-r--r--  1 root root 1213 May 29 08:14 release
```