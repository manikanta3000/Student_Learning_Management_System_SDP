# Student_Learning_Management_System_SDP
This is a course management application built using Spring Boot. It allows students to choose courses and start learning. The application also includes teachers who are assigned to each course. Entity Classes The project consists of four entity classes: Batch Course Student Teacher These classes represent the different entities in the application and their relationships. Project Structure The project structure follows the standard conventions for a Spring Boot application. It is recommended to locate your main application class in a root package above other classes. The @SpringBootApplication annotation is often placed on the main class, and it implicitly defines a base "search package" for certain items, such as @Entity classes 4 .

Tech stack used

HTML
CSS
JavaScript
Springboot
MySQL
Here is an example of the recommended project structure:

src
main
java
com.masai.project
Application.java
controller
// Controller classes
model
// Entity classes (Batch, Course, Student, Teacher)
repository
// Repository interfaces
service
// Service classes
resources
// Configuration files, templates, static files, etc.
You can customize the structure based on your specific needs, but it's generally a good practice to follow the recommended conventions.

Getting Started

To run the application locally, follow these steps:

Clone the repository.
Open the project in your preferred IDE.
Build the project using Maven or Gradle.
Run the Application class as a Java application.
Access the application at http://localhost:8080 in your web browser.
Feel free to customize the application and add more features as needed.
I hope this helps! Let me know if you have any further questions.
