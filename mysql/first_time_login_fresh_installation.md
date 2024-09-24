## Ubuntu

**Note**:  On some systems, like  [Ubuntu](https://en.wikipedia.org/wiki/Ubuntu_%28operating_system%29), MySQL is using the  [Unix auth_socket plugin](https://dev.mysql.com/doc/mysql-security-excerpt/5.5/en/socket-pluggable-authentication.html)  by default.

Basically it means that:  _db_users using it, will be "authenticated" by  **the system user credentials.**_  You can see if your  `root`  user is set up like this by doing the following:

```
someone@somewhere:~$ sudo mysql -u root
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 11
Server version: 8.0.37-0ubuntu0.23.10.2 (Ubuntu)

Copyright (c) 2000, 2024, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> USE mysql
Database changed
mysql> SELECT user, host, plugin FROM user;
+------------------+-----------+-----------------------+
| user             | host      | plugin                |
+------------------+-----------+-----------------------+
| debian-sys-maint | localhost | caching_sha2_password |
| mysql.infoschema | localhost | caching_sha2_password |
| mysql.session    | localhost | caching_sha2_password |
| mysql.sys        | localhost | caching_sha2_password |
| root             | localhost | auth_socket           |
+------------------+-----------+-----------------------+
5 rows in set (0.00 sec)

```


Here’s the refined version of the text for clarity and readability:

---

In the query, the `root` user is using the `auth_socket` plugin. To address this, you have two options:

1. **Set the `root` user to use the `mysql_native_password` plugin**  
2. **Create a new `db_user` mapped to your `system_user`** (recommended)

### Option 1: Switch the `root` user to `mysql_native_password`

```bash
sudo mysql -u root 
```

```sql
mysql> USE mysql;
mysql> UPDATE user SET plugin = 'mysql_native_password' WHERE User = 'root';
mysql> FLUSH PRIVILEGES;
mysql> exit;
```

```bash
sudo service mysql restart
```

### Option 2: Create a new `db_user` for your system user (recommended)

Replace `YOUR_SYSTEM_USER` with your actual system username.

```bash
sudo mysql -u root 
```

```sql
mysql> USE mysql;
mysql> CREATE USER 'YOUR_SYSTEM_USER'@'localhost' IDENTIFIED BY 'YOUR_PASSWD';
mysql> GRANT ALL PRIVILEGES ON *.* TO 'YOUR_SYSTEM_USER'@'localhost';
mysql> UPDATE user SET plugin = 'auth_socket' WHERE User = 'YOUR_SYSTEM_USER';
mysql> FLUSH PRIVILEGES;
mysql> exit;
```

```bash
sudo service mysql restart
```

> **Note:** With this method, use your system username to connect to MySQL:
> ```bash
> mysql -u YOUR_SYSTEM_USER
> ```

### Important Notes

1. **Plugin Name Differences**: On some systems (e.g., [Debian 9 Stretch](https://en.wikipedia.org/wiki/Debian_version_history#Debian_9_(Stretch))), the `auth_socket` plugin is called `unix_socket`. In that case, use this SQL command instead:
   ```sql
   UPDATE user SET plugin = 'unix_socket' WHERE User = 'YOUR_SYSTEM_USER';
   ```

2. **MySQL 8.x.x Changes**:  
   In MySQL 8.x.x, the `auth_socket` plugin was replaced by `caching_sha2_password`. The default authentication plugin for new users from MySQL 8.0.4 onward is `caching_sha2_password`.  
   You can log in with the new `db_user` using:
   ```bash
   mysql -u YOUR_SYSTEM_USER -p
   ```
   There is no need to run the `UPDATE user SET plugin` command for new users under MySQL 8.x.x. For more information, refer to the official update on this change:  
   **[MySQL 8.0.4: New Default Authentication Plugin: caching_sha2_password](https://mysqlserverteam.com/mysql-8-0-4-new-default-authentication-plugin-caching_sha2_password/)**

