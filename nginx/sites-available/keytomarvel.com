server {
    root /var/www/html;

    index index.html index.htm index.nginx-debian.html;

    server_name keytomarvel.com www.keytomarvel.com;

    location / {
        # Proxy requests to the Keycloak application running on port 8888
        proxy_pass http://localhost:8888;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header X-Forwarded-Host $host;
        proxy_set_header X-Forwarded-Port $server_port;
    }

    listen [::]:443 ssl ipv6only=on; # managed by Certbot
    listen 443 ssl; # managed by Certbot
    ssl_certificate /etc/letsencrypt/live/keytomarvel.com/fullchain.pem; # managed by Certbot
    ssl_certificate_key /etc/letsencrypt/live/keytomarvel.com/privkey.pem; # managed by Certbot
    include /etc/letsencrypt/options-ssl-nginx.conf; # managed by Certbot
    ssl_dhparam /etc/letsencrypt/ssl-dhparams.pem; # managed by Certbot
}

server {
    if ($host = www.keytomarvel.com) {
        return 301 https://$host$request_uri;
    } # managed by Certbot

    if ($host = keytomarvel.com) {
        return 301 https://$host$request_uri;
    } # managed by Certbot

    listen 80 default_server;
    listen [::]:80 default_server;

    server_name keytomarvel.com www.keytomarvel.com;
    return 404; # managed by Certbot
}