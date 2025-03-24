```bash
sudo mysql -u root
```

 ```sql
 CREATE DATABASE whereq;
 CREATE USER 'user'@'localhost' IDENTIFIED BY 'user123';
 CREATE USER 'user'@'%' IDENTIFIED BY 'user123';

 GRANT ALL PRIVILEGES ON whereq.* TO 'user'@'%' WITH GRANT OPTION;
 FLUSH PRIVILEGES;
 ```

Edit the MySQL configuration file (usually /etc/mysql/my.cnf or /etc/mysql/mysql.conf.d/mysqld.cnf) and ensure the bind-address is set to 0.0.0.0 (to allow connections from all IPs) or the specific IP of the Docker network.
```bash
bind-address = 0.0.0.0
```