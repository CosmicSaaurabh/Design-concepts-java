## Problem statement

Imagine you are developing a software application that needs to integrate with multiple third-party payment gateways (like PayPal, Stripe, and Square).
Each payment gateway has its own unique API and data format for processing payments. 
Without a common interface, your application would need to implement separate code for each payment gateway, 
leading to code duplication and increased complexity.

Or say you have an existing application that uses a specific logging library, but you want to switch to a different logging library without changing the existing codebase.
The two logging libraries have different interfaces, making it challenging to switch between them seamlessly.   
This is where the Adapter Design Pattern comes into play.

Or suppose we have a ecommerce application that needs to integrate send email notifications using different email service providers like SendGrid, Amazon SES, and Mailgun.
Each email service provider has its own API and data format for sending emails.
Without a common interface, the application would need to implement separate code for each email service provider, leading to code duplication and increased complexity.

The Adapter Design Pattern acts as a bridge between two incompatible interfaces, allowing them to work together seamlessly.
It provides a way to convert the interface of one class into another interface that the client expects.
This pattern is particularly useful when integrating with third-party libraries or legacy systems that have different interfaces than the rest of the application.

### How to solve
To solve this problem, we can implement the Adapter Design Pattern by creating adapter classes that wrap around the third-party payment gateway APIs or logging libraries.
These adapter classes will implement a common interface that the application expects, allowing the application to interact with different payment gateways or logging libraries without worrying about their specific implementations.
For example, we can create a `PaymentGatewayAdapter` interface with methods like `processPayment(amount)` and `refundPayment(transactionId)`.
Then, we can create concrete adapter classes like `PayPalAdapter`, `StripeAdapter`, and `SquareAdapter` that implement the `PaymentGatewayAdapter` interface and internally use the respective payment gateway APIs to process payments.
Similarly, for logging libraries, we can create a `LoggerAdapter` interface with methods like `logInfo(message)` and `logError(message)`.
Then, we can create concrete adapter classes like `Log4jAdapter` and `SLF4JAdapter` that implement the `LoggerAdapter` interface and internally use the respective logging library APIs to log messages.
By using the Adapter Design Pattern, we can achieve a clean separation of concerns, reduce code duplication, and make it easier to switch between different payment gateways or logging libraries in the future.