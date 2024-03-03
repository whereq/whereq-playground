# Start / Restart / Stop Nginx Commands

```
sudo systemctl start nginx 
sudo systemctl stop nginx 
sudo systemctl restart nginx
```

On older version of ubuntu
```
sudo service nginx start
sudo service nginx stop
sudo service nginx restart
```

To view status of your Nginx server

```
sudo systemctl status nginx
```

** OR **

```
sudo service status nginx
```

# Virtual Hosts Configuration

1. Add virtual host configuration under /etc/nginx/sites-available/
2. Create symbol link under /etc/nginx/sites-enabled


# Reference
[https://www.cyberciti.biz/faq/nginx-restart-ubuntu-linux-command/](https://www.cyberciti.biz/faq/nginx-restart-ubuntu-linux-command/)
