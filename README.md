# FailoverEmailService

Email Service with failover capability

This service offers emails sending with failover capabilities. Means, if service goes down it tries with other one.

Currently, this service providing with 2 email service providers

1.[MailGun](www.mailgun.com)<br/>
2.[SendGrid](www.sendgrid.com)

# dependencies / Technology stack
I chose backend track so, minimal frontend code is written.</br>

This is Maven-SpringBoot project works with [thymeleaf](http://www.thymeleaf.org/) template engine for rendering front end.<br/>

# Experience with technology stack

springboot and maven - since i'm in current job for more than 1 year </br>
thymeleaf templte engine and email service provider like MailGun - this is first time </br>
working with Java for more than 2 years all together.</br>

No backend is used because it does not store anything.

# Endpoint

It has only one endpoint, that is root(/).

just type localhost:8080 and service is ready to send emails.

# Constraints of email service providers.

FrontPage of this service has four test box to add details.

![Screenshot](https://github.com/Bhalchandra-B/FailoverEmailService/blob/master/FailoverEmailService.png)

There are some constraints with recipients and sender email address for *MailGun* and *SendGrid*.

**MailGun** :

*MailGun* has policy to add list of recipients address into the mailing list first. Recipient Email address which is not present in mailing list will be discarded and will throw exception.

For experiment purpose, only one user has been added, **scotttiger000@gmail.com**.

**SendTo** : scotttiger000@gmail.com<br/>
**From** : *DMARC policy* is restricting to use some email address as sender from few domain, for example *yahoo.com*.

So, to send message successfully with *mailgun*, there are two options.

1. Leave blank.
2. use email address with *gmail.com* domain.

**SendGrid**

*SendGrid* does NOT need to add recipients in to the mailing list. So user can send emails WITHOUT adding beforehand.<br/>
It works flawlessly with *gmail* domain but mail to *yahoo* are being deferred because of *user complaints*.<br/>

*SendGrid* has one constraints regarding *sender* address.<br/>
Email address of sender can not be blank. It MUST be provided.<br/>
Keeping Blank *From*, blocks the email from sending.

You can add more recipients in *MailGun* and sender in *SendGrid* account, after i provide credentials through mail.

Conclusion for sending mails:

**SendTo** : for *mailgun*, **scotttiger000@gmail.com**, for *sendgrid* any address from *gmail* domain<br/>
**From** : for *mailgun*, blank or any other email address from *gmail* domain, for *sendgrid*, email address from *gmail* domain.

Ex:<br/>
**SendTo** : scotttiger000@gmail.com<br/>
**From** : abcd@gmail.com or xyz@gmail.com

# Dockerization
Image is dockerized.<br/>

docker run -p 8080:8080 smaccit

# Confessions
1. Unable to write unit tests and integration tests. It's quite complicated.
2. In integration test, i failed to manage, to populate the EmailModel object. Because no JSON/XML files are being used.
3. In Unit tests, 'GreenMail' is best choice to test SMTP email code, but it needs same port to accumulate first though which email is going to be sent. In this case, first app is starting port 'xxx' and then 'GreenMail' on same port. That causes, IncosistentStateException.

