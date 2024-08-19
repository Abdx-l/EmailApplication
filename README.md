# Email Application

This project is a Java-based email client that allows users to send and receive emails. It includes a GUI for interacting with the email system and instructions for setting up a custom mail server on a Linux system.


Project Overview:
This project demonstrates the creation of a fully functional email client using Java. The client interacts with a custom-configured mail server running on a Linux virtual machine, allowing users to send and receive emails within the application.


Features
Send emails through a custom mail server.
Receive emails via the same server.
Simple and intuitive graphical user interface (GUI).
Complete setup and configuration of a mail server on a Linux system.


# Installation
Clone the Repository:

git clone https://github.com/Abdx-l/EmailApplication

cd EmailApplication

Set Up the Mail Server (see Setting Up Your Own Mail Server below).

Compile the Java Files:

javac GUI.java ReceivingEmail.java SendingEmail.java

Run the Application:

java GUI


Usage:


Sending Emails: Open the GUI, enter the recipient’s email address, and compose your message. Click “Send” to send the email via your custom mail server.
Receiving Emails: Use the “Check Inbox” feature in the GUI to retrieve emails from your server.
Setting Up Your Own Mail Server
This project includes instructions for setting up a custom mail server on a Linux system, which is necessary for the email client to function. Follow the steps below to configure the server:

1. Set Up a Linux Virtual Machine
You can use virtualization software like VMware, VirtualBox, or Hyper-V to create a Linux virtual machine (VM). Ensure that the VM’s network is configured in Bridged Mode so that it has its own IP address on your local network.

2. Install Postfix
Postfix is a popular mail transfer agent (MTA) that routes and delivers emails. Install it on your Linux VM:

sudo apt-get update
sudo apt-get install postfix

3. Configure Postfix
Edit the /etc/postfix/main.cf configuration file:

sudo nano /etc/postfix/main.cf


Add or modify the following lines:


myhostname = mail.yourdomain.com


mydomain = yourdomain.com


myorigin = $mydomain


inet_interfaces = all


mydestination = $myhostname, localhost.$mydomain, localhost, $mydomain


relay_domains =

Save and exit the file, then restart Postfix:


sudo systemctl restart postfix

4. Configure DNS Settings
In your domain registrar, configure your DNS settings to point to your server:

A Record: Point mail.yourdomain.com to your VM’s IP address.
MX Record: Set up an MX record to handle email routing for yourdomain.com.

5. Verify the Configuration
Ensure your Postfix configuration is working by sending a test email from the terminal:

echo "Test Email Body" | mail -s "Test Subject" recipient@emaildomain.com


# File Descriptions
1. GUI.java
This file contains the code for the graphical user interface (GUI) of the email client. The GUI allows users to send and receive emails through a simple interface.

2. ReceivingEmail.java
This file contains the code responsible for retrieving emails from the mail server. It uses the javax.mail package to connect to the server and download emails to the client.

3. SendingEmail.java
This file contains the code for sending emails through the custom mail server. It uses the javax.mail package to handle the SMTP connection and message sending.

# Contributing
Contributions to this project are welcome. Feel free to fork the repository, make changes, and submit a pull request.
