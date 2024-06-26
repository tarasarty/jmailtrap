# jmailtrap

# Mailtrap client

This library offers integration with the [official API](https://api-docs.mailtrap.io/) for [Mailtrap](https://mailtrap.io).

Quickly add email sending functionality to your java application with Mailtrap.

## Installation

Use maven for build client:

```sh
mvn clean install
mvn jar
```

## Usage
There are java console apps as examples:
### Minimal

```java

/**
 * For this example to work, you need to set up a sending domain,
 * and obtain a token that is authorized to send from the domain.
 *
 */
public class MinimalExample {
    public static void main(String... args) {
    MinimalExample minimal = new MinimalExample();
    minimal.sendMinimal();
}

public void sendMinimal() {
    ApiKeyToken apiKeyToken = new ApiKeyToken(Settings.getTOKEN());
    MailTrapClient client = new MailTrapClient(apiKeyToken);
    EmailAddress from = new EmailAddress(
        "",
        "From");

    EmailAddress to = new EmailAddress(
        "",
        "To");

    String subject = "Hello from Mailtrap!";
    String text = "Welcome to Mailtrap Sending!";

    client.send(from, to, subject, text);
}

}
```

Refer to the examples folder for the source code of this and other advanced examples.


## Development

This library has been developed using Java 11 or later.

## License

The package is available as open source under the terms of the [MIT License](https://opensource.org/licenses/MIT).

