# How To Secure Nginx with Let's Encrypt on Ubuntu 

## Step 1 — Installing Certbot
```
sudo snap install core; sudo snap refresh core
```

If you’re working on a server that previously had an older version of certbot installed, you should remove it before going any further
```
sudo apt remove certbot
```

Install the certbot package
```
sudo snap install --classic certbot
```

Link the certbot command from the snap install directory to your path
```
sudo ln -s /snap/bin/certbot /usr/bin/certbot
```

## Step 2 — Confirming Nginx’s Configuration
```
sudo nano /etc/nginx/sites-available/example.com
```
```
server_name example.com www.example.com;
```
```
sudo systemctl reload nginx
```

## Step 3 — Allowing HTTPS Through the Firewall
Adjust the settings to allow for HTTPS traffic.
```
sudo ufw status
```

```
Output
Status: active

To                         Action      From
--                         ------      ----
OpenSSH                    ALLOW       Anywhere                  
Nginx HTTP                 ALLOW       Anywhere                  
OpenSSH (v6)               ALLOW       Anywhere (v6)             
Nginx HTTP (v6)            ALLOW       Anywhere (v6)
```

```
sudo ufw allow 'Nginx Full'
sudo ufw delete allow 'Nginx HTTP'
```

```
sudo ufw status
```

```
Output
Status: active

To                         Action      From
--                         ------      ----
OpenSSH                    ALLOW       Anywhere
Nginx Full                 ALLOW       Anywhere
OpenSSH (v6)               ALLOW       Anywhere (v6)
Nginx Full (v6)            ALLOW       Anywhere (v6)
```


## Step 4 — Obtaining an SSL Certificate
Run certbot with the --nginx plugin, using -d to specify the domain names we’d like the certificate to be valid for.
```
sudo certbot --nginx -d whereq.cc -d www.whereq.cc
```

```
Saving debug log to /var/log/letsencrypt/letsencrypt.log
Requesting a certificate for whereq.cc and www.whereq.cc

Successfully received certificate.
Certificate is saved at: /etc/letsencrypt/live/whereq.cc/fullchain.pem
Key is saved at:         /etc/letsencrypt/live/whereq.cc/privkey.pem
This certificate expires on 2024-06-01.
These files will be updated when the certificate renews.
Certbot has set up a scheduled task to automatically renew this certificate in the background.

Deploying certificate
Successfully deployed certificate for whereq.cc to /etc/nginx/sites-enabled/whereq.cc
Successfully deployed certificate for www.whereq.cc to /etc/nginx/sites-enabled/whereq.cc
Congratulations! You have successfully enabled HTTPS on https://whereq.cc and https://www.whereq.cc

- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
If you like Certbot, please consider supporting our work by:
 * Donating to ISRG / Let's Encrypt:   https://letsencrypt.org/donate
 * Donating to EFF:                    https://eff.org/donate-le
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
```

## Step 5 — Verifying Certbot Auto-Renewal

```
sudo systemctl status snap.certbot.renew.service
```

```
Output
○ snap.certbot.renew.service - Service for snap application certbot.renew
     Loaded: loaded (/etc/systemd/system/snap.certbot.renew.service; static)
     Active: inactive (dead)
TriggeredBy: ● snap.certbot.renew.timer
```

```
sudo certbot renew --dry-run
```


# Reference
[How To Secure Nginx with Let's Encrypt on Ubuntu 22.04](https://www.digitalocean.com/community/tutorials/how-to-secure-nginx-with-let-s-encrypt-on-ubuntu-22-04)
