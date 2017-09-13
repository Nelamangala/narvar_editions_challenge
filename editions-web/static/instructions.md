
# Coding Project

## Provided Code 

The provided code is a spring-boot application that contains an example controller and a defined API for Editions. For 
the purpose of this challenge you can treat an Edition as a published piece of literature. A JSON schema and multiple
JSON examples are available under the resources directory.

The example endpoints can be found in *ExampleController*.
 
There are three submodules in the project.

1. editions-web: This is the main module and contains all the server code. Most of your development will take place within this module.
1. editions-client: A client class that can be used in external projects to consume the endpoints created under `editions-web`.  Make sure to update this client so the changes made under `editions-web` are mirrored here. I will use the editions client to submit requests to the server and verify your solution.
1. editions-api: The api contract of your web server, this comes with bundled request objects representing an "edition".

### Dependencies 

To start the application both Java 8 and Maven are required.

### Starting up the web server

The application can be started by running `MainApplication.java` in your IDE of choice or by executing the below
command from the `editions-web` directory.

```text
cd ${root_directory_of_project}
mvn clean install
cd editions-web
mvn spring-boot:run
```

If running the program through an IDE make sure to set the working directory and classpath of the module to point at `editions-web`.

## Functional spec

Create a service that accepts data in the format provided by `com.narvar.challenge.api.request.Edition` and
generates a top 10 list of words contained in the titles of Editions excluding the definite article **'the'** and the
indefinite articles **'a'** and **'an'**. If there is a tie between two words, such as if the 10th and 11th highest item in the list both
have the value of 35, make sure the new 10th item represents the most recently seen/processed value. 

* Provide an endpoint to display the top 10 list of words, ordered and with their respective counts. 
* Provide an endpoint to display the given frequency of a supplied word. It should answer the question of "for a given word provide how many times it has occurred in a title over the total number of titles processed".

Provide any other endpoints that you think would be useful for a consumer of the API. An example of this could be
something like a 'reset data' endpoint. 

You are welcome to change any of the provided code outside of the defined api under `editions-api`. Feel free to improve the provided REST endpoints, change any of the code flow, or update variable and functions names. You don't need to save any data in a persistent layer but are welcome to do so if such a solution is easier for you to implement.

## Readme

Create a readme file that includes the following:

* A short description on your approach and why it was chosen. What other approaches were considered, if applicable.
* Trade offs that may have been made and why.
* What you may do differently if this was a service you were building professionally and without a limited time constraint.
* How long you spent on the project so we can adjust our expectations.  We don't expect or require a huge time investment in this project. Spend what you feel comfortable doing and try to timebox it to under three hours. This is to help us get a feel for how you write production code NOT for how dedicated you are to spending multiple days to add every feature under the sun!
* Anything else you feel is important or want to explain.

**Please do not spend an exorbitant amount of time on this**. It's more for you to provide any additional details on your
approach that may be hard to express via the code or within comments. 


## How we will evaluate

The goal of this code sample is help us identify what you consider production ready code. As a result, focus more on
quality, clarity, and the design of the code rather than implementing the most optimal solution.

Some things we will consider when evaluating your submission: 

* **Architecture**: how clean is the separation of logic between classes and functions. 
* **Correctness**: does your solution solve the problem presented.
* **Readability / Clarity**:  do you explain your solution well and is the code easy to understand.
* **Security**: are there any glaring security concerns?
* **Testing**: are there any automated tests, how are they structured?
  * **Full coverage is not required or expected!** Please provide enough examples so that we can get a feel for how you
      approach testing.
     
We know that you won't be able to make everything 100% production ready and fully tested. Get as much done within the three hour time frame as you can then submit what you have completed.  

## Questions

You are welcomed and encouraged to submit clarifying questions or ask for assistance in any way well implementing your solution. We understand that you may have not been exposed to some of the libraries used in this project.  We don't expect you to become an expert in each of them or to spend significant time learning them.  We would much rather help you out so you can focus on implementing your solution.

Feel free to submit all questions to `tommy.meusburger@narvar.com`.

## SwaggerUI

Swagger UI is also included to make it easy for you to post JSON data up to the server. To access the Swagger UI go to http://localhost:8080/swagger-ui.html

You can expand the example controller and see the endpoint details. The SwaggerUI is the easiest way to post an example request to the server, you can copy the edition json payload from the file located at: 

`editions-web/src/main/resources/edition_json_examples_100.json`

## Improvements

If during the course of implementing your solution you notice any typos or errors in the code provided, please include them in your submitted readme. Take this opportunity to critique us as well so we can improve the project. We encourage you to submit your honest feedback and overall opinion about this exercise. Doing so helps us improve and adjust the challenge where our instructions or code are lacking.
