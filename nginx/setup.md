# ssh rp4
```bash
ssh whereq@192.168.2.128
```

# ssh rp4 remote
```bash
ssh -p 50022 whereq@184.145.66.133
```

# sftp rp4 remote
```bash
sftp -P 50022 whereq@184.145.66.133

cd /tmp

put -r /local/path
```

# Test the configuration for syntax errors:
```bash
nginx -t
```

# Start / Restart / Stop Nginx Commands

```bash
sudo systemctl start nginx 
sudo systemctl stop nginx 
sudo systemctl restart nginx
```

On older version of ubuntu
```bash
sudo service nginx start
sudo service nginx stop
sudo service nginx restart
```

To view status of your Nginx server

```bash
sudo systemctl status nginx
```

** OR **

```bash
sudo service status nginx
```


# letsencrypt
```bash
sudo certbot renew
```

# Virtual Hosts Configuration

1. Add virtual host configuration under /etc/nginx/sites-available/
2. Create symbol link under /etc/nginx/sites-enabled


# Reference
[https://www.cyberciti.biz/faq/nginx-restart-ubuntu-linux-command/](https://www.cyberciti.biz/faq/nginx-restart-ubuntu-linux-command/)
