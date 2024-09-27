# SSH Passwordless Login 
**SSH Passwordless Login** is an SSH authentication method that employs a pair of public and private keys for asymmetric encryption. The public key resides on the server, and only a client that presents the private key can connect.

# Setup 
To set up a passwordless SSH login in Linux all you need to do is to generate a public authentication key and append it to the remote hosts `~/.ssh/authorized_keys` file.

## 01 - Check for existing SSH key pair.
Before generating a new SSH key pair, it's important to first check if an existing SSH key is present on the client machine, as overwriting current keys is generally not recommended.

To check for existing SSH keys, the following [ls command](https://linuxize.com/post/how-to-list-files-in-linux-using-the-ls-command/) can be run:

```
ls -al ~/.ssh/*.pub
```

If SSH keys are already present, the existing keys can either be reused, or they can be backed up before generating a new one.

## 02 - Generate a new SSH key pair.
To generate a new SSH key pair, the following command can be used:

```
ssh-keygen -t rsa -b 4096 -C "someone@remote_server_or_ip"
```

After completing the process, the presence of the SSH keys can be verified with this command:

```
ls -al ~/.ssh/*
```

If successful, two files will be generated in the **~/.ssh/** folder (the default keyfile name will be **id_rsa**):

- **id_rsa** contains the private key.
- **id_rsa.pub** contains the public key.

## 03 - Create SSH directory on server 
Access the remote server using the existing username and password. Verify whether the _~/.ssh_ directory exists with the following command:

```
ls ~/.ssh
```

If the directory is not present, create it using:

```
mkdir -p ~/.ssh
```
    

## 04 - copy public key to remote server
Assume the key name is **id_rsa.pub**, in client machine
```
ssh-copy-id -i ~/.ssh/id_rsa.pub -p remote_port someone@remote_server_or_ip
```

A prompt will appear requesting the password for the `someone` account:

```
someone@remote_server_or_ip's password:
```

After authentication, the public key will be appended to the remote user's `authorized_keys` file, and the connection will be closed.

### Alternative Option
Assume the key name is **id_rsa.pub**, in client machine

On the client machine, transfer the public key to the remote server:

```
scp ~/.ssh/id_rsa.pub someone@remote_server_or_ip:~/.ssh
```

On the remote server, append the public key to the `authorized_keys` file and clean up the temporary file:

```
cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
rm ~/.ssh/id_rsa.pub  # remove the no longer needed public key file
```

## 05 - SSH to the remote server using SSH keys(passwordless)
Assume the key name is **id_rsa.pub**, in client machine

On the client machine, might need to add the private key manually
```
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_rsa
```

*Once the private key is added, passwordless SSH will work like a charm.*
```
ssh -p remote_port someone@remote_server_or_ip
```

# Disable Password Authentication
Open the SSH configuration file located at `/etc/ssh/sshd_config` and modify the following directives as needed:

```ini
PasswordAuthentication no
ChallengeResponseAuthentication no
UsePAM no
```

After making the changes, save the file and restart the SSH service.

On Ubuntu or Debian servers, restart SSH with the following command:

```
sudo systemctl restart ssh
```

On CentOS or Fedora servers, use the following command:

```
sudo systemctl restart sshd
```