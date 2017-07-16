# FailoverEmailService

Email Service with failover capability

This service offers emails sending with failover capabilities. Means, if service goes down it tries with other one.

Currently, this service providing with 2 email service providers

1.[MailGun](www.mailgun.com)n
2.[SendGrid](www.sendgrid.com)

#dependecies

This is Maven-SpringBoot project works with [thymeleaf](http://www.thymeleaf.org/) template engine for rendering front end.

No backend is used because it does not store anything.

#Endpoint

It has only one endpoint, that is root(/).

Just execute jar and type localhost:8080 and service is ready to send emails.

#Constraints of email service providers.

FrontPage of this service has four test box to add details.

![](~/Desktop/FailoverEmailService.png)

There are some constraints with recipients and sender email address for *MailGun* and *SendGrid*.

**MailGun** :

*MailGun* has policy to add list of recepients address into the mailing list first. Recepient Email address which is not present in mailing list will be discarded and will throw exception.

For experiment purpose, only one user has been added, **scotttiger000@gmail.com**.

**SendTo** : scotttiger000@gmail.com

**From** : *DMARC policy* is restricting to use some email address as sender from few domain, for example *yahoo.com*.

So, to send message successfully with *mailgun* , there are two options.

1. Leave blank.
2. use email address with *gmail.com* domain.

For *SendGrid*

**SendGrid**

*SendGrid* does NOT need to add recepients in to the mailing list. So user can send emails WITHOUT adding beforehand.
It works flawlessly with *gmail* domain but mail to *yahoo* are being deferred because of *user complaints*.

*SendGrid* has one constraints regarding *sender* address.
Email address of sender can not be blank. It MUST be provided.
Keeping Blank *From*, blocks the email from sending.


Conclusion;

**SendTo** : for *maillgun*, **scotttiger000@gmail.com**, for *sendgrid* any address from *gmail* domain
**From** : for *mailgun*, blank or anyother email address from *gmail* domain, for *sendgrid*, email address from *gmail* domain.

Ex:
**SendTo** : scotttiger000@gmail.com
**From** : abcd@gmail.com or xyz@gmail.com



